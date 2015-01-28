package hu.bme.mit.incqueryd.actorservice

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.PoisonPill
import akka.actor.Props

object LocalActorService extends ActorService {

  override def start(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef = {
    val actorSystem = AkkaUtils.getRemotingActorSystem(id.actorSystemName, id.ip, id.port)
    val props = Props(actorClass)
    actorSystem.actorOf(props, id.name)
  }

  override def stop(id: ActorId) {
    AkkaUtils.findActor(id) ! PoisonPill
  }

}