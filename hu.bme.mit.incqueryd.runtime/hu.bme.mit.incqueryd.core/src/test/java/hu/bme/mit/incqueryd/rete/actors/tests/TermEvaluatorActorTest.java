package hu.bme.mit.incqueryd.rete.actors.tests;
//package hu.bme.mit.incqueryd.rete.actors;
//
//import static org.junit.Assert.assertEquals;
//import hu.bme.mit.incqueryd.rete.comparison.ConditionExpression;
//import hu.bme.mit.incqueryd.rete.configuration.TermEvaluatorActorConfiguration;
//import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
//import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
//import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
//import hu.bme.mit.incqueryd.rete.nodes.data.TermEvaluatorNodeTestData;
//import hu.bme.mit.incqueryd.test.util.GsonParser;
//import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Collection;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
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
// * Test cases for the {@link TermEvaluatorActor} class.
// * @author szarnyasg
// *
// */
//public class TermEvaluatorActorTest {
//    static ActorSystem system;
//
//    @BeforeClass
//    public static void setup() {
//        system = ActorSystem.create();
//    }
//
//    @AfterClass
//    public static void teardown() {
//        system.shutdown();
//    }
//    
//	@Test
//	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
//		File[] files = TestCaseFinder.getTestCases("termevaluatornode-*.json");
//
//		for (File file : files) {
//			System.err.println(file);
//			Gson gson = GsonParser.getGsonParser();
//			TermEvaluatorNodeTestData data = gson.fromJson(new FileReader(file), TermEvaluatorNodeTestData.class);
//			
//			evaluate(data);
//		}
//	}
//	
//    public void evaluate(final TermEvaluatorNodeTestData data) {
//        new JavaTestKit(system) {
//            {
//                // Arrange
//                final Props props = new Props(TermEvaluatorActor.class);
//                final ActorRef filterActor = system.actorOf(props);
//
//                // create a probe to check the propagated UpdateMessage from the EqualityNode
//                final JavaTestKit probe = new JavaTestKit(system);
//                final ActorRef targetActorRef = probe.getRef();
//
//                final ActorRef coordinator = getRef();
//                final Collection<ConditionExpression> conditionExpressions = data.getConditionExpressions();
//                final ReteNodeSlot targetNodeSlot = null;
//                final TermEvaluatorActorConfiguration configuration = new TermEvaluatorActorConfiguration(coordinator,
//                        targetActorRef, targetNodeSlot, conditionExpressions);
//
//                // Act
//                filterActor.tell(configuration, getRef());
//                // Assert
//                expectMsgEquals(duration("1 second"), ActorMessage.INITIALIZED);
//
//                // Act
//                final Stack<ActorRef> senderStack = new Stack<>();
//                senderStack.add(getRef());
//                final UpdateMessage updateMessage = new UpdateMessage(data.getChangeSet(), null, senderStack);
//                filterActor.tell(updateMessage, getRef());
//                // Assert
//                // we expect a ReadyMessage with an empty stack as the sender route
//                final UpdateMessage propagatedUpdateMessage = probe.expectMsgClass(duration("1 second"),
//                        UpdateMessage.class);
//                assertEquals(data.getExpectedResults(), propagatedUpdateMessage.getChangeSet());
//            }
//        };
//    }
//}
