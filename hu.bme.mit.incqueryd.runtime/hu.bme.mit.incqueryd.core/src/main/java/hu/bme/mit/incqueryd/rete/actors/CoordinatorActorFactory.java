package hu.bme.mit.incqueryd.rete.actors;

import akka.actor.Actor;
import akka.actor.UntypedActorFactory;

public class CoordinatorActorFactory implements UntypedActorFactory {

	private static final long serialVersionUID = 1L;
	private final String architectureFile;
	private final boolean remoting;

	public CoordinatorActorFactory(final String architectureFile, final boolean remoting) {
		this.architectureFile = architectureFile;
		this.remoting = remoting;
	}
	
	@Override
	public Actor create() throws Exception {
		return new CoordinatorActor(architectureFile, remoting);
	}

}
