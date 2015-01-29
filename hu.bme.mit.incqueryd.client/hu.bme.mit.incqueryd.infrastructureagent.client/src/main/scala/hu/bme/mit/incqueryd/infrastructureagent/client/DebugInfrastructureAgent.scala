package hu.bme.mit.incqueryd.infrastructureagent.client

import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.actorservice.LocalActorService
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.engine.CoordinatorActor

class DebugInfrastructureAgent(val instance: MachineInstance) extends InfrastructureAgent {

  val coordinatorId = Coordinator.actorId(instance.ip)
 
  override def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println("Preparing infrastructure on local machine")
    LocalActorService.start(coordinatorId, classOf[CoordinatorActor])
    val coordinator = new Coordinator(instance)
    val monitoringServer = None // TODO
    Infrastructure(Some(coordinator), monitoringServer)
  }

  override def destroyInfrastructure(inventory: Inventory) {
    LocalActorService.stop(coordinatorId)
  }

}