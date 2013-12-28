package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;

import org.apache.cassandra.transport.messages.ReadyMessage;

/**
 * 
 * @author szarnyasg
 * 
 */
public abstract class AlphaActor extends ReteActor {

    private AlphaNode getAlphaNode() {
        return (AlphaNode) reteNode;
    }

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        super.configure(incQueryDConfiguration);
    }

    @Override
    public void onReceive(final Object message) throws Exception {
        super.onReceive(message);

        if (message instanceof UpdateMessage) {
            final UpdateMessage incomingUpdateMessage = (UpdateMessage) message;
            incomingUpdate(incomingUpdateMessage);
        }

        else if (message instanceof ReadyMessage) {
            logger.info(actorString() + " ReadyMessage received");
        }
    }

    protected void incomingUpdate(final UpdateMessage updateMessage) {
        final ChangeSet resultChangeSet = getAlphaNode().update(updateMessage.getChangeSet());

        if (resultChangeSet.getTuples().isEmpty()) {
            // if there was nothing to send, we are immediately ready
            readyImmediately(updateMessage);
        } else {
            // if there is something to send, we send it to the approriate actor
            final UpdateMessage propagatedUpdateMessage = new UpdateMessage(resultChangeSet, null,
                    updateMessage.getSenderStack());
            sendUpdateMessage(updateMessage.getSenderStack(), propagatedUpdateMessage);
        }
    }

}
