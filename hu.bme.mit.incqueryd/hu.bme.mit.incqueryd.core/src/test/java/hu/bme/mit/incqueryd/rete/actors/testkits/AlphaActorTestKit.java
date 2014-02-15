package hu.bme.mit.incqueryd.rete.actors.testkits;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.AlphaTestData;
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
 *                                     (parentActor)
 *                                            ^
 *                                            |
 *                                            | (5) V
 *                                            | (8) ^
 *                                            |
 *                                            |
 *                                            V
 *  (coordinatorActor) <--------------> (alphaActor)
 *                           (1) >            ^
 *                           (2) <            |
 *                                            | (3) ^
 *                                            | (4) V
 *                                            |
 *                                            | (6) V  
 *                                            | (7) ^
 *                                            |
 *                                            V
 *                                     (targetActor) 
 * 
 * 
 * (1) ! AlphaRecipe
 * (2) ? RECIPE_RECEIVED
 * 
 * (3) ! SUBSCRIBE_SINGLE
 * (4) ? SUBSCRIBED
 * 
 * (5) ! UpdateMessage, stack: [testKit] 
 * (6) ? UpdateMessage, stack: [testKit, alphaActor]
 * (7) ! ReadyMessage, stack: [testKit]
 * (8) ? ReadyMessage, stack: []
 * 
 * Legend:
 *  - [!] sent by the test framework, [?] expected by the test framework
 *  - the stack is represented according to the immutable.Stack Scala class' toString() method: 
 *    the top item in the stack is the _first_ in the list (unlike the java.util.Stack class' toString()) 
 *
 */
public class AlphaActorTestKit extends JavaTestKit {

	ActorRef alphaActor;
	JavaTestKit coordinatorActor;
	JavaTestKit parentActor;
	JavaTestKit targetActor;
	
	public AlphaActorTestKit(final ActorSystem system, final ReteNodeType type, final String recipeFile) throws IOException {
		super(system);

		// Arrange
		final Props props = new Props(ReteActor.class);
		alphaActor = system.actorOf(props);

		// configuration
		// ====================================================================================================
		parentActor = new JavaTestKit(system);
		coordinatorActor = new JavaTestKit(system);
		targetActor = new JavaTestKit(system);

		final String jsonRecipe = FileUtils.readFileToString(new File(recipeFile));
		final ReteNodeConfiguration conf = new ReteNodeConfiguration(type, jsonRecipe);
		
		// Act
		// message (1)		
		alphaActor.tell(conf, coordinatorActor.getRef());
		// Assert
		// message (2)
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONF_RECEIVED);

		// subscription
		// ====================================================================================================
		// Act
		// message (3)
		alphaActor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
		// Assert
		// message (4)
		targetActor.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
	}
	
	public void compute(final AlphaTestData data) {
		// computation
		// ====================================================================================================
		// Act
		final Stack<ActorRef> message5Stack = Stack$.MODULE$.empty().push(parentActor.getRef());
		final UpdateMessage updateMessage = new UpdateMessage(data.getIncomingChangeSet(), ReteNodeSlot.SINGLE, message5Stack);

		// message (5)
		alphaActor.tell(updateMessage, parentActor.getRef());

		// create the exptected senderStack
		final Stack<ActorRef> message6Stack = message5Stack.push(alphaActor);

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
		final ReadyMessage readyMessage2 = parentActor.expectMsgClass(duration("1 second"), ReadyMessage.class);

		assertEquals(expectedReadyMessage, readyMessage2);
		
		System.out.println("Test successful.");
	}

}
