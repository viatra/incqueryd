package hu.bme.mit.incqueryd.engine

import akka.actor._
import com.typesafe.config.ConfigFactory
import eu.mondo.utils.{NetworkUtils, UnixUtils}

import scala.collection.JavaConversions._
import scala.util.{Failure, Success, Try}

object AkkaUtils {

  def createRemotingActorSystem(actorSystemName: String, externalIp: String, port: Int): ActorSystem = {
    val config = ConfigFactory.parseString( s"""
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
    retry(10)(1000) {
      findActor(actorSystemName, ip, port, actorName)
    }
  }

  @annotation.tailrec
  def retry[T](n: Int)(delayMillis: Long)(fn: => T): T = {
    Try {
      fn
    } match {
      case Success(x) => x
      case _ if n > 1 => {
        Thread.sleep(delayMillis); retry(n - 1)(delayMillis)(fn)
      }
      case Failure(e) => throw e
    }
  }

}
