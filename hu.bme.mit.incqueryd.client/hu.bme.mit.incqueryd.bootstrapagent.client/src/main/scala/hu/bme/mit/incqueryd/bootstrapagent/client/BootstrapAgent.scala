package hu.bme.mit.incqueryd.bootstrapagent.client

import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import hu.bme.mit.incqueryd.inventory.InstanceSet
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance
import scala.collection.JavaConversions._

object BootstrapAgent {

  def bootstrapAll(inventory: Inventory): java.lang.Iterable[InfrastructureAgent] = {
    inventory.getMachineSet match {
      case instanceSet: InstanceSet => instanceSet.getMachineInstances.map(new BootstrapAgent(_).bootstrap)
      case _ => List()
    }
  }

}

class BootstrapAgent(private val instance: MachineInstance) {

  def bootstrap: InfrastructureAgent = {
    println(s"Bootstrapping ${instance.getIp}")
    new InfrastructureAgent(instance)
  }

}
