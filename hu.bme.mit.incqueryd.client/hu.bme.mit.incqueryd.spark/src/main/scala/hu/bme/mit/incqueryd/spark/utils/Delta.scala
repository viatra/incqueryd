package hu.bme.mit.incqueryd.spark.utils

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import akka.actor.ActorPath

trait Delta {
  def subjectId: String
}

case class ResetDelta(subjectId: String) extends Delta

trait SingleDelta extends Delta {
	def changeType: ChangeType
  def rdfTypeId: String
}

case class VertexDelta(changeType: ChangeType, subjectId: String, rdfTypeId: String) extends SingleDelta
case class EdgeDelta(changeType: ChangeType, subjectId: String, rdfTypeId: String, objectId: String) extends SingleDelta
case class AttributeDelta(changeType: ChangeType, subjectId: String, rdfTypeId: String, objectValue: String) extends SingleDelta
