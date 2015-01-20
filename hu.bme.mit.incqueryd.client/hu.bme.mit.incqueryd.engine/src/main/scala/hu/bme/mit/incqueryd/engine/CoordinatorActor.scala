package hu.bme.mit.incqueryd.engine

import akka.actor.Actor
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.{Resource, Model}
import org.openrdf.model.vocabulary.{OWL, RDFS, RDF}
import scala.collection.JavaConversions._

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

  def getTypes(model: Model): Set[RdfType] = {
    val rdfClasses = model.filter(null, RDF.TYPE, RDFS.CLASS)
    val owlClasses = model.filter(null, RDF.TYPE, OWL.CLASS)
    val classes = rdfClasses union owlClasses
    val classTypes = classes.map(statement => RdfType(statement.getSubject, 1))
    val objectProperties = model.filter(null, RDF.TYPE, OWL.OBJECTPROPERTY)
    val datatypeProperties = model.filter(null, RDF.TYPE, OWL.DATATYPEPROPERTY)
    val properties = objectProperties union datatypeProperties
    val propertyTypes = properties.map(statement => RdfType(statement.getSubject, 2))
    (classTypes union propertyTypes).toSet
  }

}

case class RdfType(typeId: Resource, arity: Int)

sealed trait CoordinatorCommand
case object IsAlive extends CoordinatorCommand
case class LoadData(databaseUrl: String, vocabulary: Model, inventoryJson: String) extends CoordinatorCommand // XXX
case class StartQuery(recipe: ReteRecipe) extends CoordinatorCommand
case class CheckResults(pattern: PatternDescriptor) extends CoordinatorCommand
case class StopQuery(network: ReteNetwork) extends CoordinatorCommand