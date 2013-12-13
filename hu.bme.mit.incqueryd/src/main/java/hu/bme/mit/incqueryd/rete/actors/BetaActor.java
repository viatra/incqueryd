package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.BetaNodeConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.messages.NodeMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateType;
import hu.bme.mit.incqueryd.rete.nodes.BetaNode;

import java.util.Set;

import org.apache.cassandra.transport.messages.ReadyMessage;

public abstract class BetaActor extends ReteActor {

    private BetaNode getBetaNode() {
        return (BetaNode) reteNode;
    }
    
    protected Indexer primaryIndexer;
    protected Indexer secondaryIndexer;
    protected ReteNodeSlot nextNodeSlot;

    public BetaActor() {
        super();        
    }

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {        
        final BetaNodeConfiguration configuration = (BetaNodeConfiguration) incQueryDConfiguration;
        
        super.configure(configuration);

        this.primaryIndexer = new Indexer(configuration.getPrimaryMask());
        this.secondaryIndexer = new Indexer(configuration.getSecondaryMask());
        this.nextNodeSlot = configuration.getTargetNodeSlot();

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

            final UpdateMessage incomingUpdateMessage = (UpdateMessage) message;
            final UpdateType updateType = incomingUpdateMessage.getUpdateType();
            final Set<Tuple> tuples = incomingUpdateMessage.getTuples();

            logger.info(tuples.size() + " tuples received");

            incomingUpdate(incomingUpdateMessage, updateType, tuples);
        }

        else if (message instanceof ReadyMessage) {
            logger.info(actorString() + " ReadyMessage received");
        }
    }

    private void incomingUpdate(final UpdateMessage incomingUpdateMessage, final UpdateType updateType,
            final Set<Tuple> tuples) {
        final UpdateMessage propagatedUpdateMessage = joinNewTuples(tuples, incomingUpdateMessage.getNodeSlot(),
                updateType);

        if (propagatedUpdateMessage != null) {
            sendUpdateMessage(incomingUpdateMessage.getSender(), propagatedUpdateMessage);
        } else {
            // if there was nothing to send, we are immediately ready
            readyImmediately(incomingUpdateMessage);
        }
    }
    
    protected UpdateMessage joinNewTuples(final Set<Tuple> newTuples, final ReteNodeSlot nodeSlot, final UpdateType updateType) {
        return null;
    }
}
