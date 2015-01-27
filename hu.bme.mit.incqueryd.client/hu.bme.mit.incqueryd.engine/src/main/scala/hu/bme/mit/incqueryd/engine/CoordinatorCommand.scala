package hu.bme.mit.incqueryd.engine

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.Model
import hu.bme.mit.incqueryd.inventory.Inventory

sealed trait CoordinatorCommand
case object IsAlive extends CoordinatorCommand
case class LoadData(databaseUrl: String, vocabulary: Model, inventory: Inventory) extends CoordinatorCommand // XXX TODO make inventory serializable
case class StartQuery(recipe: ReteRecipe) extends CoordinatorCommand
case class CheckResults(pattern: PatternDescriptor) extends CoordinatorCommand
case class StopQuery(network: ReteNetwork) extends CoordinatorCommand