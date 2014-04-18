package distributed.rete.configuration;

import akka.actor.ActorRef;
import distributed.rete.database.DatabaseClientType;
import distributed.rete.datastructure.JoinSide;

public class UniquenessEnforcerNodeConfiguration extends ReteNodeConfiguration {

	public UniquenessEnforcerNodeConfiguration(final ActorRef coordinator, final String targetActorPath, final String edgeLabel, final JoinSide targetJoinSide,
			final DatabaseClientType databaseClientType, final String filename) {
		super(coordinator, targetActorPath);

		this.edgeLabel = edgeLabel;
		this.targetJoinSide = targetJoinSide;
		this.databaseClientType = databaseClientType;
		this.filename = filename;
	}

	protected static final long serialVersionUID = 1L;

	public final String edgeLabel;
	public final JoinSide targetJoinSide;
	public final DatabaseClientType databaseClientType;
	public final String filename;
}
