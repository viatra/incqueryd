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
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import scala.concurrent.Await
import scala.concurrent.duration._
import hu.bme.mit.incqueryd.yarn.HdfsUtils
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import org.apache.commons.io.IOUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend

class ITBasic {

  @Test
  def test() {
    val modelFileName = "railway-test-1.ttl"
    val vocabularyFileName = "vocabulary.rdf"
    val patternName = "switchSensor"
    val expectedResult = Set(52, 138, 78, 391).map(n => new Tuple(new Long(n)))
    val rmHostname = "yarn-rm.docker"
    val fileSystemUri = "hdfs://yarn-rm.docker:9000"
    val zkHostname = rmHostname
    val timeout = 30 seconds

    val testFile = new File(getClass.getClassLoader.getResource(modelFileName).getFile)
    val testFilePath = fileSystemUri + "/test/" + modelFileName
    val hdfs = HdfsUtils.getDistributedFileSystem(fileSystemUri)
    HdfsUtils.upload(hdfs, testFile, testFilePath)

    val advancedYarnClient = new AdvancedYarnClient(rmHostname, fileSystemUri)
    Await.result(Future.sequence(YarnActorService.startActorSystems(advancedYarnClient)), timeout)
    val coordinator = Await.result(Coordinator.create(advancedYarnClient), timeout)

    val vocabulary = loadRdf(getClass.getClassLoader.getResource(vocabularyFileName))
    coordinator.loadData(vocabulary, new DatabaseConnection(testFilePath, Backend.FILE), rmHostname, fileSystemUri)

    val recipe = loadRecipe
    coordinator.startQuery(recipe, rmHostname, fileSystemUri)

    try {
      val result = coordinator.checkResults(recipe, patternName)
      println(s"Query result: $result")
      assertEquals(expectedResult, result)
    } finally {
      coordinator.stopQuery(recipe, zkHostname)
      coordinator.dispose
    }
    // TODO finally stop actor systems
  }

  private def loadRdf(documentUrl: URL): Model = {
    val result = new LinkedHashModel
    val urlString = documentUrl.toString
    val format = Rio.getParserFormatForFileName(urlString)
    val parser = Rio.createParser(format)
    parser.setRDFHandler(new StatementCollector(result))
    val inputStream = documentUrl.openStream
    parser.parse(inputStream, urlString)
    result
  }

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

}