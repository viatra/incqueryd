package hu.bme.mit.incqueryd.spark.workers

import org.apache.spark.streaming.dstream.ReceiverInputDStream

import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.idservice.IDService.lookupID
import hu.bme.mit.incqueryd.spark.utils.Delta
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils.propagateToInput

/**
 * @author pappi
 */
object InputStreamWorker {

  def process(stream: ReceiverInputDStream[Delta]) {
    stream.foreachRDD {_.foreach { record =>
        val inputActorPath = record.inputActorPath
        val inputType = record.inputType
        val changeType = record.changeType
        val data = record.data
        
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
        
        propagateToInput(inputActorPath, new ChangeSet(tupleSet, changeType))
      }
    }
  }

}