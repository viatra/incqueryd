package hu.bme.mit.incqueryd.rete.actors.testkits;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.AlphaTestData;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;

import scala.Tuple2;
import scala.collection.immutable.Stack;
import scala.collection.immutable.Stack$;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

/** @formatter:off
 * 
 * Test plan
 * ---------
 * 
 *                                        
 *                          (primaryParent)      (secondaryParent)
 *                                 |                     |
 *                                 +-------+----------+
 *                                         |
 *                                   (5) V |  (9) V
 *                                   (8) ^ | (12) ^
 *                                         |
 *                                         V
 *  (coordinatorActor) <--------------> (betaActor)
 *                           (1) >            ^
 *                           (2) <            |
 *                                            | (3) ^   (6) V 
 *                                            | (4) V   (7) ^
 *                                            |
 *                                            V
 *                                      (targetActor) 
 * 
 * 
 *  (1) ! BetaRecipe
 *  (2) ? RECIPE_RECEIVED
 *  
 *  (3) ! SUBSCRIBE_SINGLE
 *  (4) ? SUBSCRIBED
 *  
 *  (5) ! UpdateMessage, stack: [secondaryParent] 
 *  (6) ? UpdateMessage, stack: [secondaryParent, betaActor]
 *  (7) ! ReadyMessage, stack: [secondaryParent]
 *  (8) ? ReadyMessage, stack: []
 * 
 *  (9) ! UpdateMessage, stack: [primaryParent] 
 * (10) ? UpdateMessage, stack: [primaryParent, betaActor]
 * (11) ! ReadyMessage, stack: [primaryParent]
 * (12) ? ReadyMessage, stack: []
 * 
 * Legend:
 *  - [!] sent by the test framework, [?] expected by the test framework
 *  - the stack is represented according to the immutable.Stack Scala class' toString() method: 
 *    the top item in the stack is the _first_ in the list (unlike the java.util.Stack class' toString()) 
 *
 */
public class BetaActorTestKit extends JavaTestKit {

	ActorRef betaActor;
	
	JavaTestKit coordinatorActor;
	JavaTestKit targetActor;
	
	JavaTestKit primaryParent;
	JavaTestKit secondaryParent;
	
	public BetaActorTestKit(final ActorSystem system, final BetaRecipe recipe) {
		super(system);

		// Arrange
		final Props props = new Props(ReteActor.class);
		betaActor = system.actorOf(props);

		// configuration
		// ====================================================================================================
		coordinatorActor = new JavaTestKit(system);
		targetActor = new JavaTestKit(system);
		
		primaryParent = new JavaTestKit(system);
		secondaryParent = new JavaTestKit(system);

		// Act
		// message (1)
		betaActor.tell(recipe, coordinatorActor.getRef());
		// Assert
		// message (2)
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.RECIPE_RECEIVED);

		// subscription
		// ====================================================================================================
		// Act
		// message (3)
		betaActor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
				
		// Assert
		// message (4)
		targetActor.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
	}
	
	public void compute(final AlphaTestData data) {
		// computation
		// ====================================================================================================
		// Act
		final Stack<ActorRef> message5Stack = Stack$.MODULE$.empty().push(getRef());
		final UpdateMessage updateMessage = new UpdateMessage(data.getIncomingChangeSet(), ReteNodeSlot.SINGLE, message5Stack);

		// message (5)
		betaActor.tell(updateMessage, getRef());

		// create the exptected senderStack
		final Stack<ActorRef> message6Stack = message5Stack.push(betaActor);

		// Assert
		// message (6)
		final UpdateMessage propagatedUpdateMessage = targetActor.expectMsgClass(duration("1 second"),
				UpdateMessage.class);
		assertEquals(data.getExpectedChangeSet(), propagatedUpdateMessage.getChangeSet());
		assertEquals(ReteNodeSlot.SINGLE, propagatedUpdateMessage.getNodeSlot());
		assertEquals(message6Stack, propagatedUpdateMessage.getSenderStack());

		// termination protocol
		// ====================================================================================================
		// Act
		final Stack<ActorRef> senderStack2 = propagatedUpdateMessage.getSenderStack();

		final Tuple2<ActorRef, Stack<ActorRef>> pair = senderStack2.pop2();
		final ActorRef terminationActorRef = pair._1();
		final Stack<ActorRef> terminationSenderStack = pair._2();

		final ReadyMessage readyMessage = new ReadyMessage(terminationSenderStack);
		// message (7)
		terminationActorRef.tell(readyMessage, targetActor.getRef());

		// we expect a ReadyMessage with an empty stack as the sender route
		final ReadyMessage expectedReadyMessage = new ReadyMessage(Stack$.MODULE$.empty());
		// message (8)
		final ReadyMessage readyMessage2 = expectMsgClass(duration("1 second"), ReadyMessage.class);

		assertEquals(expectedReadyMessage, readyMessage2);
		
		System.out.println("Test successful.");
	}

}
