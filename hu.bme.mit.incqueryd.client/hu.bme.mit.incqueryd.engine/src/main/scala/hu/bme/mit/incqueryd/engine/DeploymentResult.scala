package hu.bme.mit.incqueryd.engine

import akka.actor.ActorRef
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.engine.rete.actors.RdfType
import hu.bme.mit.incqueryd.engine.rete.actors.YellowPages

case class DeploymentResult(yellowPages: YellowPages, deployedInventory: Inventory)