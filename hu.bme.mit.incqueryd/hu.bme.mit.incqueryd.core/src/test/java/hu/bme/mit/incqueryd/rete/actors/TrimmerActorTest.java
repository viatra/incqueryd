package hu.bme.mit.incqueryd.rete.actors;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.TrimmerNodeTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import scala.Tuple2;
import scala.collection.immutable.Stack;
import scala.collection.immutable.Stack$;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link TrimmerActor} class.
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerActorTest {

	static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		system.shutdown();
	}

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		final File[] files = TestCaseFinder.getTestCases("" + "trimmernode-*.json");

		for (final File file : files) {
			System.out.println(file);
			final Gson gson = GsonParser.getGsonParser();
			final TrimmerNodeTestData data = gson.fromJson(new FileReader(file), TrimmerNodeTestData.class);

			trim(data);
		}
	}

	/** @formatter:off
	 *                                        (testKit)
	 *                                            ^
	 *                                            |
	 *                                            | (5) V
	 *                                            | (8) ^
	 *                                            |
	 *                                            |
	 *                                            V
	 *  (coordinatorActor) <--------------> (trimmerActor)
	 *                           (1) >            ^
	 *                           (2) <            |
	 *                                            | (3) ^
	 *                                            | (4) V
	 *                                            |
	 *                                            | (6) V  
	 *                                            | (7) ^
	 *                                            |
	 *                                            V
	 *                                       (targetActor) 
	 * 
	 * 
	 * (1) ! TrimmerNodeConfiguration
	 * (2) ? CONFIGURATION_RECEIVED
	 * (3) ! SUBSCRIBE_SINGLE
	 * (4) ? SUBSCRIBED
	 * (5) ! UpdateMessage, stack: [testKit] 
	 * (6) ? UpdateMessage, stack: [testKit, trimmerActor]
	 * (7) ! ReadyMessage, stack: [testKit]
	 * (8) ? ReadyMessage, stack: []
	 * 
	 * Legend:
	 *  - [!] sent by the test framework, [?] expected by the test framework
	 *  - the stack is represented according to the immutable.Stack Scala class' toString() method: 
	 *    the top item in the stack is the _first_ in the list (unlike the java.util.Stack class' toString()) 
	 * 
	 * @param data
	 */
	public void trim(final TrimmerNodeTestData data) {		
		new JavaTestKit(system) {
			{
				// Arrange
				final Props props = new Props(GenericReteActor.class);
				final ActorRef trimmerActor = system.actorOf(props);

				// configuration
				// ====================================================================================================
				final JavaTestKit coordinatorActor = new JavaTestKit(system);
				final JavaTestKit targetActor = new JavaTestKit(system);

				// Act
				final TupleMask projectionMask = data.getProjectionMask();
				final TrimmerNodeConfiguration conf = new TrimmerNodeConfiguration(projectionMask);
				// message (1)
				trimmerActor.tell(conf, coordinatorActor.getRef());
				// Assert
				// message (2)
				coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);

				// subscription
				// ====================================================================================================
				// Act
				// message (3)
				trimmerActor.tell(ActorMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
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
				final UpdateMessage propagatedUpdateMessage = targetActor.expectMsgClass(duration("1 second"), UpdateMessage.class);
				assertEquals(data.getExpectedResults(), propagatedUpdateMessage.getChangeSet());
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
		};
	}

}