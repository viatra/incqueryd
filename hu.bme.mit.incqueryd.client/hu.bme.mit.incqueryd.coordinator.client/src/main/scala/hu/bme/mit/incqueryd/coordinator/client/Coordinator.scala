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

object Coordinator {
  final val port = 2552
  final val actorSystemName = "coordinator"
  final val actorName = "coordinator"
  def actorId(ip: String) = ActorId(actorSystemName, ip, port, actorName)
  
  def create(client: AdvancedYarnClient, zooKeeperHost: String): Future[Coordinator] = {
    val jarPath = client.fileSystemUri + "/jars/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar" // XXX duplicated path
    val zk = IncQueryDZooKeeper.create(zooKeeperHost)
    zk.create(IncQueryDZooKeeper.ipPath, Array[Byte](), List(new ACL(Perms.ALL, Ids.ANYONE_ID_UNSAFE)), CreateMode.PERSISTENT)
    val applicationId = client.runRemotely(
        List("$JAVA_HOME/bin/java -Xmx256M hu.bme.mit.incqueryd.yarn.ApplicationMaster " + jarPath + " hu.bme.mit.incqueryd.actorservice.server.ActorServiceApplication " + zooKeeperHost),
        jarPath)
    val result = Promise[Coordinator]()
    zk.getData(IncQueryDZooKeeper.ipPath, new Watcher() {
      def process(event: WatchedEvent) {
        event.getType() match {
          case EventType.NodeCreated | EventType.NodeDataChanged => {
            val data = zk.getData(IncQueryDZooKeeper.ipPath, false, new Stat())
            val ip = new String(data)
            new RemoteActorService(ip).start(Coordinator.actorId(ip), classOf[CoordinatorActor])
            result.success(new Coordinator(ip, client, applicationId))
          }
          case _ => result.failure(new IllegalStateException(s"Unexpected event on ${IncQueryDZooKeeper.ipPath}: $event"))
        }
      }
    }, new Stat())
    result.future
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