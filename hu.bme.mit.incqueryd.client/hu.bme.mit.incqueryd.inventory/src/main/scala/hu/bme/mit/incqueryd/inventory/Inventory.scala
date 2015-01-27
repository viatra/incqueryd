package hu.bme.mit.incqueryd.inventory

case class Inventory(val machineInstances: List[MachineInstance], val master: MachineInstance)