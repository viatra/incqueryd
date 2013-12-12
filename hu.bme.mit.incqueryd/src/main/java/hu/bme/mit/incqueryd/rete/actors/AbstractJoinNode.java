package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.JoinNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.messages.NodeMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateType;

import java.util.Collection;

import org.apache.cassandra.transport.messages.ReadyMessage;

public abstract class AbstractJoinNode extends ReteActor {

    protected Indexer leftIndexer;
    protected Indexer rightIndexer;
    protected ReteNodeSlot nextJoinSide;

    public AbstractJoinNode() {
        super();
    }

    @Override
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

    private void sendTuples(final UpdateMessage receivedJoinMessage, final UpdateType updateType,
            final Collection<Tuple> tuples) {
        final UpdateMessage propagatedUpdateMessage = joinNewTuples(tuples, receivedJoinMessage.getJoinSide(),
                updateType);

        if (propagatedUpdateMessage != null) {
            sendUpdateMessage(receivedJoinMessage.getSender(), propagatedUpdateMessage);
        } else {
            // if there was nothing to send, we are immediately ready
            readyImmediately(receivedJoinMessage);
        }
    }

    protected abstract UpdateMessage joinNewTuples(Collection<Tuple> newTuples, ReteNodeSlot joinSide, UpdateType updateType);

}
