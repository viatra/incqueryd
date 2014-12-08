package hu.bme.mit.incqueryd.test

import scala.Option.option2Iterable

import org.junit.Assert._
import org.junit.Test

import hu.bme.mit.incqueryd.bootstrapagent.client.BootstrapAgent
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.inventory.InventoryFactory

class IntegrationTest {

  @Test
  def mainWorkflow() {
    val inventory = loadInventory
    val infrastructureAgents = BootstrapAgent.bootstrapAll(inventory)
    val infrastructures = infrastructureAgents.map(_.prepareInfrastructure(inventory))
    val coordinators = infrastructures.flatMap(_.coordinator.toSet)
    assertEquals(1, coordinators.size)
    val coordinator = coordinators.head
    val recipe = loadRecipe
    coordinator.startQuery(recipe)
    val result = coordinator.check
    println(s"Query result: $result")
    assertEquals(Coordinator.sampleResult, result)
    coordinator.stopQuery
    infrastructureAgents.foreach(_.destroyInfrastructure)
  }

  def loadInventory = {
    val inventory = InventoryFactory.eINSTANCE.createInventory
    val instanceSet = InventoryFactory.eINSTANCE.createInstanceSet
    val instance = InventoryFactory.eINSTANCE.createMachineInstance
    instance.setIp("127.0.0.1")
    instanceSet.getMachineInstances.add(instance)
    inventory.setMachineSet(instanceSet)
    inventory
  }
  
  def loadRecipe = null // TODO

}
