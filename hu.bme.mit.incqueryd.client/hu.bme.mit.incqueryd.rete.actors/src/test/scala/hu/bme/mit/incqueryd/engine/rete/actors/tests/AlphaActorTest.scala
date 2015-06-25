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
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import eu.mondo.utils.NetworkUtils
import org.junit.Before
import org.junit.After
import scala.concurrent.Await

object AlphaActorTest {

  var system: ActorSystem = _

  @BeforeClass
  def setup() {
    system = AkkaUtils.getRemotingActorSystem(YarnActorService.actorSystemName, NetworkUtils.getLocalIpAddress, YarnActorService.port)
  }

  @AfterClass
  def teardown() {
    //Await.result(system.terminate(), AkkaUtils.defaultTimeout)
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
