package distributed.rete.configuration;

import distributed.rete.datastructure.JoinSide;
import akka.actor.ActorRef;

public class UniquenessEnforcerNodeConfiguration extends ReteNodeConfiguration {

	public UniquenessEnforcerNodeConfiguration(ActorRef coordinator, String targetActorPath, String query,
			String[] columns, JoinSide targetJoinSide) {
		super(coordinator, targetActorPath);
		
		this.query = query;
		this.columns = columns;
		this.targetJoinSide = targetJoinSide;
	}

	private static final long serialVersionUID = 1L;

	public String query;
	public String[] columns;
	public JoinSide targetJoinSide;
	public int modelSize;

}
