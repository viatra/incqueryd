package hu.bme.mit.incqueryd.dashboard.utils

import org.eclipse.paho.client.mqttv3.MqttClient
import scala.collection.mutable.HashMap
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTSubscriber
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage
import hu.bme.mit.incqueryd.dashboard.controller.DashboardController
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken


/**
 * @author pappi
 */
object DashboardUtils {

  val JETTY_PORT = 7070
  val SEPARATOR = "_"
  
  
  def createPatternId(pattern : String, query : String) : String = {
    s"${query}$SEPARATOR${pattern}"
  }
  
  def resolvePattern(patternId : String) : String = {
    patternId.split(SEPARATOR).tail.mkString(SEPARATOR)
  }
  
  def resolveQuery(patternId : String) : String = {
    patternId.split(SEPARATOR).head
  }
}