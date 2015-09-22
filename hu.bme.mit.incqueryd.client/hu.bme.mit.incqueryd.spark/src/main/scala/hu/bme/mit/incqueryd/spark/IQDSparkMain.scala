package hu.bme.mit.incqueryd.spark

import java.net.URL
import org.apache.commons.cli.Options
import org.apache.commons.cli.PosixParser
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import org.apache.spark.SparkConf
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkException
import org.apache.spark.scheduler.JobResult
import org.apache.spark.scheduler.SparkListener
import org.apache.spark.scheduler.SparkListenerJobEnd
import org.apache.spark.scheduler.SparkListenerJobEnd
import org.apache.spark.streaming.Milliseconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.scheduler.StreamingListener
import org.apache.spark.streaming.scheduler.StreamingListenerBatchCompleted
import org.apache.spark.streaming.scheduler.StreamingListenerReceiverStopped
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend
import hu.bme.mit.incqueryd.spark.recievers.RDFGraphLoadReceiver
import hu.bme.mit.incqueryd.spark.recievers.WikiStreamReceiver
import hu.bme.mit.incqueryd.spark.utils.Delta
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.spark.workers.InputStreamWorker
import hu.bme.mit.incqueryd.spark.workers.OutputStreamWorker
import scala.sys.process.Process
import akka.actor.Props
import hu.bme.mit.incqueryd.spark.recievers.ProductionReceiver
import hu.bme.mit.incqueryd.spark.mqtt.MQTTPublisher
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage


/**
 * @author pappi
 */
object IQDSparkMain extends Serializable {

  val options = new Options  // XXX create option groups
  options.addOption(OPTION_PROCESSING_METHOD, true, "Stream processing method: HDFS_LOAD | FOURSTORE_LOAD | WIKISTREAM | OUTPUTSTREAM")
  options.addOption(OPTION_DURATION, true, "Duration time in milliseconds")
  options.addOption(OPTION_DATASOURCE_URL, true, "Datasource URL")
  options.addOption(OPTION_NO_DATA_TIMEOUT_MS, true, "No data time limit (ms)")
  options.addOption(OPTION_QUERY_ID, true, "Query name - in case of output stream processing application")
  options.addOption(OPTION_SINGLE_RUN, false, "Stop processing after data run out")
  
  def main(args: Array[String]) {
    val parser = (new PosixParser).parse(options, args)
    val DS_URL = parser.getOptionValue(OPTION_DATASOURCE_URL)
    val METHOD = ProcessingMethod.withName(parser.getOptionValue(OPTION_PROCESSING_METHOD))
    val DURATION = parser.getOptionValue(OPTION_DURATION).toLong
    val SINGLE = parser.hasOption(OPTION_SINGLE_RUN)
    val QUERY = if(parser.hasOption(OPTION_QUERY_ID)) parser.getOptionValue(OPTION_QUERY_ID) else ""
    val NO_DATA_TIMEOUT = if(parser.hasOption(OPTION_NO_DATA_TIMEOUT_MS)) parser.getOptionValue(OPTION_NO_DATA_TIMEOUT_MS).toLong else -1
    
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)
    
    val sparkConf = new SparkConf
    sparkConf.set("spark.scheduler.mode", "FAIR")
    sparkConf.set("spark.executor.instances", "3")
    
    val ssc = new StreamingContext(sparkConf, Milliseconds(DURATION))

    // Create stream
    val receiver = METHOD match {
      case ProcessingMethod.HDFS_LOAD => new RDFGraphLoadReceiver(new DatabaseConnection(DS_URL, Backend.FILE))
      case ProcessingMethod.FOURSTORE_LOAD => new RDFGraphLoadReceiver(new DatabaseConnection(DS_URL, Backend.FOURSTORE))
      case ProcessingMethod.WIKISTREAM => new WikiStreamReceiver(new DatabaseConnection(DS_URL, Backend.FOURSTORE))
      case _ => {}
    }
    
    val stream = METHOD match {
      // Input streams
      case ProcessingMethod.HDFS_LOAD | ProcessingMethod.FOURSTORE_LOAD | ProcessingMethod.WIKISTREAM => 
        InputStreamWorker.process(ssc.receiverStream(receiver.asInstanceOf[Receiver[Delta]]))
      
      // Output streams
      case ProcessingMethod.PRODUCTIONSTREAM =>
        OutputStreamWorker.process(QUERY, ssc.actorStream[Array[Byte]](Props(new ProductionReceiver(DS_URL)), "productionReceiver"))
    }
    ssc.sparkContext.addJar(HDFS_JAR_PATH)
    if(SINGLE) {
      val procFinishedListener = new ProcessingFinishedListener(ssc, NO_DATA_TIMEOUT / DURATION)
      ssc.addStreamingListener(procFinishedListener)
      ssc.sparkContext.addSparkListener(procFinishedListener)
    }
    
    ssc.start()
    ssc.awaitTermination()
    
  }

}

class ProcessingFinishedListener(ssc : StreamingContext, batchIdleLimit : Long) extends StreamingListener with SparkListener {
  
  var currentBatchIdle : Long = 0
  var processingFinished : Boolean = false
  
  override def onBatchCompleted(batchCompleted : StreamingListenerBatchCompleted) {
    // If no processed record increase idle counter
    if(batchCompleted.batchInfo.numRecords == 0) 
      currentBatchIdle+=1;
    else 
      currentBatchIdle = 0
    
    if(currentBatchIdle >= batchIdleLimit) {
      ssc.sparkContext.cancelAllJobs()
      val applicationId = ssc.sparkContext.applicationId
      val process = Process(s"/usr/local/hadoop/bin/yarn application -kill $applicationId")
      process.run()
    }
  }
}

object ProcessingMethod extends Enumeration {
  type Method = Value
  val HDFS_LOAD, FOURSTORE_LOAD, WIKISTREAM, PRODUCTIONSTREAM = Value
}
