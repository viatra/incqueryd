package distributed.rete.configuration;

import java.io.Serializable;

import akka.actor.ActorRef;

public class ReteNodeConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;

	public ReteNodeConfiguration(ActorRef coordinator, String targetActorPath) {
		super();
		this.coordinator = coordinator;
		this.targetActorPath = targetActorPath;
	}

	public ActorRef coordinator;
	public String targetActorPath;

}
