package hu.bme.mit.incqueryd.main

import hu.bme.mit.incqueryd.rete.dataunits.ScalaChangeSet
import hu.bme.mit.incqueryd.rete.dataunits.Tuple
import java.util.HashSet
import akka.actor.ActorSystem
import akka.actor.Props
import hu.bme.mit.incqueryd.rete.actors.HttpCoordinatorActorFactory
import akka.util.Timeout
import scala.concurrent.duration._
import akka.io.IO
import spray.can.Http
import akka.pattern.ask

object IncQueryDMain {

  def main(args: Array[String]) {
    
    val architectureFile = args(0)
    val interface = args(1)
    var remoting = !(args.length > 2 && args(2) == "local")
    
    val engine = new IncQueryDEngine(interface)
    
    val coordinator = engine initialize (architectureFile, remoting)
    
    implicit val system = ActorSystem("http")
    val coordinatorService = system.actorOf(Props(new HttpCoordinatorActorFactory(coordinator)), "coordinator-service")
    implicit val timeout = Timeout(1000000 seconds)
    
    IO(Http) ? Http.Bind(coordinatorService, interface = interface, port = 9090)
  }
 }