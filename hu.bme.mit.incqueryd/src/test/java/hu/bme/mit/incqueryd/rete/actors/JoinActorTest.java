package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.BetaNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.BetaNodeTestHelper;

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
//                final Props props = new Props(DummyActor.class);
//                final ActorRef actor = system.actorOf(props);
//
//                // telling message
//                actor.tell(new DummyMessage(1), getRef());
//
//                // expecting message
//                final DummyMessage expectedMessage1 = expectMsgClass(duration("1 second"), DummyMessage.class);
//                System.out.println(expectedMessage1);
//
//                // assertion
//                assertEquals(expectedMessage1.getX(), 2);                
        
                // // JoinNode: JoinNode1
                // final TupleMask join1LeftMask =
                // new TupleMask(new ArrayList<>(Arrays.asList(0)), null); // [Sp], Sw
                // final TupleMask join1RightMask =
                // new TupleMask(new ArrayList<>(Arrays.asList(1)), null); // R, [Sp]
                // final JoinNodeConfiguration joinNode1Configuration = new JoinNodeConfiguration(coordinator,
                // join1LeftMask,
                // join1RightMask, actors.get(joinNode2Name).actorRef.path().toString(), JoinSide.PRIMARY);
                // actors.get(joinNode1Name).configuration = joinNode1Configuration;
                //
                //
                //
                // final Props props = new Props(SomeActor.class);
                // final ActorRef subject = system.actorOf(props);

                final Props props = new Props(JoinActor.class);
                final ActorRef betaActor = system.actorOf(props);

                //final JavaTestKit probe = new JavaTestKit(system);

                final BetaNodeTestData data = BetaNodeTestHelper.data1();

                final ActorRef coordinator = getRef();
                final TupleMask primaryMask = data.getPrimaryMask();
                final TupleMask secondaryMask = data.getSecondaryMask();
                final String targetActorPath = "";
                final ReteNodeSlot targetNodeSlot = null;
                final BetaNodeConfiguration configuration = new BetaNodeConfiguration(coordinator, primaryMask,
                        secondaryMask, targetActorPath, targetNodeSlot);

                betaActor.tell(configuration, getRef());
                expectMsgEquals(duration("3 second"), ActorMessage.INITIALIZED);
                
//                final DummyMessage expectedMessage1 = expectMsgClass(duration("1 second"), DummyMessage.class);
                
                
                final ActorMessage actorMessage = expectMsgClass(duration("1 second"), ActorMessage.class);                
                System.out.println(actorMessage);
                

//                final UpdateMessage primarySlotUpdateMessage = new UpdateMessage(data.getPrimaryChangeSet(),
//                        ReteNodeSlot.PRIMARY);
//                primarySlotUpdateMessage.getSender().push(getRef());
//                betaActor.tell(primarySlotUpdateMessage, getRef());
//
//                System.out.println(getRef() + " :::");
//
//                final UpdateMessage secondarySlotUpdateMessage = new UpdateMessage(data.getSecondaryChangeSet(),
//                        ReteNodeSlot.SECONDARY);
//                betaActor.tell(secondarySlotUpdateMessage, getRef());
//
//                final UpdateMessage expectedUpdateMessage = new UpdateMessage(data.getJoinExpectedResults(), null);
//
//                System.out.println("changeset }}} " + expectedUpdateMessage.getChangeSet().getChangeType() + " "
//                        + expectedUpdateMessage.getChangeSet().getTuples());
//                System.out.println("nodeslot  }}} " + expectedUpdateMessage.getNodeSlot());
//                System.out.println("sender    }}} " + expectedUpdateMessage.getSender());
//
//                //
//
//                final UpdateMessage out = new ExpectMsg<UpdateMessage>("match hint") {
//                    // do not put code outside this method, will run afterwards
//                    @Override
//                    protected UpdateMessage match(final Object in) {
//                        if (in instanceof UpdateMessage) {
//                            return (UpdateMessage) in;
//                        } else {
//                            throw noMatch();
//                        }
//                    }
//                }.get(); // this extracts the received message
//                System.out.println(out + " //////////////////////");
//
//                // assertEquals("match", out);
//
//                //
//
//                final UpdateMessage[] updateMessages = new ReceiveWhile<UpdateMessage>(UpdateMessage.class,
//                        duration("1 second")) {
//
//                    @Override
//                    protected UpdateMessage match(final Object msg) {
//                        System.out.println("-----------------");
//                        System.out.println(msg.getClass() + ": " + msg);
//                        if (msg instanceof UpdateMessage) {
//                            return (UpdateMessage) msg;
//                        } else {
//                            return null;
//                        }
//                    }
//                }.get();
//
//                System.out.println("===================================");
//                System.out.println(updateMessages);
//                System.out.println("===================================");

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