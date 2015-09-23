package hu.bme.mit.incqueryd.dashboard.utils

import org.eclipse.paho.client.mqttv3.MqttClient
import scala.collection.mutable.HashMap
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTSubscriber
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage
import hu.bme.mit.incqueryd.dashboard.controller.DashboardController
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._

/**
 * @author pappi
 */
object DashboardUtils {

  val JETTY_PORT = 7070

}