package hu.bme.mit.incqueryd.rete.messages;

import scala.collection.immutable.Stack;
import akka.actor.ActorRef;

public class TerminationMessage extends ReteCommunicationMessage {

	private static final long serialVersionUID = 1L;

	public TerminationMessage(final Stack<ActorRef> route) {
		super(route);
	}

}
