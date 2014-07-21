package hu.bme.mit.incqueryd.monitoringserver.core

import java.util.ArrayList
import hu.bme.mit.incqueryd.monitoringserver.core.data.MonitoringChangeSet
import scala.collection.JavaConversions._

object QueryResultStore {
  
  val changeSets = new ArrayList[MonitoringChangeSet]
  var sumChangeSet = new MonitoringChangeSet
  
  def addChangeSet(changeSet: MonitoringChangeSet) = changeSets.synchronized(changeSets.add(changeSet))
  
  def getChangeSet : MonitoringChangeSet = {
    changeSets.synchronized({
      
      if(changeSets.size == 0)return null;
      println("Start")
      changeSets.foreach(changeSet => {
        sumChangeSet = sumChangeSet + changeSet
      })
      
      changeSets clear
      
      println( sumChangeSet )
      println( sumChangeSet.posChanges.size )
      println("Done")
      sumChangeSet
      
    })
  }
  
}