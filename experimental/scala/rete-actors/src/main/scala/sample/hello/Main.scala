package sample.hello

import akka.actor.ActorSystem
import akka.actor.Props
import hu.bme.mit.rete.MaxNode
import hu.bme.mit.rete.ChangeSet
import akka.actor.Terminated
import akka.actor.ActorLogging
import akka.actor.Actor
import akka.actor.ActorRef
import hu.bme.mit.rete.Terminate

object Main {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("Rete")
    val maxNode = system.actorOf(Props[MaxNode], "maxNode")
    system.actorOf(Props(classOf[Terminator], maxNode), "terminator")
    
    val cs1 = new ChangeSet(Set(1, 2, 3), Set())
    val cs2 = new ChangeSet(Set(), Set(3))
    val cs3 = new ChangeSet(Set(4), Set())
    
    maxNode ! cs1
    maxNode ! cs2
    maxNode ! cs3
    
    maxNode ! Terminate    
  }

  class Terminator(ref: ActorRef) extends Actor with ActorLogging {
    context watch ref
    def receive = {
      case Terminated(_) =>
        log.info("{} has terminated, shutting down system", ref.path)
        context.system.shutdown()
    }
  }


}