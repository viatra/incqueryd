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
import akka.actor.DeadLetterActorRef
import scala.concurrent.duration._
import akka.pattern.ask
import scala.util.Either
import com.google.common.collect.Sets
import hu.bme.mit.incqueryd.spark.utils.SingleDelta
import hu.bme.mit.incqueryd.spark.utils.ResetDelta
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.engine.rete.actors.FilterOutAndPropagate
import hu.bme.mit.incqueryd.engine.rete.actors.PropagateInputChange
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActorKey
import akka.util.Timeout
import scala.concurrent.Await
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor
import org.apache.spark.util.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.AkkaUtils

/**
 * @author pappi
 */
object InputStreamWorker {
  
  val actorMap : collection.mutable.Map[ActorPath, ActorRef] = collection.mutable.Map[ActorPath, ActorRef]()
  
  def process(stream: ReceiverInputDStream[Set[Delta]]) {
    stream.foreachRDD {
      _.foreach { deltas =>
        deltas.foreach { delta =>
          implicit val timeout = Timeout(30 seconds)
          delta match {
            case delta: SingleDelta => {
              val inputActor = getInputActor(ReteActorKey.fromString(delta.rdfTypeId).internalId)
              if (inputActor == null) {
                  println(s"WARNING: No type input node for delta, skipping $delta")
              } else {
                val changeType = delta.changeType
        
                val tupleSet = delta match {
                  case delta: VertexDelta =>
                    val vertexId = lookupID(delta.subjectId)
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
                val future = inputActor ? PropagateInputChange(new ChangeSet(tupleSet, changeType))
                Await.result(future, timeout.duration)
              }
            }
            case delta: ResetDelta => {
              val inputNodes = IncQueryDZooKeeper.getChildPaths(IncQueryDZooKeeper.inputNodesPath)
              inputNodes.foreach { inputNode =>
                val inputActor = getInputActor(inputNode)
                if (inputActor == null) {
                  println(s"WARNING: No type input node with related znode $inputNode, skipping $delta")
                } else { 
                	println(s"Resetting statements of ${delta.subjectId}, property $inputNode")
                	val future = inputActor ? FilterOutAndPropagate(lookupID(delta.subjectId))
                  Await.result(future, timeout.duration)
                }
              }
            }
          }
        }
      }
    }
  }

  def getInputActor(znodeId: String): ActorRef = {
    try {
      val inputActorPath = IQDSparkUtils.getInputActorPathByZnodeId(znodeId)
      actorMap.getOrElseUpdate(inputActorPath, AkkaUtils.getClientActorSystem().actorFor(inputActorPath))
    } catch {
      case e: Exception => {
        null
      }
    }
  }

}