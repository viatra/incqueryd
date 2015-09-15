package hu.bme.mit.incqueryd.spark.workers

import org.apache.spark.streaming.dstream.ReceiverInputDStream
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import java.util.HashSet

/**
 * @author pappi
 */
object OutputStreamWorker {
  
  def process(stream : ReceiverInputDStream[Set[Tuple]]) {
    val resolvedTupleSet : Set[Tuple] = Set[Tuple]()
    stream.foreachRDD(_.foreach { tupleSet =>
      tupleSet.foreach { IQDSparkUtils.writeln(_) } // TODO: propagate data to dashboard
    })
  }
  
}