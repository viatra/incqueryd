package hu.bme.mit.incqueryd.rete.actors

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.Set
import scala.collection.JavaConversions._
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration.Duration
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Address
import akka.actor.Deploy
import akka.actor.Props
import akka.pattern.Patterns.ask
import akka.remote.RemoteScope
import akka.util.Timeout
import arch.CacheRole
import arch.Configuration
import arch.ReteRole
import hu.bme.mit.incqueryd.arch.util.ArchUtil
import hu.bme.mit.incqueryd.monitoring.actors.JVMMonitoringActor
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.rete.dataunits.ScalaChangeSet
import hu.bme.mit.incqueryd.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.rete.messages.CoordinatorCommand
import hu.bme.mit.incqueryd.rete.messages.CoordinatorMessage
import hu.bme.mit.incqueryd.rete.messages.Transformation
import hu.bme.mit.incqueryd.rete.messages.YellowPages
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoredActorCollection
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoredMachines
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage
import hu.bme.mit.incqueryd.util.EObjectSerializer
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration
import infrastructure.Machine
import hu.bme.mit.bigmodel.fourstore.FourStoreLoader
import hu.bme.mit.bigmodel.fourstore.FourStoreDriver
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import infrastructure.Process
import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot
import scala.collection.immutable.Stack
import hu.bme.mit.incqueryd.rete.messages.TerminationMessage
import java.nio.file.Paths
import org.apache.commons.io.FilenameUtils

class CoordinatorActor(val architectureFile: String, val remoting: Boolean) extends Actor {

  val logPrefix = "[CoordinatorActor] "
  val conf: Configuration = ArchUtil.loadConfiguration(architectureFile)
  val queryName = FilenameUtils.removeExtension(Paths.get(architectureFile).getFileName.toString())
  
  println("query name: " + queryName)
  
  var engine: ActorRef = null

  var verbose = true
  val timeout = new Timeout(Duration.create(14400, "seconds"))
  var productionActorRef: ActorRef = null
  var monitoringActor: ActorRef = null
  var yellowPages: YellowPages = null
  var latestResults = new HashSet[Tuple]
  var pendingUpdateMessages = 0

  var recipeToProcess = new HashMap[ReteNodeRecipe, Process]
  var recipeToActorRef = new HashMap[ReteNodeRecipe, ActorRef]
  var recipeToEmfUri = HashBiMap.create[ReteNodeRecipe, String]
  var emfUriToActorRef = new HashMap[String, ActorRef]
  var jvmActorRefs = new HashSet[ActorRef]
  
  def start = {
    processConfiguration
  }

  def processConfiguration = {
    // mapping
    fillRecipeToProcess

    // phase 1
    deployActors
    // deploy jvm monitoring actors as well
    deployJVMMonitoringActors

    // create mapping based on the results of phase one mapping
    fillEmfUriToActorRef

    // phase 2
    if (conf.getMonitoringMachine != null) {
      subscribeMonitoringService
    }

    subscribeActors

    // load the model to the Rete network
    load
  }

  def fillRecipeToProcess = {
    conf.getMappings.foreach(mapping => {
      mapping.getRoles.foreach(role => role match {
        case reteRole: ReteRole => recipeToProcess.put(reteRole.getNodeRecipe, mapping.getProcess)
      })
    })
  }

  def fillEmfUriToActorRef = {
    recipeToEmfUri.entrySet.foreach(emfUriAndRecipe => {
      val recipe = emfUriAndRecipe.getKey
      val emfUri = emfUriAndRecipe.getValue
      val akkaUri = recipeToActorRef.get(recipe)

      emfUriToActorRef.put(emfUri, akkaUri)
    })
  }

