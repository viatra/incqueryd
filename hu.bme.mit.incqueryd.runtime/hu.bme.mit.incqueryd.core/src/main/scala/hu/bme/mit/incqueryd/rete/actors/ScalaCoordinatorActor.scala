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

class ScalaCoordinatorActor(val architectureFile: String, val remoting: Boolean, val monitoringServerIPAddress: String) extends Actor {

  protected val timeout: Timeout = new Timeout(Duration.create(14400, "seconds"))
  protected var productionActorRef: ActorRef = null
  protected var query: String = null
  protected var debug: Boolean = true
  protected var latestResults: Set[Tuple] = new HashSet[Tuple]
  protected var latestChangeSet: ChangeSet = null
  protected var monitoringActor: ActorRef = null

  if (architectureFile.toLowerCase().contains("poslength")) {
    query = "PosLength";
  }
  if (architectureFile.toLowerCase().contains("routesensor")) {
    query = "RouteSensor";
  }
  if (architectureFile.toLowerCase().contains("signalneighbor")) {
    query = "SignalNeighbor";
  }
  if (architectureFile.toLowerCase().contains("switchsensor")) {
    query = "SwitchSensor";
  }

  var recipeToAddress: HashMap[ReteNodeRecipe, Tuple2[String,Int]] = new HashMap
  var recipeToActorRef: HashMap[ReteNodeRecipe, ActorRef] = new HashMap[ReteNodeRecipe, ActorRef]
  var emfUriToRecipe: HashMap[String, ReteNodeRecipe] = new HashMap[String, ReteNodeRecipe]
  var emfUriToActorRef: HashMap[String, ActorRef] = new HashMap[String, ActorRef]
  var actorRefs: HashSet[ActorRef] = new HashSet[ActorRef]
  var jvmActorRefs: HashSet[ActorRef] = new HashSet[ActorRef]

  def start = {
    val conf: Configuration = ArchUtil.loadConfiguration(architectureFile)
    processConfiguration(conf)
  }

  private def processConfiguration(conf: Configuration) = {
    // mapping
    fillRecipeToAddress(conf)

    // phase 1
    deployActors(conf)
    // deploy jvm monitoring actors as well
    deployJVMMonitoringActors(conf)

    // create mapping based on the results of phase one mapping
    fillEmfUriToActorRef

    // phase 2
    if (monitoringServerIPAddress != null) {
      subscribeMonitoringService(conf)
    }

    subscribeActors(conf)

    // phase 3
    initialize
  }

  private def fillRecipeToAddress(conf: Configuration) = {

    conf.getMappings.foreach(mapping => {
      val process = mapping.getProcess
      val machine = process.getMachine

      mapping.getRoles.foreach(role => role match {
        case reteRole: ReteRole => recipeToAddress.put(reteRole.getNodeRecipe, (machine.getIp, process.getPort))
      })
    })

  }

  private def fillEmfUriToActorRef = {

    emfUriToRecipe.entrySet.foreach(emfUriAndRecipe => {
      val emfUri = emfUriAndRecipe.getKey
      val recipe = emfUriAndRecipe.getValue
      val akkaUri = recipeToActorRef.get(recipe)

      emfUriToActorRef.put(emfUri, akkaUri)

      if (debug) System.err.println("EMF URI: " + emfUri + ", Akka URI: " + akkaUri + ", traceInfo "
        + recipe.getTraceInfo())
    })

    if (debug) System.err.println()

  }

  private def deployActors(conf: Configuration) = {

    val cacheMachineIps = conf.getMappings.toList.
      filter(_.getRoles.exists(_.isInstanceOf[CacheRole])).
      map(_.getProcess.getMachine.getIp)

    conf.getMappings.foreach(mapping => {
      // the ProjectionIndexerRecipes are dropped,
      // as the current implementation handles BetaNodes with their indexers as one actor

      mapping.getRoles.flatMap { case reteRole: ReteRole => Some(reteRole) }.
        filter(!_.getNodeRecipe().isInstanceOf[ProjectionIndexerRecipe]).
        foreach { reteRole =>
          val rnr = reteRole.getNodeRecipe

          if (debug) System.err.println("[TestKit] Recipe: " + rnr.getClass.getName)

          val address = recipeToAddress.get(rnr)
          val ipAddress = address._1
          val port = address._2
          
          val emfUri = EcoreUtil.getURI(rnr).toString

          if (debug) System.err.println("[TestKit] - IP address:  " + ipAddress)
          if (debug) System.err.println("[TestKit] - EMF address: " + emfUri)

          emfUriToRecipe.put(emfUri, rnr)

          // create a clone, else we would get a java.util.ConcurrentModificationException
          val rnrClone = EcoreUtil.copy(rnr)
          val recipeString = EObjectSerializer.serializeToString(rnrClone)

          var props: Props = null
          if (remoting) {
            props = Props[ScalaReteActor].withDeploy(new Deploy(new RemoteScope(new Address("akka",
              IncQueryDMicrokernel.ACTOR_SYSTEM_NAME, ipAddress, port))))
          } else {
            props = Props[ScalaReteActor]
          }

          val actorRef = context.actorOf(props)

          configure(actorRef, recipeString, cacheMachineIps)

          actorRefs.add(actorRef)
          recipeToActorRef.put(rnr, actorRef)

          rnr match {
            case pRec: ProductionRecipe => productionActorRef = actorRef
            case _ => {}
          }

          if (debug) System.err.println("[TestKit] Actor configured.")
          if (debug) System.err.println()
        }
    })

    if (debug) System.err.println("[ReteActor] All actors deployed and configured.")
    if (debug) System.err.println()

  }

