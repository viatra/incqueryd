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
package hu.bme.mit.incqueryd.engine.rete.actors.tests;

import hu.bme.mit.incqueryd.engine.rete.actors.IncQueryDMicrokernel;
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.engine.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.engine.rete.messages.SubscriptionMessage;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.remote.RemoteScope;
import akka.testkit.JavaTestKit;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class RemoteReteActorExample {

	public static void main(final String[] args) {
		final Config config = ConfigFactory.parseString("akka.actor.provider = akka.remote.RemoteActorRefProvider");
		final ActorSystem system = ActorSystem.create("test", config);
		new JavaTestKit(system) {
			{
				// Arrange
				final Props props = new Props(ReteActor.class).withDeploy(new Deploy(new RemoteScope(new Address(
						"akka", IncQueryDMicrokernel.ACTOR_SYSTEM_NAME, System.getenv("remoteHost"), 2552))));
				final ActorRef actor = system.actorOf(props);

				// create probes to check the propagated
				final JavaTestKit probe1 = new JavaTestKit(system);
				final JavaTestKit probe2 = new JavaTestKit(system);

				System.out.println(actor);
				
				// Act
				actor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, probe1.getRef());
				// Assert
				probe1.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);

				// Act
				actor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, probe2.getRef());
				// Assert
				probe2.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
			}
		};
		system.shutdown();
	}

}
