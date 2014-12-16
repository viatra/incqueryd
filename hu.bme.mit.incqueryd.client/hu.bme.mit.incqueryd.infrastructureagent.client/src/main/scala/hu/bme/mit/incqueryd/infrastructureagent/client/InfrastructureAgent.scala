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
import org.apache.http.NameValuePair
import hu.bme.mit.incqueryd.util.EObjectSerializer
import org.apache.http.message.BasicNameValuePair
import com.sun.jersey.api.client.Client
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import com.sun.jersey.api.client.ClientResponse
import org.apache.http.client.utils.URIUtils
import org.apache.http.client.utils.URLEncodedUtils
import com.google.common.collect.ImmutableList
import com.sun.jersey.api.client.config.DefaultClientConfig
import org.codehaus.jackson.jaxrs.JacksonJsonProvider

object InfrastructureAgent {
  final val port = 8080
  object PrepareInfrastructure {
    final val path = "/prepare"
    final val inventoryParameter = "inventory"
  }
  object StartMicrokernels {
    final val path = "/start"
  }
  object StopMicrokernels {
    final val path = "/stop"
  }
  object DestroyInfrastructure {
    final val path = "/destroy"
  }
}

class InfrastructureAgent(val instance: MachineInstance) {

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.getIp}")
    val inventoryJson = EObjectSerializer.serializeToString(inventory)
    val response = callWebService(InfrastructureAgent.PrepareInfrastructure.path, new BasicNameValuePair(InfrastructureAgent.PrepareInfrastructure.inventoryParameter, inventoryJson)).getEntity(classOf[PrepareInfrastructureResponse])
    if (response.isMaster) {
      val coordinator = new Coordinator(instance)
      val monitoringServer = new MonitoringServer(instance)
      Infrastructure(Some(coordinator), Some(monitoringServer))
    } else {
      Infrastructure(None, None)
    }
  }

  def destroyInfrastructure() {
    val response = callWebService(InfrastructureAgent.DestroyInfrastructure.path)
  }

  def startMicrokernels() {
    val response = callWebService(InfrastructureAgent.StartMicrokernels.path)
  }

  def stopMicrokernels() {
    val response = callWebService(InfrastructureAgent.StopMicrokernels.path)
  }

  private def callWebService(path: String, params: NameValuePair*) = WebServiceUtils.call(instance.getIp, InfrastructureAgent.port, path, params: _*)

}
