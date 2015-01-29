package hu.bme.mit.incqueryd.infrastructureagent

import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces, QueryParam}
import com.codahale.metrics.annotation.Timed
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.infrastructureagent.client.DefaultInfrastructureAgent._
import hu.bme.mit.incqueryd.infrastructureagent.client.PrepareInfrastructureResponse
import hu.bme.mit.incqueryd.inventory.Inventory
import upickle._
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.LocalActorService
import hu.bme.mit.incqueryd.engine.CoordinatorActor

@Path(PrepareInfrastructure.path)
@Produces(Array(MediaType.APPLICATION_JSON))
class PrepareInfrastructureResource {

  @GET
  @Timed
  def execute(@QueryParam(inventoryParameter) inventoryJson: String, @QueryParam(currentIpParameter) currentIp: String): PrepareInfrastructureResponse = {
    val inventory = read[Inventory](inventoryJson)
    val isMaster = inventory.master.ip == currentIp
    if (isMaster) {
      startCoordinator(currentIp)
      startMonitoring
    }
    startOsAgent(inventory)
    new PrepareInfrastructureResponse(isMaster)
  }

  private def startCoordinator(currentIp: String) {
    LocalActorService.start(Coordinator.actorId(currentIp), classOf[CoordinatorActor])
  }

  private def startMonitoring {
    // TODO
  }

  private def startOsAgent(inventory: Inventory) {
    // TODO
  }

}
