package hu.bme.mit.incqueryd.coordinator.client

import akka.actor.Actor
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe

class CoordinatorActor extends Actor {

  def receive = {
    case IsAlive => {
    }
    case StartQuery => {
      sender ! "ready"
    }
    case CheckResults => {
      sender ! Coordinator.CheckResults.sampleResult
    }
    case StopQuery => {
      sender ! "ready"
    }
  }

}

case object IsAlive
case class StartQuery(recipe: ReteRecipe)
case object CheckResults
case object StopQuery