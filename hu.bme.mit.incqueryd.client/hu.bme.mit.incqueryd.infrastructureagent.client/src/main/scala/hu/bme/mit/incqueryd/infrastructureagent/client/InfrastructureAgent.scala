package hu.bme.mit.incqueryd.infrastructureagent.client

import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.monitoringserver.client.MonitoringServer

trait InfrastructureAgent {
  def prepareInfrastructure(inventory: Inventory): Infrastructure
  def destroyInfrastructure(inventory: Inventory)
}