package distributed.rete.actors.controllers;

import akka.actor.ActorRef;
import distributed.rete.configuration.ReteNodeConfiguration;

/**
 * Container for the actors of the Rete net.
 * 
 * @author szarnyasg
 * 
 */
public class ActorContainer {

	
	
	public ActorContainer(final boolean startSignal, final String host, final Class<?> actorClass) {
		super();
		this.startSignal = startSignal;
		this.host = host;
		this.actorClass = actorClass;
	}

	// TODO this looks like a struct in C...
	public boolean initialized;
	public boolean startSignal;
	public boolean todo;
	public final String host;
	public final Class<?> actorClass;
	public ReteNodeConfiguration configuration;
	public ActorRef actorRef;
	
	@Override
	public String toString() {
		return "ActorContainer [initialized=" + initialized + ", startSignal=" + startSignal + ", todo=" + todo + ", host=" + host + ", actorClass="
				+ actorClass + ", configuration=" + configuration + ", actorRef=" + actorRef + "]";
	}	
	
}
