package hu.bme.mit.incqueryd.actorservice

import akka.actor.Actor
import akka.actor.Deploy
import akka.actor.Props
import akka.actor.AddressFromURIString
import akka.remote.RemoteScope
import akka.actor.Address
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import java.net.URL

/**
 * @author pappi
 */
class DeployActor extends Actor {
  
  override def preStart() = {
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)
  }
  
  def receive = {
    case DoDeploy(actorClass, id) => {
      val address = Address("akka.tcp", id.actorSystemName, id.ip, id.port)
      val remoteActor = context.system.actorOf(Props(actorClass), id.name)
      sender ! DeployDone
    }
  }
}

sealed trait DeployCommand
case class DoDeploy(actorClass: Class[_ <: Actor], id : ActorId) extends DeployCommand
case class DeployDone() extends DeployCommand