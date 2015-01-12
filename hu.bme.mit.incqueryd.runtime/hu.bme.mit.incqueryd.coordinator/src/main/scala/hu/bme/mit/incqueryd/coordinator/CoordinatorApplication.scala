package hu.bme.mit.incqueryd.coordinator

import akka.actor.ActorSystem
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import akka.actor.Props
import hu.bme.mit.incqueryd.coordinator.client.CoordinatorActor
import akka.actor.Deploy
import akka.remote.RemoteScope
import akka.actor.Address
import akka.kernel.Main
import akka.kernel.Bootable
import scala.concurrent.Await
import akka.util.Timeout
import java.util.concurrent.TimeUnit
import com.typesafe.config.ConfigFactory
import eu.mondo.utils.NetworkUtils

object CoordinatorApplication {
  def main(args: Array[String]) {
    val actorSystem = Coordinator.createCoordinatorRuntimeActorSystem(args(0))
    val props = Props[CoordinatorActor]
    actorSystem.actorOf(props, Coordinator.actorName)
    Runtime.getRuntime.addShutdownHook(new Thread(new Runnable {
      def run = {
        actorSystem.shutdown
      }
    }))
  }
}