package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

public class GenericReteActorTest {

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
	public void test() {
		new JavaTestKit(system) {
			{
				// Arrange
				final Props props = new Props(GenericReteActor.class);
				final ActorRef actor = system.actorOf(props);

				// create a probe to check the propagated UpdateMessage from the EqualityNode
				final JavaTestKit probe1 = new JavaTestKit(system);
				final JavaTestKit probe2 = new JavaTestKit(system);
								
				actor.tell(ActorMessage.SUBSCRIBE, probe1.getRef());
				probe1.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
				
				actor.tell(ActorMessage.SUBSCRIBE, probe2.getRef());
				probe2.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
				
				// Act
//				actor.tell(configuration, getRef());
				// Assert
//				expectMsgEquals(duration("1 second"), ActorMessage.INITIALIZED);

//				// Act
//				final Stack<ActorRef> senderStack = new Stack<>();
//				senderStack.add(getRef());
//				final UpdateMessage updateMessage = new UpdateMessage(data.getChangeSet(), null, senderStack);
//				actor.tell(updateMessage, getRef());
//				// Assert
//				// we expect a ReadyMessage with an empty stack as the sender route
//				final UpdateMessage propagatedUpdateMessage = probe.expectMsgClass(duration("1 second"),
//						UpdateMessage.class);
//				assertEquals(data.getExpectedResults(), propagatedUpdateMessage.getChangeSet());
			}
		};
	}

}
