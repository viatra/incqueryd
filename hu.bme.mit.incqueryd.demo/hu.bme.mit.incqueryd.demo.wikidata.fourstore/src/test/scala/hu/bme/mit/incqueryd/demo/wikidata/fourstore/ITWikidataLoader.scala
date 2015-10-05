package hu.bme.mit.incqueryd.demo.wikidata.fourstore

import org.junit.Assert._
import org.junit.Test

import eu.mondo.driver.fourstore.FourStoreGraphDriverRead

class ITWikidataLoader {

  /** Start 4store before running! */
  @Test
  def load() {
    println("Setting up database")
    FourstoreUtils.setup(WikidataLoader.defaultDatabaseName)
    val driver = new FourStoreGraphDriverRead(WikidataLoader.defaultDatabaseName)
    driver.setShowCommandOutput(true)
    println("Loading dump")
    WikidataLoader.load(driver, "property-taxonomy")
    try {
    	assertTrue(driver.countProperties("http://www.w3.org/1999/02/22-rdf-syntax-ns#type") > 0)
    } finally {
      println("Destroying database")
    	FourstoreUtils.destroy(WikidataLoader.defaultDatabaseName)
    }
  }

}