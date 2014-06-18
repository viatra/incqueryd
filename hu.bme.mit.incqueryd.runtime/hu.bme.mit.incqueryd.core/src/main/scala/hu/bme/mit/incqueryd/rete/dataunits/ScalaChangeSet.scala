package hu.bme.mit.incqueryd.rete.dataunits

import scala.collection.JavaConversions._
import java.util.HashSet

class ScalaChangeSet(val positiveChanges: Set[Tuple], val negativeChanges: Set[Tuple]) {
  
  def this(pChanges: java.util.Set[Tuple], nChanges: java.util.Set[Tuple]) = {
    this(asScalaSet(pChanges).toSet, asScalaSet(nChanges).toSet)
  }
  
  def +(otherChange: ScalaChangeSet): ScalaChangeSet = {
    val posC = positiveChanges.union(otherChange.positiveChanges).diff(negativeChanges).diff(otherChange.negativeChanges)
    val negC = negativeChanges.union(otherChange.negativeChanges).diff(positiveChanges).diff(otherChange.positiveChanges)
    
    new ScalaChangeSet(posC, negC)
  }
  
  def posChanges = asJavaSet(positiveChanges)
  
  def negChanges = asJavaSet(negativeChanges)
  
  override def toString: String = "+: " + positiveChanges + "\n" + "-: " + negativeChanges
  
}