package hu.bme.mit.incqueryd.engine.rete.actors.testkits

import scala.collection.JavaConversions.seqAsJavaList
import scala.collection.immutable.List
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.junit.Assert.assertEquals
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.testkit.JavaTestKit
import akka.testkit.JavaTestKit.duration
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.engine.rete.actors.ConfigurationFinished
import hu.bme.mit.incqueryd.engine.rete.actors.SubscriberRegistered
import hu.bme.mit.incqueryd.engine.rete.actors.RegisterSubscriber
import hu.bme.mit.incqueryd.engine.rete.actors.TerminationMessage
import hu.bme.mit.incqueryd.engine.rete.actors.UpdateMessage
import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration
import hu.bme.mit.incqueryd.engine.rete.actors.Configure
import hu.bme.mit.incqueryd.actorservice.AkkaUtils

abstract class ReteActorTestKit(protected val system: ActorSystem, recipeFilename: String) extends JavaTestKit(system) {

  val props = Props.create(classOf[ReteActor])

  protected val reteActor = system.actorOf(props)

  protected val coordinatorActor = new JavaTestKit(system)

  protected val targetActor = new JavaTestKit(system)

  val recipe = RecipeDeserializer.deserializeFromFile(recipeFilename).asInstanceOf[ReteNodeRecipe]

  protected val conf = new ReteNodeConfiguration(recipe)

  def configure(coordinatorActor: JavaTestKit, testedActor: ActorRef, conf: ReteNodeConfiguration) {
    testedActor.tell(Configure(conf), coordinatorActor.getRef)
    coordinatorActor.expectMsgEquals(duration("1 second"), ConfigurationFinished)
  }

  def subscribe(targetActor: JavaTestKit, testedActor: ActorRef) {
    testedActor.tell(RegisterSubscriber(ReteNodeSlot.SINGLE), targetActor.getRef)
    targetActor.expectMsgEquals(duration("1 second"), SubscriberRegistered)
  }

  def testComputation(parentActor: JavaTestKit, 
      testedActor: ActorRef, 
      targetActor: JavaTestKit, 
      incomingChangeSet: ChangeSet, 
      expectedChangeSet: ChangeSet, 
      targetSlot: ReteNodeSlot) {
    val messageAStack = List(AkkaUtils.toRemoteActorPath(parentActor.getRef))
    val messageA = UpdateMessage(incomingChangeSet, targetSlot, messageAStack)
    testedActor.tell(messageA, parentActor.getRef)
    val messageBStack = AkkaUtils.toRemoteActorPath(testedActor.path) :: messageAStack
    val expectedMessageB = UpdateMessage(expectedChangeSet, ReteNodeSlot.SINGLE, messageBStack)
    val actualMessageB = targetActor.expectMsgClass(duration("1 second"), classOf[UpdateMessage])
    assertEquals(expectedMessageB, actualMessageB)
    val terminationActorRef = actualMessageB.route.head
    val messageC = TerminationMessage(actualMessageB.route.drop(1))
    AkkaUtils.findActor(terminationActorRef).tell(messageC, targetActor.getRef)
    val expectedMessageD = TerminationMessage(List())
    val actualMessageD = parentActor.expectMsgClass(duration("1 second"), classOf[TerminationMessage])
    assertEquals(expectedMessageD, actualMessageD)
  }
}
