package hu.bme.mit.incqueryd.rete.actors;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.configuration.FilterActorConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.FilterTestHelper;

import java.util.Stack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

/**
 * Test cases for the {@link InequalityActor} class.
 * 
 * @author szarnyasg
 * 
 */
public class InequalityActorTest {

    static ActorSystem system;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() {
        system.shutdown();
    }

    public void test(final FilterNodeTestData data) {
        new JavaTestKit(system) {
            {
                // Arrange
                final Props props = new Props(InequalityActor.class);
                final ActorRef filterActor = system.actorOf(props);

                // create a probe to check the propagated UpdateMessage from the InequalityNode
                final JavaTestKit probe = new JavaTestKit(system);
                final ActorRef targetActorRef = probe.getRef();

                final ActorRef coordinator = getRef();
                final TupleMask mask = data.getTupleMask();
                final ReteNodeSlot targetNodeSlot = null;
                final FilterActorConfiguration configuration = new FilterActorConfiguration(coordinator,
                        targetActorRef, targetNodeSlot, mask);

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
                assertEquals(data.getInequalityExpectedResults(), propagatedUpdateMessage.getChangeSet());
            }
        };
    }

    @Test
    public void test1() {
        test(FilterTestHelper.data1());
    }

}
