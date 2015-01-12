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
import akka.actor.ActorSystem
import hu.bme.mit.incqueryd.coordinator.client.CoordinatorActor
import akka.actor.Props
import akka.actor.Deploy
import akka.remote.RemoteScope
import akka.actor.Address
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import akka.actor.ActorPath
import scala.concurrent.Await
import akka.util.Timeout
import java.util.concurrent.TimeUnit
import eu.mondo.utils.NetworkUtils
import akka.actor.ActorRef

object InfrastructureAgent {
  final val port = 8084
  final val adminPort = 8085
  object PrepareInfrastructure {
    final val path = "/prepare"
    final val inventoryParameter = "inventory"
    final val currentIpParameter = "currentIp"
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

trait InfrastructureAgent {
  def prepareInfrastructure(inventory: Inventory): Infrastructure
  def destroyInfrastructure
  def startMicrokernels
  def stopMicrokernels
}

object DefaultInfrastructureAgent {
}

class DefaultInfrastructureAgent(val instance: MachineInstance) extends InfrastructureAgent {

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.getIp}")
    val inventoryJson = EObjectSerializer.serializeToString(inventory)
    val instanceIp = instance.getIp
    val response = callWebService(InfrastructureAgent.PrepareInfrastructure.path,
      new BasicNameValuePair(InfrastructureAgent.PrepareInfrastructure.inventoryParameter, inventoryJson),
      new BasicNameValuePair(InfrastructureAgent.PrepareInfrastructure.currentIpParameter, instanceIp)).getEntity(classOf[PrepareInfrastructureResponse])
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

class DebugInfrastructureAgent(val instance: MachineInstance) extends InfrastructureAgent {

  val actorSystem = ActorSystem(Coordinator.actorSystemName)

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println("Preparing infrastructure on local machine")
    val actorSystem = Coordinator.createCoordinatorRuntimeActorSystem(instance.getIp)
    val props = Props[CoordinatorActor]
    actorSystem.actorOf(props, Coordinator.actorName)
    val coordinator = new Coordinator(instance)
    Infrastructure(Some(coordinator), None)
  }

  def destroyInfrastructure {
    actorSystem.shutdown
  }

  def startMicrokernels {
  }

  def stopMicrokernels {
  }

}