  def deployActors = {
    val cacheMachineIps = conf.getMappings.toList.
      filter(_.getRoles.exists(_.isInstanceOf[CacheRole])).
      map(_.getProcess.getMachine.getIp)

    if (verbose) println(logPrefix + "Deploying actors")
    conf.getRecipes.foreach(recipe =>
      recipe.getRecipeNodes.foreach(recipeNode => {
        if (verbose) println(logPrefix + "Recipe: " + recipeNode.getClass.getSimpleName)

        val emfUri = EcoreUtil.getURI(recipeNode).toString
        recipeToEmfUri.put(recipeNode, emfUri)

        // create a clone, else we would get a java.util.ConcurrentModificationException
        val rnrClone = EcoreUtil.copy(recipeNode)
        val recipeString = EObjectSerializer.serializeToString(rnrClone)

        var props: Props = null
        if (remoting) {
          val process = recipeToProcess.get(recipeNode)
          val ipAddress = process.getMachine.getIp
          val port = process.getPort

          if (verbose) println(logPrefix + "IP address:  " + ipAddress)
          if (verbose) println(logPrefix + "EMF address: " + emfUri)

          props = Props[ReteActor].withDeploy(new Deploy(new RemoteScope(new Address("akka",
            IncQueryDMicrokernel.ACTOR_SYSTEM_NAME, ipAddress, port))))
        } else {
          props = Props[ReteActor]
        }

        val actorRef = context.actorOf(props)

        configure(actorRef, recipeString, cacheMachineIps)

        recipeToActorRef.put(recipeNode, actorRef)

        recipeNode match {
          case pRec: ProductionRecipe => {
            if (pRec.getTraceInfo().contains(queryName)) {
              productionActorRef = actorRef
            }
          }
          case _ => {}
        }

        if (verbose) println(logPrefix + "Actor configured.")
      }))

    if (verbose) println(logPrefix + "All actors deployed and configured.")
    if (verbose) println

  }

  def deployJVMMonitoringActors = {
    if (remoting) {
      conf.getMappings.foreach(mapping => {
        val ipAddress = mapping.getProcess.getMachine.getIp
        val port = mapping.getProcess.getPort

        var props = Props[JVMMonitoringActor].withDeploy(new Deploy(new RemoteScope(new Address("akka",
          IncQueryDMicrokernel.ACTOR_SYSTEM_NAME, ipAddress, port))))

        val actorRef = context.actorOf(props)
        jvmActorRefs.add(actorRef)
      })
    } else {
      var props = Props[JVMMonitoringActor]
      val actorRef = context.actorOf(props)
      jvmActorRefs.add(actorRef)
    }

  }

  def subscribeActors = {
    if (verbose) println(logPrefix + "Subscribing actors")

    yellowPages = new YellowPages(emfUriToActorRef, monitoringActor)

    recipeToActorRef.foreach(recipeAndActorRef => {
      println(logPrefix + "Subscribing " + recipeAndActorRef._1 + " actor, which is based on a " + recipeAndActorRef + " recipe.")
      val future = ask(recipeAndActorRef._2, yellowPages, timeout)
      Await.result(future, timeout.duration)
    })
    
    if (verbose) println(logPrefix + "Actors subscribed.")
    if (verbose) println
  }

  def check = {
    val latestChangeSets = getQueryResults

    println(latestChangeSets.size + " lCS")
    println(latestChangeSets)
    
    latestChangeSets.foreach(latestChangeSet => {
      latestChangeSet.getChangeType match {
        case ChangeType.POSITIVE => latestResults.addAll(latestChangeSet.getTuples)
        case ChangeType.NEGATIVE => latestResults.removeAll(latestChangeSet.getTuples)
        case _ => {}
      }

      if (monitoringActor != null) monitoringActor ! sendChangesForMonitoring(latestChangeSet)
    })

    if (verbose) println("Results: " + latestResults.size)

    latestChangeSets
  }

  def sendChangesForMonitoring(changeSet: ChangeSet) = {
    val sb = new StringBuilder

    changeSet.getChangeType match {
      case ChangeType.POSITIVE => sb ++= "+ "
      case ChangeType.NEGATIVE => sb ++= "- "
    }

    changeSet.getTuples.foreach(tuple => {
      for (i <- 0 to tuple.size - 1) {
        sb ++= tuple.get(i) + ":"
      }
      sb.deleteCharAt(sb.size - 1)
      sb += ';'
    })

    sb.toString
  }

