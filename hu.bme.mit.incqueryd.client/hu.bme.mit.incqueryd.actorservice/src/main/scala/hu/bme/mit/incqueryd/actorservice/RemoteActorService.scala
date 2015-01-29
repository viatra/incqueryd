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
  object Stop {
    final val path = "/stop"
  }
}

class RemoteActorService(val ip: String) extends ActorService {

  override def start(id: ActorId, actorClass: Class[_ <: Actor]): ActorRef = {
    callWebService(RemoteActorService.Start.path, id,
        new BasicNameValuePair(RemoteActorService.classNameParameter, actorClass.getName))
    AkkaUtils.findActor(id)
  }

  override def stop(id: ActorId) {
    callWebService(RemoteActorService.Stop.path, id)
  }

  private def callWebService(path: String, id: ActorId, moreParameters: NameValuePair*) = {
    val idJson = write(id)
    val allParameters =
      new BasicNameValuePair(RemoteActorService.idJsonParameter, idJson) :: moreParameters.toList  
    WebServiceUtils.call(ip, RemoteActorService.port, path, allParameters: _*)
  }

}
