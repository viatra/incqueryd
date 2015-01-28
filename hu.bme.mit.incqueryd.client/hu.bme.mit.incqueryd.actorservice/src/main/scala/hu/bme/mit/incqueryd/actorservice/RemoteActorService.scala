package hu.bme.mit.incqueryd.actorservice

import org.apache.http.NameValuePair

import akka.actor.Actor
import akka.actor.ActorRef
import eu.mondo.utils.WebServiceUtils

object RemoteActorService {
  final val port = 8094
  final val adminPort = 8095
  object Start {
    final val path = "/start"
  }
  object Stop {
    final val path = "/stop"
  }
}

class RemoteActorService(val ip: String) extends ActorService {

  override def start(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef = {
    val response = callWebService(RemoteActorService.Start.path)
    val actor = AkkaUtils.findActor(id)
    actor
  }

  override def stop(id: ActorId) {
    val response = callWebService(RemoteActorService.Stop.path)
  }

  private def callWebService(path: String, params: NameValuePair*) = WebServiceUtils.call(ip, RemoteActorService.port, path, params: _*)

}
