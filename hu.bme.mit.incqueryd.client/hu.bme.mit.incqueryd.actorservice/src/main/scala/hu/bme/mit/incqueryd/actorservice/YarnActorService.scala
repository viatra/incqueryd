package hu.bme.mit.incqueryd.actorservice

import org.apache.hadoop.yarn.api.records.ApplicationId
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
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
import org.apache.curator.utils.ZKPaths
import com.google.common.net.HostAndPort
import hu.bme.mit.incqueryd.yarn.YarnApplication

object YarnActorService {
  // TODO eliminate duplication between these methods

   /*
    *  TODO: modify this method according to the new workflow
    *  
    *  1. Read deployment information from ZooKeeper (e.g. Recipe, ZK paths ... whatever)
    *  2. Start an application master
    *  3. Run an application to start ReteActor (using the ActorSystem running on the same node)
    *  4. Write ActorPath into the appropriate ZNode when Actor is started
    *  5. Stop container and AM
    *  
    */
  def startActors(client: AdvancedYarnClient, zkParentPath: String): List[Future[YarnApplication]] = {
    val jarPath = client.fileSystemUri + "/jars/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar" // XXX duplicated path
    IncQueryDZooKeeper.createDir(zkParentPath)
    val appMasterObjectName = ActorApplicationMaster.getClass.getName
    val appMasterClassName = appMasterObjectName.substring(0, appMasterObjectName.length - 1)
     
    val actorPaths = IncQueryDZooKeeper.getChildPaths(zkParentPath)
    
    actorPaths.foreach { actorPath =>
      val actorName = actorPath // TODO
      val applicationId = client.runRemotely(
        List(s"$$JAVA_HOME/bin/java -Xmx64m -XX:MaxPermSize=64m -XX:MaxDirectMemorySize=128M $appMasterClassName $jarPath $zkParentPath $actorName"),
        jarPath, true)
    }
    
    val result = Promise[YarnApplication]()
    actorPaths.map { actorPath =>
      val zkContainerAddressPath = "/" + actorPath + "/" + actorPath + IncQueryDZooKeeper.addressPath
      IncQueryDZooKeeper.createDir(zkContainerAddressPath)
      val watcher = new Watcher() {
        def process(event: WatchedEvent) {
          event.getType() match {
            case EventType.NodeCreated | EventType.NodeDataChanged => {
              val data = IncQueryDZooKeeper.getStringData(zkContainerAddressPath)
              val url = HostAndPort.fromString(data)
              result.success(YarnApplication(url.getHostText, url.getPort, null))
            }
            case _ => result.failure(new IllegalStateException(s"Unexpected event on ${zkContainerAddressPath}: $event"))
          }
        }
      }
      IncQueryDZooKeeper.getStringDataWithWatcher(zkContainerAddressPath, watcher)
      result.future
    }
  }
  
  val actorSystemName = "incqueryd"
  val port = 2552
  
  /**
   * Start one RemoteActorSystem on each yarn node
   */
  def startActorSystems(client : AdvancedYarnClient): List[Future[YarnApplication]] = {
    val jarPath = client.fileSystemUri + "/jars/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar" // XXX duplicated path
    val appMasterObjectName = ActorSystemsApplicationMaster.getClass.getName
    val appMasterClassName = appMasterObjectName.substring(0, appMasterObjectName.length - 1) // XXX
    
    val yarnNodes = client.getRunningNodes()
    IncQueryDZooKeeper.registerYarnNodes(yarnNodes)
    
    val applicationId = client.runRemotely(
      List(s"$$JAVA_HOME/bin/java -Xmx64m -XX:MaxPermSize=64m -XX:MaxDirectMemorySize=128M $appMasterClassName $jarPath"),
      jarPath, true)
    
    val result = Promise[YarnApplication]()
    yarnNodes.map { yarnNode =>
      val zkContainerAddressPath = IncQueryDZooKeeper.yarnNodesPath + "/" + yarnNode + IncQueryDZooKeeper.applicationPath
      IncQueryDZooKeeper.createDir(zkContainerAddressPath)
      val watcher = new Watcher() {
        def process(event: WatchedEvent) {
          event.getType() match {
            case EventType.NodeCreated | EventType.NodeDataChanged => {
              val data = IncQueryDZooKeeper.getStringData(zkContainerAddressPath)
              val url = HostAndPort.fromString(data)
              result.success(YarnApplication(url.getHostText, url.getPort, applicationId))
            }
            case _ => result.failure(new IllegalStateException(s"Unexpected event on ${zkContainerAddressPath}: $event"))
          }
        }
      }
      IncQueryDZooKeeper.getStringDataWithWatcher(zkContainerAddressPath, watcher)
      result.future
    }
    
  }

}