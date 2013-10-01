package distributed.rete.actors;

import java.util.Collection;

import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.ReadyMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.actors.messages.UpdateType;
import distributed.rete.configuration.JoinNodeConfiguration;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.Tuple;

public abstract class AbstractJoinNode extends ReteActor {

	protected Indexer leftIndexer;
	protected Indexer rightIndexer;
	protected JoinSide nextJoinSide;

	public AbstractJoinNode() {
		super();
	}

	protected void configure(JoinNodeConfiguration configuration) {
		this.leftIndexer = new Indexer(configuration.leftMask);
		this.rightIndexer = new Indexer(configuration.rightMask);
		this.targetActorPath = configuration.targetActorPath;
		this.nextJoinSide = configuration.targetJoinSide;
		this.coordinator = configuration.coordinator;

		logger.info(actorString() + " telling INITIALIZED to " + coordinator);
		coordinator.tell(NodeMessage.INITIALIZED, getSelf());
	}

	@Override
	public void onReceive(Object message) throws Exception {
		super.onReceive(message);

		if (message instanceof UpdateMessage) {
			if (targetActor == null) {
				targetActor = getContext().actorFor(targetActorPath);
			}

			UpdateMessage receivedJoinMessage = (UpdateMessage) message;
			UpdateType updateType = receivedJoinMessage.getUpdateType();
			Collection<Tuple> tuples = receivedJoinMessage.getTuples();

			logger.info(tuples.size() + " tuples received");
			// for (Tuple tuple : tuples) { logger.info(" - " + tuple); }

			sendTuples(receivedJoinMessage, updateType, tuples);
		}

		else if (message instanceof ReadyMessage) {
			logger.info(actorString() + " ReadyMessage received");
		}

		else if (message instanceof JoinNodeConfiguration) {
			JoinNodeConfiguration configuration = (JoinNodeConfiguration) message;
			configure(configuration);
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

	protected abstract UpdateMessage joinNewTuples(Collection<Tuple> newTuples, JoinSide joinSide, UpdateType updateType);

}
