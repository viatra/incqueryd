//package hu.bme.mit.incqueryd.rete.actors;
//
//import static org.junit.Assert.assertEquals;
//import hu.bme.mit.incqueryd.rete.configuration.FilterActorConfiguration;
//import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
//import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
//import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
//import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
//import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;
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
// * Test cases for the {@link EqualityActor} class.
// * 
// * @author szarnyasg
// * 
// */
//public class EqualityActorTest {
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
//		final File[] files = TestCaseFinder.getTestCases("filternode-*.json");
//
//		for (final File file : files) {
//			System.out.println(file);
//			final Gson gson = GsonParser.getGsonParser();
//			final FilterNodeTestData data = gson.fromJson(new FileReader(file), FilterNodeTestData.class);
//			filterEquality(data);
//		}
//	}
//
//	public void filterEquality(final FilterNodeTestData data) {
//		new JavaTestKit(system) {
//			{
//				// Arrange
//				final Props props = new Props(EqualityActor.class);
//				final ActorRef filterActor = system.actorOf(props);
//
//				// create a probe to check the propagated UpdateMessage from the EqualityNode
//				final JavaTestKit probe = new JavaTestKit(system);
//				final ActorRef targetActorRef = probe.getRef();
//
//				final ActorRef coordinator = getRef();
//				final TupleMask mask = data.getTupleMask();
//				final ReteNodeSlot targetNodeSlot = ReteNodeSlot.SINGLE;
//				final FilterActorConfiguration configuration = new FilterActorConfiguration(coordinator,
//						targetActorRef, targetNodeSlot, mask);
//
//				// Act
//				filterActor.tell(configuration, getRef());
//				// Assert
//				expectMsgEquals(duration("1 second"), ActorMessage.INITIALIZED);
//
//				// Act				
//				final Stack<ActorRef> senderStack = Stack.empty().push(getRef());
//				
//				final UpdateMessage updateMessage = new UpdateMessage(data.getChangeSet(), ReteNodeSlot.SINGLE, senderStack);
//				filterActor.tell(updateMessage, getRef());
//				// Assert
//				// we expect a ReadyMessage with an empty stack as the sender route
//				final UpdateMessage propagatedUpdateMessage = probe.expectMsgClass(duration("1 second"),
//						UpdateMessage.class);
//				assertEquals(data.getEqualityExpectedResults(), propagatedUpdateMessage.getChangeSet());
//			}
//		};
//	}
//
//}
