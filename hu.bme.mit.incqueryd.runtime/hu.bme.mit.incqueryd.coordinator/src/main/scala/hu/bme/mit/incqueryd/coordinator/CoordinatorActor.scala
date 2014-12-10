package hu.bme.mit.incqueryd.engine.rete.actors

import akka.actor.Actor
import spray.http.HttpResponse
import spray.can.Http

class CoordinatorActor extends Actor {

  def receive = {
    case _: Http.Connected => sender ! Http.Register(self)
    case _ => sender ! HttpResponse(entity = "STARTED")
  }

}