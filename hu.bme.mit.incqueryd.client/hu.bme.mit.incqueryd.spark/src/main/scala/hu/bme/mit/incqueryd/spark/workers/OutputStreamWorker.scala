package hu.bme.mit.incqueryd.spark.workers

import org.apache.spark.streaming.dstream.ReceiverInputDStream
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.spark.mqtt.MQTTPublisher

/**
 * @author pappi
 */
object OutputStreamWorker {
  
  def process(queryName : String, stream : ReceiverInputDStream[Array[Byte]]) {
    val result = stream.map { msg => resolveIDs(deserializeProductionMessage[java.util.Set[Tuple]](msg).toSet) }
    result.foreachRDD { _.foreach {
      MQTTPublisher.publishResults(queryName, _)
    }}
  }
  
}
