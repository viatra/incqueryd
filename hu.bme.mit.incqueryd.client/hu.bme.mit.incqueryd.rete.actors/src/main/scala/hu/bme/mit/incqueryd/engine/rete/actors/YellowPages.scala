package hu.bme.mit.incqueryd.engine.rete.actors

import akka.actor.ActorRef

case class YellowPages(inputActorsByType: Map[RdfType, ActorRef], otherActorsByKey: Map[ReteActorKey, ActorRef])