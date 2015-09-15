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
import hu.bme.mit.incqueryd.idservice.IDService.lookupID
import akka.actor.ActorPath
import akka.actor.ActorRef
import hu.bme.mit.incqueryd.engine.rete.actors.PropagateInputState

/**
 * @author pappi
 */
object InputStreamWorker {
  
  val actorMap : collection.mutable.Map[ActorPath, ActorRef] = collection.mutable.Map[ActorPath, ActorRef]()
  
  def process(stream: ReceiverInputDStream[Delta]) {
    stream.foreachRDD {_.foreach { record =>
        val inputActorPath = record.inputActorPath
        val changeType = record.changeType
        val tupleSet = new java.util.HashSet[Tuple]
        
        record match {
          case delta: VertexDelta =>
          	val vertexId = lookupID(delta.vertexId)
          	tupleSet.add(new Tuple(vertexId))
          case delta: EdgeDelta =>
          	val subjectId = lookupID(delta.subjectId)
          	val objectId = lookupID(delta.objectId)
          	tupleSet.add(new Tuple(subjectId, objectId))
          case delta: AttributeDelta =>
          	val subjectId = lookupID(delta.subjectId)
          	val objectValue = lookupID(delta.objectValue)
          	tupleSet.add(new Tuple(subjectId, objectValue))
        }
        
        val inputActor = actorMap.getOrElseUpdate(inputActorPath, SparkEnv.get.actorSystem.actorFor(inputActorPath))
        inputActor ! PropagateInputState(new ChangeSet(tupleSet, changeType))
      }
    }
  }

}