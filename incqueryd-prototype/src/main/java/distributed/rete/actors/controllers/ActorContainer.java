package distributed.rete.actors.controllers;

import akka.actor.ActorRef;

/**
 * Container for the actors of the Rete net.
 * @author szarnyasg
 *
 */
public class ActorContainer {
	
	public ActorContainer(boolean startSignal) {
		this.startSignal = startSignal;
	}
	
	// TODO this looks like a struct in C...	
	public ActorRef actorRef;
	public boolean initialized;
	public boolean startSignal;
	public boolean todo;
	
}
