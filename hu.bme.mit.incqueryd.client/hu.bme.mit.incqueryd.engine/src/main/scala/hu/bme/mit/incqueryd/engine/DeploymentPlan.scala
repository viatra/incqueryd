package hu.bme.mit.incqueryd.engine

import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.inventory.Inventory
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe

case class DeploymentPlan(allocation: Map[ReteNodeRecipe, MachineInstance], deployedInventory: Inventory)