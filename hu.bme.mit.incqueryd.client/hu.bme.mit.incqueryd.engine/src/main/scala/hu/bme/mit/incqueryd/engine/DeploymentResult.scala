package hu.bme.mit.incqueryd.engine

import akka.actor.ActorRef
import hu.bme.mit.incqueryd.inventory.Inventory

case class DeploymentResult(
  inputActorsByType: Map[RdfType, ActorRef],
  otherActorsByEmfId: Map[String, ActorRef],
  deployedInventory: Inventory)