  def load = {
    println(logPrefix + "Loading the Rete network...")

    val clusterName = conf.getConnectionString.split("://")(1)
    val databaseDriver = new FourStoreDriver(clusterName)

    conf.getRecipes.foreach(recipe =>
      recipe.getRecipeNodes.foreach(_ match {
        case typeInputRecipe: TypeInputRecipe =>

          val tuples = scala.collection.mutable.Set[Tuple]()
          typeInputRecipe match {
            case binaryInputRecipe: BinaryInputRecipe => { 
              val traceInfo = binaryInputRecipe.getTraceInfo
              if (traceInfo.startsWith("attribute")) {
                initializeAttribute(databaseDriver, binaryInputRecipe, tuples)
              } else if (traceInfo.startsWith("edge")) {
                  initializeEdge(databaseDriver, binaryInputRecipe, tuples)
              }
            }
            case unaryInputRecipe: UnaryInputRecipe => {
              initializeVertex(databaseDriver, unaryInputRecipe, tuples)
            }
          }

          val actor = recipeToActorRef.get(typeInputRecipe)
          val changeSet = new ChangeSet(tuples, ChangeType.POSITIVE)

          update(actor, changeSet)
        case _ => {}
      }))
  }

  /**
   * Update API
   */
  def update(actor: ActorRef, changeSet: ChangeSet) {
    val senderStack = Stack(self)
    val updateMessage = new UpdateMessage(changeSet, ReteNodeSlot.SINGLE, senderStack)

    // send the updates to the actor
    println(logPrefix + "Sending update message to " + actor)
    actor.tell(updateMessage)

    pendingUpdateMessages += 1
    println(logPrefix + pendingUpdateMessages + " update message(s) pending.")
  }

  def initializeAttribute(databaseDriver: FourStoreDriver, recipe: BinaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val attributes = databaseDriver.collectVerticesWithProperty(recipe.getTypeName)

    attributes.foreach(attribute => {
      tuples += new Tuple(attribute._1, attribute._2)
    })
  }

  def initializeEdge(databaseDriver: FourStoreDriver, recipe: BinaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val edges = databaseDriver.collectEdges(recipe.getTypeName)

    edges.entries.foreach(edge => {
      tuples += new Tuple(edge.getKey, edge.getValue)
    })
  }

  def initializeVertex(databaseDriver: FourStoreDriver, recipe: UnaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val vertices = databaseDriver.collectVertices(recipe.getTypeName)
    vertices.foreach(vertex => tuples += new Tuple(vertex))
  }

  def getQueryResults: java.util.List[ChangeSet] = {
    val queryResultFuture = ask(productionActorRef, CoordinatorMessage.GETQUERYRESULTS, timeout)
    Await.result(queryResultFuture, timeout.duration).asInstanceOf[java.util.List[ChangeSet]]
  }

  def configure(actorRef: ActorRef, recipeString: String, cacheMachineIps: List[String]) = {
    val reteConf = new ReteNodeConfiguration(recipeString, cacheMachineIps, conf.getConnectionString)
    val future = ask(actorRef, reteConf, timeout)
    Await.result(future, timeout.duration)
  }

  def subscribeMonitoringService = {
    monitoringActor = context.actorFor("akka://monitoringserver@" + conf.getMonitoringMachine.getIp + ":5225/user/collector")
    monitoringActor ! new MonitoredActorCollection(recipeToActorRef.values, jvmActorRefs)
  }

  def receive = {
    case CoordinatorCommand.START => {
      start
      engine = sender
    }
    case CoordinatorCommand.CHECK => {
      sender ! check
    }
    case CoordinatorCommand.TRANSFORM => {
      sender ! CoordinatorMessage.DONE
    }
    case CoordinatorCommand.LOAD => {
      load
      sender ! CoordinatorMessage.DONE
    }
    case terminationMessage: TerminationMessage => {
      pendingUpdateMessages -= 1
      println(logPrefix + "Termination message received, " + pendingUpdateMessages + " update message(s) pending.")

      if (pendingUpdateMessages == 0) {
        println(logPrefix + "Termination protocol finished.")
        engine ! CoordinatorMessage.DONE
      }
    }
    case _ => {}
  }

}