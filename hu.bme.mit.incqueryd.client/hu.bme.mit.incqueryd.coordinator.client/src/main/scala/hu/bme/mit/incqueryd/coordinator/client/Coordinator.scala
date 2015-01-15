package hu.bme.mit.incqueryd.coordinator.client

import scala.collection.JavaConversions._
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration._

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe

import com.typesafe.config.ConfigFactory

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.ActorSystem
import akka.pattern.ask
import akka.util.Timeout
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.inventory.MachineInstance

object Coordinator {
  final val port = 9090
  final val actorSystemName = "coordinator"
  final val actorName = "coordinator"
  object CheckResults {
    final val sampleResult = List(ChangeSet(Set(Tuple(List(42))), true))
  }

  def getRemotingActorSystem(externalIp: String, port: Int): ActorSystem = {
    val config = ConfigFactory.parseString(s"""
akka {
  actor {
    provider = "akka.remote.RemoteActorRefProvider"
  }
  remote {
    enabled-transports = ["akka.remote.netty.tcp"]
    netty.tcp {
      hostname = "$externalIp"
      bind-hostname = "${NetworkUtils.getLocalIpAddress}" # XXX needed for docker networking
      port = $port
    }
  }
}
""")
    ActorSystem(Coordinator.actorSystemName, config)
  }
  def createCoordinatorRuntimeActorSystem(externalIp: String) = {
    Coordinator.getRemotingActorSystem(externalIp, Coordinator.port)
  }

  def coordinatorActor(ip: String): ActorRef = {
	  lazy val coordinatorClientActorSystem = Coordinator.getRemotingActorSystem(NetworkUtils.getLocalIpAddress, 0)
    val actorPath = s"akka.tcp://${Coordinator.actorSystemName}@$ip:${Coordinator.port}/user/${Coordinator.actorName}"
    coordinatorClientActorSystem.actorFor(actorPath)
  }

}

class Coordinator(instance: MachineInstance) {

  val coordinatorActor = Coordinator.coordinatorActor(instance.getIp)

  def startQuery(recipe: ReteRecipe): ReteNetwork = {
    println(s"Starting query")
    askCoordinator[ReteNetwork](StartQuery(recipe))
  }

  def checkResults(pattern: PatternDescriptor): List[ChangeSet] = {
    askCoordinator[List[ChangeSet]](CheckResults(pattern))
  }

  def stopQuery(network: ReteNetwork) {
    println(s"Stopping query")
    askCoordinator[String](StopQuery(network))
  }

  private def askCoordinator[T](message: CoordinatorCommand): T = {
    implicit val timeout = Timeout(5 seconds)
    val future = coordinatorActor ? message
    Await.result(future, timeout.duration).asInstanceOf[T]
  }

}