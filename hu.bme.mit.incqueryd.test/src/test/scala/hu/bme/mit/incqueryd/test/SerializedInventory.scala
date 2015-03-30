package hu.bme.mit.incqueryd.test

import hu.bme.mit.incqueryd.inventory.MachineInstance

// to avoid cross-reference in JSON
case class SerializedInventory(
    val slaves: List[MachineInstance],
    val master: MachineInstance)