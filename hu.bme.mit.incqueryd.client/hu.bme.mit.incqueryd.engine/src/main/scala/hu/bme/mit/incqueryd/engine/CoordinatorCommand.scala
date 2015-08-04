package hu.bme.mit.incqueryd.engine

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.openrdf.model.Model
import hu.bme.mit.incqueryd.inventory.Inventory
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet

sealed trait CoordinatorCommand
case class LoadData(vocabulary: Model, hdfsPath: String, rmHostname: String, fileSystemUri: String) extends CoordinatorCommand
case class StartQuery(recipeJson: String, rmHostname: String, fileSystemUri: String) extends CoordinatorCommand
case class PropagateInputChanges(inputChanges : Map[String, ChangeSet]) extends CoordinatorCommand
case class CheckResults(recipeJson: String, patternName: String) extends CoordinatorCommand
case class StopQuery(recipeJson: String) extends CoordinatorCommand
case class Dispose() extends CoordinatorCommand