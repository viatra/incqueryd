package hu.bme.mit.scala.rete

import akka.actor.Actor
import scala.collection.Set

class MaxNode extends Actor {

  var memory = Set[Int]()

  def receive = {
    case c: ChangeSet =>
      memory = memory.union(c.positiveChanges).diff(c.negativeChanges)
      println(memory.max)
    case Terminate =>
      context.stop(self)
  }

}