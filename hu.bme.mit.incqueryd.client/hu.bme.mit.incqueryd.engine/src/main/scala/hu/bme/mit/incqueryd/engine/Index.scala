package hu.bme.mit.incqueryd.engine

import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance

case class Index(allocation: Map[RdfType, MachineInstance], deployedInventory: Inventory) // TODO inventory is not serializable