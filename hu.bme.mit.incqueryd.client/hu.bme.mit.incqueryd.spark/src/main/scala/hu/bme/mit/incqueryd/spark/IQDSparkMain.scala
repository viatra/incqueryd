package hu.bme.mit.incqueryd.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.Milliseconds
import org.apache.spark.streaming.StreamingContext
import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import com.google.common.net.HostAndPort
import hu.bme.mit.incqueryd.spark.recievers.FileGraphLoadReceiver
import hu.bme.mit.incqueryd.spark.workers.InputStreamWorker
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import java.net.URL
import org.apache.commons.cli.Options
import org.apache.commons.cli.PosixParser
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import hu.bme.mit.incqueryd.actorservice.YarnActorService

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
    
    val ssc = new StreamingContext(sparkConf, Milliseconds(DURATION.toInt))

    // Create stream
    var stream : ReceiverInputDStream[String] = null
    METHOD match {
      case ProcessingMethod.HDFS_LOAD => stream = ssc.receiverStream(new FileGraphLoadReceiver(DS_URL))
      case ProcessingMethod.FOURSTORE_LOAD => throw new UnsupportedOperationException("Not supported yet!")
      case ProcessingMethod.WIKISTREAM => throw new UnsupportedOperationException("Not supported yet!")
    }
    
    // Processing stream
    InputStreamWorker.process(stream)

    ssc.start()
    
    if(!SINGLE)
      ssc.awaitTermination()
  }

}

object ProcessingMethod extends Enumeration {
  type Method = Value
  val HDFS_LOAD, FOURSTORE_LOAD, WIKISTREAM = Value
}