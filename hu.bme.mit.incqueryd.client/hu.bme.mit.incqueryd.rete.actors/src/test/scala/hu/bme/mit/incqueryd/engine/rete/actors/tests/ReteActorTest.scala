package hu.bme.mit.incqueryd.engine.rete.actors.tests

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import akka.actor.ActorSystem
import akka.actor.Props
import akka.testkit.JavaTestKit
import akka.testkit.JavaTestKit.duration
import hu.bme.mit.incqueryd.engine.rete.actors.RegisterSubscriber
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor
import hu.bme.mit.incqueryd.engine.rete.actors.SubscriberRegistered
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import ReteActorTest._
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import org.junit.Before
import org.junit.After
import scala.concurrent.Await

object ReteActorTest {

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

class ReteActorTest {

  @Test
  def subscription() {
    new JavaTestKit(system) {

      val props = Props.create(classOf[ReteActor])

      val actor = system.actorOf(props)

      val probe1 = new JavaTestKit(system)

      val probe2 = new JavaTestKit(system)

      actor.tell(RegisterSubscriber(ReteNodeSlot.SINGLE), probe1.getRef)

      probe1.expectMsgEquals(duration("1 second"), SubscriberRegistered)

      actor.tell(RegisterSubscriber(ReteNodeSlot.SINGLE), probe2.getRef)

      probe2.expectMsgEquals(duration("1 second"), SubscriberRegistered)
    }
  }
}
