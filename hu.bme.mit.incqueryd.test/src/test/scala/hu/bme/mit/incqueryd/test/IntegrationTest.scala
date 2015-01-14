package hu.bme.mit.incqueryd.test

import scala.Option.option2Iterable
import org.junit.Assert._
import org.junit.Test
import hu.bme.mit.incqueryd.bootstrapagent.client.BootstrapAgent
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.inventory.InventoryFactory
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.InstanceSet
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.infrastructureagent.client.DefaultInfrastructureAgent
import hu.bme.mit.incqueryd.infrastructureagent.client.DebugInfrastructureAgent

trait IntegrationTest {

  def getInfrastructureAgents(inventory: Inventory): Iterable[InfrastructureAgent]

  @Test
  def test() {
    val inventory = loadInventory
    val infrastructureAgents = getInfrastructureAgents(inventory)
    try {
      val infrastructures = infrastructureAgents.map(_.prepareInfrastructure(inventory))
      val coordinators = infrastructures.flatMap(_.coordinator.toSet)
      assertEquals(1, coordinators.size)
      val coordinator = coordinators.head
      val recipe = loadRecipe
      val network = coordinator.startQuery(recipe)
      try {
        assertTrue(!network.patterns.isEmpty)
        val result = coordinator.checkResults(network.patterns.head)
        println(s"Query result: $result")
        assertEquals(Coordinator.CheckResults.sampleResult, result)
      } finally {
        coordinator.stopQuery(network)
      }
    } finally {
      infrastructureAgents.foreach(_.destroyInfrastructure)
    }
  }

  private def loadInventory = {
    val inventory = InventoryFactory.eINSTANCE.createInventory
    val instanceSet = InventoryFactory.eINSTANCE.createInstanceSet
    val instance = InventoryFactory.eINSTANCE.createMachineInstance
    val instanceIpKey: String = "instanceIp"
    val instanceIp: String = System.getProperty(instanceIpKey)
    if (instanceIp == null) {
      throw new IllegalArgumentException(s"VM argument $instanceIpKey is not set!")
    }
    instance.setIp(instanceIp)
    instanceSet.getMachineInstances.add(instance)
    inventory.setMachineSet(instanceSet)
    inventory.setMaster(instance)
    inventory
  }

  private def loadRecipe = null // TODO

}

class Debug extends IntegrationTest {
  override def getInfrastructureAgents(inventory: Inventory) = {
    inventory.getMachineSet match {
      case instanceSet: InstanceSet =>
        instanceSet.getMachineInstances.map(new DebugInfrastructureAgent(_))
      case _ => List()
    }
  }
}

class Development extends IntegrationTest {
  override def getInfrastructureAgents(inventory: Inventory) = {
    inventory.getMachineSet match {
      case instanceSet: InstanceSet =>
        instanceSet.getMachineInstances.map(new DefaultInfrastructureAgent(_))
      case _ => List()
    }
  }
}

class Production extends IntegrationTest {
  override def getInfrastructureAgents(inventory: Inventory) = {
    BootstrapAgent.bootstrapAll(inventory)
  }
}