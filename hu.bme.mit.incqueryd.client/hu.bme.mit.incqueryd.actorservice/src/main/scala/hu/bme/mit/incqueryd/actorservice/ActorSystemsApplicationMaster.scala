package hu.bme.mit.incqueryd.actorservice

import java.util.Collections
import org.apache.hadoop.fs.Path
import org.apache.hadoop.yarn.api.ApplicationConstants
import org.apache.hadoop.yarn.api.records._
import org.apache.hadoop.yarn.client.api.AMRMClient.ContainerRequest
import org.apache.hadoop.yarn.client.api.{ AMRMClient, NMClient }
import org.apache.hadoop.yarn.conf.YarnConfiguration
import org.apache.hadoop.yarn.util.Records
import scala.collection.JavaConverters._
import org.apache.hadoop.fs.FileSystem
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import org.apache.hadoop.yarn.api.records.ContainerLaunchContext
import org.apache.hadoop.yarn.api.records.Priority
import org.apache.hadoop.yarn.api.records.Resource
import org.apache.hadoop.yarn.api.records.ContainerLaunchContext
import org.apache.hadoop.yarn.api.records.Priority
import org.apache.hadoop.yarn.api.records.Resource
import org.apache.commons.cli.Options
import org.apache.commons.cli.PosixParser

object ActorSystemsApplicationMaster {
  
  
  
  val options = new Options
  options.addOption("jarpath", true, "JAR path")
  options.addOption("memory", true, "Requested memory in MB")
  options.addOption("cpu", true, "Requested CPU cores")
  
  def main(args: Array[String]) {
    val parser = (new PosixParser).parse(options, args)
    val jarPath = parser.getOptionValue("jarpath")
    val memory_mb = parser.getOptionValue("memory")
    val cpu_cores = parser.getOptionValue("cpu")
    
    val applicationClassName = "hu.bme.mit.incqueryd.actorservice.server.ActorSystemApplication"  // XXX duplicated class name to avoid dependency on runtime

    // Create new YARN configuration
    implicit val conf = new YarnConfiguration()
    
    conf.set(YarnConfiguration.RM_SCHEDULER_MAXIMUM_ALLOCATION_MB, memory_mb)
    
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

    //resources needed by each ActorSystem
    val resource = Records.newRecord(classOf[Resource])
    resource.setMemory(new Integer(memory_mb))
    resource.setVirtualCores(new Integer(cpu_cores))

    val nodes = IncQueryDZooKeeper.getYarnNodesWithZK()

    nodes.foreach { node =>
      val nodesarray = new Array[String](1)
      nodesarray(0) = node
      val containerRequest = new ContainerRequest(resource, nodesarray, null, priority, true)
      rmClient.addContainerRequest(containerRequest)
    }
    
    var neededContainers = nodes.length
    var responseId = 0
    var completedContainers = 0
    val nodesIt = nodes.iterator

    while (completedContainers < neededContainers) {

      val appMasterJar = AdvancedYarnClient.setUpLocalResource(new Path(jarPath), FileSystem.get(conf))

      val env = AdvancedYarnClient.setUpEnv(conf, false)

      val response = rmClient.allocate(responseId + 1)
      responseId += 1

      for (container <- response.getAllocatedContainers.asScala) {
        
        val zkActorSystemAddress = "/" + nodesIt.next() + IncQueryDZooKeeper.actorSystemPath

        val ctx = Records.newRecord(classOf[ContainerLaunchContext])

        ctx.setCommands(
          List(
            s"$$JAVA_HOME/bin/java -Xmx${memory_mb}m -XX:MaxPermSize=${memory_mb}m -XX:MaxDirectMemorySize=${memory_mb}m -agentlib:jdwp=transport=dt_socket,address=9999,server=y,suspend=n $applicationClassName $zkActorSystemAddress " +
              " 1>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stdout" +
              " 2>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stderr").asJava)
        ctx.setLocalResources(Collections.singletonMap("appMaster.jar", appMasterJar))
        ctx.setEnvironment(env)

        System.out.println("Launching container " + container)
        nmClient.startContainer(container, ctx)

        // val ip = container.getNodeHttpAddress.replaceFirst(":\\d+", "")

      }

      for (status <- response.getCompletedContainersStatuses.asScala) {
        println("Completed container " + status.getContainerId)
        completedContainers += 1
      }

      Thread.sleep(1000)
    }
    rmClient.unregisterApplicationMaster(FinalApplicationStatus.SUCCEEDED, "", "")
    rmClient.stop()
  }

}
