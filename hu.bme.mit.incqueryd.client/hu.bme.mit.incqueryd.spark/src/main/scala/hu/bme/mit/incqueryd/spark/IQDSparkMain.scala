package hu.bme.mit.incqueryd.spark

import java.net.URL
import org.apache.commons.cli.Options
import org.apache.commons.cli.PosixParser
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import org.apache.spark.SparkConf
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Milliseconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver
import akka.actor.Props
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend
import hu.bme.mit.incqueryd.spark.recievers.ProductionReceiver
import hu.bme.mit.incqueryd.spark.recievers.RDFGraphLoadReceiver
import hu.bme.mit.incqueryd.spark.recievers.WikiStreamReceiver
import hu.bme.mit.incqueryd.spark.utils.Delta
import hu.bme.mit.incqueryd.spark.workers.InputStreamWorker
import akka.actor.Actor
import hu.bme.mit.incqueryd.spark.workers.OutputStreamWorker
import org.apache.spark.scheduler.SparkListener
import org.apache.spark.streaming.scheduler.StreamingListener
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import org.apache.spark.SparkContext
import org.apache.spark.scheduler.SparkListenerJobEnd
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._

/**
 * @author pappi
 */
object IQDSparkMain extends Serializable {

  val options = new Options
  options.addOption("method", true, "Stream processing method: HDFS_LOAD | FOURSTORE_LOAD | WIKISTREAM")
  options.addOption("duration", true, "Duration time in milliseconds")
  options.addOption("ds_url", true, "Datasource URL")
  options.addOption("single", false, "Stop processing after data run out")
  
  def main(args: Array[String]) {
    val parser = (new PosixParser).parse(options, args)
    val DS_URL = parser.getOptionValue("ds_url")
    val METHOD = ProcessingMethod.withName(parser.getOptionValue("method"))
    val DURATION = parser.getOptionValue("duration")
    val SINGLE = parser.hasOption("single")

    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)
    
    val sparkConf = new SparkConf
    sparkConf.set("spark.scheduler.mode", "FAIR")
    sparkConf.set("spark.executor.instances", "3")
    sparkConf.setJars(IQDSparkUtils.getJars())
    sparkConf.set("spark.executor.extraLibraryPath", TARGET_PATH)
    val ssc = new StreamingContext(sparkConf, Milliseconds(DURATION.toInt))

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
        OutputStreamWorker.process(ssc.actorStream[Set[Tuple]](Props(new ProductionReceiver[Set[Tuple]](DS_URL)), "productionReceiver"))
    }
    
    if(SINGLE) {
      ssc.sparkContext.addSparkListener(new LoadSparkListener(ssc))
    }
    ssc.start()
    ssc.awaitTermination()
    
  }

}

class LoadSparkListener(ssc : StreamingContext) extends SparkListener {
  override def onJobEnd(jobEnd : SparkListenerJobEnd) {
    IQDSparkUtils.writeln(jobEnd.jobResult)
    ssc.stop(true, false)
  }
}

object ProcessingMethod extends Enumeration {
  type Method = Value
  val HDFS_LOAD, FOURSTORE_LOAD, WIKISTREAM, PRODUCTIONSTREAM = Value
}
