package hu.bme.mit.incqueryd.rete.actors;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.UntypedActorFactory;

public class HttpCoordinatorActorFactory implements UntypedActorFactory {

	private static final long serialVersionUID = 1L;

	private ActorRef coordinatorActorRef;

	public HttpCoordinatorActorFactory(ActorRef coordinatorActorRef) {
		this.coordinatorActorRef = coordinatorActorRef;
	}

	@Override
	public Actor create() throws Exception {
		return new HttpCoordinatorActor(coordinatorActorRef);
	}

}
