package hu.bme.mit.incqueryd.engine.rete.actors

import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import akka.actor.ActorRef
import akka.actor.ActorPath

case class ReteActorConnection(parent: ActorPath, slot: ReteNodeSlot, child: ActorPath)