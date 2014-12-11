package hu.bme.mit.incqueryd.bootstrapagent.client

import scala.collection.JavaConversions.asScalaBuffer
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import hu.bme.mit.incqueryd.inventory.InstanceSet
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance
import eu.mondo.utils.WebServiceUtils

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
    val port = 4242 // XXX duplication
    WebServiceUtils.call(instance.getIp, port, "")
    new InfrastructureAgent(instance)
  }

}
