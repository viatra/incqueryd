package hu.bme.mit.incqueryd.spark.workers

import org.apache.spark.streaming.dstream.ReceiverInputDStream

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.idservice.IDService._
import hu.bme.mit.incqueryd.spark.recievers.FileGraphLoadReceiver
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import java.lang.Long

/**
 * @author pappi
 */
object InputStreamWorker {

  def process(stream: ReceiverInputDStream[String]) {
    val sections = stream.map {_.split(SEPARATOR)}
    sections.foreachRDD {_.foreach { record =>
        val inputActorPath = record.last
        val inputType = record.dropRight(1).last
        val changeType = record.dropRight(2).last
        val data = record.dropRight(3)
        
        val tupleSet = new java.util.HashSet[Tuple]
        
        inputType match {
          case RecipeUtils.VERTEX => {
            val id0 = lookupID(data(0))
            tupleSet.add(new Tuple(id0))
          }
          case RecipeUtils.EDGE => {
            val id0 = lookupID(data(0))
            val id1 = lookupID(data(1))
            tupleSet.add(new Tuple(id0, id1))
          }
          case RecipeUtils.ATTRIBUTE => {
            val id0 = lookupID(data(0))
            tupleSet.add(new Tuple(id0, data(1)))
          }
        }
        
        propagateToInput(inputActorPath, new ChangeSet(tupleSet, ChangeType.valueOf(changeType)))
      }
    }
  }

}