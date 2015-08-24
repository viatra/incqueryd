package hu.bme.mit.incqueryd.engine

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.Model
import hu.bme.mit.incqueryd.inventory.Inventory
import hu.bme.mit.incqueryd.engine.rete.nodes.TypeInputNode
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection

sealed trait CoordinatorCommand
case class LoadData(vocabulary: Model, databaseConnection: DatabaseConnection, rmHostname: String, fileSystemUri: String) extends CoordinatorCommand
case class StartQuery(recipeJson: String, rmHostname: String, fileSystemUri: String) extends CoordinatorCommand
case class CheckResults(recipeJson: String, patternName: String) extends CoordinatorCommand
case class StopQuery(recipeJson: String) extends CoordinatorCommand