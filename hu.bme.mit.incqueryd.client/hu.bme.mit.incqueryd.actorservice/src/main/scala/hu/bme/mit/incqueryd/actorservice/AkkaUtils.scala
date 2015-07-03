package hu.bme.mit.incqueryd.actorservice

import scala.collection.JavaConversions._
import scala.collection.mutable
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.Failure
import scala.util.Success
import scala.util.Try

import com.typesafe.config.ConfigFactory

import akka.actor._
import akka.pattern.ask
import eu.mondo.utils.NetworkUtils

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

  private var clientActorSystem : ActorSystem = null
  
  def getClientActorSystem() : ActorSystem = {
    if(clientActorSystem == null || clientActorSystem.isTerminated)
      clientActorSystem = getRemotingActorSystem("client", NetworkUtils.getLocalIpAddress, 0)
    clientActorSystem
  }
  
  def teminateClientActorSystem() = {
    if (clientActorSystem != null) {
      val terminate = clientActorSystem.terminate()
      Await.result(terminate, AkkaUtils.defaultTimeout)
    }
  }

  def findActor(id: ActorId): ActorRef = {
    val actorPath = toActorPath(id)
    findActor(actorPath)
  }
  
  def findActor(actorPathString: String) = {
    getClientActorSystem.actorFor(actorPathString)
  }
  
  def findActor(actorPath : ActorPath) = {
    getClientActorSystem.actorFor(actorPath)
  }
  
  def toActorPath(id: ActorId) = {
    s"akka.tcp://${id.actorSystemName}@${id.ip}:${id.port}/user/${id.name}"
  }
  
  def toRemoteActorPath(actorRef : ActorRef) : ActorPath = {
    toRemoteActorPath(actorRef.path)
  }
  
  def toRemoteActorPath(actorPath : ActorPath) : ActorPath = {
    val address = new Address("akka.tcp", YarnActorService.actorSystemName, NetworkUtils.getLocalIpAddress, YarnActorService.port)
    ActorPath.fromString(actorPath.toStringWithAddress(address))
  }
  
  def convertToRemoteActorRef(_actorRef : ActorRef, context: ActorContext) : ActorRef = {
    val _path = toRemoteActorPath(_actorRef.path)
    val _host = _path.address.host
    val _name = _path.name
    if(_name.equals("") || _name == null || _name == None || _path.toString().contains("/temp/")) // XXX further cleanup needed
      return _actorRef
    val actorPathString = toActorPath(new ActorId(YarnActorService.actorSystemName, _host.get, YarnActorService.port, _name))
    convertToRemoteActorRef(actorPathString, context)
  }
  
  def convertToRemoteActorRef(actorPathString : String, context: ActorContext) : ActorRef = {
    context.actorFor(actorPathString)
  }
  
  def convertToRemoteActorRef(actorPath : ActorPath, context : ActorContext) : ActorRef = {
    context.actorFor(actorPath)
  }
  
  def startActor(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef = {
    val serviceActor = AkkaUtils.findActor(new ActorId(id.actorSystemName, id.ip, id.port, YarnActorService.serviceActorName))
    val futureDeploy = serviceActor.ask(DoDeploy(actorClass, id))(defaultTimeout)
    Await.result(futureDeploy, defaultTimeout)
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

  val defaultTimeout = 300 seconds

}