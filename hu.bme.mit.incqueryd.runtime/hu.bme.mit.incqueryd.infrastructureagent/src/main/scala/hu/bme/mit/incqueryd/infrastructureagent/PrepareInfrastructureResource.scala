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
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import hu.bme.mit.incqueryd.util.EObjectDeserializer
import hu.bme.mit.incqueryd.inventory.InventoryPackage
import scala.collection.JavaConversions._
import eu.mondo.utils.UnixUtils
import java.util.Collections
import com.google.common.collect.ImmutableMap
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import scala.concurrent.duration._
import hu.bme.mit.incqueryd.infrastructureagent.client.PrepareInfrastructureResponse

@Path(InfrastructureAgent.PrepareInfrastructure.path)
@Produces(Array(MediaType.APPLICATION_JSON))
class PrepareInfrastructureResource {

  @GET
  @Timed
  def execute(@QueryParam(InfrastructureAgent.PrepareInfrastructure.inventoryParameter) inventoryJson: String): PrepareInfrastructureResponse = {
    val inventory = parseInventory(inventoryJson)
    val isMaster = thisMachineIsMaster(inventory)
    if (isMaster) {
      startCoordinator(inventory)
      startMonitoring
    }
    startOsAgent(inventory)
    new PrepareInfrastructureResponse(isMaster)
  }

  private def parseInventory(inventoryJson: String): Inventory = {
	EObjectDeserializer.deserializeFromString(inventoryJson, Set(InventoryPackage.eINSTANCE)) match {
	  case inventory: Inventory => inventory
	  case _ => throw new IllegalArgumentException(s"JSON does not describe an inventory: $inventoryJson")
	}
  }

  private def thisMachineIsMaster(inventory: Inventory): Boolean = {
    InfrastructureAgentUtils.thisMachineIs(inventory.getMaster)
  }

  private def startCoordinator(inventory: Inventory) {
    UnixUtils.exec("./start-coordinator.sh", Map[String, String](), System.out)
    InfrastructureAgentUtils.waitForServer(inventory.getMaster.getIp, Coordinator.port, 10 seconds)
  }

  private def startMonitoring {
    // TODO
  }

  private def startOsAgent(inventory: Inventory) {
    // TODO
  }

}
