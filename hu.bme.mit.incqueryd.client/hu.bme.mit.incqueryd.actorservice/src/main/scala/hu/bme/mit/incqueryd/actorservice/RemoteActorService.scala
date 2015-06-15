package hu.bme.mit.incqueryd.actorservice

import org.apache.http.NameValuePair
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import eu.mondo.utils.WebServiceUtils
import org.apache.http.message.BasicNameValuePair
import upickle._

object RemoteActorService {
  final val port = 8094
  final val adminPort = 8095
  final val idJsonParameter = "idJson"
  final val classNameParameter = "className"
  object Start {
    final val start = "/start"
    final val actor = "/actor"
    final val system = "/system"
    final val startsystem = start + system
    final val startactor = start + actor
  }
}

class RemoteActorService(val ip: String, val port: Int) extends ActorService {
  
  override def startActor(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef = {
    startActorSystem(id, actorClass)
    AkkaUtils.findActor(id)
  }
  
  def startActorSystem(id: ActorId, actorClass: Class[_ <: Actor]) {
    val idJson = write(id)
    val allParameters = List(
      new BasicNameValuePair(RemoteActorService.idJsonParameter, idJson),
      new BasicNameValuePair(RemoteActorService.classNameParameter, actorClass.getName)
    )
    WebServiceUtils.call(ip, port, RemoteActorService.Start.startsystem, allParameters: _*)
  }
  
  private def callWebService(path: String, id: ActorId, moreParameters: NameValuePair*) = {
  }
  
}
