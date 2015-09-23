package hu.bme.mit.incqueryd.dashboard.mqtt

import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.storage.StorageLevel
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._

/**
 * @author pappi
 */
class MQTTReceiver(brokerUrl : String, queryName : String) extends Receiver[Set[Tuple]](StorageLevel.MEMORY_ONLY){
  
  val subscriber = new MQTTSubscriber(brokerUrl)
  
  def onStart() {

    val callback = new MqttCallback() {

      override def messageArrived(topic: String, message: MqttMessage) {
        store(deserializeProductionMessage[Set[Tuple]](message.getPayload()))
      }
      
      override def deliveryComplete(token: IMqttDeliveryToken) {}
      
      override def connectionLost(cause: Throwable) {
        restart("Connection lost ", cause)
      }
    
    }
    
    subscriber.start(queryName, callback)

  }
  
  def onStop() {
    subscriber.stop()
  }
  
}