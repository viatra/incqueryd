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
import java.io.InputStream
import org.apache.commons.io.IOUtils
import java.io.FileInputStream

class AdvancedYarnClient(rmHostname: String, val fileSystemUri: String) {

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

  def runRemotely(commands: List[String], jarPath: String, useDefaultClassPath: Boolean) = {
    val app = client.createApplication
    val amContainerSpec = initApplicationMasterContainerSpec(commands, jarPath, useDefaultClassPath)
    val resource = initResource
    val appContext = initAppContext(app, amContainerSpec, resource)
    client.submitApplication(appContext)
  }

  def kill(applicationId: ApplicationId) = {
    client.killApplication(applicationId)
  }

  private def initApplicationMasterContainerSpec(commands: List[String], jarPath: String, useDefaultClassPath: Boolean) = {
    val amContainer = Records.newRecord(classOf[ContainerLaunchContext])
    amContainer.setCommands(commands.asJava)
    val appMasterJar = AdvancedYarnClient.setUpLocalResource(new Path(jarPath), HdfsUtils.getDistributedFileSystem(fileSystemUri))
    amContainer.setLocalResources(Collections.singletonMap("appMaster.jar", appMasterJar))
    val env = AdvancedYarnClient.setUpEnv(conf, useDefaultClassPath)
    amContainer.setEnvironment(env)
    amContainer
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

object AdvancedYarnClient {

  def setUpLocalResource(resourcePath: Path, fileSystem: FileSystem) = {
    val resource = Records.newRecord(classOf[LocalResource])
    val jarStat = fileSystem.getFileStatus(resourcePath)
    resource.setResource(ConverterUtils.getYarnUrlFromPath(resourcePath))
    resource.setSize(jarStat.getLen())
    resource.setTimestamp(jarStat.getModificationTime())
    resource.setType(LocalResourceType.FILE)
    resource.setVisibility(LocalResourceVisibility.PUBLIC)
    resource
  }

  def setUpEnv(conf: YarnConfiguration, useDefaultClassPath: Boolean) = {
    val env = Maps.newHashMap[String, String]()
    if (useDefaultClassPath) {
      val classPath = conf.getStrings(YarnConfiguration.YARN_APPLICATION_CLASSPATH, YarnConfiguration.DEFAULT_YARN_APPLICATION_CLASSPATH: _*)
      for (c <- classPath) {
        Apps.addToEnvironment(env,
          Environment.CLASSPATH.name(),
          c.trim())
      }
    }
    Apps.addToEnvironment(env,
      Environment.CLASSPATH.name(),
      Environment.PWD.$() + File.separator + "*")
    env
  }

}