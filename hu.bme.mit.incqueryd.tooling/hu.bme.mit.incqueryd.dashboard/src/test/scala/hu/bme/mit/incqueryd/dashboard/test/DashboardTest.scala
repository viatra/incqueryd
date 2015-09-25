package hu.bme.mit.incqueryd.dashboard.test

import org.junit.After
import org.junit.Before
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.spark.mqtt.MQTTPublisher
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils._

import org.junit.Test

class DashboardTest {

  val TEST_QUERY = "test"
  val TEST_PATTERN = "pattern"
  
  var resultSet: Set[Tuple] = Set[Tuple]()

  private def toTuples(set: Set[AnyRef]) = set.map(new Tuple(_))
  val resultSet1 = toTuples(Set("52", "138", "78", "391"))
  val resulSet2 = toTuples(Set("52", "78", "391"))

  @Before
  def startUp() {
    IncQueryDZooKeeper.createDir(s"${IncQueryDZooKeeper.runningQueries}/$TEST_QUERY/$TEST_PATTERN")
  }

  @Test
  def rutTest() {
    for (i <- 1 to 99) {
      val data = if (i % 2 == 0) resultSet1 else resulSet2
      MQTTPublisher.publishResults(createPatternId(TEST_PATTERN, TEST_QUERY), data)
      Thread.sleep(1000)
    }
  }

}