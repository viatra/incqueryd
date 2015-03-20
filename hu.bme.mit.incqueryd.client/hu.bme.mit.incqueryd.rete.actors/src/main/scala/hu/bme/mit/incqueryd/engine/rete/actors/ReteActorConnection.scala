package hu.bme.mit.incqueryd.engine.rete.actors

import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import akka.actor.ActorRef

case class ReteActorConnection(parent: ActorRef, slot: ReteNodeSlot, child: ActorRef)