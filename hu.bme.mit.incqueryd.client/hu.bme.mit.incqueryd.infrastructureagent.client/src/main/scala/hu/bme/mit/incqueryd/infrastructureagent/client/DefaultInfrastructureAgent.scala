package hu.bme.mit.incqueryd.infrastructureagent.client

import hu.bme.mit.incqueryd.monitoringserver.client.MonitoringServer
import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import eu.mondo.utils.WebServiceUtils
import org.apache.http.message.BasicNameValuePair
import upickle._
import hu.bme.mit.incqueryd.infrastructureagent.client.DefaultInfrastructureAgent._

object DefaultInfrastructureAgent {
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

class DefaultInfrastructureAgent(val instance: MachineInstance) extends InfrastructureAgent {

  override def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.ip}")
    val response = callWebService(PrepareInfrastructure.path, inventory).getEntity(classOf[PrepareInfrastructureResponse])
    if (response.isMaster()) {
      val coordinator = new Coordinator(instance)
      val monitoringServer = new MonitoringServer(instance)
      Infrastructure(Some(coordinator), Some(monitoringServer))
    } else {
      Infrastructure(None, None)
    }
  }

  override def destroyInfrastructure(inventory: Inventory) {
    callWebService(DestroyInfrastructure.path, inventory)
  }

  private def callWebService(path: String, inventory: Inventory) = {
    val inventoryJson = write(inventory)
    WebServiceUtils.call(instance.ip, port, path,
      new BasicNameValuePair(inventoryParameter, inventoryJson),
      new BasicNameValuePair(currentIpParameter, instance.ip))
  }

}