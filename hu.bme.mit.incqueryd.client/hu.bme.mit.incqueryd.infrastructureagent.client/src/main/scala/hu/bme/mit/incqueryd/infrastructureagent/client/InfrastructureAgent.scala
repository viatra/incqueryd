package hu.bme.mit.incqueryd.infrastructureagent.client

import akka.actor.{ActorSystem, Props}
import eu.mondo.utils.WebServiceUtils
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.inventory.{Inventory, MachineInstance}
import hu.bme.mit.incqueryd.monitoringserver.client.MonitoringServer
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import upickle._
import hu.bme.mit.incqueryd.actorservice.LocalActorService
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.engine.CoordinatorActor
import hu.bme.mit.incqueryd.coordinator.client.Coordinator

object InfrastructureAgent {
  final val port = 8084
  final val adminPort = 8085
  final val inventoryParameter = "inventory"
  final val currentIpParameter = "currentIp"
  object PrepareInfrastructure {
    final val path = "/prepare"
  }
  object DestroyInfrastructure {
    final val path = "/destroy"
  }
}

trait InfrastructureAgent {
  def prepareInfrastructure(inventory: Inventory): Infrastructure
  def destroyInfrastructure(inventory: Inventory)
}

class DefaultInfrastructureAgent(val instance: MachineInstance) extends InfrastructureAgent {

  override def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.ip}")
    val response = callWebService(InfrastructureAgent.PrepareInfrastructure.path, inventory).getEntity(classOf[PrepareInfrastructureResponse])
    if (response.isMaster()) {
      val coordinator = new Coordinator(instance)
      val monitoringServer = new MonitoringServer(instance)
      Infrastructure(Some(coordinator), Some(monitoringServer))
    } else {
      Infrastructure(None, None)
    }
  }

  override def destroyInfrastructure(inventory: Inventory) {
    val response = callWebService(InfrastructureAgent.DestroyInfrastructure.path, inventory)
  }

  private def callWebService(path: String, inventory: Inventory) = {
    val inventoryJson = write(inventory)
    WebServiceUtils.call(instance.ip, InfrastructureAgent.port, path,
      new BasicNameValuePair(InfrastructureAgent.inventoryParameter, inventoryJson),
      new BasicNameValuePair(InfrastructureAgent.currentIpParameter, instance.ip))
  }

}

class DebugInfrastructureAgent(val instance: MachineInstance) extends InfrastructureAgent {

  val coordinatorId = Coordinator.actorId(instance.ip)
 
  override def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println("Preparing infrastructure on local machine")
    LocalActorService.start(coordinatorId, classOf[CoordinatorActor])
    val coordinator = new Coordinator(instance)
    Infrastructure(Some(coordinator), None)
  }

  override def destroyInfrastructure(inventory: Inventory) {
    LocalActorService.stop(coordinatorId)
  }

}