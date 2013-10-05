package distributed.rete.actors;

import java.util.Collection;

import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.ReadyMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.actors.messages.UpdateType;
import distributed.rete.configuration.IncQueryDConfiguration;
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

	protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
		final JoinNodeConfiguration configuration = (JoinNodeConfiguration) incQueryDConfiguration;
		
		this.leftIndexer = new Indexer(configuration.leftMask);
		this.rightIndexer = new Indexer(configuration.rightMask);
		this.targetActorPath = configuration.targetActorPath;
		this.nextJoinSide = configuration.targetJoinSide;
		this.coordinator = configuration.coordinator;

		logger.info(actorString() + " telling INITIALIZED to " + coordinator);
		coordinator.tell(NodeMessage.INITIALIZED, getSelf());
	}

	@Override
	public void onReceive(final Object message) throws Exception {
		super.onReceive(message);

		if (message instanceof UpdateMessage) {
			if (targetActor == null) {
				targetActor = getContext().actorFor(targetActorPath);
			}

			final UpdateMessage receivedJoinMessage = (UpdateMessage) message;
			final UpdateType updateType = receivedJoinMessage.getUpdateType();
			final Collection<Tuple> tuples = receivedJoinMessage.getTuples();

			logger.info(tuples.size() + " tuples received");

			sendTuples(receivedJoinMessage, updateType, tuples);
		}

		else if (message instanceof ReadyMessage) {
			logger.info(actorString() + " ReadyMessage received");
		}
	}

	private void sendTuples(final UpdateMessage receivedJoinMessage, final UpdateType updateType, final Collection<Tuple> tuples) {
		final UpdateMessage propagatedUpdateMessage = joinNewTuples(tuples, receivedJoinMessage.getJoinSide(), updateType);

		if (propagatedUpdateMessage != null) {
			sendUpdateMessage(receivedJoinMessage.getSender(), propagatedUpdateMessage);
		} else {
			// if there was nothing to send, we are immediately ready
			readyImmediately(receivedJoinMessage);
		}
	}

	protected abstract UpdateMessage joinNewTuples(Collection<Tuple> newTuples, JoinSide joinSide, UpdateType updateType);

}
