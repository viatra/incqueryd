package hu.bme.mit.incqueryd.core.rete.messages;

import java.io.Serializable;

import scala.collection.immutable.Stack;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 * 
 */
public abstract class ReteCommunicationMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	protected Stack<ActorRef> route;

	public ReteCommunicationMessage(final Stack<ActorRef> route) {
		super();
		this.route = route;
	}

	public Stack<ActorRef> getRoute() {
		return route;
	}

	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof ReteCommunicationMessage))
			return false;
		final ReteCommunicationMessage readyMessage = (ReteCommunicationMessage) o;
		
		return route.equals(readyMessage.getRoute());
	}
}
