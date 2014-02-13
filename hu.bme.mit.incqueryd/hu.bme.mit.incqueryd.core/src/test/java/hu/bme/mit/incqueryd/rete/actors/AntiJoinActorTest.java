//package hu.bme.mit.incqueryd.rete.actors;
//
//import static org.junit.Assert.assertEquals;
//import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
//import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
//import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
//import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
//import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
//import hu.bme.mit.incqueryd.test.util.GsonParser;
//import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import scala.collection.immutable.Stack;
//import akka.actor.ActorRef;
//import akka.actor.ActorSystem;
//import akka.actor.Props;
//import akka.testkit.JavaTestKit;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonIOException;
//import com.google.gson.JsonSyntaxException;
//
///**
// * Test cases for the {@link AntiJoinActor} class.
// * 
// * @author szarnyasg
// * 
// */
//public class AntiJoinActorTest {
//
//	static ActorSystem system;
//
//	@BeforeClass
//	public static void setup() {
//		system = ActorSystem.create();
//	}
//
//	@AfterClass
//	public static void teardown() {
//		system.shutdown();
//	}
//
//	@Test
//	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
//		final File[] files = TestCaseFinder.getTestCases("betanode-*.json");
//
//		for (final File file : files) {
//			System.out.println(file);
//			final Gson gson = GsonParser.getGsonParser();
//			final BetaNodeTestData data = gson.fromJson(new FileReader(file), BetaNodeTestData.class);
//			antijoin(data);
//		}
//	}
//
//	public void antijoin(final BetaNodeTestData data) {
//
//		System.out.println();
//		System.out.println();
//
//		new JavaTestKit(system) {
//			{
//				// Arrange
//				final Props props = new Props(AntiJoinActor.class);
//				final ActorRef betaActor = system.actorOf(props);
//
//				// create a probe to check the propagated UpdateMessage from the BetaNode
//				final JavaTestKit probe = new JavaTestKit(system);
//				final ActorRef targetActorRef = probe.getRef();
//
//				// the TestKit will serve as the coordinator
//				final ActorRef coordinator = getRef();
//				final TupleMask primaryMask = data.getPrimaryMask();
//				final TupleMask secondaryMask = data.getSecondaryMask();
//				final ReteNodeSlot targetNodeSlot = ReteNodeSlot.SINGLE;
//				final BetaActorConfiguration configuration = new BetaActorConfiguration(coordinator, targetActorRef,
//						targetNodeSlot, primaryMask, secondaryMask);
//
//				// Act
//				betaActor.tell(configuration, getRef());
//				// Assert
//				expectMsgEquals(duration("1 second"), ActorMessage.INITIALIZED);
//
//				// 1. sending the updates to the secondary input slot
//				// Act
//				final Stack<ActorRef> senderStack2 = Stack.empty().push(getRef());
//
//				final UpdateMessage secondarySlotUpdateMessage = new UpdateMessage(data.getSecondaryChangeSet(),
//						ReteNodeSlot.SECONDARY, senderStack2);
//				betaActor.tell(secondarySlotUpdateMessage, getRef());
//				// Assert
//				// we expect a ReadyMessage with an empty stack as the sender route
//				final ReadyMessage readyMessage1 = expectMsgClass(duration("1 second"), ReadyMessage.class);
//				assertEquals(new Stack<ActorRef>(), readyMessage1.getRoute());
//
//				// 2. sending the updates to the primary input slot
//				// Act
//				final Stack<ActorRef> senderStack1 = Stack.empty().push(getRef());
//				final UpdateMessage primarySlotUpdateMessage = new UpdateMessage(data.getPrimaryChangeSet(),
//						ReteNodeSlot.PRIMARY, senderStack1);
//				betaActor.tell(primarySlotUpdateMessage, getRef());
//				// Assert
//				if (data.getAntiJoinExpectedResults().getTuples().isEmpty()) {
//					// if the operation results in no tuples, we expect a ReadyMessage to the coordinator (the TestKit)
//					final ReadyMessage readyMessage2 = expectMsgClass(duration("1 second"), ReadyMessage.class);
//					assertEquals(new Stack<ActorRef>(), readyMessage2.getRoute());
//
//				} else {
//					// else we expect an UpdateMessage to the probe with the expected content defined by the
//					// BetaNodeTestData object
//					final UpdateMessage propagatedUpdateMessage = probe.expectMsgClass(duration("1 second"),
//							UpdateMessage.class);
//					assertEquals(data.getAntiJoinExpectedResults(), propagatedUpdateMessage.getChangeSet());
//				}
//
//			}
//		};
//	}
//
//}