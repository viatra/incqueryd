package hu.bme.mit.incqueryd.rete.actors;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerActorConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
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
		File[] files = TestCaseFinder.getTestCases("trimmernode-*.json");

		for (File file : files) {
			System.out.println(file);
			Gson gson = GsonParser.getGsonParser();
			TrimmerNodeTestData data = gson.fromJson(new FileReader(file), TrimmerNodeTestData.class);
			
			trim(data);
		}
	}
    
    public void trim(final TrimmerNodeTestData data) {
        new JavaTestKit(system) {
            {
                // Arrange
                final Props props = new Props(TrimmerActor.class);
                final ActorRef filterActor = system.actorOf(props);

                // create a probe to check the propagated UpdateMessage from the EqualityNode
                final JavaTestKit probe = new JavaTestKit(system);
                final ActorRef targetActorRef = probe.getRef();

                final ActorRef coordinator = getRef();
                final TupleMask projectionMask = data.getProjectionMask();
                final ReteNodeSlot targetNodeSlot = null;
                final TrimmerActorConfiguration configuration = new TrimmerActorConfiguration(coordinator,
                        targetActorRef, targetNodeSlot, projectionMask);

                // Act
                filterActor.tell(configuration, getRef());
                // Assert
                expectMsgEquals(duration("1 second"), ActorMessage.INITIALIZED);

                // Act
                final Stack<ActorRef> senderStack = new Stack<>();
                senderStack.add(getRef());
                final UpdateMessage updateMessage = new UpdateMessage(data.getChangeSet(), null, senderStack);
                filterActor.tell(updateMessage, getRef());
                // Assert
                // we expect a ReadyMessage with an empty stack as the sender route
                final UpdateMessage propagatedUpdateMessage = probe.expectMsgClass(duration("1 second"),
                        UpdateMessage.class);
                assertEquals(data.getExpectedResults(), propagatedUpdateMessage.getChangeSet());
            }
        };
    }

}