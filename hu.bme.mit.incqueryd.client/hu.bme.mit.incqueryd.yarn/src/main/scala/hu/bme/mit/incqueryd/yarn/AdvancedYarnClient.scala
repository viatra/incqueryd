package hu.bme.mit.incqueryd.yarn

import org.apache.hadoop.yarn.conf.YarnConfiguration
import org.apache.hadoop.yarn.client.api.YarnClient
import org.apache.hadoop.yarn.api.records.LocalResource
import org.apache.hadoop.yarn.api.records.ContainerLaunchContext
import org.apache.hadoop.yarn.util.Records
import org.apache.hadoop.fs.Path
import org.apache.hadoop.yarn.api.ApplicationConstants
import java.util.Collections
import org.apache.hadoop.yarn.api.records.Resource
import scala.collection.JavaConverters._
import org.apache.hadoop.yarn.util.Apps
import org.apache.hadoop.yarn.api.ApplicationConstants.Environment
import com.google.common.collect.Maps
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.yarn.api.records.LocalResourceVisibility
import org.apache.hadoop.yarn.api.records.LocalResourceType
import org.apache.hadoop.yarn.util.ConverterUtils
import org.apache.hadoop.fs.FileSystem
import java.io.File
import org.apache.hadoop.yarn.client.api.YarnClientApplication
import org.apache.hadoop.yarn.api.records.ApplicationId

class AdvancedYarnClient(rmHostname: String) {

  val conf = {
    val conf = new YarnConfiguration()
    conf.set(YarnConfiguration.RM_HOSTNAME, rmHostname)
    conf
  }

	val client = {
    val client = YarnClient.createYarnClient()
    client.init(conf)
    client.start()
    client
  }

  def runRemotely(commands: List[String]) = {
    val app = client.createApplication
    val amContainerSpec = initApplicationMasterContainerSpec(commands)
    val resource = initResource
    val appContext = initAppContext(app, amContainerSpec, resource)
    client.submitApplication(appContext)
  }
  
  def getIp(applicationId: ApplicationId) = {
    client.getApplicationReport(applicationId).getHost
  }

  private def initApplicationMasterContainerSpec(commands: List[String]) = {
    val amContainer = Records.newRecord(classOf[ContainerLaunchContext])
    amContainer.setCommands(commands.asJava)
    val env = setUpEnv
    amContainer.setEnvironment(env)
    amContainer
  }

  private def setUpLocalResource(resourcePath: Path) = {
    val resource = Records.newRecord(classOf[LocalResource])
    val jarStat = FileSystem.get(conf).getFileStatus(resourcePath)
    resource.setResource(ConverterUtils.getYarnUrlFromPath(resourcePath))
    resource.setSize(jarStat.getLen())
    resource.setTimestamp(jarStat.getModificationTime())
    resource.setType(LocalResourceType.FILE)
    resource.setVisibility(LocalResourceVisibility.PUBLIC)
    resource
  }

  private def setUpEnv = {
    val env = Maps.newHashMap[String, String]()
    val classPath = conf.getStrings(YarnConfiguration.YARN_APPLICATION_CLASSPATH, YarnConfiguration.DEFAULT_YARN_APPLICATION_CLASSPATH: _*)
    for (c <- classPath) {
      Apps.addToEnvironment(env,
        Environment.CLASSPATH.name(),
        c.trim())
    }
    Apps.addToEnvironment(env,
      Environment.CLASSPATH.name(),
      Environment.PWD.$() + File.separator + "*")
    env
  }

  private def initResource = {
    val resource = Records.newRecord(classOf[Resource])
    resource.setMemory(300)
    resource.setVirtualCores(1)
    resource
  }

  private def initAppContext(app: YarnClientApplication, amContainerSpec: ContainerLaunchContext, resource: Resource) = {
    val appContext = app.getApplicationSubmissionContext
    appContext.setApplicationName("IncQuery-D")
    appContext.setAMContainerSpec(amContainerSpec)
    appContext.setResource(resource)
    appContext.setQueue("default")
    appContext
  }
 
}