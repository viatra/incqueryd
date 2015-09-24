package hu.bme.mit.incqueryd.coordinator.client

import java.util.HashSet

import scala.collection.JavaConversions._
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

import org.apache.hadoop.yarn.api.records.ApplicationId
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.Model

import akka.pattern.ask
import akka.util.Timeout
import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import hu.bme.mit.incqueryd.engine._
import hu.bme.mit.incqueryd.engine.PropagateInputChanges
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.EObjectSerializer
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper

object Coordinator {
  final val actorName = "coordinator"

  def actorId(ip: String) = ActorId(YarnActorService.actorSystemName, ip, YarnActorService.port, actorName)
  
  def create(client: AdvancedYarnClient): Future[Coordinator] = {
    IncQueryDZooKeeper.setData(IncQueryDZooKeeper.defaultCoordinatorPath + IncQueryDZooKeeper.actorNamePath, actorName.getBytes)
    val startCoordinator = YarnActorService.startActors(client, IncQueryDZooKeeper.coordinatorsPath, classOf[CoordinatorActor]).get(0)
    startCoordinator.map { coordinatorApplication =>
      new Coordinator(coordinatorApplication.ip, client, coordinatorApplication.applicationId)
    }
  }

}

class Coordinator(ip: String, client: AdvancedYarnClient, applicationId: ApplicationId) {

  def loadData(vocabulary: Model, databaseConnection: DatabaseConnection, rmHostname: String, fileSystemUri: String): Boolean = {
    println(s"Loading data")
    askCoordinator[Boolean](LoadData(vocabulary, databaseConnection, rmHostname, fileSystemUri))
  }

  def startQuery(recipe: ReteRecipe, rmHostname: String, fileSystemUri: String): Boolean = {
    println(s"Starting query")
    val recipeJson = EObjectSerializer.serializeToString(recipe)
    askCoordinator[Boolean](StartQuery(recipeJson, rmHostname, fileSystemUri))
  }

  def startOutputStream(recipe : ReteRecipe) = {
    val recipeJSon = EObjectSerializer.serializeToString(recipe)
    askCoordinator[Boolean](StartOutputStream(recipeJSon))
  }
  
  def stopOutputStreams() {
    println(s"Stopping output streams..")
    askCoordinator[Boolean](StopOutputStreams())
  }
  
  def checkResults(recipe: ReteRecipe, patternName: String): Set[Tuple] = {
    println(s"Checking results")
    val recipeJson = EObjectSerializer.serializeToString(recipe)
    askCoordinator[HashSet[Tuple]](CheckResults(recipeJson, patternName)).toSet
  }
  
  def sendChangesToInputs(inputChanges : Map[String, ChangeSet]): Boolean = {
    askCoordinator[Boolean](PropagateInputChanges(inputChanges))
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
    println("Dispose ... ")
    askCoordinator[Boolean](Dispose())
    client.kill(applicationId)
  }

}