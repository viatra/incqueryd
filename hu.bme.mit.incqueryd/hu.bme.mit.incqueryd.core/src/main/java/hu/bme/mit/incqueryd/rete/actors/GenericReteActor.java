package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.ReteNodeConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class GenericReteActor extends UntypedActor {

	protected ReteNode reteNode;
	protected Set<ActorRef> subscribers = new HashSet<>();

	public GenericReteActor() {
		System.out.println("Trimmer node instantiated.");
	}

	@Override
	public void onReceive(final Object message) throws Exception {

		if (message == ActorMessage.SUBSCRIBE_SINGLE) {
			subscribeSender();
		} else if (message instanceof ReteNodeConfiguration) {
			// ReteNodeConfigurations
			if (message instanceof TrimmerNodeConfiguration) {
				final TrimmerNodeConfiguration conf = (TrimmerNodeConfiguration) message;
				reteNode = new TrimmerNode(conf);
			} else if (message instanceof Object) { // more configuration coming...
				
			}
			
			getSender().tell(ActorReply.CONFIGURATION_RECEIVED, getSelf());
		} else if (message instanceof UpdateMessage) {
			final UpdateMessage updateMessage = (UpdateMessage) message;
			final AlphaNode alphaNode = (AlphaNode)reteNode;
			final ChangeSet changeSet = alphaNode.update(updateMessage.getChangeSet());
			final UpdateMessage propagatedUpdateMessage = new UpdateMessage(changeSet, null, null);
			sendToSubscribers(propagatedUpdateMessage);
		}

	}

	protected void subscribeSender() {
		final ActorRef sender = getSender();

		subscribers.add(sender);
		sender.tell(ActorReply.SUBSCRIBED, getSelf());
		System.out.println("Subscribed: " + sender);
	}
	
	protected void sendToSubscribers(final Serializable message) {
		for (final ActorRef subscriber : subscribers) {
			subscriber.tell(message, getSelf());
		}
	}


}
