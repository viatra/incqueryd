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
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils

class ITBasic {

  val vocabularyFilename = "vocabulary.rdf"
	val modelFilename = "railway-test-1.ttl"
	val recipeFilename = "SwitchSensor.rdfiq.recipe"
	val patternName = "switchSensor"
	val expectedResult = toTuples(Set("52", "138", "78", "391"))
	val expectedResultAfterChange = toTuples(Set("52", "78", "391"))

  @Test
  def test() {
    val client = new IQDYarnClient
    val metamodel = client.loadMetamodel(getClass.getClassLoader.getResource(vocabularyFilename))
    val modelFilePath = client.uploadFile(getClass.getClassLoader.getResource(modelFilename))
    client.loadInitialData(metamodel, new DatabaseConnection(modelFilePath, Backend.FILE))
    val recipe = RecipeUtils.loadRecipe(recipeFilename)
    client.startQuery(recipe)
    try {
      assertResult(client, recipe, expectedResult)
      Thread.sleep(60000) // Wait until output stream processing starts
      for(i <- 1 to 99) {
        val changeType = if(i % 2 == 0 ) ChangeType.POSITIVE else ChangeType.NEGATIVE
        client.loadChanges(getInputChanges(changeType))
      }
      assertResult(client, recipe, expectedResultAfterChange)
    } finally {
      client.dispose()
    }
  }

  private def getInputChanges(changeType : ChangeType) = {
  	val switchID = IDService.lookupID("138")
    Map(ReteActorKey.fromString("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Switch").internalId ->
      new ChangeSet(
        new java.util.HashSet(toTuples(Set(switchID))), // XXX must be serializable
        changeType
      )
    )
  }

  private def toTuples(set: Set[AnyRef]) = set.map(new Tuple(_))

  private def assertResult(client: IQDYarnClient, recipe: ReteRecipe, expectedResult: Set[Tuple]) {
	  val result = client.checkQuery(recipe, patternName)
	  println(s"Query result: $result")
    val resolved = resolveIDs(result)
	  assertEquals(expectedResult, resolved)
  }

}
