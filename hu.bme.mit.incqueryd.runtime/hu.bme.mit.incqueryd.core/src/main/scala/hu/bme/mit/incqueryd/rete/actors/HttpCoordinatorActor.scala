package hu.bme.mit.incqueryd.rete.actors

import akka.actor.ActorRef
import akka.actor.Actor
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.Await
import scala.concurrent.duration._
import spray.can.Http
import spray.http.HttpRequest
import spray.http.Uri
import spray.http._
import HttpMethods._
import hu.bme.mit.incqueryd.rete.messages.CoordinatorCommand

class HttpCoordinatorActor (val actorRef: ActorRef) extends Actor {
  
  implicit val timeout = Timeout(14400 seconds)
  
  def receive = {

    case _: Http.Connected => sender ! Http.Register(self)
    
    case HttpRequest(GET, Uri.Path("/start"), _, _, _) => {
      val future = actorRef ? CoordinatorCommand.START
      Await.result(future, timeout.duration)
      
      sender ! HttpResponse(entity = "DONE")
    }
    
    case HttpRequest(GET, Uri.Path("/transform"), _, _, _) => {
      val future = actorRef ? CoordinatorCommand.TRANSFORM
      Await.result(future, timeout.duration)
      
      sender ! HttpResponse(entity = "DONE")
    }
    
    case HttpRequest(GET, Uri.Path("/check"), _, _, _) => {
      val future = actorRef ? CoordinatorCommand.CHECK
      Await.result(future, timeout.duration)
      
      sender ! HttpResponse(entity = "DONE")
    }
    
    case HttpRequest(GET, Uri.Path("/load"), _, _, _) => {
      val future = actorRef ? CoordinatorCommand.LOAD
      Await.result(future, timeout.duration)
      
      sender ! HttpResponse(entity = "DONE")
    }
    
  }
  
}