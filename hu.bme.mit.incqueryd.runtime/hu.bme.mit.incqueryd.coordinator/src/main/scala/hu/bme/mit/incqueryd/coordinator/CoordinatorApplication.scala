package hu.bme.mit.incqueryd.coordinator

import akka.actor.ActorSystem
import akka.util.Timeout
import akka.actor.Props
import scala.concurrent.duration._
import akka.io.IO
import akka.actor.ActorRef
import spray.can.Http
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import eu.mondo.utils.NetworkUtils

object CoordinatorApplication {

  def main(args: Array[String]) {
    implicit val httpActorSystem = ActorSystem("http")
    val coordinatorActor = httpActorSystem.actorOf(Props[HttpCoordinatorActor], "coordinator")
    implicit val timeout = Timeout(1000000 seconds)
    IO(Http) ! Http.Bind(coordinatorActor, interface = NetworkUtils.getLocalIpAddress, port = Coordinator.port)
  }

}