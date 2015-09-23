package hu.bme.mit.incqueryd.demo.wikidata.main

import hu.bme.mit.incqueryd.coordinator.client.IQDYarnClient
import hu.bme.mit.incqueryd.demo.wikidata.fourstore.FourstoreUtils
import hu.bme.mit.incqueryd.demo.wikidata.fourstore.WikidataLoader
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import hu.bme.mit.incqueryd.spark.client.IQDSparkClient

object WikidataDemo {

  val vocabularyFilename = "wikidata-demo-vocabulary.nt"
  val recipeFilename = "recipes/wikidata.rdfiq.recipe"

  def main(args: Array[String]){
    println("Initializing IQD YARN client")
    val client = new IQDYarnClient
    println("Loading metamodel")
    val metamodel = client.loadMetamodel(getClass.getClassLoader.getResource(vocabularyFilename))
    println("Loading initial data")
    val databaseConnection = new DatabaseConnection("https://query.wikidata.org/bigdata/namespace/wdq/sparql?format=json&query=", Backend.SPARQL)
    client.loadInitialData(metamodel, databaseConnection)
    println("Starting query")
    val recipe = RecipeUtils.loadRecipe(recipeFilename)
    client.startQuery(recipe)
    println("Starting Wikidata stream processor")
    IQDSparkClient.startWikidataStreaming(databaseConnection)
    println("Press Enter to quit!")
    System.in.read()
    println("Stopping Wikidata stream processor")
    IQDSparkClient.stopWikidataStreaming()
    println("Disposing IQD")
    client.dispose()
  }

}
