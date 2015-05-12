package hu.bme.mit.incqueryd.coordinator.client

import akka.pattern.ask
import akka.util.Timeout
import hu.bme.mit.incqueryd.engine._
import hu.bme.mit.incqueryd.inventory.{Inventory, MachineInstance}
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.Model
import scala.concurrent.Await
import scala.concurrent.duration._
import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import hu.bme.mit.incqueryd.engine.DeploymentResult
import hu.bme.mit.incqueryd.engine.util.EObjectSerializer
import java.util.HashSet
import java.util.ArrayList
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import hu.bme.mit.incqueryd.actorservice.RemoteActorService
import hu.bme.mit.incqueryd.yarn.ApplicationMaster
import org.apache.hadoop.yarn.api.records.ApplicationId

object Coordinator {
  final val port = 2552
  final val actorSystemName = "coordinator"
  final val actorName = "coordinator"
  def actorId(ip: String) = ActorId(actorSystemName, ip, port, actorName)
  
  def apply(client: AdvancedYarnClient): Coordinator = {
    val jarPath = client.fileSystemUri + "/jars/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar" // XXX duplicated path
    val applicationId = client.runRemotely(
        List("$JAVA_HOME/bin/java -Xmx256M hu.bme.mit.incqueryd.yarn.ApplicationMaster " + jarPath + " hu.bme.mit.incqueryd.actorservice.server.ActorServiceApplication"),
        jarPath)
    val ip = client.getIp(applicationId)
    new RemoteActorService(ip).start(Coordinator.actorId(ip), classOf[CoordinatorActor])
    new Coordinator(ip, client, applicationId)
  }
}

class Coordinator(ip: String, client: AdvancedYarnClient, applicationId: ApplicationId) {

  def loadData(databaseUrl: String, vocabulary: Model, inventory: Inventory): DeploymentResult = {
    println(s"Loading data")
    askCoordinator[DeploymentResult](LoadData(databaseUrl, vocabulary, inventory))
  }

  def startQuery(recipe: ReteRecipe, index: DeploymentResult): DeploymentResult = {
    println(s"Starting query")
    askCoordinator[DeploymentResult](StartQuery(EObjectSerializer.serializeToString(recipe), index))
  }

  def checkResults(recipe: ReteRecipe, index: DeploymentResult, patternName: String): Set[Tuple] = {
    println(s"Checking results")
    askCoordinator[HashSet[Tuple]](CheckResults(EObjectSerializer.serializeToString(recipe), index, patternName)).toSet
  }

  def stopQuery(network: DeploymentResult) {
    println(s"Stopping query")
    askCoordinator[String](StopQuery(network))
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