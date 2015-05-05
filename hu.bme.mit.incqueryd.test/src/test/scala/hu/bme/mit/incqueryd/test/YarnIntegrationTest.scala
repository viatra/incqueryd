package hu.bme.mit.incqueryd.test

import org.apache.hadoop.yarn.conf.YarnConfiguration
import org.junit.Test
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

class YarnIntegrationTest {

  @Test
  def main() {
    implicit val conf = createConfiguration
    val client = initYarnClient(conf)
    val app = client.createApplication
    val amContainerSpec = initApplicationMasterContainerSpec
    val resource = initResource
    val appContext = initAppContext(app, amContainerSpec, resource)
    client.submitApplication(appContext)
  }

  def createConfiguration() = {
    val conf = new YarnConfiguration()
    conf.set(YarnConfiguration.RM_HOSTNAME, "yarn-rm.docker")
    conf
  }

  def initYarnClient(implicit conf: YarnConfiguration): YarnClient = {
    val client = YarnClient.createYarnClient()
    client.init(conf)
    client.start()
    client
  }

  def initApplicationMasterContainerSpec(implicit conf: YarnConfiguration) = {
    val amContainer = Records.newRecord(classOf[ContainerLaunchContext])
    //application master is a just java program with given commands
    amContainer.setCommands(List(
      "echo Hello").asJava)
    //add the jar which contains the Application master code to classpath
    //    val appMasterJar = setUpLocalResource(new Path(jarPath))
    //    amContainer.setLocalResources(Collections.singletonMap("appMaster.jar", appMasterJar))
    val env = setUpEnv
    amContainer.setEnvironment(env)
    amContainer
  }

  def setUpLocalResource(resourcePath: Path)(implicit conf: Configuration) = {
    val resource = Records.newRecord(classOf[LocalResource])
    val jarStat = FileSystem.get(conf).getFileStatus(resourcePath)
    resource.setResource(ConverterUtils.getYarnUrlFromPath(resourcePath))
    resource.setSize(jarStat.getLen())
    resource.setTimestamp(jarStat.getModificationTime())
    resource.setType(LocalResourceType.FILE)
    resource.setVisibility(LocalResourceVisibility.PUBLIC)
    resource
  }

  def setUpEnv(implicit conf: YarnConfiguration) = {
    val env = Maps.newHashMap[String, String]()
    val classPath = conf.getStrings(YarnConfiguration.YARN_APPLICATION_CLASSPATH, YarnConfiguration.DEFAULT_YARN_APPLICATION_CLASSPATH: _*)
    for (c <- classPath) {
      Apps.addToEnvironment(env, Environment.CLASSPATH.name(),
        c.trim())
    }
    Apps.addToEnvironment(env,
      Environment.CLASSPATH.name(),
      Environment.PWD.$() + File.separator + "*")
    env
  }

  def initResource = {
    val resource = Records.newRecord(classOf[Resource])
    resource.setMemory(300)
    resource.setVirtualCores(1)
    resource
  }

  def initAppContext(app: YarnClientApplication, amContainerSpec: ContainerLaunchContext, resource: Resource) = {
    val appContext = app.getApplicationSubmissionContext
    appContext.setApplicationName("IncQuery-D")
    appContext.setAMContainerSpec(amContainerSpec)
    appContext.setResource(resource)
    appContext.setQueue("default")
    appContext
  }

}