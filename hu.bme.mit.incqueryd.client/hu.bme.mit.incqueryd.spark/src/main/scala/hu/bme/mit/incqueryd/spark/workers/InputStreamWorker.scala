package hu.bme.mit.incqueryd.spark.workers

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkEnv
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import scala.collection.JavaConverters._
import java.lang.Long
import hu.bme.mit.incqueryd.spark.utils.Delta

/**
 * @author pappi
 */
object InputStreamWorker {

  def process(stream: ReceiverInputDStream[Delta]) {
    // TODO: implement ID generation
    stream.foreachRDD {_.foreach { record =>
        val inputActorPath = record.inputActorPath
        val inputType = record.inputType
        val changeType = record.changeType
        val data = record.data
        
        val tupleSet = new java.util.HashSet[Tuple]
        
        // XXX ID generation
        inputType match {
          case RecipeUtils.VERTEX => tupleSet.add(new Tuple(Long.valueOf(data(0))))
          case RecipeUtils.EDGE => tupleSet.add(new Tuple(Long.valueOf(data(0)), Long.valueOf(data(1))))
          case RecipeUtils.ATTRIBUTE => tupleSet.add(new Tuple(Long.valueOf(data(0)), data(1)))
        }
        
        propagateToInput(inputActorPath, new ChangeSet(tupleSet, changeType))
      }
    }
  }

}