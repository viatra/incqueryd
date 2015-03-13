package hu.bme.mit.incqueryd.engine.rete.messages

import akka.actor.ActorRef
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot

sealed trait ReteCommunicationMessage {
  def route: List[ActorRef]
}

case class TerminationMessage(route: List[ActorRef]) extends ReteCommunicationMessage

case class UpdateMessage(changeSet: ChangeSet, nodeSlot: ReteNodeSlot, route: List[ActorRef]) extends ReteCommunicationMessage