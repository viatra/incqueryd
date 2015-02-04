package hu.bme.mit.incqueryd.engine

import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.inventory.MachineInstance
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import hu.bme.mit.incqueryd.actorservice.ActorId
import java.io.Serializable

case class DeploymentResult[Key](
  allActors: Set[ActorId],
  specialActors: Map[Key, ActorId],
  deployedInventory: Inventory)