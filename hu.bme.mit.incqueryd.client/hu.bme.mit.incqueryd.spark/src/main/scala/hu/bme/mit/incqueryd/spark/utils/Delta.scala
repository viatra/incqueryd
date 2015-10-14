package hu.bme.mit.incqueryd.spark.utils

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import akka.actor.ActorPath

trait Delta

case object NoChange extends Delta
case class Reset(subjectId: String) extends Delta
case class SendUpdates(updates: Set[Update]) extends Delta
case object LoadFinished extends Delta

trait Update {
	def changeType: ChangeType
  def rdfTypeId: String
}

case class UpdateVertex(changeType: ChangeType, subjectId: String, rdfTypeId: String) extends Update
case class UpdateEdge(changeType: ChangeType, subjectId: String, rdfTypeId: String, objectId: String) extends Update
case class UpdateAttribute(changeType: ChangeType, subjectId: String, rdfTypeId: String, objectValue: String) extends Update
