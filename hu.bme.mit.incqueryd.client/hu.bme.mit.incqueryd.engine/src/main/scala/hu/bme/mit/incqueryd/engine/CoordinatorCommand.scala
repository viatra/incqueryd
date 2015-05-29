package hu.bme.mit.incqueryd.engine

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.Model
import hu.bme.mit.incqueryd.inventory.Inventory

sealed trait CoordinatorCommand
case class LoadData(vocabulary: Model, hdfsPath: String, rmHostname: String, fileSystemUri: String, zkHostname: String) extends CoordinatorCommand
case class StartQuery(recipeJson: String, rmHostname: String, fileSystemUri: String, zkHostname: String) extends CoordinatorCommand
case class CheckResults(recipeJson: String, patternName: String, zkHostname: String) extends CoordinatorCommand
case class StopQuery(recipeJson: String, zkHostname: String) extends CoordinatorCommand