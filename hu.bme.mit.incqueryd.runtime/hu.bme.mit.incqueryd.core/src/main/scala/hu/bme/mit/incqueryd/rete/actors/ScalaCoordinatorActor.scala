package hu.bme.mit.incqueryd.rete.actors

import akka.actor.Actor
import akka.util.Timeout
import scala.concurrent.duration.Duration
import akka.actor.ActorRef
import hu.bme.mit.incqueryd.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.arch.ArchUtil
import java.util.HashMap
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import java.util.HashSet
import java.util.Set
import scala.collection.JavaConversions._
import com.google.common.collect.Lists
import java.util.ArrayList
import org.eclipse.emf.ecore.util.EcoreUtil
import hu.bme.mit.incqueryd.util.EObjectSerializer
import akka.actor.Props
import akka.actor.Deploy
import akka.remote.RemoteScope
import akka.actor.Address
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import hu.bme.mit.incqueryd.rete.messages.YellowPages
import scala.concurrent.Await
import scala.concurrent.Future
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe
import hu.bme.mit.incqueryd.rete.messages.CoordinatorMessage
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration
import akka.pattern.Patterns.ask
import hu.bme.mit.incqueryd.rete.messages.CoordinatorCommand
import hu.bme.mit.incqueryd.rete.messages.Transformation
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet
import arch.Configuration
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType

class ScalaCoordinatorActor(val architectureFile: String, val remoting: Boolean) extends Actor{
  
  protected val timeout: Timeout = new Timeout(Duration.create(14400, "seconds"))
  //implicit val timeout: Timeout = Timeout(14400)
  protected var productionActorRef: ActorRef = null
  protected var query: String = null
  protected var debug: Boolean = false
  protected var latestResults: Set[Tuple] = new HashSet[Tuple]
  protected var latestChangeSet: ChangeSet = null
  
  if (architectureFile.contains("poslength")) {
    query = "PosLength";
  }
  if (architectureFile.contains("routesensor")) {
    query = "RouteSensor";
  }
  if (architectureFile.contains("signalneighbor")) {
    query = "SignalNeighbor";
  }
  if (architectureFile.contains("switchsensor")) {
    query = "SwitchSensor";
  }
  
  var recipeToIp: HashMap[ReteNodeRecipe, String] = new HashMap[ReteNodeRecipe, String]
  var recipeToActorRef: HashMap[ReteNodeRecipe, ActorRef] = new HashMap[ReteNodeRecipe, ActorRef]
  var emfUriToRecipe: HashMap[String, ReteNodeRecipe] = new HashMap[String, ReteNodeRecipe]
  var emfUriToActorRef: HashMap[String, ActorRef] = new HashMap[String, ActorRef]
  var actorRefs: HashSet[ActorRef] = new HashSet[ActorRef]
  
  def start = {
    val conf: Configuration = ArchUtil.loadConfiguration(architectureFile)
    processConfiguration(conf)
  }
  
  private def processConfiguration(conf: Configuration) = {
    // mapping
    fillRecipeToIp(conf)

    // phase 1
    deployActors(conf)
    
    // create mapping based on the results of phase one mapping
    fillEmfUriToActorRef

    // phase 2
    subscribeActors(conf)

    // phase 3
    initialize
  }
  
  private def fillRecipeToIp(conf: Configuration) = {
    
    conf.getMappings.foreach( mapping => {
      val machine = mapping.getTargetElement
      
      mapping.getMappedElements.foreach(reteNodeRecipe => {
        recipeToIp.put(reteNodeRecipe, machine.getIp)
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
						+ ArchUtil.oneLiner(recipe.getTraceInfo()))
    })
    
    if (debug) System.err.println()
    
  }
  
  private def deployActors(conf: Configuration) = {
    
    val cluster = conf.getClusters().get(0)
    val cacheMachines = cluster.getCacheMachines
    
    val cacheMachineIps: List[String] = List()
    cacheMachines.foreach(machine => {
      cacheMachineIps.add(machine.getIp)
    })
    
    conf.getReteRecipes.foreach(rr => {
      rr.getRecipeNodes.foreach(rnr => {
        if (debug) System.err.println("[TestKit] Recipe: " + rnr.getClass.getName)
        
        val ipAddress = recipeToIp.get(rnr)
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
                      IncQueryDMicrokernel.ACTOR_SYSTEM_NAME, ipAddress, 2552))))
        } else {
          props = Props[ScalaReteActor]
        }
        
        val actorRef = context.actorOf(props)
        
        configure(actorRef, recipeString, cacheMachineIps)
        
        actorRefs.add(actorRef)
        recipeToActorRef.put(rnr, actorRef)
        
        rnr match{
          case pRec: ProductionRecipe => productionActorRef = actorRef
          case _ => {}
        }
        
        if (debug) System.err.println("[TestKit] Actor configured.")
        if (debug) System.err.println()
        
      })
    })
    
    if (debug) System.err.println("[ReteActor] All actors deployed and configured.")
    if (debug) System.err.println()
    
  }
  
  private def subscribeActors(conf: Configuration) = {
    val yellowPages = new YellowPages(emfUriToActorRef)
    
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
      recipe match{
        case rec: UniquenessEnforcerRecipe => {
          val future = ask(entry.getValue, CoordinatorMessage.INITIALIZE, timeout)
          futures.add(future)
        }
        case _ => {}
      }
    })
    
    if (debug) System.err.println("<AWAIT>")
    
    futures.foreach(future => {
      if (debug) System.err.println("await for " + future)
      val result = Await.result(future, timeout.duration)
      if (debug) System.err.println(result)
      if (debug) System.err.println("</AWAIT>")
    })
  }
  
  def check(): ChangeSet = {
    latestChangeSet = getQueryResults
    
    latestChangeSet.getChangeType match {
      case ChangeType.POSITIVE => latestResults.addAll(latestChangeSet.getTuples)
      case ChangeType.NEGATIVE => latestResults.removeAll(latestChangeSet.getTuples)
      case _ => {}
    }
    
    if (debug) System.err.println("Results: " + latestResults.size)
    latestChangeSet
  }
  
  def transform = {
    recipeToActorRef.entrySet.foreach(entry => {
      
      entry.getKey match {
        case uer: UniquenessEnforcerRecipe => {
          val actorRef = entry.getValue
          
          query match {
            
            case "PosLength" => {
              if (uer.getTraceInfo.contains("Segment")) {
                val transformation = new Transformation(latestResults, query)
                val future = ask(actorRef, transformation, timeout)
                Await.result(future, timeout.duration)
              }
            }
            
            case "RouteSensor" => {
              if (uer.getTraceInfo.contains("TrackElement_sensor")) {
                val transformation = new Transformation(latestResults, query)
                val future = ask(actorRef, transformation, timeout)
                Await.result(future, timeout.duration)
              }
            }
            
            case "SignalNeighbor" => {
              if (uer.getTraceInfo.contains("Route_exit")) {
                val transformation = new Transformation(latestResults, query)
                val future = ask(actorRef, transformation, timeout)
                Await.result(future, timeout.duration)
              }
            }
            
            case "SwitchSensor" => {
              if (uer.getTraceInfo.contains("TrackElement_sensor")) {
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
  
  private def configure (actorRef: ActorRef, recipeString: String, cacheMachineIps: List[String]) = {
    val conf = new ReteNodeConfiguration(recipeString, cacheMachineIps)
    val future = ask(actorRef, conf, timeout)
    Await.result(future, timeout.duration)
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