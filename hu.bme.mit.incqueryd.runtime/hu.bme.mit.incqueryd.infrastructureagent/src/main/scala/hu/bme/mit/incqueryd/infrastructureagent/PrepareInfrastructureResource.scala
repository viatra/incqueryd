package hu.bme.mit.incqueryd.infrastructureagent

import com.codahale.metrics.annotation.Timed
import hu.bme.mit.incqueryd.inventory.Inventory
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType
import hu.bme.mit.incqueryd.inventory.InventoryFactory
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgentPaths
import eu.mondo.utils.UnixUtils
import eu.mondo.utils.UnixUtils

@Path(InfrastructureAgentPaths.prepareInfrastructure)
@Produces(Array(MediaType.APPLICATION_JSON))
class PrepareInfrastructureResource {

  @GET
  @Timed
  def execute(@QueryParam("inventory") inventoryJson: String): Response = {
    val inventory = parseInventory(inventoryJson)
    if (thisMachineIsMaster(inventory)) {
      startCoordinator(inventory)
      startMonitoring
    }
    startOsAgent(inventory)
    Response.ok.build
  }

  private def parseInventory(inventoryJson: String): Inventory = {
    InventoryFactory.eINSTANCE.createInventory // TODO
  }

  private def thisMachineIsMaster(inventory: Inventory): Boolean = {
    true // TODO
  }

  private def startCoordinator(inventory: Inventory) {
    // TODO scripts/start.sh
  }

  private def startMonitoring {
    // TODO
  }

  private def startOsAgent(inventory: Inventory) {
    // TODO
  }

}
