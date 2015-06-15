package hu.bme.mit.incqueryd.actorservice

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorSystem

trait ActorService {
  def startActor(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef
  def startActorSystem(id: ActorId, actorClass: Class[_ <: Actor])
}