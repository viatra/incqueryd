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
import hu.bme.mit.incqueryd.spark.utils.VertexDelta
import hu.bme.mit.incqueryd.spark.utils.EdgeDelta
import hu.bme.mit.incqueryd.spark.utils.AttributeDelta

/**
 * @author pappi
 */
object InputStreamWorker {

  def process(stream: ReceiverInputDStream[Delta]) {
    // TODO: implement ID generation
    stream.foreachRDD {_.foreach { record =>
        val inputActorPath = record.inputActorPath
        val changeType = record.changeType
        val tupleSet = new java.util.HashSet[Tuple]
        
        // XXX ID generation
        record match {
          case delta: VertexDelta => tupleSet.add(new Tuple(Long.valueOf(delta.vertexId)))
          case delta: EdgeDelta => tupleSet.add(new Tuple(Long.valueOf(delta.subjectId), Long.valueOf(delta.objectId)))
          case delta: AttributeDelta => tupleSet.add(new Tuple(Long.valueOf(delta.subjectId), Long.valueOf(delta.objectValue)))
        }
        
        propagateToInput(inputActorPath, new ChangeSet(tupleSet, changeType))
      }
    }
  }

}