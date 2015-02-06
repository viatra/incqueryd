package hu.bme.mit.incqueryd.actorservice

import org.apache.http.NameValuePair
import akka.actor.Actor
import akka.actor.ActorRef
import eu.mondo.utils.WebServiceUtils
import org.apache.http.message.BasicNameValuePair
import upickle._

object RemoteActorService {
  final val port = 8094
  final val adminPort = 8095
  final val idJsonParameter = "idJson"
  final val classNameParameter = "className"
  object Start {
    final val path = "/start"
  }
}

class RemoteActorService(val ip: String) extends ActorService {

  override def start(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef = {
    val idJson = write(id)
    val allParameters = List(
      new BasicNameValuePair(RemoteActorService.idJsonParameter, idJson),
      new BasicNameValuePair(RemoteActorService.classNameParameter, actorClass.getName)
    )
    WebServiceUtils.call(ip, RemoteActorService.port, RemoteActorService.Start.path, allParameters: _*)
    AkkaUtils.findActor(id)
  }

  private def callWebService(path: String, id: ActorId, moreParameters: NameValuePair*) = {
  }

}
