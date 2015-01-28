package hu.bme.mit.incqueryd.actorservice

import akka.actor.Actor
import akka.actor.ActorRef

trait ActorService {
  def start(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef
  def stop(id: ActorId)
}