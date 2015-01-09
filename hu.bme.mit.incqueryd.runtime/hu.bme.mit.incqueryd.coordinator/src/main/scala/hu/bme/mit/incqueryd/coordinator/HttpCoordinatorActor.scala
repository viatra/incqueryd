package hu.bme.mit.incqueryd.coordinator

import akka.actor.Actor

class HttpCoordinatorActor extends CoordinatorService with Actor {

  def actorRefFactory = context

  def receive = runRoute(route)

}