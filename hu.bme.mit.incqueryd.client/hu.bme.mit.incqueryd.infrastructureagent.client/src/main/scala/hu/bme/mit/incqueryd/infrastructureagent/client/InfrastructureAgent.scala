package hu.bme.mit.incqueryd.infrastructureagent.client

import akka.actor.{ActorSystem, Props}
import eu.mondo.utils.WebServiceUtils
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import hu.bme.mit.incqueryd.engine.{AkkaUtils, CoordinatorActor}
import hu.bme.mit.incqueryd.inventory.{Inventory, MachineInstance}
import hu.bme.mit.incqueryd.monitoringserver.client.MonitoringServer
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import upickle._

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

class DefaultInfrastructureAgent(val instance: MachineInstance) extends InfrastructureAgent {

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println(s"Preparing infrastructure on ${instance.ip}")
    val inventoryJson = write(inventory)
    val instanceIp = instance.ip
    val response = callWebService(InfrastructureAgent.PrepareInfrastructure.path,
      new BasicNameValuePair(InfrastructureAgent.PrepareInfrastructure.inventoryParameter, inventoryJson),
      new BasicNameValuePair(InfrastructureAgent.PrepareInfrastructure.currentIpParameter, instanceIp)).getEntity(classOf[PrepareInfrastructureResponse])
    if (response.isMaster()) {
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

  private def callWebService(path: String, params: NameValuePair*) = WebServiceUtils.call(instance.ip, InfrastructureAgent.port, path, params: _*)

}

class DebugInfrastructureAgent(val instance: MachineInstance) extends InfrastructureAgent {

  lazy val actorSystem = AkkaUtils.createRemotingActorSystem(Coordinator.actorSystemName, instance.ip, Coordinator.port)

  def prepareInfrastructure(inventory: Inventory): Infrastructure = {
    println("Preparing infrastructure on local machine")
    val props = Props[CoordinatorActor]
    actorSystem.actorOf(props, Coordinator.actorName)
    val coordinator = new Coordinator(instance)
    Infrastructure(Some(coordinator), None)
  }

  def destroyInfrastructure {
    actorSystem.terminate
  }

  def startMicrokernels {
  }

  def stopMicrokernels {
  }

}