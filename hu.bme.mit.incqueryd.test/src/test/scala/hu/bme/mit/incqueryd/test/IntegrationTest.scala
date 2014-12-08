package hu.bme.mit.incqueryd.test

import org.junit.Test
import hu.bme.mit.incqueryd.bootstrapagent.client.BootstrapAgent
import hu.bme.mit.incqueryd.inventory.InventoryFactory
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import org.junit.Assert

class IntegrationTest {

  @Test
  def mainWorkflow() {
    val inventory = InventoryFactory.eINSTANCE.createInventory
    val instanceSet = InventoryFactory.eINSTANCE.createInstanceSet
    val instance = InventoryFactory.eINSTANCE.createMachineInstance
    instance.setIp("127.0.0.1")
    instanceSet.getMachineInstances.add(instance)
    inventory.setMachineSet(instanceSet)
    val infrastructureAgents = BootstrapAgent.bootstrapAll(inventory)
    val infrastructures = infrastructureAgents.map(agent => agent.prepareInfrastructure(inventory))
    val coordinators = infrastructures.flatMap(_.coordinator.toSet)
    Assert.assertEquals(1, coordinators.size)
    val coordinator = coordinators.head
    val recipe = null // TODO
    coordinator.startQuery(recipe)
    val result = coordinator.check
    println(s"Query result: $result")
    Assert.assertEquals(Coordinator.sampleResult, result)
    coordinator.stopQuery
    infrastructureAgents.foreach(_.destroyInfrastructure)
  }

}
