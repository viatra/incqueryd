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

				// create probes to check the propagated
				final JavaTestKit probe1 = new JavaTestKit(system);
				final JavaTestKit probe2 = new JavaTestKit(system);

				// Act
				actor.tell(ActorMessage.SUBSCRIBE_SINGLE, probe1.getRef());
				// Assert
				probe1.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);

				// Act
				actor.tell(ActorMessage.SUBSCRIBE_SINGLE, probe2.getRef());
				// Assert
				probe2.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);				
			}
		};
	}

}
