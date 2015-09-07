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
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend
import hu.bme.mit.incqueryd.coordinator.client.IQDYarnClient
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActorKey

class ITBasic {

  val vocabularyFileName = "vocabulary.rdf"
	val modelFileName = "railway-test-1.ttl"
	val patternName = "switchSensor"
	val expectedResult = toTuples(Set(52, 138, 78, 391))
	val inputChanges =
    Map(ReteActorKey.fromString("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Switch").internalId ->
      new ChangeSet(
        new java.util.HashSet(toTuples(Set(138))), // XXX must be serializable
        ChangeType.NEGATIVE
      )
    )
	val expectedResultAfterChange = toTuples(Set(52, 78, 391))

  @Test
  def test() {
    val client = new IQDYarnClient
    val metamodel = client.loadMetamodel(getClass.getClassLoader.getResource(vocabularyFileName))
    val modelFilePath = client.uploadFile(getClass.getClassLoader.getResource(modelFileName))
    client.loadInitialData(metamodel, new DatabaseConnection(modelFilePath, Backend.FILE))
    val recipe = loadRecipe
    try {
      assertResult(client, recipe, expectedResult)
      client.loadChanges(inputChanges)
      assertResult(client, recipe, expectedResultAfterChange)
    } finally {
      client.dispose()
    }
  }

  private def toTuples(set: Set[Int]) = set.map(n => new Tuple(new Long(n)))

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
  
  private def uploadFile() {
  }

  private def assertResult(client: IQDYarnClient, recipe: ReteRecipe, expectedResult: Set[Tuple]) {
	  val result = client.checkQuery(recipe, patternName)
	  println(s"Query result: $result")
	  assertEquals(expectedResult, result)
  }
  
}
