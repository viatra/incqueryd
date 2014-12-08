package hu.bme.mit.incqueryd.infrastructureagent.client

import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.monitoringserver.client.MonitoringServer

class InfrastructureAgent(val instance: MachineInstance) {

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.getIp}")
    val coordinator = new Coordinator(instance)
    val monitoringServer = new MonitoringServer(instance)
    Infrastructure(Some(coordinator), Some(monitoringServer))
  }

  def destroyInfrastructure() {
  }

  def startMicrokernels() {
  }
  
  def stopMicrokernels() {
  }
 
}
