package hu.bme.mit.incqueryd.rete.actors;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.TrimmerNodeTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Stack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
		final File[] files = TestCaseFinder.getTestCases("trimmernode-*.json");

		for (final File file : files) {
			System.out.println(file);
			final Gson gson = GsonParser.getGsonParser();
			final TrimmerNodeTestData data = gson.fromJson(new FileReader(file), TrimmerNodeTestData.class);

			trim(data);
		}
	}

	public void trim(final TrimmerNodeTestData data) {
		new JavaTestKit(system) {
			{
				// Arrange
				final Props props = new Props(GenericReteActor.class);
				final ActorRef trimmerActor = system.actorOf(props);

				final JavaTestKit coordinatorActor = new JavaTestKit(system);
				final JavaTestKit targetActor = new JavaTestKit(system);

				// Act
				final TupleMask projectionMask = data.getProjectionMask();
				final TrimmerNodeConfiguration conf = new TrimmerNodeConfiguration(projectionMask);
				trimmerActor.tell(conf, coordinatorActor.getRef());
				// Assert
				coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);

				// Act
				trimmerActor.tell(ActorMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
				// Assert
				targetActor.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);

				// Act
				final Stack<ActorRef> senderStack = new Stack<>();
				senderStack.add(getRef());
				final UpdateMessage updateMessage = new UpdateMessage(data.getChangeSet(), null, senderStack);
				// send an update message from the testkit
				trimmerActor.tell(updateMessage, getRef());
				
				// Assert
				// we expect a ReadyMessage with an empty stack as the sender route
				final UpdateMessage propagatedUpdateMessage = targetActor.expectMsgClass(duration("1 second"),
						UpdateMessage.class);
				assertEquals(data.getExpectedResults(), propagatedUpdateMessage.getChangeSet());
			}
		};
	}

}