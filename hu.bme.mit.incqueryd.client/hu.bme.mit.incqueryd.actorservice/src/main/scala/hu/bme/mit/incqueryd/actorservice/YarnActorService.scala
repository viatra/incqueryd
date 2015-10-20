
package hu.bme.mit.incqueryd.actorservice

import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.Promise
import org.apache.hadoop.yarn.api.records.ApplicationId
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.Watcher
import org.apache.zookeeper.Watcher.Event.EventType
import com.google.common.net.HostAndPort
import akka.pattern.ask
import akka.util.Timeout.durationToTimeout
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.yarn.YarnApplication
import akka.actor.Actor

object YarnActorService {
  // TODO eliminate duplication between these methods
  
  val memory_mb = AdvancedYarnClient.AM_MEMORY_MB
  
  def startActors(client: AdvancedYarnClient, zkParentPath: String, actorClass: Class[_ <: Actor]): List[Future[YarnApplication]] = {
    val jarPath = client.fileSystemUri + "/jars/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar" // XXX duplicated path
    IncQueryDZooKeeper.createDir(zkParentPath)
    val appMasterObjectName = ActorApplicationMaster.getClass.getName
    val appMasterClassName = appMasterObjectName.substring(0, appMasterObjectName.length - 1)
    
    val actorPaths = IncQueryDZooKeeper.getChildPaths(zkParentPath)
    
    val applicationIds = mutable.Map.empty[String, ApplicationId]
    
    actorPaths.foreach { actorPath =>
      val actorName = IncQueryDZooKeeper.getStringData(s"$zkParentPath/$actorPath" + IncQueryDZooKeeper.actorNamePath)
      val actorMemory = "512" // XXX read from ZK in the future
      val actorCPU = 1
      val applicationId = client.runRemotely(
        "Deploy IncQuery-D Actor",
        List(s"$$JAVA_HOME/bin/java -Xmx${memory_mb}m -XX:MaxPermSize=${memory_mb}m -XX:MaxDirectMemorySize=${memory_mb}m $appMasterClassName -jarpath $jarPath -zkpath $zkParentPath/$actorPath -actorname $actorName -actorclass ${actorClass.getName} -memory $actorMemory -cpu $actorCPU"),
        jarPath,
        true)
      applicationIds.put(s"$zkParentPath/$actorPath", applicationId)
    }
    
    actorPaths.map { actorPath =>
      val result = Promise[YarnApplication]()
      val zkActorPath = s"$zkParentPath/$actorPath"
      val zkActorAddressPath = s"$zkActorPath${IncQueryDZooKeeper.addressPath}"
      IncQueryDZooKeeper.createDir(zkActorAddressPath)
      val watcher = new Watcher() {
        def process(event: WatchedEvent) {
          event.getType() match {
            case EventType.NodeCreated | EventType.NodeDataChanged => {
              val data = IncQueryDZooKeeper.getStringData(zkActorAddressPath)
              val url = HostAndPort.fromString(data)
              result.success(YarnApplication(url.getHostText, url.getPort, applicationIds.get(zkActorPath).get))
            }
            case _ => result.failure(new IllegalStateException(s"Unexpected event on ${zkActorAddressPath}: $event"))
          }
        }
      }
      IncQueryDZooKeeper.getStringDataWithWatcher(zkActorPath, watcher)
      result.future
    }
  }
  
  val actorSystemName = "incqueryd"
  val port = 2552
  val serviceActorName = "service"
  
  /**
   * Start one RemoteActorSystem on each yarn node
   */
  def startActorSystems(client : AdvancedYarnClient): List[Future[YarnApplication]] = {
    val jarPath = client.fileSystemUri + "/jars/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar" // XXX duplicated path
    val appMasterObjectName = ActorSystemsApplicationMaster.getClass.getName
    val appMasterClassName = appMasterObjectName.substring(0, appMasterObjectName.length - 1) // XXX
    
    val actorSystemMemory = "1024" // XXX read from ZK in the future
    val actorSystemCPU = 4         
    val yarnNodes = client.getRunningNodes()
    IncQueryDZooKeeper.registerYarnNodes(yarnNodes)
    
    val applicationId = client.runRemotely(
      "IncQuery-D Actor System",
      List(s"$$JAVA_HOME/bin/java -Xmx${memory_mb}m -XX:MaxPermSize=${memory_mb}m -XX:MaxDirectMemorySize=${memory_mb}m $appMasterClassName -jarpath $jarPath -memory $actorSystemMemory -cpu $actorSystemCPU"),
      jarPath,
      true)
    
    yarnNodes.map { yarnNode =>
      val result = Promise[YarnApplication]()
      val zkContainerAddressPath = IncQueryDZooKeeper.yarnNodesPath + "/" + yarnNode + IncQueryDZooKeeper.actorSystemPath
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

  def stopActorSystems() {
    val nodes = IncQueryDZooKeeper.getYarnNodesWithZK()
    nodes.foreach { node => 
        val asData = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.yarnNodesPath}/$node${IncQueryDZooKeeper.actorSystemPath}")
        val asURL = HostAndPort.fromString(asData)
        val serviceActor = AkkaUtils.findActor(new ActorId(actorSystemName, asURL.getHostText, port, YarnActorService.serviceActorName))
        serviceActor.ask(DisposeSystem())(AkkaUtils.defaultTimeout)
    }
    AkkaUtils.teminateClientActorSystem()
  }
}