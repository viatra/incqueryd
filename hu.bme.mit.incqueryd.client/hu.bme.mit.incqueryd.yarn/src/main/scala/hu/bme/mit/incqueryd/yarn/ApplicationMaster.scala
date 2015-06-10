package hu.bme.mit.incqueryd.yarn

import java.util.Collections
import org.apache.hadoop.fs.Path
import org.apache.hadoop.yarn.api.ApplicationConstants
import org.apache.hadoop.yarn.api.records._
import org.apache.hadoop.yarn.client.api.AMRMClient.ContainerRequest
import org.apache.hadoop.yarn.client.api.{ AMRMClient, NMClient }
import org.apache.hadoop.yarn.conf.YarnConfiguration
import org.apache.hadoop.yarn.util.Records
import org.apache.hadoop.yarn.api.records.Container
import scala.collection.JavaConverters._
import org.apache.zookeeper.ZooKeeper
import org.apache.zookeeper.Watcher
import org.apache.zookeeper.WatchedEvent
import java.net.URL
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem

object ApplicationMaster {

  def main(args: Array[String]){
    val jarPath = args(0)
    val mainClass = args(1)
    val zkAMPath = args(2)
    val applicationArgument = args(3)

    // Create new YARN configuration
    implicit val conf = new YarnConfiguration()

    // Create a client to talk to the RM
    val rmClient = AMRMClient.createAMRMClient().asInstanceOf[AMRMClient[ContainerRequest]]

    // Initialize YARN client with configuration
    rmClient.init(conf)

    // Start YARN client
    rmClient.start()

    /*
     * Register ApplicationMaster(appHostName, appHostPort, appTrackingURL)
     */
    rmClient.registerApplicationMaster("", 0, "")

    //create a client to talk to NM
    val nmClient = NMClient.createNMClient()
    nmClient.init(conf)
    nmClient.start()

    // set priority
    val priority = Records.newRecord(classOf[Priority])
    priority.setPriority(0)

    //resources needed by each container
    val resource = Records.newRecord(classOf[Resource])
    resource.setMemory(200)
    resource.setVirtualCores(1)

    val containerRequest = new ContainerRequest(resource, null, null, priority, true)
    rmClient.addContainerRequest(containerRequest)
    
    val containerPaths = IncQueryDZooKeeper.getChildPaths(zkAMPath)
    
    var neededContainers = containerPaths.length
    var responseId = 0
    var completedContainers = 0
    val containerPathIt = containerPaths.iterator
    
    while (completedContainers < neededContainers) {

      val appMasterJar = AdvancedYarnClient.setUpLocalResource(new Path(jarPath), FileSystem.get(conf))

      val env = AdvancedYarnClient.setUpEnv(conf, false)

      val response = rmClient.allocate(responseId + 1)
      responseId += 1

      for (container <- response.getAllocatedContainers.asScala) {

        val ctx = Records.newRecord(classOf[ContainerLaunchContext])

        ctx.setCommands(
            List(
              "$JAVA_HOME/bin/java -Xmx64m -XX:MaxPermSize=64m -XX:MaxDirectMemorySize=128M " + mainClass + " " + applicationArgument +
                " 1>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stdout" +
                " 2>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stderr").asJava)
        ctx.setLocalResources(Collections.singletonMap("appMaster.jar", appMasterJar))
        ctx.setEnvironment(env)

        System.out.println("Launching container " + container)
        nmClient.startContainer(container, ctx)
        
        val ip = container.getNodeHttpAddress
        IncQueryDZooKeeper.setData(zkAMPath + "/" + containerPathIt.next() + "/ip", ip.getBytes)
      }

      for (status <- response.getCompletedContainersStatuses.asScala) {
        println("Completed container " + status.getContainerId)
        completedContainers += 1
      }

      Thread.sleep(10000)
    }
    rmClient.unregisterApplicationMaster(FinalApplicationStatus.SUCCEEDED, "", "")
    rmClient.stop()
  }

}
