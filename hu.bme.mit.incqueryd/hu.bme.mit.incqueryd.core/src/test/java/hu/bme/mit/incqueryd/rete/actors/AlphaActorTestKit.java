package hu.bme.mit.incqueryd.rete.actors;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;

import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;

import scala.Tuple2;
import scala.collection.immutable.Stack;
import scala.collection.immutable.Stack$;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

public class AlphaActorTestKit extends JavaTestKit {

	// public AlphaActorTestKit(final ActorSystem system, final TrimmerNodeTestData data) {
	public AlphaActorTestKit(final ActorSystem system, final FilterNodeTestData data) {
		super(system);

		// Arrange
		final Props props = new Props(ReteActor.class);
		final ActorRef trimmerActor = system.actorOf(props);

		// configuration
		// ====================================================================================================
		final JavaTestKit coordinatorActor = new JavaTestKit(system);
		final JavaTestKit targetActor = new JavaTestKit(system);

		// Act
		// final TupleMask projectionMask = data.getProjectionMask();
		// final TrimmerRecipe recipe = RecipesFactory.eINSTANCE.createTrimmerRecipe();
		// final Mask mask = RecipesFactory.eINSTANCE.createMask();
		// mask.getSourceIndices().addAll(projectionMask.getMask());
		// recipe.setMask(mask);

		// final EqualityFilterRecipe recipe = RecipesFactory.eINSTANCE.createEqualityFilterRecipe();
		// recipe.getIndices().addAll(data.getTupleMask().getMask());

		final InequalityFilterRecipe recipe = RecipesFactory.eINSTANCE.createInequalityFilterRecipe();
		
		// set the subject
		recipe.setSubject(data.getTupleMask().getMask().get(0));		
		// remove the head
		data.getTupleMask().getMask().remove(0);
		// get tha tail as inequals
		recipe.getInequals().addAll(data.getTupleMask().getMask());

		// message (1)
		trimmerActor.tell(recipe, coordinatorActor.getRef());
		// Assert
		// message (2)
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);

		// subscription
		// ====================================================================================================
		// Act
		// message (3)
		trimmerActor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
		// Assert
		// message (4)
		targetActor.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);

		// computation
		// ====================================================================================================
		// Act
		final Stack<ActorRef> message5Stack = Stack$.MODULE$.empty().push(getRef());
		final UpdateMessage updateMessage = new UpdateMessage(data.getChangeSet(), ReteNodeSlot.SINGLE, message5Stack);

		// message (5)
		trimmerActor.tell(updateMessage, getRef());

		// create the exptected senderStack
		final Stack<ActorRef> message6Stack = message5Stack.push(trimmerActor);

		// Assert
		// message (6)
		final UpdateMessage propagatedUpdateMessage = targetActor.expectMsgClass(duration("1 second"),
				UpdateMessage.class);
		// assertEquals(data.getExpectedResults(), propagatedUpdateMessage.getChangeSet());
		// assertEquals(data.getEqualityExpectedResults(), propagatedUpdateMessage.getChangeSet());
		assertEquals(data.getInequalityExpectedResults(), propagatedUpdateMessage.getChangeSet());

		assertEquals(ReteNodeSlot.SINGLE, propagatedUpdateMessage.getNodeSlot());
		assertEquals(message6Stack, propagatedUpdateMessage.getSenderStack());

		// termination protocol
		// ====================================================================================================
		// Act
		final Stack<ActorRef> senderStack2 = propagatedUpdateMessage.getSenderStack();

		final Tuple2<ActorRef, Stack<ActorRef>> pair = senderStack2.pop2();
		final ActorRef terminationTrimmerActorRef = pair._1();
		final Stack<ActorRef> terminationSenderStack = pair._2();

		final ReadyMessage readyMessage = new ReadyMessage(terminationSenderStack);
		// message (7)
		terminationTrimmerActorRef.tell(readyMessage, targetActor.getRef());

		// we expect a ReadyMessage with an empty stack as the sender route
		final ReadyMessage expectedReadyMessage = new ReadyMessage(Stack$.MODULE$.empty());
		// message (8)
		final ReadyMessage readyMessage2 = expectMsgClass(duration("1 second"), ReadyMessage.class);

		assertEquals(expectedReadyMessage, readyMessage2);
	}

}
