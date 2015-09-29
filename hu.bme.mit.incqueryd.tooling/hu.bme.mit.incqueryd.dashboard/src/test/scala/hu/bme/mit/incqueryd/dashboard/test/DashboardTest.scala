package hu.bme.mit.incqueryd.dashboard.test

import org.junit.After
import org.junit.Before
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.spark.mqtt.MQTTPublisher
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils._

import org.junit.Test

class DashboardTest {

  val TEST_QUERY1 = "testQuery1"
  val TEST_QUERY2 = "testQuery2"
  
  val TEST_PATTERN11 = "pattern11"
  val TEST_PATTERN12 = "pattern12"
  
  val TEST_PATTERN21 = "pattern21"
  val TEST_PATTERN22 = "pattern22"
  
  val _52 = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#_52"
  val _138 = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#_138"
  val _78 = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#_78"
  val _391 = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#_391"
  
  var resultSet: Set[Tuple] = Set[Tuple]()

  private def toTuples(set: Set[AnyRef]) = set.map(new Tuple(_))
  val resultSet11 = toTuples(Set(_52, _138, _78))
  val resultSet12 = toTuples(Set(_52, _78))
  val resultSet21 = toTuples(Set(_391, _138, _78))
  val resultSet22 = toTuples(Set(_391, _78))
  
  @Before
  def startUp() {
    IncQueryDZooKeeper.createDir(s"${IncQueryDZooKeeper.runningQueries}/$TEST_QUERY1/$TEST_PATTERN11")
    IncQueryDZooKeeper.createDir(s"${IncQueryDZooKeeper.runningQueries}/$TEST_QUERY1/$TEST_PATTERN12")
    IncQueryDZooKeeper.createDir(s"${IncQueryDZooKeeper.runningQueries}/$TEST_QUERY2/$TEST_PATTERN21")
    IncQueryDZooKeeper.createDir(s"${IncQueryDZooKeeper.runningQueries}/$TEST_QUERY2/$TEST_PATTERN22")
  }

  @Test
  def runTest() {
    for (i <- 1 to 99) {
      MQTTPublisher.publishResults(createPatternId(TEST_PATTERN11, TEST_QUERY1), resultSet11)
      MQTTPublisher.publishResults(createPatternId(TEST_PATTERN12, TEST_QUERY1), resultSet12)
      MQTTPublisher.publishResults(createPatternId(TEST_PATTERN21, TEST_QUERY2), resultSet21)
      MQTTPublisher.publishResults(createPatternId(TEST_PATTERN22, TEST_QUERY2), resultSet22)
      Thread.sleep(1000)
    }
  }

}