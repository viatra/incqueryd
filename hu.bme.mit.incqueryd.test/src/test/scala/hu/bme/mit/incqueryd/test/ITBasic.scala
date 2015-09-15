package hu.bme.mit.incqueryd.test

import java.io.File
import java.lang.Long
import java.net.URL
import scala.Option.option2Iterable
import scala.collection.JavaConversions._
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.junit.Assert._
import org.junit.Test
import org.openrdf.model.Model
import org.openrdf.model.impl.LinkedHashModel
import org.openrdf.rio.Rio
import org.openrdf.rio.helpers.StatementCollector
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.engine.CoordinatorActor
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance
import upickle._
import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import scala.concurrent.Await
import scala.concurrent.duration._
import hu.bme.mit.incqueryd.yarn.HdfsUtils
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import org.apache.commons.io.IOUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import java.util.HashSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import java.util.HashMap
import scala.collection.JavaConverters
import scala.collection.SortedSet
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend
import hu.bme.mit.incqueryd.coordinator.client.IQDYarnClient
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActorKey
import hu.bme.mit.incqueryd.idservice.IDService

class ITBasic {

  val vocabularyFileName = "vocabulary.rdf"
	val modelFileName = "railway-test-1.ttl"
	val patternName = "switchSensor"
	val expectedResult = toTuples(Set("52", "138", "78", "391"))
	val expectedResultAfterChange = toTuples(Set("52", "78", "391"))

  @Test
  def test() {
    val client = new IQDYarnClient
    val metamodel = client.loadMetamodel(getClass.getClassLoader.getResource(vocabularyFileName))
    val modelFilePath = client.uploadFile(getClass.getClassLoader.getResource(modelFileName))
    client.loadInitialData(metamodel, new DatabaseConnection(modelFilePath, Backend.FILE))
    val recipe = loadRecipe
    try {
      assertResult(client, recipe, expectedResult)
      Thread.sleep(60000) // Wait until output stream processing starts
      client.loadChanges(getInputChanges)
      assertResult(client, recipe, expectedResultAfterChange)
    } finally {
      client.dispose()
    }
  }

  private def getInputChanges() = {
  	val switchID = IDService.lookupID("138")
    println("SwitchID: " + switchID)
    Map(ReteActorKey.fromString("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Switch").internalId ->
      new ChangeSet(
        new java.util.HashSet(toTuples(Set(switchID))), // XXX must be serializable
        ChangeType.NEGATIVE
      )
    )
  }

  private def toTuples(set: Set[AnyRef]) = set.map(new Tuple(_))

  private def loadRecipe: ReteRecipe = {
    val filename = "SwitchSensor.rdfiq.recipe"
    val extension = FilenameUtils.getExtension(filename)
    val url = getClass.getClassLoader.getResource(filename)
    RecipesPackage.eINSTANCE.eClass
    val resourceSet = new ResourceSetImpl
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap.put(extension, new XMIResourceFactoryImpl)
    val resource = resourceSet.createResource(URI.createURI(url.toString))
    resource.load(Map[Object, Object]())
    resource.getContents.get(0).asInstanceOf[ReteRecipe]
  }

  private def assertResult(client: IQDYarnClient, recipe: ReteRecipe, expectedResult: Set[Tuple]) {
	  val result = client.checkQuery(recipe, patternName)
	  println(s"Query result: $result")
    val resolved = resolveIDs(result)
	  assertEquals(expectedResult, resolved)
  }

  private def resolveIDs(tuples : Set[Tuple]) : Set[Tuple] = {
    tuples.map { tuple =>
      val val0 = IDService.resolveID(tuple.get(0).asInstanceOf[Long])
      if(tuple.size() == 1) {
        new Tuple(val0)
      } else {
        val val1 = tuple.get(1)
        if(val1.isInstanceOf[Long]) {
          new Tuple(val0, IDService.resolveID(val1.asInstanceOf[Long]))
        } else {
          new Tuple(val0, val1)
        }
      }
    }
  }

}
