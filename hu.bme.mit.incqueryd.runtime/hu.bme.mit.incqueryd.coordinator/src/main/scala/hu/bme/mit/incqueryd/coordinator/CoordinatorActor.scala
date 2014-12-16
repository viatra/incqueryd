package hu.bme.mit.incqueryd.coordinator

import akka.actor.Actor

class CoordinatorActor extends CoordinatorService with Actor {

  def actorRefFactory = context

  def receive = runRoute(route)

}