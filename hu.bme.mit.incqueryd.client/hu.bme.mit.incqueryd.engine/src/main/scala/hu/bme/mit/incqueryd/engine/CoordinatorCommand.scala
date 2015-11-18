package hu.bme.mit.incqueryd.engine

import org.openrdf.model.Model

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection

sealed trait CoordinatorCommand
case class DeployInputNodes(vocabulary: Model, recipeJson: String, databaseConnection: DatabaseConnection, rmHostname: String, fileSystemUri: String) extends CoordinatorCommand
case class LoadData(databaseConnection: DatabaseConnection) extends CoordinatorCommand
case class StartQuery(recipeJson: String, rdfiqContents: String, rmHostname: String, fileSystemUri: String) extends CoordinatorCommand
case class StartOutputStream(recipeJson: String) extends CoordinatorCommand
case object StopOutputStreams extends CoordinatorCommand
case class PropagateInputChanges(inputChanges : Map[String, ChangeSet]) extends CoordinatorCommand
case class CheckResults(recipeJson: String, patternName: String) extends CoordinatorCommand
case class StopQuery(recipeJson: String) extends CoordinatorCommand
case class UndeployInputNodes(recipeJson: String) extends CoordinatorCommand
// XXX move out of coordinator
case class StartWikidataStream(databaseConnection: DatabaseConnection) extends CoordinatorCommand
case object StopWikidataStream extends CoordinatorCommand
