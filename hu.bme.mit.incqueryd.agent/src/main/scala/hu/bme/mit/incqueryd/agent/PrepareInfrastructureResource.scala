package hu.bme.mit.incqueryd.agent

import java.text.MessageFormat
import java.util.Collections

import org.mondo.eu.utils.UnixUtils

import com.codahale.metrics.annotation.Timed
import com.google.common.collect.ImmutableSet

import Paths.CORE_SCRIPTS
import Paths.MONITORING_SCRIPTS
import hu.bme.mit.incqueryd.engine.util.EObjectDeserializer
import inventory.Inventory
import inventory.InventoryPackage
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response

@Path("/prepare")
class PrepareInfrastructureResource {

  @GET
  @Timed
  def execute(@QueryParam("infrastructure") inventoryJson: String): Response = {
    val inventory = parseInventory(inventoryJson)
    if (thisMachineIsMaster(inventory)) {
      startCoordinator(inventory)
      startMonitoring
    }
    startOsAgent(inventory)
    Response.ok.build
  }

  private def parseInventory(inventoryJson: String): Inventory = {
    EObjectDeserializer.deserializeFromString(inventoryJson, ImmutableSet.of(InventoryPackage.eINSTANCE)).asInstanceOf[Inventory]
  }

  private def thisMachineIsMaster(inventory: Inventory): Boolean = {
    NetworkUtils.thisMachineIs(inventory.getMaster)
  }

  private def startCoordinator(inventory: Inventory) {
    val command = CORE_SCRIPTS + "coordinator/start-coordinator.sh"
    UnixUtils.exec(command, Collections.emptyMap[String, String])
  }

  private def startMonitoring {
    val command = MONITORING_SCRIPTS + "server/start-server.sh"
    UnixUtils.exec(command, Collections.emptyMap[String, String])
  }

  private def startOsAgent(inventory: Inventory) {
    val command = MessageFormat.format(MONITORING_SCRIPTS + "osagent/start.sh {0}", inventory.getMaster.getIp)
    UnixUtils.exec(command, Collections.emptyMap[String, String])
  }

}
