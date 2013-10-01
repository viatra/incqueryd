package distributed.rete.actors.messages;

import java.io.Serializable;
import java.util.Stack;

import akka.actor.ActorRef;

public class ReadyMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected Stack<ActorRef> route;
	
	public ReadyMessage(Stack<ActorRef> route) {
		super();
		this.route = route;
	}

	public Stack<ActorRef> getRoute() {
		return route;
	}
	
}
