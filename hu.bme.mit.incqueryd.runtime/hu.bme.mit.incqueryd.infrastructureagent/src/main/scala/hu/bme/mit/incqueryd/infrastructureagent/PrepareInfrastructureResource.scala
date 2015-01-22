package hu.bme.mit.incqueryd.infrastructureagent

import javax.ws.rs.{GET, Path, Produces, QueryParam}
import javax.ws.rs.core.MediaType

import akka.actor.{Address, Deploy, Props}
import akka.remote.RemoteScope
import com.codahale.metrics.annotation.Timed
import eu.mondo.utils.UnixUtils
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.engine.{IsAlive, AkkaUtils, CoordinatorActor}
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent.PrepareInfrastructure._
import hu.bme.mit.incqueryd.infrastructureagent.client.{InfrastructureAgent, PrepareInfrastructureResponse}
import hu.bme.mit.incqueryd.inventory.{Inventory, InventoryPackage}
import hu.bme.mit.incqueryd.util.EObjectDeserializer

import scala.collection.JavaConversions._

@Path(InfrastructureAgent.PrepareInfrastructure.path)
@Produces(Array(MediaType.APPLICATION_JSON))
class PrepareInfrastructureResource {

  @GET
  @Timed
  def execute(@QueryParam(inventoryParameter) inventoryJson: String, @QueryParam(currentIpParameter) currentIp: String): PrepareInfrastructureResponse = {
    val inventory = parseInventory(inventoryJson)
    val isMaster = inventory.getMaster.getIp == currentIp
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

  private def startCoordinator(inventory: Inventory) {
    val masterIp = inventory.getMaster.getIp
    val coordinatorActor = AkkaUtils.createActor(Coordinator.actorSystemName, masterIp, Coordinator.port, Coordinator.actorName, classOf[CoordinatorActor])
    AkkaUtils.retry(AkkaUtils.defaultRetryCount)(AkkaUtils.defaultDelayMillis) {
      coordinatorActor ! IsAlive
    }
  }

  private def startMonitoring {
    // TODO
  }

  private def startOsAgent(inventory: Inventory) {
    // TODO
  }

}
