package hu.bme.mit.incqueryd.engine

import akka.actor.ActorRef
import hu.bme.mit.incqueryd.inventory.Inventory

case class DeploymentResult(
  inputNodesByType: Map[RdfType, ActorRef],
  otherNodesByEmfUri: Map[String, ActorRef],
  deployedInventory: Inventory)