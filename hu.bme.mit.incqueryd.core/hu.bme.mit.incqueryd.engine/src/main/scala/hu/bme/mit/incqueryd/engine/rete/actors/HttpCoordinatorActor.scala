package hu.bme.mit.incqueryd.engine.rete.actors

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
import hu.bme.mit.incqueryd.engine.rete.messages.CoordinatorCommand

class HttpCoordinatorActor (val coordinatorActor: ActorRef) extends Actor {
  
  implicit val timeout = Timeout(14400 seconds)
  
  def receive = {

    case _: Http.Connected => sender ! Http.Register(self)
    
    case HttpRequest(GET, Uri.Path("/start"), _, _, _) => {
      
      sender ! HttpResponse(entity = "STARTED")
      
      val future = coordinatorActor ? CoordinatorCommand.START
      Await.result(future, timeout.duration)
      
    }
    
    case HttpRequest(GET, Uri.Path("/check"), _, _, _) => {
      
      sender ! HttpResponse(entity = "CHECKED")
      
      val future = coordinatorActor ? CoordinatorCommand.CHECK
      Await.result(future, timeout.duration)
      
    }
    
    case HttpRequest(GET, Uri.Path("/load"), _, _, _) => {
      val future = coordinatorActor ? CoordinatorCommand.LOAD
      Await.result(future, timeout.duration)
      
      sender ! HttpResponse(entity = "LOADED")
    }
    
  }
  
}