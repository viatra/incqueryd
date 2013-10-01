package distributed.rete.actors.messages;


import java.io.Serializable;
import java.util.Collection;
import java.util.Stack;

import akka.actor.ActorRef;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.Tuple;

public class UpdateMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected UpdateType updateType;
	protected JoinSide joinSide;
	protected Collection<Tuple> tuples;
	protected Stack<ActorRef> sender = new Stack<>();
	
	public UpdateMessage(UpdateType updateType, JoinSide joinSide, Collection<Tuple> tuples) {
		this.updateType = updateType;
		this.joinSide = joinSide;
		this.tuples = tuples;
	}
	
	public UpdateType getUpdateType() {
		return updateType;
	}
	
	public JoinSide getJoinSide() {
		return joinSide;
	}
	
	public Collection<Tuple> getTuples() {
		return tuples;
	}

	public Stack<ActorRef> getSender() {
		return sender;
	}

	public void setSender(Stack<ActorRef> sender) {
		this.sender = sender;
	}
	
}
