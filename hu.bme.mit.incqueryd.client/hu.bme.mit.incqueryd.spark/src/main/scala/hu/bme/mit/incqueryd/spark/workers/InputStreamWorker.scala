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
import akka.actor.DeadLetterActorRef
import scala.util.Either
import com.google.common.collect.Sets

/**
 * @author pappi
 */
object InputStreamWorker {
  
  val actorMap : collection.mutable.Map[ActorPath, ActorRef] = collection.mutable.Map[ActorPath, ActorRef]()
  
  def process(stream: ReceiverInputDStream[Delta]) {
    stream.foreachRDD {
      _.foreach { delta =>
        val inputActorPath =
          try {
            IQDSparkUtils.getInputActorPathByTypeName(delta.rdfTypeId)
          } catch {
            case e: Exception => {
              println(s"WARNING: No type input node for ${delta.rdfTypeId}, skipping delta")
              null
            }
          }
        if (inputActorPath != null) {
          val inputActor = actorMap.getOrElseUpdate(inputActorPath, SparkEnv.get.actorSystem.actorFor(inputActorPath))
          val changeType = delta.changeType
  
          val tupleSet = delta match {
            case delta: VertexDelta =>
              val vertexId = lookupID(delta.vertexId)
              Sets.newHashSet(new Tuple(vertexId))
            case delta: EdgeDelta =>
              val subjectId = lookupID(delta.subjectId)
              val objectId = lookupID(delta.objectId)
              Sets.newHashSet(new Tuple(subjectId, objectId))
            case delta: AttributeDelta =>
              val subjectId = lookupID(delta.subjectId)
              val objectValue = lookupID(delta.objectValue)
              Sets.newHashSet(new Tuple(subjectId, objectValue))
          }

          println(s"Sending update for $delta")
          inputActor ! PropagateInputState(new ChangeSet(tupleSet, changeType))          
        }
      }
    }
  }

}