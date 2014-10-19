package hu.bme.mit.incqueryd.core.rete.actors

import java.nio.file.Paths
import java.util.HashMap
import java.util.HashSet
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.asScalaSet
import scala.collection.JavaConversions.collectionAsScalaIterable
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.mutableSetAsJavaSet
import scala.collection.JavaConversions.seqAsJavaList
import scala.collection.immutable.Stack
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe
import com.google.common.collect.HashBiMap
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Address
import akka.actor.Deploy
import akka.actor.Props
import akka.actor.actorRef2Scala
import akka.pattern.Patterns.ask
import akka.remote.RemoteScope
import akka.util.Timeout
import arch.CacheRole
import arch.Configuration
import arch.Configuration
import arch.Configuration
import arch.Configuration
import arch.ReteRole
import hu.bme.mit.bigmodel.fourstore.FourStoreDriverUnique
import hu.bme.mit.bigmodel.rdf.RDFHelper
import hu.bme.mit.incqueryd.arch.util.ArchUtil
import hu.bme.mit.incqueryd.core.monitoring.actors.JVMMonitoringActor
import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.core.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.core.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.core.rete.messages.CoordinatorCommand
import hu.bme.mit.incqueryd.core.rete.messages.CoordinatorMessage
import hu.bme.mit.incqueryd.core.rete.messages.QueryIndexer
import hu.bme.mit.incqueryd.core.rete.messages.TerminationMessage
import hu.bme.mit.incqueryd.core.rete.messages.UpdateMessage
import hu.bme.mit.incqueryd.core.rete.messages.YellowPages
import hu.bme.mit.incqueryd.core.util.EObjectSerializer
import hu.bme.mit.incqueryd.core.util.ReteNodeConfiguration
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoredActorCollection
import infrastructure.Process
import hu.bme.mit.bigmodel.fourstore.FourStoreDriverTrainBenchmark

class CoordinatorActor(val architectureFile: String, val distributed: Boolean) extends Actor {

  val logPrefix = "[CoordinatorActor] "
  val conf: Configuration = ArchUtil.loadConfiguration(architectureFile)
  val queryName = FilenameUtils.removeExtension(Paths.get(architectureFile).getFileName.toString()).toLowerCase

  println(logPrefix + "Running query: " + queryName)

  val verbose = true
  val timeout = new Timeout(Duration.create(14400, "seconds"))
  val latestResults = new HashSet[Tuple]
  val indexers = new HashMap[String, ActorRef]

  var engine: ActorRef = null
  var productionActors = new HashMap[String, ActorRef]
  var monitoringActor: ActorRef = null
  var yellowPages: YellowPages = null
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
        case reteRole: ReteRole => {
          println(reteRole.getNodeRecipe() + ": " + mapping.getProcess())
          recipeToProcess.put(reteRole.getNodeRecipe, mapping.getProcess)
        }
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
        if (distributed) {
          if (verbose) println(logPrefix + "EMF address: " + emfUri)
          val process = recipeToProcess.get(recipeNode)
          val machine = process.getMachine
          val ipAddress = machine.getIp
          val port = process.getPort

          if (verbose) println(logPrefix + "IP address:  " + ipAddress)

          props = Props[ReteActor].withDeploy(new Deploy(new RemoteScope(new Address("akka",
            IncQueryDMicrokernel.ACTOR_SYSTEM_NAME, ipAddress, port))))
        } else {
          props = Props[ReteActor]
        }

        val actorRef = context.actorOf(props)
        configure(actorRef, recipeString, cacheMachineIps)
        recipeToActorRef.put(recipeNode, actorRef)

        recipeNode match {
          case productionRecipe: ProductionRecipe => {
            val traceInfo = productionRecipe.getTraceInfo()
            val patternName = traceInfo.split(" ", 2)(0).toLowerCase
            println(patternName)
            productionActors.put(patternName, actorRef)
          }
          case typeInputRecipe: TypeInputRecipe => {
            indexers.put(typeInputRecipe.getTypeName(), actorRef)
          }
          case _ => {}
        }

        if (verbose) println(logPrefix + "Actor configured.")
      }))
      
    if (verbose) println(logPrefix + "All actors deployed and configured.")
    if (verbose) println(logPrefix + "Indexers: " + indexers)

  }

  def deployJVMMonitoringActors = {
    if (distributed) {
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
    val latestChangeSets = getQueryResults(queryName)

    latestChangeSets.foreach(latestChangeSet => {
      latestChangeSet.getChangeType match {
        case ChangeType.POSITIVE => latestResults.addAll(latestChangeSet.getTuples)
        case ChangeType.NEGATIVE => latestResults.removeAll(latestChangeSet.getTuples)
        case _ => {}
      }

      if (monitoringActor != null) monitoringActor ! sendChangesForMonitoring(latestChangeSet)
    })

    if (verbose) println(logPrefix + "Results: " + latestResults.size)

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
    println(logPrefix + "Loading the Rete network.")

    val clusterName = conf.getConnectionString.split("://")(1)
    val databaseDriver = new FourStoreDriverTrainBenchmark(clusterName, distributed)

    conf.getRecipes.foreach(recipe =>
      recipe.getRecipeNodes.foreach(_ match {
        case typeInputRecipe: TypeInputRecipe =>

          val tuples : java.util.Set[Tuple] = new java.util.HashSet
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

  def initializeAttribute(databaseDriver: FourStoreDriverTrainBenchmark, recipe: BinaryInputRecipe, tuples: java.util.Set[Tuple]) = {
    val typeName = RDFHelper.brackets(recipe.getTypeName)
    val attributes = databaseDriver.collectVerticesWithProperty(typeName) 

    attributes.foreach(attribute => {
      val key = attribute._1
      val value = attribute._2
      
      val regex = "\"(.*?)\"\\^\\^<http://www.w3.org/2001/XMLSchema#int>".r
      val intValue = regex.findFirstMatchIn(value).get.group(1)
      tuples += new Tuple(key, intValue)
    })
  }

  def initializeEdge(databaseDriver: FourStoreDriverTrainBenchmark, recipe: BinaryInputRecipe, tuples: java.util.Set[Tuple]) = {
    val typeName = RDFHelper.brackets(recipe.getTypeName)
    val edges = databaseDriver.collectEdges(typeName)
    
    edges.entries.foreach(edge => {
      tuples += new Tuple(edge.getKey, edge.getValue)
    })
  }

  def initializeVertex(databaseDriver: FourStoreDriverTrainBenchmark, recipe: UnaryInputRecipe, tuples: java.util.Set[Tuple]) = {
    val vertices = databaseDriver.collectVertices(RDFHelper.brackets(recipe.getTypeName))
    vertices.foreach(vertex => tuples += new Tuple(vertex))
  }

  def getQueryResults(pattern: String): java.util.List[ChangeSet] = {
    val productionActorRef = productionActors.get(pattern)
    
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
    case updateMessage: UpdateMessage => {
      update(updateMessage.getTarget, updateMessage.getChangeSet);
    } 
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
    case queryIndexer: QueryIndexer => {
      sender ! indexers.get(queryIndexer.getTypeName)
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