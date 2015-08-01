package hu.bme.mit.incqueryd.demo.dbpedia.fourstore

import org.junit.Assert._
import org.junit.Test

import eu.mondo.driver.fourstore.FourStoreGraphDriverReadWrite

class DBpediaLoaderTest {

  @Test
  def load() {
    val driver = new FourStoreGraphDriverReadWrite("dbpedia")
    driver.setShowCommandOutput(true)
    driver.start()
    DBpediaLoader.load(driver, "hu")
    try {
    	assertTrue(driver.countProperties("http://www.w3.org/2000/01/rdf-schema#label") > 0)
    } finally {
    	driver.stop()
    }
  }

}