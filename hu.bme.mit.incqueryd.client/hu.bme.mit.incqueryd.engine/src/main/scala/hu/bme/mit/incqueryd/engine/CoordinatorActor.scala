package hu.bme.mit.incqueryd.engine

import akka.actor.Actor
import hu.bme.mit.incqueryd.inventory.Inventory
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.Resource

object CoordinatorActor {
  final val sampleResult = List(ChangeSet(Set(Tuple(List(42))), true))
}

class CoordinatorActor extends Actor {

  def receive = {
    case IsAlive => {
    }
    case LoadData(databaseUrl, vocabulary, inventoryJson) => {
      sender ! Index()
    }
    case StartQuery(recipe) => {
      sender ! ReteNetwork(List(PatternDescriptor()))
    }
    case CheckResults(pattern) => {
      sender ! CoordinatorActor.sampleResult
    }
    case StopQuery(network) => {
      sender ! "Ready"
    }
  }

}

sealed trait CoordinatorCommand
case object IsAlive extends CoordinatorCommand
case class LoadData(databaseUrl: String, vocabulary: Resource, inventoryJson: String) extends CoordinatorCommand // XXX
case class StartQuery(recipe: ReteRecipe) extends CoordinatorCommand
case class CheckResults(pattern: PatternDescriptor) extends CoordinatorCommand
case class StopQuery(network: ReteNetwork) extends CoordinatorCommand