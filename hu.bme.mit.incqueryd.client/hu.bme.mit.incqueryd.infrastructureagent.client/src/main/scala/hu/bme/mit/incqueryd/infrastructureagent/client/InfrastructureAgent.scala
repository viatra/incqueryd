package hu.bme.mit.incqueryd.infrastructureagent.client

import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.monitoringserver.client.MonitoringServer
import org.apache.http.HttpResponse
import eu.mondo.utils.WebServiceUtils

class InfrastructureAgent(val instance: MachineInstance) {

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.getIp}")
    val response = callWebService(InfrastructureAgentPaths.prepareInfrastructure)
    val coordinator = new Coordinator(instance)
    val monitoringServer = new MonitoringServer(instance)
    Infrastructure(Some(coordinator), Some(monitoringServer))
  }

  def destroyInfrastructure() {
    val response = callWebService(InfrastructureAgentPaths.destroyInfrastructure)
  }

  def startMicrokernels() {
    val response = callWebService(InfrastructureAgentPaths.startMicrokernels)
  }

  def stopMicrokernels() {
    val response = callWebService(InfrastructureAgentPaths.stopMicrokernels)
  }
  
  private def callWebService(path: String) = WebServiceUtils.call(instance.getIp, 8080, path)

}
