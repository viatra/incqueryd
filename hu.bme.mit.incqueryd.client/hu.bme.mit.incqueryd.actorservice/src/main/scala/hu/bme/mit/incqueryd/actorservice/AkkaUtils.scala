package hu.bme.mit.incqueryd.actorservice

import scala.collection.mutable
import scala.concurrent.duration.DurationInt
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Address
import akka.actor.Deploy
import akka.actor.Props
import akka.actor.Status
import akka.actor.actorRef2Scala
import akka.remote.RemoteScope
import akka.serialization.SerializationExtension
import eu.mondo.utils.NetworkUtils
import akka.actor.Actor

object AkkaUtils {

  case class ActorSystemId(val actorSystemName: String, val ip: String, val port: Int)

  private[this] val actorSystems = mutable.Map.empty[ActorSystemId, ActorSystem]

  def getRemotingActorSystem(actorSystemName: String, ip: String, port: Int): ActorSystem = {
    val id = ActorSystemId(actorSystemName, ip, port)
    val actorSystem = actorSystems.getOrElseUpdate(id, createRemotingActorSystem(id))
    actorSystem.actorOf(Props[DeployActor], "deploy")
    actorSystem
  }

  private def getActorSystemConfig(id: ActorSystemId): Config = {
    ConfigFactory.parseString(s"""
akka {
  actor {
    provider = "akka.remote.RemoteActorRefProvider"
  }
  remote {
    enabled-transports = ["akka.remote.netty.tcp"]
    netty.tcp {
      hostname = "${id.ip}"
      bind-hostname = "${NetworkUtils.getLocalIpAddress}" # XXX needed for docker networking
      port = ${id.port}
    }
  }
}
""")
  }

  private def createRemotingActorSystem(id: ActorSystemId): ActorSystem = {
    val actorSystem = ActorSystem(id.actorSystemName, getActorSystemConfig(id))
    Runtime.getRuntime.addShutdownHook(new Thread(new Runnable {
      def run = {
        actorSystem.terminate
      }
    }))
    actorSystem
  }

  lazy val clientActorSystem = getRemotingActorSystem("client", NetworkUtils.getLocalIpAddress, 0)

  def findActor(id: ActorId): ActorRef = {
    val actorPath = toActorPath(id)
    findActor(actorPath)
  }

  def toActorPath(id: ActorId) = {
    s"akka.tcp://${id.actorSystemName}@${id.ip}:${id.port}/user/${id.name}"
  }

  def findActor(actorPath: String) = {
    clientActorSystem.actorFor(actorPath)
  }
  
  def serializeActorSystem(system : ActorSystem) : Array[Byte] = {
    val serialization = SerializationExtension.get(system)
    val serializer = serialization.findSerializerFor(system)
    serializer.toBinary(system)
  }
  
  def startActor(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef = {
    val address = Address("akka.tcp", id.actorSystemName, id.ip, id.port)
    val system = AkkaUtils.clientActorSystem
    val deployActor = AkkaUtils.findActor(new ActorId(id.actorSystemName, id.ip, id.port, "deploy"))
    deployActor ! DoDeploy(actorClass, id)
    AkkaUtils.findActor(id)
  }

  def propagateException[T](sender: ActorRef)(fn: => T): T = {
    try {
      fn
    } catch {
      case e: Exception => {
        sender ! Status.Failure(e) // Alert the sender of the failure
        throw e // Alert any supervisor actor of the failure
      }
    }
  }

  @annotation.tailrec
  def retry[T](retryCount: Int)(delayMillis: Long)(fn: => T): T = {
    Try {
      fn
    } match {
      case Success(x) => x
      case _ if retryCount > 1 => {
        Thread.sleep(delayMillis); retry(retryCount - 1)(delayMillis)(fn)
      }
      case Failure(e) => throw e
    }
  }

  val defaultRetryCount = 10
  val defaultDelayMillis = 1000

  val defaultTimeout = 30 seconds

}