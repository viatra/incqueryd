package hu.bme.mit.incqueryd.infrastructureagent.client

import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.coordinator.client.CoordinatorClient
import hu.bme.mit.incqueryd.coordinator.client.CoordinatorClient
import hu.bme.mit.incqueryd.inventory.Inventory

class InfrastructureAgent(val instance: MachineInstance) {

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.getIp}")
    val coordinator = new CoordinatorClient(instance)
    Infrastructure(Some(coordinator))
  }

  def destroyInfrastructure() {
  }

  def startMicrokernels() {
  }
 
}
