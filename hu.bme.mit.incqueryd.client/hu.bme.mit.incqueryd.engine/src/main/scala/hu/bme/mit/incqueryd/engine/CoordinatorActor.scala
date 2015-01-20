package hu.bme.mit.incqueryd.engine

import akka.actor.Actor
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.{Resource, Model}
import org.openrdf.model.vocabulary.{OWL, RDFS, RDF}
import scala.collection.JavaConversions._
import scala.collection.immutable

object CoordinatorActor {
  final val sampleResult = List(ChangeSet(Set(Tuple(List(42))), true))
}

class CoordinatorActor extends Actor {

  def receive = {
    case IsAlive => {
    }
    case LoadData(databaseUrl, vocabulary, inventoryJson) => {
      val types = getTypes(vocabulary)
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

  def getTypes(model: Model) = {
    val rdfClasses = model.filter(null, RDF.TYPE, RDFS.CLASS).subjects
    val owlClasses = model.filter(null, RDF.TYPE, OWL.CLASS).subjects
    rdfClasses.union(owlClasses)
  }

}

sealed trait CoordinatorCommand
case object IsAlive extends CoordinatorCommand
case class LoadData(databaseUrl: String, vocabulary: Model, inventoryJson: String) extends CoordinatorCommand // XXX
case class StartQuery(recipe: ReteRecipe) extends CoordinatorCommand
case class CheckResults(pattern: PatternDescriptor) extends CoordinatorCommand
case class StopQuery(network: ReteNetwork) extends CoordinatorCommand