package hu.bme.mit.incqueryd.engine

import hu.bme.mit.incqueryd.inventory._
import hu.bme.mit.incqueryd.util.EObjectDeserializer
import scala.collection.JavaConversions._

object InventoryUtils {

  def parseInventory(inventoryJson: String): Inventory = {
    EObjectDeserializer.deserializeFromString(inventoryJson, Set(InventoryPackage.eINSTANCE)) match {
      case inventory: Inventory => inventory
      case _ => throw new IllegalArgumentException(s"JSON does not describe an inventory: $inventoryJson")
    }
  }

  def getMachineInstances(inventory: Inventory): List[MachineInstance] = {
    inventory.getMachineSet match {
      case instanceSet: InstanceSet => instanceSet.getMachineInstances.toList
      case _ => List()
    }
  }

  def getMemoryInMb(machineInstance: MachineInstance): Long = {
    val factor = machineInstance.getMemoryUnit match {
      case MemoryUnit.MB => 1
      case MemoryUnit.GB => 1024
    }
    machineInstance.getMemorySize * factor
  }

}
