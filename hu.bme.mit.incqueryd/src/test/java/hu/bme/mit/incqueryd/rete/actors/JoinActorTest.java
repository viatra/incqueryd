package hu.bme.mit.incqueryd.rete.actors;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.configuration.BetaNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.BetaNodeTestHelper;

import java.util.Stack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

/**
 * 
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

    public void test() {
        new JavaTestKit(system) {
            {
                // Arrange
                final Props props = new Props(JoinActor.class);
                final ActorRef betaActor = system.actorOf(props);

                final JavaTestKit probe = new JavaTestKit(system);
                final ActorRef targetActorRef = probe.getRef();
                
                final BetaNodeTestData data = BetaNodeTestHelper.data1();

                final ActorRef coordinator = getRef();
                final TupleMask primaryMask = data.getPrimaryMask();
                final TupleMask secondaryMask = data.getSecondaryMask();
                final String targetActorPath = "";
                final ReteNodeSlot targetNodeSlot = null;
                final BetaNodeConfiguration configuration = new BetaNodeConfiguration(coordinator, primaryMask,
                        secondaryMask, targetActorRef, targetNodeSlot);

                // Act
                betaActor.tell(configuration, getRef());
                // Assert
                expectMsgEquals(duration("1 second"), ActorMessage.INITIALIZED);

                // Act
                final Stack<ActorRef> senderStack1 = new Stack<>();
                senderStack1.add(getRef());
                final UpdateMessage primarySlotUpdateMessage = new UpdateMessage(data.getPrimaryChangeSet(), ReteNodeSlot.PRIMARY, senderStack1);
                betaActor.tell(primarySlotUpdateMessage, getRef());
                // Assert
                // we expect a ReadyMessage with an empty stack as the sender route
                final ReadyMessage readyMessage1 = expectMsgClass(duration("1 second"), ReadyMessage.class);
                assertEquals(new Stack<ActorRef>(), readyMessage1.getRoute());
                               
                // Act
                final Stack<ActorRef> senderStack2 = new Stack<>();
                senderStack2.add(getRef());
                final UpdateMessage secondarySlotUpdateMessage = new UpdateMessage(data.getSecondaryChangeSet(), ReteNodeSlot.SECONDARY, senderStack2);
                betaActor.tell(secondarySlotUpdateMessage, getRef());
                // Assert
                // we expect a ReadyMessage with an empty stack as the sender route
                final ReadyMessage readyMessage2 = expectMsgClass(duration("1 second"), ReadyMessage.class);
                assertEquals(new Stack<ActorRef>(), readyMessage2.getRoute());

//                final Serializable propagatedUpdateMessage = expectMsgClass(duration("1 second"), Serializable.class);
//                System.out.println(propagatedUpdateMessage);

                
                
                // Assert
//                final DummyMessage expectedMessage1 = expectMsgClass(duration("1 second"), UpdateMe.class);
//                System.out.println(expectedMessage1);

                // assertion
//                assertEquals(expectedMessage1.getX(), 2);


                
                
                // final ActorMessage actorMessage = expectMsgClass(duration("1 second"), ActorMessage.class);
                // System.out.println(actorMessage);
                // final UpdateMessage secondarySlotUpdateMessage = new UpdateMessage(data.getSecondaryChangeSet(),
                // ReteNodeSlot.SECONDARY);
                // betaActor.tell(secondarySlotUpdateMessage, getRef());
                //
                // final UpdateMessage expectedUpdateMessage = new UpdateMessage(data.getJoinExpectedResults(), null);
                //
                // System.out.println("changeset }}} " + expectedUpdateMessage.getChangeSet().getChangeType() + " "
                // + expectedUpdateMessage.getChangeSet().getTuples());
                // System.out.println("nodeslot  }}} " + expectedUpdateMessage.getNodeSlot());
                // System.out.println("sender    }}} " + expectedUpdateMessage.getSender());
                //
                // //
                //
                // final UpdateMessage out = new ExpectMsg<UpdateMessage>("match hint") {
                // // do not put code outside this method, will run afterwards
                // @Override
                // protected UpdateMessage match(final Object in) {
                // if (in instanceof UpdateMessage) {
                // return (UpdateMessage) in;
                // } else {
                // throw noMatch();
                // }
                // }
                // }.get(); // this extracts the received message
                // System.out.println(out + " //////////////////////");
                //
                // // assertEquals("match", out);
                //
                // //
                //
                // final UpdateMessage[] updateMessages = new ReceiveWhile<UpdateMessage>(UpdateMessage.class,
                // duration("1 second")) {
                //
                // @Override
                // protected UpdateMessage match(final Object msg) {
                // System.out.println("-----------------");
                // System.out.println(msg.getClass() + ": " + msg);
                // if (msg instanceof UpdateMessage) {
                // return (UpdateMessage) msg;
                // } else {
                // return null;
                // }
                // }
                // }.get();
                //
                // System.out.println("===================================");
                // System.out.println(updateMessages);
                // System.out.println("===================================");

                // expectMsgEquals(duration("3 second"), expectedUpdateMessage);

                // the run() method needs to finish within 3 seconds
                // new Within(duration("3 seconds")) {
                // @Override
                // protected void run() {
                //
                // betaActor.tell(configuration, getRef());
                // // betaActor.tell("hello", getRef());
                //
                // // This is a demo: would normally use expectMsgEquals().
                // // Wait time is bounded by 3-second deadline above.
                // new AwaitCond() {
                // @Override
                // protected boolean cond() {
                // return probe.msgAvailable();
                // }
                // };
                //
                // // response must have been enqueued to us before probe
                // expectMsgEquals(Duration.Zero(), "world");
                // // check that the probe we injected earlier got the msg
                // probe.expectMsgEquals(Duration.Zero(), "hello");
                // Assert.assertEquals(getRef(), probe.getLastSender());
                //
                // // Will wait for the rest of the 3 seconds
                // expectNoMsg();
                // }
                // };
            }
        };
    }

    @Test
    public void test1() {
        test();
    }

}