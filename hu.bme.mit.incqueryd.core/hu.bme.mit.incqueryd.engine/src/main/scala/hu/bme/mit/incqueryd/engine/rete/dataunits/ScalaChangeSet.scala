package hu.bme.mit.incqueryd.engine.rete.dataunits;
//package hu.bme.mit.incqueryd.engine.rete.dataunits
//
//import scala.collection.JavaConversions._
//import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
//
//import java.util.HashSet
//
//class ScalaChangeSet(val positiveChanges: Set[Tuple], val negativeChanges: Set[Tuple]) {
//  
//  def this(pChanges: java.util.Set[Tuple], nChanges: java.util.Set[Tuple]) = {
//    this(asScalaSet(pChanges).toSet, asScalaSet(nChanges).toSet)
//  }
//  
//  def this() = {
//    this(Set[Tuple](), Set[Tuple]())
//  }
//  
//  def +(otherChange: ScalaChangeSet): ScalaChangeSet = {
//    val posC = positiveChanges.union(otherChange.positiveChanges).diff(negativeChanges).diff(otherChange.negativeChanges)
//    val negC = negativeChanges.union(otherChange.negativeChanges).diff(positiveChanges).diff(otherChange.positiveChanges)
//    
//    new ScalaChangeSet(posC, negC)
//  }
//  
//  def posChanges = asJavaSet(positiveChanges)
//  
//  def negChanges = asJavaSet(negativeChanges)
//  
//  override def toString: String = "+: " + positiveChanges + "\n" + "-: " + negativeChanges
//  
//}
//
//object ScalaChangeSet {
//  def create (changeSet: ChangeSet) = {
//    changeSet.getChangeType match {
//      case ChangeType.POSITIVE => new ScalaChangeSet(asScalaSet(changeSet.getTuples).toSet, Set[Tuple]())
//      case ChangeType.NEGATIVE => new ScalaChangeSet(Set[Tuple](), asScalaSet(changeSet.getTuples).toSet)
//    }
//  }
//}