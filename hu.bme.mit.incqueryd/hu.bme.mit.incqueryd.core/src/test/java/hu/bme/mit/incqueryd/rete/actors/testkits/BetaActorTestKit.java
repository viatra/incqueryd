package hu.bme.mit.incqueryd.rete.actors.testkits;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaTestData;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;
import hu.bme.mit.incqueryd.util.ReteNodeType;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

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
 *                       (primaryParentActor)  (secondaryParentActor)
 *                                 |                    |
 *                                 +-------+   +--------+
 *                                         |   | 
 *                                   (5) V |   |  (9) V
 *                                   (8) ^ |   | (12) ^
 *                                         |   |
 *                                         V   V
 *  (coordinatorActor) <--------------> (betaActor)
 *                           (1) >           ^
 *                           (2) <           |
 *                                           | (3) ^   (6) V   (10) V
 *                                           | (4) V   (7) ^   (11) ^
 *                                           |
 *                                           V
 *                                      (targetActor) 
 * 
 * 
 *  (1) ! ReteNodeConfiguration
 *  (2) ? CONFIGURATION_RECEIVED
 *  
 *  (3) ! SUBSCRIBE_SINGLE
 *  (4) ? SUBSCRIBED
 *  
 *  (5) ! UpdateMessage, stack: [secondaryParentActor] 
 *  (6) ? UpdateMessage, stack: [secondaryParentActor, betaActor]
 *  (7) ! ReadyMessage, stack: [secondaryParentActor]
 *  (8) ? ReadyMessage, stack: []
 * 
 *  (9) ! UpdateMessage, stack: [primaryParentActor] 
 * (10) ? UpdateMessage, stack: [primaryParentActor, betaActor]
 * (11) ! ReadyMessage, stack: [primaryParentActor]
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
	
	JavaTestKit primaryParentActor;
	JavaTestKit secondaryParentActor;
	
	public BetaActorTestKit(final ActorSystem system, final ReteNodeType type, final String recipeFile) throws IOException {
		super(system);

		// Arrange
		final Props props = new Props(ReteActor.class);
		betaActor = system.actorOf(props);

		// configuration
		// ====================================================================================================
		coordinatorActor = new JavaTestKit(system);
		targetActor = new JavaTestKit(system);
		
		primaryParentActor = new JavaTestKit(system);
		secondaryParentActor = new JavaTestKit(system);

		final String jsonRecipe = FileUtils.readFileToString(new File(recipeFile));
		final ReteNodeConfiguration conf = new ReteNodeConfiguration(type, jsonRecipe);
		
		// Act
		// message (1)
		betaActor.tell(conf, coordinatorActor.getRef());
		// Assert
		// message (2)
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);

		// subscription
		// ====================================================================================================
		// Act
		// message (3)
		betaActor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
				
		// Assert
		// message (4)
		targetActor.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
	}
	
	public void compute(final BetaTestData data) {
		// computation
		// ====================================================================================================
		// Act
		final Stack<ActorRef> message5Stack = Stack$.MODULE$.empty().push(getRef());
		final UpdateMessage primaryUpdateMessage = new UpdateMessage(data.getPrimaryChangeSet(), ReteNodeSlot.SINGLE, message5Stack);
		
		final UpdateMessage secondaryUpdateMessage = new UpdateMessage(data.getSecondaryChangeSet(), ReteNodeSlot.SINGLE, message5Stack);

		// message (5)
		betaActor.tell(primaryUpdateMessage, getRef());

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
