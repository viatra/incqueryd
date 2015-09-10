package hu.bme.mit.incqueryd.demo.wikidata.main

import eu.mondo.driver.fourstore.FourStoreGraphDriverReadWrite
import hu.bme.mit.incqueryd.coordinator.client.IQDYarnClient
import hu.bme.mit.incqueryd.demo.wikidata.fourstore.FourstoreUtils
import hu.bme.mit.incqueryd.demo.wikidata.fourstore.WikidataLoader
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend

object WikidataDemo {

  val vocabularyFilename = "wikidata-property-taxonomy.nt"
	val driver = new FourStoreGraphDriverReadWrite(WikidataLoader.defaultDatabaseName)
  val recipeFilename = "recipes/wikidata.rdfiq.recipe"

  def main(args: Array[String]) {
    println("Do you want to setup 4store database and load Wikidata dump (y = yes)?")
    if (System.console.readLine == "y") {
      println("Setting up 4store database")
      FourstoreUtils.setup(WikidataLoader.defaultDatabaseName)
      println("Loading Wikidata dump")
    	WikidataLoader.load(driver, "simple-statements")
    }
    println("Initializing IQD YARN client")
    val client = new IQDYarnClient
    println("Loading metamodel")
    val metamodel = client.loadMetamodel(getClass.getClassLoader.getResource(vocabularyFilename))
    println("Loading initial data")
    client.loadInitialData(metamodel, new DatabaseConnection(WikidataLoader.defaultDatabaseName, Backend.FOURSTORE))
    println("Starting query")
    val recipe = RecipeUtils.loadRecipe(recipeFilename)
    client.startQuery(recipe)
    println("Press Enter to quit!")
    System.in.read()
    println("Disposing IQD")
    client.dispose()
  }

}
