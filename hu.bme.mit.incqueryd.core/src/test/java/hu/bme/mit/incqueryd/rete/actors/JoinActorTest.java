package hu.bme.mit.incqueryd.rete.actors;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.configuration.BetaActorConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.BetaTestHelper;

import java.util.Stack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

/**
 * Test cases for the {@link JoinActor} class.
 * 
 * @author szarnyasg
 * 
 */
public class JoinActorTest {

    static ActorSystem system;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() {
        system.shutdown();
    }

    public void test(final BetaNodeTestData data) {
        new JavaTestKit(system) {
            {
                // Arrange
                final Props props = new Props(JoinActor.class);
                final ActorRef betaActor = system.actorOf(props);

                // create a probe to check the propagated UpdateMessage from the BetaNode
                final JavaTestKit probe = new JavaTestKit(system);
                final ActorRef targetActorRef = probe.getRef();

                final ActorRef coordinator = getRef();
                final TupleMask primaryMask = data.getPrimaryMask();
                final TupleMask secondaryMask = data.getSecondaryMask();
                final ReteNodeSlot targetNodeSlot = null;
                final BetaActorConfiguration configuration = new BetaActorConfiguration(coordinator, targetActorRef, targetNodeSlot, primaryMask,
                        secondaryMask);

                // Act
                betaActor.tell(configuration, getRef());
                // Assert
                expectMsgEquals(duration("1 second"), ActorMessage.INITIALIZED);

                // Act
                final Stack<ActorRef> senderStack1 = new Stack<>();
                senderStack1.add(getRef());
                final UpdateMessage primarySlotUpdateMessage = new UpdateMessage(data.getPrimaryChangeSet(),
                        ReteNodeSlot.PRIMARY, senderStack1);
                betaActor.tell(primarySlotUpdateMessage, getRef());
                // Assert
                // we expect a ReadyMessage with an empty stack as the sender route
                final ReadyMessage readyMessage1 = expectMsgClass(duration("1 second"), ReadyMessage.class);
                assertEquals(new Stack<ActorRef>(), readyMessage1.getRoute());

                // Act
                final Stack<ActorRef> senderStack2 = new Stack<>();
                senderStack2.add(getRef());
                final UpdateMessage secondarySlotUpdateMessage = new UpdateMessage(data.getSecondaryChangeSet(),
                        ReteNodeSlot.SECONDARY, senderStack2);
                betaActor.tell(secondarySlotUpdateMessage, getRef());
                // Assert
                // we expect an UpdateMessage to the probe with the expected content defined by the BetaNodeTestData
                // object
                final UpdateMessage propagatedUpdateMessage = probe.expectMsgClass(duration("1 second"),
                        UpdateMessage.class);
                assertEquals(data.getJoinExpectedResults(), propagatedUpdateMessage.getChangeSet());
            }
        };
    }

    @Test
    public void test1() {
        test(BetaTestHelper.data1());
    }

    @Test
    public void test2() {
        test(BetaTestHelper.data2());
    }

    @Test
    public void test3() {
        test(BetaTestHelper.data3());
    }

}