package hu.bme.mit.incqueryd.monitoringserver.core.data

import scala.collection.JavaConversions._

class MonitoringChangeSet (val positiveChanges: Set[StringTuple], val negativeChanges: Set[StringTuple]){
  
  def this() = {
    this(Set[StringTuple](), Set[StringTuple]())
  }
  
  def +(otherChange: MonitoringChangeSet): MonitoringChangeSet = {
    val posC = positiveChanges.union(otherChange.positiveChanges).diff(negativeChanges).diff(otherChange.negativeChanges)
    val negC = negativeChanges.union(otherChange.negativeChanges).diff(positiveChanges).diff(otherChange.positiveChanges)
    
    new MonitoringChangeSet(posC, negC)
  }
  
  def posChanges = asJavaSet(positiveChanges)
  
  def negChanges = asJavaSet(negativeChanges)
  
  override def toString: String = "+: " + positiveChanges + "\n" + "-: " + negativeChanges
}

object MonitoringChangeSet {
  def from (changeSet: String) : MonitoringChangeSet = {
    changeSet charAt 0 match {
      case '+' => {
        val set = extractTuple(changeSet)
        new MonitoringChangeSet(set, Set[StringTuple]())
      }
      case '-' => {
        val set = extractTuple(changeSet)
        new MonitoringChangeSet(Set[StringTuple](), set)
      }
    }
  }
  
  private def extractTuple(changeSet: String) = {
    val values = changeSet drop 2 split ";"
    (for {value <- values} yield new StringTuple(value)) toSet
  }
}