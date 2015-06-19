package hu.bme.mit.incqueryd.coordinator.client

import akka.pattern.ask
import akka.util.Timeout
import hu.bme.mit.incqueryd.engine._
import hu.bme.mit.incqueryd.engine.RemoteReteActor
import hu.bme.mit.incqueryd.inventory.{ Inventory, MachineInstance }
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.Model
import scala.concurrent.Await
import scala.concurrent.duration._
import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import hu.bme.mit.incqueryd.engine.util.EObjectSerializer
import java.util.HashSet
import java.util.ArrayList
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import org.apache.hadoop.yarn.api.records.ApplicationId
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import scala.concurrent.Promise
import org.apache.zookeeper.Watcher
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.data.Stat
import org.apache.zookeeper.Watcher.Event.EventType
import scala.concurrent.Future
import org.apache.zookeeper.CreateMode
import org.apache.zookeeper.data.ACL
import org.apache.zookeeper.ZooDefs.Perms
import org.apache.zookeeper.ZooDefs.Ids
import java.net.URI
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import scala.concurrent.ExecutionContext.Implicits.global
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor

object Coordinator {
  final val actorName = "coordinator"

  def actorId(ip: String) = ActorId(YarnActorService.actorSystemName, ip, YarnActorService.port, actorName)
  
  def create(client: AdvancedYarnClient): Future[Coordinator] = {
    IncQueryDZooKeeper.createDir(IncQueryDZooKeeper.defaultCoordinatorPath)
    val startCoordinator = YarnActorService.startActors(client, IncQueryDZooKeeper.coordinatorsPath, classOf[CoordinatorActor]).get(0)
    startCoordinator.map { coordinatorApplication =>
      new Coordinator(coordinatorApplication.ip, client, coordinatorApplication.applicationId)
    }
  }

}

class Coordinator(ip: String, client: AdvancedYarnClient, applicationId: ApplicationId) {

  def loadData(vocabulary: Model, hdfsPath: String, rmHostname: String, fileSystemUri: String): Boolean = {
    println(s"Loading data")
    askCoordinator[Boolean](LoadData(vocabulary, hdfsPath, rmHostname, fileSystemUri))
  }

  def startQuery(recipe: ReteRecipe, rmHostname: String, fileSystemUri: String): Boolean = {
    println(s"Starting query")
    val recipeJson = EObjectSerializer.serializeToString(recipe)
    askCoordinator[Boolean](StartQuery(recipeJson, rmHostname, fileSystemUri))
  }

  def checkResults(recipe: ReteRecipe, patternName: String): Set[Tuple] = {
    println(s"Checking results")
    val recipeJson = EObjectSerializer.serializeToString(recipe)
    askCoordinator[HashSet[Tuple]](CheckResults(recipeJson, patternName)).toSet
  }

  def stopQuery(recipe: ReteRecipe, zkHostname: String): Boolean = {
    println(s"Stopping query")
    val recipeJson = EObjectSerializer.serializeToString(recipe)
    askCoordinator[Boolean](StopQuery(recipeJson))
  }

  private def askCoordinator[T](message: CoordinatorCommand, timeout: Timeout = Timeout(AkkaUtils.defaultTimeout)): T = {
    val coordinatorActor = AkkaUtils.findActor(Coordinator.actorId(ip))
    val future = coordinatorActor.ask(message)(timeout)
    Await.result(future, timeout.duration).asInstanceOf[T]
  }

  def dispose = {
    client.kill(applicationId)
  }

}