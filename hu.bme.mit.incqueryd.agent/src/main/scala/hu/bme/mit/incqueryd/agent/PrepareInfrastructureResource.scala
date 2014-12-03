package hu.bme.mit.incqueryd.agent

import java.text.MessageFormat
import java.util.Collections
import org.mondo.eu.utils.UnixUtils
import com.codahale.metrics.annotation.Timed
import com.google.common.collect.ImmutableSet
import hu.bme.mit.incqueryd.engine.util.EObjectDeserializer
import inventory.Inventory
import inventory.InventoryPackage
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import hu.bme.mit.incqueryd.core.CoreScripts
import hu.bme.mit.incqueryd.monitoring.MonitoringScripts

@Path("/prepare")
@Produces(Array(MediaType.APPLICATION_JSON))
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
    val command = CoreScripts.START_COORDINATOR
    UnixUtils.exec(command, Collections.emptyMap[String, String])
  }

  private def startMonitoring {
    val command = MonitoringScripts.START_SERVER
    UnixUtils.exec(command, Collections.emptyMap[String, String])
  }

  private def startOsAgent(inventory: Inventory) {
    val command = MonitoringScripts.START_OS_AGENT(inventory.getMaster.getIp)
    UnixUtils.exec(command, Collections.emptyMap[String, String])
  }

}
