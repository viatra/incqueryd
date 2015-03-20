package hu.bme.mit.incqueryd.engine.rete.actors.tests

import java.io.FileReader

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

import akka.actor.ActorSystem
import hu.bme.mit.incqueryd.engine.rete.actors.testkits.BetaActorTestKit
import hu.bme.mit.incqueryd.engine.rete.nodes.data.BetaTestData
import hu.bme.mit.incqueryd.engine.test.util.GsonParser
import hu.bme.mit.incqueryd.engine.test.util.TestCaseFinder
import BetaActorTest._

object BetaActorTest {

  var system: ActorSystem = _

  @BeforeClass
  def setup() {
    system = ActorSystem.create()
  }

  @AfterClass
  def teardown() {
    system.shutdown()
  }
}

class BetaActorTest {

  private def betaNodeTest(typeString: String) {
    val fileNamePrefix = typeString + "-test-"
    val files = TestCaseFinder.getTestCases(fileNamePrefix + "*.json")
    for (testFile <- files) {
      val recipeFile = testFile.getPath.replace(fileNamePrefix, typeString + "-recipe-")
      val gson = GsonParser.getGsonParser
      val data = gson.fromJson(new FileReader(testFile), classOf[BetaTestData])
      val testKit = new BetaActorTestKit(system, recipeFile)
      testKit.test(data)
    }
  }

  @Test
  def joinNodeTest() {
    betaNodeTest("join")
  }

  @Test
  def antiJoinNodeTest() {
    betaNodeTest("antijoin")
  }
}
