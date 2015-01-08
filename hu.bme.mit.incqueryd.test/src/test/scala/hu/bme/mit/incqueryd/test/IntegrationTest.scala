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

object IntegrationTest {

  def test(development: Boolean) {
    val inventory = loadInventory
    val infrastructureAgents = if (development) localInfrastructureAgents(inventory) else BootstrapAgent.bootstrapAll(inventory)
    try {
      val infrastructures = infrastructureAgents.map(_.prepareInfrastructure(inventory))
      val coordinators = infrastructures.flatMap(_.coordinator.toSet)
      assertEquals(1, coordinators.size)
      val coordinator = coordinators.head
      val recipe = loadRecipe
      coordinator.startQuery(recipe)
      val result = coordinator.check
      println(s"Query result: $result")
      assertEquals(Coordinator.CheckResults.sampleResult, result)
      coordinator.stopQuery
    } finally {
	  infrastructureAgents.foreach(_.destroyInfrastructure)
    }
  }

  private def localInfrastructureAgents(inventory: Inventory) = {
    inventory.getMachineSet match {
      case instanceSet: InstanceSet => instanceSet.getMachineInstances.map(new InfrastructureAgent(_))
      case _ => List()
    }
  }

  private def loadInventory = {
    val inventory = InventoryFactory.eINSTANCE.createInventory
    val instanceSet = InventoryFactory.eINSTANCE.createInstanceSet
    val instance = InventoryFactory.eINSTANCE.createMachineInstance
    instance.setIp(System.getProperty("instanceIp"))
    instanceSet.getMachineInstances.add(instance)
    inventory.setMachineSet(instanceSet)
    inventory.setMaster(instance)
    inventory
  }

  private def loadRecipe = null // TODO

}