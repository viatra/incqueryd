package hu.bme.mit.incqueryd.engine.rete.actors.tests

import hu.bme.mit.incqueryd.engine.rete.actors.testkits.AlphaActorTestKit
import hu.bme.mit.incqueryd.engine.rete.nodes.data.AlphaTestData
import hu.bme.mit.incqueryd.engine.test.util.GsonParser
import hu.bme.mit.incqueryd.engine.test.util.TestCaseFinder
import java.io.FileReader
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import akka.actor.ActorSystem
import com.google.gson.Gson
import AlphaActorTest._

object AlphaActorTest {

  protected var system: ActorSystem = _

  @BeforeClass
  def setup() {
    system = ActorSystem.create()
  }

  @AfterClass
  def teardown() {
    system.shutdown()
  }
}

class AlphaActorTest {

  private def alphaNodeTest(typeString: String) {
    val files = TestCaseFinder.getTestCases(typeString + "-test-*.json")
    for (testFile <- files) {
      val recipeFile = testFile.getPath.replace("-test-", "-recipe-")
      val gson = GsonParser.getGsonParser
      val data = gson.fromJson(new FileReader(testFile), classOf[AlphaTestData])
      val testKit = new AlphaActorTestKit(system, recipeFile)
      testKit.test(data)
    }
  }

  @Test
  def trimmerNodeTest() {
    alphaNodeTest("trimmer")
  }

  @Test
  def equalityNodeTest() {
    alphaNodeTest("equality")
  }

  @Test
  def inequalityNodeTest() {
    alphaNodeTest("inequality")
  }
}