  private def deployJVMMonitoringActors(conf: Configuration) = {

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

  private def subscribeActors(conf: Configuration) = {
    val yellowPages = new YellowPages(emfUriToActorRef, monitoringActor)

    actorRefs.foreach(actorRef => {
      val future = ask(actorRef, yellowPages, timeout)
      Await.result(future, timeout.duration)
    })

    if (debug) System.err.println()
    if (debug) System.err.println()

    if (debug) yellowPages.getEmfUriToActorRef.entrySet.foreach(entry => System.err.println(entry))
  }

  private def initialize = {
    val futures: HashSet[Future[AnyRef]] = new HashSet[Future[AnyRef]]

    recipeToActorRef.entrySet.foreach(entry => {
      val recipe = entry.getKey
      recipe match {
        case rec: InputRecipe => {
          val future = ask(entry.getValue, CoordinatorMessage.INITIALIZE, timeout)
          futures.add(future)
        }
        case _ => {}
      }
    })

    if (debug) System.err.println("<AWAIT> for " + futures.size + " futures.")
    futures.foreach(future => {
      if (debug) System.err.println("await for " + future)
      val result = Await.result(future, timeout.duration)
      if (debug) System.err.println("result is: " + result)
    })
    if (debug) System.err.println("</AWAIT>")

  }

  def check(): ChangeSet = {
    latestChangeSet = getQueryResults

    latestChangeSet.getChangeType match {
      case ChangeType.POSITIVE => latestResults.addAll(latestChangeSet.getTuples)
      case ChangeType.NEGATIVE => latestResults.removeAll(latestChangeSet.getTuples)
      case _ => {}
    }

    if (debug) System.err.println("Results: " + latestResults.size)

    monitoringActor ! sendChangesForMonitoring(latestChangeSet)

    latestChangeSet
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

  def transform = {
    recipeToActorRef.entrySet.foreach(entry => {

      entry.getKey match {
        case ir: InputRecipe => {
          val actorRef = entry.getValue

          query match {

            case "PosLength" => {
              if (ir.isInstanceOf[BinaryInputRecipe]) {
                val transformation = new Transformation(latestResults, query)
                val future = ask(actorRef, transformation, timeout)
                Await.result(future, timeout.duration)
              }
            }

            case "RouteSensor" => {
              if (ir.getTraceInfo.contains("TrackElement_sensor")) {
                val transformation = new Transformation(latestResults, query)
                val future = ask(actorRef, transformation, timeout)
                Await.result(future, timeout.duration)
              }
            }

            case "SignalNeighbor" => {
              if (ir.getTraceInfo.contains("Route_exit")) {
                val transformation = new Transformation(latestResults, query)
                val future = ask(actorRef, transformation, timeout)
                Await.result(future, timeout.duration)
              }
            }

            case "SwitchSensor" => {
              if (ir.getTraceInfo.contains("TrackElement_sensor")) {
                val transformation = new Transformation(latestResults, query)
                val future = ask(actorRef, transformation, timeout)
                Await.result(future, timeout.duration)
              }
            }

          }
        }

        case _ => {}
      }

    })
  }

  private def getQueryResults(): ChangeSet = {
    val queryResultFuture = ask(productionActorRef, CoordinatorMessage.GETQUERYRESULTS, timeout)
    Await.result(queryResultFuture, timeout.duration).asInstanceOf[ChangeSet]
  }

  private def configure(actorRef: ActorRef, recipeString: String, cacheMachineIps: List[String]) = {
    val conf = new ReteNodeConfiguration(recipeString, cacheMachineIps)
    val future = ask(actorRef, conf, timeout)
    Await.result(future, timeout.duration)
  }

  private def subscribeMonitoringService(conf: Configuration) = {
    monitoringActor = context.actorFor("akka://monitoringserver@" + monitoringServerIPAddress + ":2552/user/collector")

    monitoringActor ! new MonitoredActorCollection(actorRefs, jvmActorRefs)

  }

  def receive = {
    case CoordinatorCommand.START => {
      start
      sender ! CoordinatorMessage.DONE
    }
    case CoordinatorCommand.CHECK => {
      sender ! check
    }
    case CoordinatorCommand.TRANSFORM => {
      transform
      sender ! CoordinatorMessage.DONE
    }
    case _ => {}
  }

}