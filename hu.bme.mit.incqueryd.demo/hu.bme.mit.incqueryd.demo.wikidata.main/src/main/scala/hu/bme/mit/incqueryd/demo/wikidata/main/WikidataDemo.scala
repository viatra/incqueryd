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
    client.coordinator.startWikidataStream(databaseConnection)
    Runtime.getRuntime.addShutdownHook(new Thread() {
      override def run() {
        client.coordinator.stopWikidataStream()
        client.dispose()
      }
    })
    while(true) {}
  }

}
