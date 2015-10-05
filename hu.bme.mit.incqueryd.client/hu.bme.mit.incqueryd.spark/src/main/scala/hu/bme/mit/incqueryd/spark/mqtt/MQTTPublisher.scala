package hu.bme.mit.incqueryd.spark.mqtt

import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import org.apache.spark.util.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._

/**
 * @author pappi
 */
object MQTTPublisher {
  
  def publishResults(topic : String, results : Set[Tuple]) {
    val client = new MqttClient(BROKER_URL, MqttClient.generateClientId)
    if(!client.isConnected()) client.connect()
    val msgTopic = client.getTopic(topic)
    val message = new MqttMessage(AkkaUtils.serializeMessage(results))
    message.setQos(0)
    msgTopic.publish(message)
    client.disconnect()
  }
}
