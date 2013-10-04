package distributed.rete.configuration;

import akka.actor.ActorRef;

public class ReteNodeConfiguration extends IncQueryDConfiguration {

	private static final long serialVersionUID = 1L;

	public ReteNodeConfiguration(final ActorRef coordinator, final String targetActorPath) {
		super();
		this.coordinator = coordinator;
		this.targetActorPath = targetActorPath;
	}

	public ActorRef coordinator;
	public String targetActorPath;

}
