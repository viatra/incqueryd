package hu.bme.mit.incqueryd.demo.wikidata.fourstore

import org.junit.Assert._
import org.junit.Test

import eu.mondo.driver.fourstore.FourStoreGraphDriverReadWrite

class WikidataLoaderTest {

  /** Configure and start 4store before running! */
  @Test
  def load() {
    val driver = new FourStoreGraphDriverReadWrite("wikidata")
    driver.setShowCommandOutput(true)
    driver.start()
    WikidataLoader.load(driver, "terms")
    try {
    	assertTrue(driver.countProperties("http://www.w3.org/2000/01/rdf-schema#label") > 0)
    } finally {
    	driver.stop()
    }
  }

}