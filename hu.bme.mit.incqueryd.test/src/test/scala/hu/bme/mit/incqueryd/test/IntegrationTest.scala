package hu.bme.mit.incqueryd.test

import java.io.File
import java.net.URL
import scala.Option.option2Iterable
import scala.collection.JavaConversions._
import org.junit.Assert._
import org.junit.Test
import org.openrdf.model.Model
import org.openrdf.model.impl.LinkedHashModel
import org.openrdf.rio.Rio
import org.openrdf.rio.helpers.StatementCollector
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.bootstrapagent.client.BootstrapAgent
import hu.bme.mit.incqueryd.engine.CoordinatorActor
import hu.bme.mit.incqueryd.infrastructureagent.client.DefaultInfrastructureAgent
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor
import hu.bme.mit.incqueryd.engine.rete.messages.CoordinatorMessage
import java.util.concurrent.TimeUnit

trait IntegrationTest {

  def getInfrastructureAgents(inventory: Inventory): Iterable[InfrastructureAgent]

  @Test
  def test() {
    val inventory = loadInventory
    val modelFileName = "railway-test-1.ttl"
    val workingDirectory = new File(getClass.getClassLoader.getResource(modelFileName).getFile).getParentFile
    val testFileServer = TestFileServer.start(workingDirectory)
    val infrastructureAgents = getInfrastructureAgents(inventory)
    try {
      val infrastructures = infrastructureAgents.map(_.prepareInfrastructure(inventory))
      val coordinators = infrastructures.flatMap(_.coordinator.toSet)
      assertEquals(1, coordinators.size)
      val coordinator = coordinators.head
      val recipe = loadRecipe
      val vocabulary = loadRdf(getClass.getClassLoader.getResource("vocabulary.rdf"))
      val databaseUrl = s"http://${NetworkUtils.getLocalIpAddress}:${TestFileServer.port}/$modelFileName"
      val index = coordinator.loadData(databaseUrl, vocabulary, inventory)
      val network = coordinator.startQuery(recipe, index)
      try {
        val result = coordinator.checkResults(recipe, network)
        println(s"Query result: $result")
        // TODO assert when expected result is determined
      } finally {
        coordinator.stopQuery(network)
      }
    } finally {
      testFileServer.destroy
      infrastructureAgents.foreach(_.destroyInfrastructure(inventory))
    }
  }

  private def loadInventory = {
    val instanceIpKey: String = "instanceIp"
    val instanceIp = System.getProperty(instanceIpKey)
    if (instanceIp == null) {
      throw new IllegalArgumentException(s"VM argument $instanceIpKey is not set!")
    }
    val instance = MachineInstance(8*1024, instanceIp)
    Inventory(List(instance), instance)
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

class Development extends IntegrationTest {
  override def getInfrastructureAgents(inventory: Inventory) = {
    inventory.machineInstances.map(new DefaultInfrastructureAgent(_))
  }
}

class Production extends IntegrationTest {
  override def getInfrastructureAgents(inventory: Inventory) = {
    BootstrapAgent.bootstrapAll(inventory)
  }
}