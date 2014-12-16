package hu.bme.mit.incqueryd.coordinator.client

case class ChangeSet(tuples: Set[Tuple], positive: Boolean)