/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.rete.actors.testkits;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.engine.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.engine.rete.messages.ReteCommunicationMessage;
import hu.bme.mit.incqueryd.engine.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.engine.rete.messages.TerminationMessage;
import hu.bme.mit.incqueryd.engine.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer;
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration;

import java.io.IOException;
import java.util.Collections;
import java.util.Stack;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

public abstract class ReteActorTestKit extends JavaTestKit {

	protected final ActorSystem system;

	protected final ActorRef reteActor;
	protected final JavaTestKit coordinatorActor;
	protected final JavaTestKit targetActor;
	protected final ReteNodeConfiguration conf;

	public ReteActorTestKit(final ActorSystem system, final String recipeFilename)
			throws IOException {
		super(system);
		this.system = system;

		final Props props = Props.create(ReteActor.class);
		reteActor = system.actorOf(props);

		coordinatorActor = new JavaTestKit(system);
		targetActor = new JavaTestKit(system);

		ReteNodeRecipe recipe = (ReteNodeRecipe) RecipeDeserializer.deserializeFromFile(recipeFilename);
		conf = new ReteNodeConfiguration(recipe, Collections.<String>emptyList());
	}

	// @formatter:off
	/**
	 * 
	 *  (coordinatorActor) <--------------> (reteActor)
     *                          (A) >
     *                          (B) <
     * 
     *  (A) ! ReteNodeConfiguration
     *  (B) ? CONFIGURATION_RECEIVED
	 */
	// @formatter:on
	public void configure(final JavaTestKit coordinatorActor, final ActorRef testedActor,
			final ReteNodeConfiguration conf) {
		// Act
		// message (A)
		testedActor.tell(conf, coordinatorActor.getRef());
		// Assert
		// message (B)
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);
	}

	// @formatter:off
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
	// @formatter:on
	public void subscribe(final JavaTestKit targetActor, final ActorRef testedActor) {
		// Act
		// message (A)
		testedActor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
		// Assert
		// message (B)
		targetActor.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
	}

	// @formatter:off
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
	// @formatter:on
	public void testComputation(final JavaTestKit parentActor, final ActorRef testedActor,
			final JavaTestKit targetActor, final ChangeSet incomingChangeSet, final ChangeSet expectedChangeSet,
			final ReteNodeSlot targetSlot) {
		// Act
		// message (A) !
		final Stack<ActorRef> messageAStack = new Stack<ActorRef>();
		messageAStack.push(parentActor.getRef());
		final UpdateMessage messageA = new UpdateMessage(incomingChangeSet, targetSlot, messageAStack);
		testedActor.tell(messageA, parentActor.getRef());

		// Assert
		// message (B) ?
		final Stack<ActorRef> messageBStack = (Stack<ActorRef>) messageAStack.clone();
		messageBStack.push(testedActor);
		final UpdateMessage expectedMessageB = new UpdateMessage(expectedChangeSet, ReteNodeSlot.SINGLE, messageBStack);
		final UpdateMessage actualMessageB = targetActor.expectMsgClass(duration("1 second"), UpdateMessage.class);

		// System.out.println("exp: " + expectedMessageB);
		// System.out.println("act: " + actualMessageB);

		assertEquals(expectedMessageB, actualMessageB);

		// termination protocol
		// Act
		// message (C) !
		//final Tuple2<ActorRef, Stack<ActorRef>> pair = actualMessageB.getRoute().pop();
		//final ActorRef terminationActorRef = pair._1();
		final ActorRef terminationActorRef = actualMessageB.getRoute().pop();
		//final Stack<ActorRef> messageCStack = pair._2();
		final Stack<ActorRef> messageCStack = (Stack<ActorRef>) actualMessageB.getRoute().clone(); 
		final ReteCommunicationMessage messageC = new TerminationMessage(messageCStack);
		terminationActorRef.tell(messageC, targetActor.getRef());

		// Assert
		// message (D) ?
		// we expect a ReadyMessage with an empty stack as the sender route
		final ReteCommunicationMessage expectedMessageD = new TerminationMessage(new Stack());
		final ReteCommunicationMessage actualMessageD = parentActor.expectMsgClass(duration("1 second"), ReteCommunicationMessage.class);
		assertEquals(expectedMessageD, actualMessageD);
	}

}
