package hu.bme.mit.incqueryd.infrastructureagent.client

import hu.bme.mit.incqueryd.inventory.MachineInstance

class InfrastructureAgent(private val instance: MachineInstance) {

  def prepareInfrastructure(): Infrastructure = null

  def destroyInfrastructure() {
  }

  def startMicrokernels() {
  }
}
