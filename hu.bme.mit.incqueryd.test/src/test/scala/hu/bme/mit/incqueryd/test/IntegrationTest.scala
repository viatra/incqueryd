package hu.bme.mit.incqueryd.test

import java.net.URL
import java.io.File
import eu.mondo.utils.{NetworkUtils, UnixUtils}
import hu.bme.mit.incqueryd.bootstrapagent.client.BootstrapAgent
import hu.bme.mit.incqueryd.engine.{AkkaUtils, CoordinatorActor}
import hu.bme.mit.incqueryd.infrastructureagent.client.{DebugInfrastructureAgent, DefaultInfrastructureAgent, InfrastructureAgent}
import hu.bme.mit.incqueryd.inventory.Inventory
import org.junit.Assert._
import org.junit.Test
import org.openrdf.model.Model
import org.openrdf.model.impl.LinkedHashModel
import org.openrdf.rio.Rio
import org.openrdf.rio.helpers.StatementCollector
import scala.Option.option2Iterable
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.inventory.MachineInstance

trait IntegrationTest {

  def getInfrastructureAgents(inventory: Inventory): Iterable[InfrastructureAgent]

  @Test
  def test() {
    val inventory = loadInventory
    val modelFileName = "model.ttl"
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
        assertTrue(network.patterns.nonEmpty)
        val result = coordinator.checkResults(network.patterns.head)
        println(s"Query result: $result")
        assertEquals(CoordinatorActor.sampleResult, result)
      } finally {
        coordinator.stopQuery(network)
      }
    } finally {
      testFileServer.destroy
      infrastructureAgents.foreach(_.destroyInfrastructure)
    }
  }

  private def loadInventory = {
    val instanceIpKey: String = "instanceIp"
    val instanceIp = System.getProperty(instanceIpKey)
    if (instanceIp == null) {
      throw new IllegalArgumentException(s"VM argument $instanceIpKey is not set!")
    }
    val instance = MachineInstance(4*1024, instanceIp)
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

  private def loadRecipe = null // TODO

}


class Debug extends IntegrationTest {
  override def getInfrastructureAgents(inventory: Inventory) = {
    inventory.machineInstances.map(new DebugInfrastructureAgent(_))
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