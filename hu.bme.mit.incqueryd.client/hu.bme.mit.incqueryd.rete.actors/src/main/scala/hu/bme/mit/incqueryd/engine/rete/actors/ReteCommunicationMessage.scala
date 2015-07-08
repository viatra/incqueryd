package hu.bme.mit.incqueryd.engine.rete.actors

import akka.actor.ActorRef
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration
import akka.actor.ActorPath

sealed trait ReteCommunicationMessage
case class Configure(configuration: ReteNodeConfiguration) extends ReteCommunicationMessage
case class EstablishSubscriptions() extends ReteCommunicationMessage
case class RegisterSubscriber(slot: ReteNodeSlot) extends ReteCommunicationMessage
case class UpdateMessage(changeSet: ChangeSet, slot: ReteNodeSlot, route: List[ActorPath]) extends ReteCommunicationMessage
case class TerminationMessage(route: List[ActorPath]) extends ReteCommunicationMessage
case class PropagateState(children: Set[ReteActorConnection]) extends ReteCommunicationMessage   // XXX probably the children parameter is unnecessary, use subscribers instead 
case class PropagateInputState(changeSet : ChangeSet) extends ReteCommunicationMessage  // TODO: merge with previous
case object GetQueryResults extends ReteCommunicationMessage