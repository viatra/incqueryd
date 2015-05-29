package hu.bme.mit.incqueryd.actorservice

import org.apache.hadoop.yarn.api.records.ApplicationId
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import hu.bme.mit.incqueryd.yarn.ApplicationMaster
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import com.sun.xml.bind.v2.runtime.Coordinator
import scala.concurrent.Future
import scala.concurrent.Promise
import org.apache.zookeeper.CreateMode
import org.apache.zookeeper.Watcher
import org.apache.zookeeper.data.ACL
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.ZooDefs.Ids
import org.apache.zookeeper.Watcher.Event.EventType
import org.apache.zookeeper.ZooDefs.Perms
import org.apache.zookeeper.data.Stat
import com.google.common.collect.ImmutableList
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._
import java.util.HashSet
import java.util.ArrayList
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
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
import java.net.URI
import hu.bme.mit.incqueryd.yarn.ApplicationMaster

object YarnActorService {
  def create(client: AdvancedYarnClient, zkHostname: String, zooKeeperIpPath: String): Future[YarnActorService] = {
    val jarPath = client.fileSystemUri + "/jars/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar" // XXX duplicated path
    val zk = IncQueryDZooKeeper.create(zkHostname)
    if (zk.exists(zooKeeperIpPath, false) == null) {
      zk.create(zooKeeperIpPath, Array[Byte](), ImmutableList.of(new ACL(Perms.ALL, Ids.ANYONE_ID_UNSAFE)), CreateMode.PERSISTENT)
    }
    val appMasterObjectName = ApplicationMaster.getClass.getName
    val appMasterClassName = appMasterObjectName.substring(0, appMasterObjectName.length - 1)
    val actorServiceClassName = "hu.bme.mit.incqueryd.actorservice.server.ActorServiceApplication" // XXX duplicated class name to avoid dependency on runtime
    val applicationId = client.runRemotely(
        List(s"$$JAVA_HOME/bin/java -Xmx256M $appMasterClassName $jarPath $actorServiceClassName $zkHostname $zooKeeperIpPath server"),
        jarPath, true)
    val result = Promise[YarnActorService]()
    zk.getData(zooKeeperIpPath, new Watcher() {
      def process(event: WatchedEvent) {
        event.getType() match {
          case EventType.NodeCreated | EventType.NodeDataChanged => {
            val data = zk.getData(zooKeeperIpPath, false, new Stat())
            val ipWithPort = new String(data)
            val ip = ipWithPort.replaceFirst(":\\d+", "")
            Thread.sleep((8 seconds).toMillis) // Wait for server to start
            result.success(YarnActorService(ip, applicationId))
          }
          case _ => result.failure(new IllegalStateException(s"Unexpected event on ${zooKeeperIpPath}: $event"))
        }
      }
    }, new Stat())
    result.future
  }
}

case class YarnActorService(ip: String, applicationId: ApplicationId)