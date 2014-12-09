package hu.bme.mit.incqueryd.infrastructureagent.client

import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.monitoringserver.client.MonitoringServer
import org.apache.http.HttpResponse

class InfrastructureAgent(val instance: MachineInstance) {

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.getIp}")
    val response = callWebService(InfrastructureAgentPaths.prepare)
    val coordinator = new Coordinator(instance)
    val monitoringServer = new MonitoringServer(instance)
    Infrastructure(Some(coordinator), Some(monitoringServer))
  }

  def destroyInfrastructure() {
    val response = callWebService(InfrastructureAgentPaths.destroy)
  }

  def startMicrokernels() {
    val response = callWebService(InfrastructureAgentPaths.startMicrokernels)
  }

  def stopMicrokernels() {
    val response = callWebService(InfrastructureAgentPaths.stopMicrokernels)
  }
  
  private def callWebService(path: String): HttpResponse = {
    val httpClient = new DefaultHttpClient
    val port = 8080
    val httpGet = new HttpGet(s"http://${instance.getIp}:$port$path")
    val response = httpClient.execute(httpGet)
    httpGet.releaseConnection
    if (response.getStatusLine.getStatusCode != HttpStatus.SC_OK) {
      throw new RuntimeException("Calling web service failed, status: " + response.getStatusLine)
    }
    response
  }

}
