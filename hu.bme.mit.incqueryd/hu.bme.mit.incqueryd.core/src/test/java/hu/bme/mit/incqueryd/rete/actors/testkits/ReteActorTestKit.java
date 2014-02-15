package hu.bme.mit.incqueryd.rete.actors.testkits;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;
import scala.Tuple2;
import scala.collection.immutable.Stack;
import scala.collection.immutable.Stack$;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.JavaTestKit;

public class ReteActorTestKit extends JavaTestKit {

	public ReteActorTestKit(final ActorSystem system) {
		super(system);
	}

	/**
	 *  (coordinatorActor) <--------------> (betaActor)
     *                          (A) >
     *                          (B) <
     * 
     *  (A) ! ReteNodeConfiguration
     *  (B) ? CONFIGURATION_RECEIVED
	 */
	public void configure(final JavaTestKit coordinatorActor, final ActorRef testedActor, final ReteNodeConfiguration conf) {
		// Act
		// message (A)
		testedActor.tell(conf, coordinatorActor.getRef());
		// Assert
		// message (B)
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);
	}
	
	/**
	 *   (testedActor)
	 *         ^
	 *         |
	 *         | (A) ^
	 *         | (B) V
	 *         |
	 *         V
	 *   (targetActor) 
	 * 
	 *  (A) ! SUBSCRIBE_SINGLE
	 *  (B) ? SUBSCRIBED
	 */
	public void subscribe(final JavaTestKit targetActor, final ActorRef testedActor) {
		// Act
		// message (A)
		testedActor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
		// Assert
		// message (B)
		targetActor.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
	}
	
	/**
	 *   (parentActor)
	 *         ^
	 *         |
	 *         |  (A) V
	 *         |  (D) ^
	 *         |
	 *         V
	 *   (testedActor)
	 *         ^
	 *         |
	 *         |  (B) V
	 *         |  (C) ^
	 *         |
	 *         V
	 *   (targetActor) 
	 *     
	 *  (A) ! UpdateMessage, stack: [parentActor] 
	 *  (B) ? UpdateMessage, stack: [parentActor, testedActor]
	 *  (C) ! ReadyMessage, stack: [parentActor]
	 *  (D) ? ReadyMessage, stack: []
	 */	
	public void testComputation(final JavaTestKit parentActor, final ActorRef testedActor, final JavaTestKit targetActor,
			final ChangeSet incomingChangeSet, final ChangeSet expectedChangeSet) {
		// Act
		// message (A) !
		final Stack<ActorRef> messageAStack = Stack$.MODULE$.empty().push(parentActor.getRef());
		final UpdateMessage messageA = new UpdateMessage(incomingChangeSet, ReteNodeSlot.SINGLE, messageAStack);
		testedActor.tell(messageA, parentActor.getRef());

		// Assert
		// message (B) ?
		final Stack<ActorRef> messageBStack = messageAStack.push(testedActor);
		final UpdateMessage expectedMessageB = new UpdateMessage(expectedChangeSet, ReteNodeSlot.SINGLE, messageBStack);
		final UpdateMessage actualMessageB = targetActor.expectMsgClass(duration("1 second"),
				UpdateMessage.class);
		
		assertEquals(expectedMessageB, actualMessageB);

		// termination protocol
		// Act
		// message (C) !
		final Tuple2<ActorRef, Stack<ActorRef>> pair = actualMessageB.getSenderStack().pop2();
		final ActorRef terminationActorRef = pair._1();
		final Stack<ActorRef> messageCStack = pair._2();		
		final ReadyMessage messageC = new ReadyMessage(messageCStack);
		terminationActorRef.tell(messageC, targetActor.getRef());
		
		// Assert
		// message (D) ?
		// we expect a ReadyMessage with an empty stack as the sender route
		final ReadyMessage expectedMessageD = new ReadyMessage(Stack$.MODULE$.empty());
		final ReadyMessage actualMessageD = parentActor.expectMsgClass(duration("1 second"), ReadyMessage.class);
		assertEquals(expectedMessageD, actualMessageD);
	}

}
