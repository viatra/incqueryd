package hu.bme.mit.incqueryd.rete.messages;

import java.io.Serializable;
import java.util.Map;

import akka.actor.ActorRef;

public class YellowPages implements Serializable {

	private static final long serialVersionUID = 1L;
	
	final Map<String, ActorRef> emfUriToActorRef;
	
	public YellowPages(final Map<String, ActorRef> emfUriToActorRef) {
		this.emfUriToActorRef = emfUriToActorRef;
	}
	
	public Map<String, ActorRef> getEmfUriToActorRef() {
		return emfUriToActorRef;
	}
	
}
