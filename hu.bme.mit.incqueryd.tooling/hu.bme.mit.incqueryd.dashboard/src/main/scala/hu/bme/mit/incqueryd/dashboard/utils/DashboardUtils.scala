package hu.bme.mit.incqueryd.dashboard.utils

import org.eclipse.paho.client.mqttv3.MqttClient
import scala.collection.mutable.HashMap
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTSubscriber
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage
import hu.bme.mit.incqueryd.dashboard.controller.DashboardController
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import java.io.File


/**
 * @author pappi
 */
object DashboardUtils {

  val JETTY_PORT = 7070
  val SEPARATOR = "_"
  
  val DEVELOPER_DASHBOARD_CONFIG_DIRECTORY = "iqd_dev_dashboard_configs"
  val DEVELOPER_DASHBOARD_CONFIGFILE_EXTENSION = ".json"
  
  def createPatternId(pattern : String, query : String) : String = {
    s"${query}$SEPARATOR${pattern}"
  }
  
  def resolvePattern(patternId : String) : String = {
    patternId.split(SEPARATOR).tail.mkString(SEPARATOR)
  }
  
  def resolveQuery(patternId : String) : String = {
    patternId.split(SEPARATOR).head
  }
  
  def getConfigFolderPath() : String = {
    getConfigFolder().getAbsolutePath + File.separator
  }
  
  def getConfigFolder() : File = {
    val configFolder = new File ( System.getProperty( "user.home" ) + File.separator + DashboardUtils.DEVELOPER_DASHBOARD_CONFIG_DIRECTORY )
    configFolder.mkdirs();
    configFolder
  }
  
  def getConfigFiles() : Array[String] = {
    getConfigFolder.list();
  }
  
}
