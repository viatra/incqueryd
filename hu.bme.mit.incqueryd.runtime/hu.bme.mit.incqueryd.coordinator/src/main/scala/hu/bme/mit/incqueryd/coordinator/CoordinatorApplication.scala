package hu.bme.mit.incqueryd.coordinator

import akka.actor.ActorSystem
import akka.util.Timeout
import akka.actor.Props
import scala.concurrent.duration._
import akka.io.IO
import akka.actor.ActorRef
import spray.can.Http
import hu.bme.mit.incqueryd.engine.rete.actors.CoordinatorActor
import hu.bme.mit.incqueryd.engine.rete.actors.CoordinatorActor
import hu.bme.mit.incqueryd.coordinator.client.Coordinator

object CoordinatorApplication {

  def main(args: Array[String]) {
    implicit val httpActorSystem = ActorSystem("http")
    val coordinatorService = httpActorSystem.actorOf(Props[CoordinatorActor], "coordinator-service")
    implicit val timeout = Timeout(1000000 seconds)
    IO(Http) ! Http.Bind(coordinatorService, interface = "127.0.0.1", port = Coordinator.port)
  }

}