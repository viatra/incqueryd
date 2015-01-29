package hu.bme.mit.incqueryd.engine

import akka.actor.Actor
import eu.mondo.driver.file.FileGraphDriverRead
import hu.bme.mit.incqueryd.inventory.{ MachineInstance, Inventory }
import org.eclipse.emf.ecore.util.EcoreUtil
import org.openrdf.model.vocabulary.{ OWL, RDF, RDFS }
import org.openrdf.model.{ Model, URI }
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import hu.bme.mit.incqueryd.inventory.MachineInstance
import scala.collection.JavaConverters._
import java.util.ArrayList
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.RemoteActorService
import java.security.MessageDigest
import org.apache.commons.codec.digest.DigestUtils
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor

object CoordinatorActor {
  final val sampleResult = List(ChangeSet(Set(Tuple(List(42))), true))
}

class CoordinatorActor extends Actor {

  def receive = {
    case LoadData(databaseUrl, vocabulary, inventory) => AkkaUtils.propagateException(sender) {
      val types = getTypes(vocabulary)
      val typeInfos = getTypeInfos(types, databaseUrl)
      val index = allocate(typeInfos, inventory)
      deployIndex(index, databaseUrl)
      sender ! index
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

  def allocate(typeInfos: Set[RdfTypeInfo], inventory: Inventory): Index = {
    val typeInfosSorted = typeInfos.toList.sortBy(-_.getEstimatedMemoryUsageMb)
    val allocation = scala.collection.mutable.Map[RdfType, MachineInstance]()
    val allocatedInstances = new ArrayList(inventory.machineInstances)
    typeInfosSorted.foreach { typeInfo =>
      val memoryUsageMb = typeInfo.getEstimatedMemoryUsageMb
      val goodInstances = allocatedInstances.filter(_.memoryMb > memoryUsageMb)
      if (goodInstances.isEmpty) {
        throw new IllegalArgumentException(s"Can't allocate index of ${typeInfo.rdfType.id.stringValue} on any machine!") // XXX return Option[Index] instead?
      } else {
        val selectedInstance = goodInstances.head
        allocation.put(typeInfo.rdfType, selectedInstance)
        val allocatedInstance = selectedInstance.copy(memoryMb = selectedInstance.memoryMb - memoryUsageMb)
        allocatedInstances.remove(selectedInstance)
        allocatedInstances.add(allocatedInstance)
      }
    }
    val deployedInventory = inventory.copy(machineInstances = allocatedInstances.toList)
    Index(allocation.toMap, deployedInventory)
  }

  def deployIndex(index: Index, databaseUrl: String): Unit = {
    for ((rdfType, instance) <- index.allocation) {
      val name = DigestUtils.md5Hex(rdfType.id.stringValue)
      val id = ActorId(ReteNetwork.actorSystemName, instance.ip, ReteNetwork.port, name)
      new RemoteActorService(instance.ip).start(id, classOf[ReteActor])
    }
  }

}