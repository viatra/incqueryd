package hu.bme.mit.incqueryd.monitoringserver.core

import java.util.ArrayList
import hu.bme.mit.incqueryd.monitoringserver.core.data.MonitoringChangeSet
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.monitoringserver.core.data.StringTuple

object QueryResultStore {
  
  val changeSets = new ArrayList[MonitoringChangeSet]
  var sumChangeSet = new MonitoringChangeSet
  
  var changeCounter = 0
  
  def addChangeSet(changeSet: MonitoringChangeSet) = {
    changeSets.synchronized(changeSets.add(changeSet))
    
    sumChangeSet.synchronized({
      sumChangeSet = sumChangeSet + changeSet
      println( sumChangeSet )
      println( sumChangeSet.posChanges.size )
    }) 
    
    changeCounter += 1
  }
  
  def getResults : java.util.Set[StringTuple] = sumChangeSet.synchronized(sumChangeSet posChanges)
  
  def getDeltas(from: Int) = changeSets.synchronized(changeSets.subList(from, changeSets.size - 1))
  
  def numberOfChanges = changeCounter
  
}