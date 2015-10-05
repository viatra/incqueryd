package hu.bme.mit.incqueryd.spark.workers

import org.apache.spark.SparkEnv
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import akka.actor.ActorPath
import akka.actor.ActorRef
import hu.bme.mit.incqueryd.spark.utils.Delta
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import hu.bme.mit.incqueryd.spark.utils.Reset
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.spark.utils.SendUpdates
import hu.bme.mit.incqueryd.engine.rete.actors.FilterOutAndPropagate
import hu.bme.mit.incqueryd.idservice.IDService.lookupID
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActorKey
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.spark.utils.UpdateVertex
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.spark.utils.UpdateEdge
import hu.bme.mit.incqueryd.spark.utils.UpdateAttribute
import hu.bme.mit.incqueryd.spark.utils.Update
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.actors.PropagateInputChange
import scala.concurrent.duration._
import akka.pattern.ask
import scala.concurrent.Await
import akka.util.Timeout
import hu.bme.mit.incqueryd.actorservice.AkkaUtils

/**
 * @author pappi
 */
object InputStreamWorker {

  val actorMap: collection.mutable.Map[ActorPath, ActorRef] = collection.mutable.Map[ActorPath, ActorRef]()

  implicit val timeout = Timeout(30 seconds)

  def process(stream: ReceiverInputDStream[Set[Delta]]) {
    stream.foreachRDD {
      _.foreach { deltas =>
        val inputNodeZnodePaths = IncQueryDZooKeeper.getChildPaths(IncQueryDZooKeeper.inputNodesPath)
        inputNodeZnodePaths.foreach { inputNodeZnodePath =>
          val inputActor = getInputActor(inputNodeZnodePath)
          if (inputActor == null) {
            println(s"WARNING: No input node with znode $inputNodeZnodePath")
          } else {
            val resets = deltas.collect { case it: Reset => it }
            resets.foreach { reset =>
              println(s"Input node @$inputActor: removing statements with subject ${reset.subjectId}")
              val future = inputActor ? FilterOutAndPropagate(lookupID(reset.subjectId))
              Await.result(future, timeout.duration)
            }
            val updates = deltas
              .collect { case it: SendUpdates => it }
              .flatMap { _.updates }
              .filter { change => inputNodeZnodePath == ReteActorKey.fromString(change.rdfTypeId).internalId }
            applyChangeSet(inputNodeZnodePath, inputActor, updates, ChangeType.NEGATIVE)
            applyChangeSet(inputNodeZnodePath, inputActor, updates, ChangeType.POSITIVE)
          }
        }
      }
    }
  }

  def getInputActor(znodePath: String): ActorRef = {
    try {
      val inputActorPath = IQDSparkUtils.getInputActorPathByZnodePath(znodePath)
      actorMap.getOrElseUpdate(inputActorPath, AkkaUtils.getClientActorSystem().actorFor(inputActorPath))
    } catch {
      case e: Exception => {
        null
      }
    }
  }
  
  def applyChangeSet(inputNodeZnodePath: String, inputActor: ActorRef, updates: Set[Update], changeType: ChangeType) {
    val relevantUpdates = updates.filter { _.changeType == changeType }
    if (!relevantUpdates.isEmpty) {
      val tuples = relevantUpdates.map {
        case update: UpdateVertex =>
          val vertexId = lookupID(update.subjectId)
          new Tuple(vertexId)
        case update: UpdateEdge =>
          val subjectId = lookupID(update.subjectId)
          val objectId = lookupID(update.objectId)
          new Tuple(subjectId, objectId)
        case update: UpdateAttribute =>
          val subjectId = lookupID(update.subjectId)
          val objectValue = lookupID(update.objectValue)
          new Tuple(subjectId, objectValue)
      }
      println(s"Input node @ $inputActor: applying changes $relevantUpdates")
      import scala.collection.JavaConversions._
      val future = inputActor ? PropagateInputChange(new ChangeSet(new java.util.HashSet(tuples), changeType))
      Await.result(future, timeout.duration)
    }
  }

}