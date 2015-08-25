package hu.bme.mit.incqueryd.spark.workers

import org.apache.spark.streaming.dstream.ReceiverInputDStream

/**
 * @author pappi
 */
object OutputStreamWorkers {
  
  def process(stream : ReceiverInputDStream[String]) {
    // TODO: implement output stream processing
    // - Get result data from production node (AkkaReceiver)
    // - Implement ID resolution
    // - Redirect process stream to destination (e.g. dashboard)
  }
  
}