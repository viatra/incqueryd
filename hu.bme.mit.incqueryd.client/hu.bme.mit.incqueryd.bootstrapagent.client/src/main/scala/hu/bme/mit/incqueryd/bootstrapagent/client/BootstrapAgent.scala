package hu.bme.mit.incqueryd.bootstrapagent.client

import scala.collection.JavaConversions.asScalaBuffer
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance
import eu.mondo.utils.WebServiceUtils
import hu.bme.mit.incqueryd.infrastructureagent.client.DefaultInfrastructureAgent

object BootstrapAgent {

  def bootstrapAll(inventory: Inventory): Iterable[InfrastructureAgent] = {
    inventory.machineInstances.map(new BootstrapAgent(_).bootstrap)
  }

}

class BootstrapAgent(val instance: MachineInstance) {

  def bootstrap: InfrastructureAgent = {
    println(s"Bootstrapping ${instance.ip}")
    val port = 4242 // XXX duplication
    WebServiceUtils.call(instance.ip, port, "")
    new DefaultInfrastructureAgent(instance)
  }

}
