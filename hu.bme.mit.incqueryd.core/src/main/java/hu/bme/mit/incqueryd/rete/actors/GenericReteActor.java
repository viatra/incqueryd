package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.TermEvaluatorActorConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerActorConfiguration;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;

import java.util.HashSet;
import java.util.Set;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class GenericReteActor extends UntypedActor {

	protected ReteNode reteNode;
	protected Set<ActorRef> subscribers = new HashSet<>();
	
	@Override
	public void onReceive(final Object message) throws Exception {

		if (message == ActorMessage.SUBSCRIBE) {
			subscribeSender();
		} else
		// ReteActorConfigurations
		if (message instanceof TrimmerActorConfiguration) {
			final TrimmerActorConfiguration conf = (TrimmerActorConfiguration) message;

			System.out.println("trimmer node");
			reteNode = new TrimmerNode(conf.getProjectionMask());
		} else if (message instanceof TermEvaluatorActorConfiguration) {

		}
	}

	protected void subscribeSender() {
		final ActorRef sender = getSender();

		System.out.println("subscribing: " + sender);
		subscribers.add(sender);
		
		System.out.println(subscribers);
		sender.tell(ActorReply.SUBSCRIBED, getSelf());
		System.out.println("ok");
	}

	public ReteNode getReteNode() {
		return reteNode;
	}

}
