package hu.bme.mit.incqueryd.engine.rete.actors.tests

import java.io.FileReader
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import BetaActorTest.system
import akka.actor.ActorSystem
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import hu.bme.mit.incqueryd.engine.rete.actors.testkits.BetaActorTestKit
import hu.bme.mit.incqueryd.engine.rete.nodes.data.BetaTestData
import hu.bme.mit.incqueryd.engine.test.util.GsonParser
import hu.bme.mit.incqueryd.engine.test.util.TestCaseFinder
import org.junit.Before
import org.junit.After
import scala.concurrent.Await

object BetaActorTest {

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
