package distributed.rete.actors;

import java.util.Collection;

import akka.actor.ActorRef;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.actors.messages.UpdateType;
import distributed.rete.configuration.JoinNodeConfiguration;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.Tuple;
import distributed.rete.datastructure.TupleMask;

public abstract class AbstractJoinNode extends ReteActor {

	protected Indexer leftIndexer;
	protected Indexer rightIndexer;
	protected JoinSide nextJoinSide;

	@Override
	public void onReceive(Object message) throws Exception {
		super.onReceive(message);
		
		if (message instanceof JoinNodeConfiguration) {
			JoinNodeConfiguration c = (JoinNodeConfiguration) message;
			configure(c.leftMask, c.rightMask, c.targetActorPath, c.targetJoinSide, c.coordinator);
		}

		else if (message instanceof UpdateMessage) {
			if (targetActor == null) {
				targetActor = getContext().actorFor(targetActorPath);
			}

			UpdateMessage receivedJoinMessage = (UpdateMessage) message;
			UpdateType updateType = receivedJoinMessage.getUpdateType();
			Collection<Tuple> tuples = receivedJoinMessage.getTuples();

			System.out.println(tuples.size() + " tuples received");
			// for (Tuple tuple : tuples) { System.out.println(" - " + tuple); }

			sendTuples(receivedJoinMessage, updateType, tuples);
		}

		else {
			unhandledMessage(message);
		}
	}

	private void sendTuples(UpdateMessage receivedJoinMessage, UpdateType updateType, Collection<Tuple> tuples) {
		UpdateMessage propagatedUpdateMessage = joinNewTuples(tuples, receivedJoinMessage.getJoinSide(), updateType);

		if (propagatedUpdateMessage != null) {
			sendUpdateMessage(receivedJoinMessage.getSender(), propagatedUpdateMessage);
		} else {
			// if there was nothing to send, we are immediately ready
			readyImmediately(receivedJoinMessage);
		}
	}

	private void configure(TupleMask leftMask, TupleMask rightMask, String targetActorPath, JoinSide targetJoinSide, ActorRef coordinator) {
		this.leftIndexer = new Indexer(leftMask);
		this.rightIndexer = new Indexer(rightMask);
		this.targetActorPath = targetActorPath;
		this.nextJoinSide = targetJoinSide;

		System.out.println(actorString() + " telling INITIALIZED to " + coordinator);
		coordinator.tell(NodeMessage.INITIALIZED, getSelf());
	}

	protected abstract UpdateMessage joinNewTuples(Collection<Tuple> newTuples, JoinSide joinSide, UpdateType updateType);
	
}
