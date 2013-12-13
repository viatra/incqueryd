package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.BetaNodeConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.BetaNode;

import org.apache.cassandra.transport.messages.ReadyMessage;

/**
 * 
 * @author szarnyasg
 *
 */
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

        this.primaryIndexer = new Indexer(configuration.getPrimaryMask());
        this.secondaryIndexer = new Indexer(configuration.getSecondaryMask());
        this.nextNodeSlot = configuration.getTargetNodeSlot();

        super.configure(configuration);
    }

    @Override
    public void onReceive(final Object message) throws Exception {
        super.onReceive(message);

        if (message instanceof UpdateMessage) {
            if (targetActor == null) {
                targetActor = getContext().actorFor(targetActorPath);
            }

            final UpdateMessage incomingUpdateMessage = (UpdateMessage) message;
            incomingUpdate(incomingUpdateMessage);
        }

        else if (message instanceof ReadyMessage) {
            logger.info(actorString() + " ReadyMessage received");
        }
    }

    protected void incomingUpdate(final UpdateMessage updateMessage) {        
        System.out.println("incoming update");
        
        final ChangeSet resultChangeSet = getBetaNode().update(updateMessage.getChangeSet(), updateMessage.getNodeSlot());
        final UpdateMessage propagatedUpdateMessage = new UpdateMessage(resultChangeSet, null);

//        final ChangeSet changeSet = updateMessage.getChangeSet();
//        final Set<Tuple> incomingTuples = changeSet.getTuples();
//        logger.info(incomingTuples.size() + " tuples received");
        //if (propagatedUpdateMessage != null) {        
        
        if (resultChangeSet.getTuples().isEmpty()) {
            // if there was nothing to send, we are immediately ready
            readyImmediately(updateMessage);
        } else {
            sendUpdateMessage(updateMessage.getSender(), propagatedUpdateMessage);
        }
    }

}
