package hu.bme.mit.incqueryd.engine.rete.actors

import akka.actor.ActorRef
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration

sealed trait ReteCommunicationMessage
case class Configure(configuration: ReteNodeConfiguration) extends ReteCommunicationMessage
case class EstablishSubscriptions(yellowPages: YellowPages) extends ReteCommunicationMessage // TODO remove parameter
case class RegisterSubscriber(slot: ReteNodeSlot) extends ReteCommunicationMessage
case class UpdateMessage(changeSet: ChangeSet, slot: ReteNodeSlot, route: List[ActorRef]) extends ReteCommunicationMessage
case class TerminationMessage(route: List[ActorRef]) extends ReteCommunicationMessage
case class PropagateState(children: Set[ReteActorConnection]) extends ReteCommunicationMessage
case object GetQueryResults extends ReteCommunicationMessage