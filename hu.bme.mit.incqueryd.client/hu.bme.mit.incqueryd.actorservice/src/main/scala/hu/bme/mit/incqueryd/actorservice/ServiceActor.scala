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
import scala.concurrent.Await

/**
 * @author pappi
 */
class ServiceActor extends Actor {
  
  override def preStart() = {
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)
  }
  
  def receive = {
    case DoDeploy(actorClass, id) => {
      val address = Address("akka.tcp", id.actorSystemName, id.ip, id.port)
      val remoteActor = context.system.actorOf(Props(actorClass), id.name)
      sender ! DeployDone
    }
    case DisposeSystem() => {
      context.stop(self)
    }
  }

  override def postStop() = {
    context.system.terminate()
  }
}

sealed trait ServiceCommand
case class DoDeploy(actorClass: Class[_ <: Actor], id : ActorId) extends ServiceCommand
case class DeployDone() extends ServiceCommand
case class DisposeSystem() extends ServiceCommand
