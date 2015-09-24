package hu.bme.mit.incqueryd.spark.utils

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import akka.actor.ActorPath

trait Delta {
  def changeType: ChangeType
  def rdfTypeId: String
}
case class VertexDelta(changeType: ChangeType, vertexId: String, rdfTypeId: String) extends Delta
case class EdgeDelta(changeType: ChangeType, subjectId: String, rdfTypeId: String, objectId: String) extends Delta
case class AttributeDelta(changeType: ChangeType, subjectId: String, rdfTypeId: String, objectValue: String) extends Delta