package hu.bme.mit.incqueryd.actorsystem

import akka.actor.Props
import hu.bme.mit.incqueryd.engine.AkkaUtils

object Main {
  def main(args: Array[String]) {
    val actorSystem = AkkaUtils.createRemotingActorSystem(args(0), args(1), args(2).toInt)
    val props = Props(Class.forName(args(4)))
    val actor = actorSystem.actorOf(props, args(3))
    println(s"Actor created at ${actor.path}")
    Runtime.getRuntime.addShutdownHook(new Thread(new Runnable {
      def run = {
        actorSystem.terminate
        println("Terminated")
      }
    }))
  }
}