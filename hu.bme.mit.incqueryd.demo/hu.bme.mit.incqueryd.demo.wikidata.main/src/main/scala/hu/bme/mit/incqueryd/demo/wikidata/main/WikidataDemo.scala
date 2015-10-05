package hu.bme.mit.incqueryd.demo.wikidata.main

import hu.bme.mit.incqueryd.coordinator.client.IQDYarnClient
import hu.bme.mit.incqueryd.demo.wikidata.fourstore.WikidataLoader
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import hu.bme.mit.incqueryd.spark.client.IQDSparkClient
import com.google.common.io.Resources
import com.google.common.base.Charsets

object WikidataDemo {

	val endpoint = "https://query.wikidata.org/bigdata/namespace/wdq/sparql?format=json&query="
  val databaseConnection = new DatabaseConnection(endpoint, Backend.SPARQL)
  val vocabularyFilename = "wikidata-demo-vocabulary.nt"
  val rdfiqFilename = "wikidata.rdfiq"
  val recipeFilename = s"recipes/$rdfiqFilename.recipe"
  val patternName = "highestPoint"

  def main(args: Array[String]){
    println("Loading metamodel")
    val metamodel = IQDYarnClient.loadMetamodel(Resources.getResource(vocabularyFilename))
    println("Initializing IQD YARN client")
    val client = new IQDYarnClient
    client.deployInputNodes(metamodel, databaseConnection)
    val recipe = RecipeUtils.loadRecipe(recipeFilename)
    client.startQuery(recipe, Resources.toString(Resources.getResource(rdfiqFilename), Charsets.UTF_8))
    client.coordinator.loadData(databaseConnection)
    val results = client.checkResults(recipe, patternName)
    println(s"Initial results of $patternName:\n$results")
    println("Starting Wikidata stream processor")
    client.coordinator.startWikidataStream(databaseConnection)
    println("Press Enter to quit!")
    System.in.read()
    println("Stopping Wikidata stream processor")
    client.coordinator.stopWikidataStream()
    println("Disposing IQD")
    client.dispose()
  }

}
