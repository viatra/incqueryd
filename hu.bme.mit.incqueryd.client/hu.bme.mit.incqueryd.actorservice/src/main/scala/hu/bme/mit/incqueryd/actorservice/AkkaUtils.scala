package hu.bme.mit.incqueryd.actorservice

import akka.actor._
import com.typesafe.config.ConfigFactory
import eu.mondo.utils.{ NetworkUtils, UnixUtils }

import scala.collection.JavaConversions._
import scala.util.{ Failure, Success, Try }
import scala.concurrent.duration._
import scala.collection.mutable

object AkkaUtils {

  case class ActorSystemId(val actorSystemName: String, val ip: String, val port: Int)

  private[this] val actorSystems = mutable.Map.empty[ActorSystemId, ActorSystem]

  def getRemotingActorSystem(actorSystemName: String, ip: String, port: Int): ActorSystem = {
    val id = ActorSystemId(actorSystemName, ip, port)
    actorSystems.getOrElseUpdate(id, createRemotingActorSystem(id))
  }

  private def createRemotingActorSystem(id: ActorSystemId): ActorSystem = {
    val config = ConfigFactory.parseString(s"""
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
    val actorSystem = ActorSystem(id.actorSystemName, config)
    Runtime.getRuntime.addShutdownHook(new Thread(new Runnable {
      def run = {
        actorSystem.terminate
      }
    }))
    actorSystem
  }

  lazy val clientActorSystem = getRemotingActorSystem("client", NetworkUtils.getLocalIpAddress, 0)

  def findActor(id: ActorId): ActorRef = {
    val actorPath = s"akka.tcp://${id.actorSystemName}@${id.ip}:${id.port}/user/${id.name}"
    clientActorSystem.actorFor(actorPath)
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