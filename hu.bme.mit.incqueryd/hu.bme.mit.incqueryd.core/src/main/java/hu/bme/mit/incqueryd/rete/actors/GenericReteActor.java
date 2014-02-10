package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.ReteNodeConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import scala.collection.immutable.Stack;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class GenericReteActor extends UntypedActor {

	protected ReteNode reteNode;
	protected Map<ActorRef, ReteNodeSlot> subscribers = new HashMap<>();

	public GenericReteActor() {
		System.out.println("Trimmer node instantiated.");
	}

	@Override
	public void onReceive(final Object message) throws Exception {

		if (message == ActorMessage.SUBSCRIBE_SINGLE) {
			subscribeSender(ReteNodeSlot.SINGLE);
		} else if (message == ActorMessage.SUBSCRIBE_PRIMARY) {
			subscribeSender(ReteNodeSlot.PRIMARY);
		} else if (message == ActorMessage.SUBSCRIBE_SECONDARY) {
			subscribeSender(ReteNodeSlot.SECONDARY);
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

			// processing
			final AlphaNode alphaNode = (AlphaNode) reteNode;
			final ChangeSet changeSet = alphaNode.update(updateMessage.getChangeSet());
			sendToSubscribers(changeSet, updateMessage.getSenderStack());
		} else if (message instanceof ReadyMessage) {
			final ReadyMessage readyMessage = (ReadyMessage) message;
			final Stack<ActorRef> route = readyMessage.getRoute();
			final ActorRef readyMessageTarget = route.pop();

			final ReadyMessage propagatedReadyMessage = new ReadyMessage(route);
			readyMessageTarget.tell(propagatedReadyMessage, getSelf());
		}

	}

	protected void subscribeSender(final ReteNodeSlot slot) {
		final ActorRef sender = getSender();

		subscribers.put(sender, slot);
		sender.tell(ActorReply.SUBSCRIBED, getSelf());
		System.out.println("Subscribed: " + sender);
	}

	protected void sendToSubscribers(final ChangeSet changeSet, final Stack<ActorRef> senderStack) {
		for (final Entry<ActorRef, ReteNodeSlot> entry : subscribers.entrySet()) {
			final ActorRef subscriber = entry.getKey();
			final ReteNodeSlot slot = entry.getValue();

			senderStack.push(getSelf());
			final UpdateMessage updateMessage = new UpdateMessage(changeSet, slot, senderStack);
			subscriber.tell(updateMessage, getSelf());
		}
	}

}
