package hu.bme.mit.incqueryd.demo.wikidata.main

import hu.bme.mit.incqueryd.coordinator.client.IQDYarnClient
import hu.bme.mit.incqueryd.demo.wikidata.fourstore.WikidataLoader
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection.Backend
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import hu.bme.mit.incqueryd.spark.client.IQDSparkClient
import hu.bme.mit.incqueryd.spark.recievers.WikidataStreamReceiver
import hu.bme.mit.incqueryd.spark.utils.Delta

object WikidataStreamReceiverTest {

  def main(args: Array[String]) {
    val receiver = new WikidataStreamReceiver(WikidataDemo.databaseConnection) {
      override def store(deltas: Set[Delta]) {
      }
    }
    receiver.onStart()
  }

}
