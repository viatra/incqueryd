package hu.bme.mit.incqueryd.spark

import java.net.URL

import scala.sys.process.Process

import org.apache.commons.cli.Options
import org.apache.commons.cli.PosixParser
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import org.apache.spark.SparkConf
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkException
import org.apache.spark.scheduler.JobResult
import org.apache.spark.scheduler.SparkListener
import org.apache.spark.streaming.Milliseconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.scheduler.StreamingListener
import org.apache.spark.streaming.scheduler.StreamingListenerBatchCompleted

import akka.actor.Props
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend
import hu.bme.mit.incqueryd.spark.recievers.ProductionReceiver
import hu.bme.mit.incqueryd.spark.recievers.RDFGraphLoadReceiver
import hu.bme.mit.incqueryd.spark.recievers.WikidataStreamReceiver
import hu.bme.mit.incqueryd.spark.utils.Delta
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.spark.workers.InputStreamWorker
import hu.bme.mit.incqueryd.spark.workers.OutputStreamWorker
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper


/**
 * @author pappi
 */
object IQDSparkMain extends Serializable {

  val options = new Options  // XXX create option groups
  options.addOption(OPTION_PROCESSING_METHOD, true, "Stream processing method: LOAD | WIKISTREAM | OUTPUTSTREAM")
  options.addOption(OPTION_DATABASE_BACKEND, true, "Database backend in case of load method")
  options.addOption(OPTION_DURATION, true, "Duration time in milliseconds")
  options.addOption(OPTION_DATASOURCE_URL, true, "Datasource URL")
  options.addOption(OPTION_QUERY_ID, true, "Query name - in case of output stream processing application")
  options.addOption(OPTION_NUM_EXECUTORS, true, "Executor instances")
  options.addOption(OPTION_SCHEDULER_MODE, true, "Scheduler mode")
  
  def main(args: Array[String]) {
    val parser = (new PosixParser).parse(options, args)
    val DS_URL = parser.getOptionValue(OPTION_DATASOURCE_URL)
    val METHOD = ProcessingMethod.withName(parser.getOptionValue(OPTION_PROCESSING_METHOD))
    val DURATION = parser.getOptionValue(OPTION_DURATION).toLong
    val QUERY = if(parser.hasOption(OPTION_QUERY_ID)) parser.getOptionValue(OPTION_QUERY_ID) else ""
    val EXECUTORS = if(parser.hasOption(OPTION_NUM_EXECUTORS)) parser.getOptionValue(OPTION_NUM_EXECUTORS) else "3"
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)
    
    val sparkConf = new SparkConf
    sparkConf.set("spark.scheduler.mode", parser.getOptionValue(OPTION_SCHEDULER_MODE, "FAIR"))
    sparkConf.set("spark.executor.instances", EXECUTORS)
    
    val ssc = new StreamingContext(sparkConf, Milliseconds(DURATION))

    // Create stream
    val receiver = METHOD match {
      case ProcessingMethod.LOAD => {
        val backend = Backend.valueOf(parser.getOptionValue(OPTION_DATABASE_BACKEND))
        new RDFGraphLoadReceiver(new DatabaseConnection(DS_URL, backend))
      }
      case ProcessingMethod.WIKISTREAM => new WikidataStreamReceiver(new DatabaseConnection(DS_URL, Backend.SPARQL))
      case _ => {}
    }
    
    val stream = METHOD match {
      // Input streams
      case ProcessingMethod.LOAD | ProcessingMethod.WIKISTREAM => 
        InputStreamWorker.process(ssc.receiverStream(receiver.asInstanceOf[Receiver[Set[Delta]]]))
      
      // Output streams
      case ProcessingMethod.PRODUCTIONSTREAM =>
        OutputStreamWorker.process(QUERY, ssc.actorStream[Array[Byte]](Props(new ProductionReceiver(DS_URL)), "productionReceiver"))
    }
    ssc.sparkContext.addJar(HDFS_JAR_PATH)
    
    ssc.start()
    ssc.awaitTermination()
    
  }

}

object ProcessingMethod extends Enumeration {
  type Method = Value
  val LOAD, WIKISTREAM, PRODUCTIONSTREAM = Value
}
