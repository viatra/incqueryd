package hu.bme.mit.incqueryd.spark.workers

import org.apache.spark.streaming.dstream.ReceiverInputDStream
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import org.apache.spark.SparkFiles
import org.apache.spark.SparkEnv

/**
 * @author pappi
 */
object OutputStreamWorker {
  
  def process(queryName : String, stream : ReceiverInputDStream[Array[Byte]]) {
    val result = stream.map { msg => resolveIDs(deserializeProductionMessage(msg)) }
    result.foreachRDD { _.saveAsObjectFile(s"$RESULT_BASE_DIR/$queryName")}
  }
  
}
