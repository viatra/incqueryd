package hu.bme.mit.incqueryd.engine

import akka.actor._
import com.typesafe.config.ConfigFactory
import eu.mondo.utils.{NetworkUtils, UnixUtils}

import scala.collection.JavaConversions._
import scala.util.{Failure, Success, Try}
import scala.concurrent.duration._

object AkkaUtils {

  def createRemotingActorSystem(actorSystemName: String, externalIp: String, port: Int): ActorSystem = {
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
    ActorSystem(actorSystemName, config)
  }

  lazy val clientActorSystem = AkkaUtils.createRemotingActorSystem("client", NetworkUtils.getLocalIpAddress, 0)

  def findActor(actorSystemName: String, ip: String, port: Int, actorName: String): ActorRef = {
    val actorPath = s"akka.tcp://$actorSystemName@$ip:$port/user/$actorName"
    clientActorSystem.actorFor(actorPath)
  }

  def createActor(actorSystemName: String, ip: String, port: Int, actorName: String, actorClass: Class[_ <: Actor]): ActorRef = {
    UnixUtils.exec(s"./start-actor-system.sh $actorSystemName $ip $port $actorName ${actorClass.getName}", Map[String, String](), System.out)
    findActor(actorSystemName, ip, port, actorName)
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

  val defaultTimeout = 20 seconds

}
