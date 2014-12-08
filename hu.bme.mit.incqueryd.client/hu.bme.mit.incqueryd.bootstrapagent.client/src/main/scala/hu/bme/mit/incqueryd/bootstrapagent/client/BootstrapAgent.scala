package hu.bme.mit.incqueryd.bootstrapagent.client

import scala.collection.JavaConversions.asScalaBuffer

import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient

import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import hu.bme.mit.incqueryd.inventory.InstanceSet
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance

object BootstrapAgent {

  def bootstrapAll(inventory: Inventory): Iterable[InfrastructureAgent] = {
    inventory.getMachineSet match {
      case instanceSet: InstanceSet => instanceSet.getMachineInstances.map(new BootstrapAgent(_).bootstrap)
      case _ => List()
    }
  }

}

class BootstrapAgent(val instance: MachineInstance) {

  def bootstrap: InfrastructureAgent = {
    println(s"Bootstrapping ${instance.getIp}")
    val httpClient = new DefaultHttpClient
    val port = 4242 // XXX duplication
    val httpGet = new HttpGet(s"http://${instance.getIp}:$port")
    val response = httpClient.execute(httpGet)
    httpGet.releaseConnection
    if (response.getStatusLine.getStatusCode != HttpStatus.SC_OK) {
      throw new RuntimeException("Bootstrapping failed, status: " + response.getStatusLine)
    }
    new InfrastructureAgent(instance)
  }

}
