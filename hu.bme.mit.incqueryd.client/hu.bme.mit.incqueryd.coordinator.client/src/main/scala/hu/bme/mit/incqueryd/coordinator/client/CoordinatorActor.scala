package hu.bme.mit.incqueryd.coordinator.client

import akka.actor.Actor
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe

class CoordinatorActor extends Actor {

  def receive = {
    case IsAlive => {
    }
    case StartQuery(recipe) => {
      sender ! ReteNetwork(List(PatternDescriptor()))
    }
    case CheckResults(pattern) => {
      sender ! Coordinator.CheckResults.sampleResult
    }
    case StopQuery(network) => {
      sender ! "Ready"
    }
  }

}

sealed trait CoordinatorCommand
case object IsAlive extends CoordinatorCommand
case class StartQuery(recipe: ReteRecipe) extends CoordinatorCommand
case class CheckResults(pattern: PatternDescriptor) extends CoordinatorCommand
case class StopQuery(network: ReteNetwork) extends CoordinatorCommand