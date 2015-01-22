package hu.bme.mit.incqueryd.engine

import akka.actor.Actor
import eu.mondo.driver.file.FileGraphDriverRead
import org.openrdf.model.vocabulary.{OWL, RDF, RDFS}
import org.openrdf.model.{Model, URI}

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
      val typeInfos = getTypeInfos(types, databaseUrl)
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
    val rdfClassStatements = model.filter(null, RDF.TYPE, RDFS.CLASS)
    val owlClassStatements = model.filter(null, RDF.TYPE, OWL.CLASS)
    val classStatements = rdfClassStatements union owlClassStatements
    val classTypes = classStatements.map(statement => RdfClass(statement.getSubject)).toSet[RdfType]
    val objectPropertyStatements = model.filter(null, RDF.TYPE, OWL.OBJECTPROPERTY)
    val objectPropertyTypes = objectPropertyStatements.map(statement => RdfObjectProperty(statement.getSubject)).toSet[RdfType]
    val datatypePropertyStatements = model.filter(null, RDF.TYPE, OWL.DATATYPEPROPERTY)
    val datatypePropertyTypes = datatypePropertyStatements.map(statement => RdfDatatypeProperty(statement.getSubject)).toSet[RdfType]
    val propertyTypes = objectPropertyTypes union datatypePropertyTypes
    (classTypes union propertyTypes).filter(rdfType => rdfType.id.isInstanceOf[URI]) // Discard blank nodes
  }

  def getTypeInfos(types: Set[RdfType], databaseUrl: String): Set[RdfTypeInfo] = {
    val driver = new FileGraphDriverRead(databaseUrl)
    types.map(rdfType => RdfTypeInfo(rdfType, rdfType.getTupleCount(driver)))
  }

  case class RdfTypeInfo(rdfType: RdfType, tupleCount: Long) {
    def getEstimatedMemoryUsageMb(): Long = {
      val normalizedTupleCount = rdfType.arity * tupleCount
      val memoryUsage = Math.ceil((0.0003 * normalizedTupleCount + 52.969) * 1.4)
      Math.max(128, memoryUsage.toLong)
    }
  }

}