package hu.bme.mit.incqueryd.test

import org.junit.Test
import hu.bme.mit.incqueryd.bootstrapagent.client.BootstrapAgent
import hu.bme.mit.incqueryd.inventory.InventoryFactory
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory

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
    val recipe = null // TODO
    coordinators.foreach(_.startQuery(recipe))
  }

}
