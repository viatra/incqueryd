package hu.bme.mit.incqueryd.dashboard.mqtt

import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.MqttCallback

/**
 * @author pappi
 */
class MQTTSubscriber(brokerUrl : String) {

  val persistence = new MemoryPersistence()
  
  val client = new MqttClient(brokerUrl, MqttClient.generateClientId(), persistence)
  
  var started = false
  
  def start(topic: String, callback: MqttCallback) {
    
    client.setCallback(callback)

    client.connect()

    client.subscribe(topic)
    
    started = true;
  }
  
  def isActive() : Boolean = {
    client.isConnected() && started
  }
  
  def stop() {
    client.disconnect()  
    started = false;
  }
}