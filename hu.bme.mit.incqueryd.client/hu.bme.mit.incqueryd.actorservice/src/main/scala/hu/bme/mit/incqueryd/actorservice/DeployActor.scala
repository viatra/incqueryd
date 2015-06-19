package hu.bme.mit.incqueryd.actorservice

import akka.actor.Actor
import akka.actor.Deploy
import akka.actor.Props
import akka.actor.AddressFromURIString
import akka.remote.RemoteScope
import akka.actor.Address

/**
 * @author pappi
 */
class DeployActor extends Actor {
  def receive = {
    case DoDeploy(actorClass, id) => {
      //Get the remote actorsystem path
      val address = Address("akka.tcp", id.actorSystemName, id.ip, id.port)
      val props = Props(actorClass).withDeploy(Deploy(scope = RemoteScope(address)))
      val remoteActor = context.actorOf(props)
    }
  }
}

case class DoDeploy(actorClass: Class[_ <: Actor], id : ActorId)