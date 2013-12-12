package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.ProductionNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.messages.NodeMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;

import java.util.ArrayList;
import java.util.Collection;

import akka.actor.ActorRef;

/**
 * Finally, a distinguished production node for each pattern collects the matches of the pattern. [Bergmann's MSc
 * thesis, p. 27]
 * 
 * @author szarnyasg
 * 
 */
public class ProductionNode extends ReteActor {

    protected Collection<Tuple> memory = new ArrayList<>();
    protected ActorRef coordinator;

    public ProductionNode() {
        super();
    }

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final ProductionNodeConfiguration conf = (ProductionNodeConfiguration) incQueryDConfiguration;

        this.coordinator = conf.coordinator;
        logger.info(actorString() + " telling INITIALIZED to " + coordinator);
        coordinator.tell(NodeMessage.INITIALIZED, getSelf());
    }

    @Override
    public void onReceive(final Object message) throws Exception {
        super.onReceive(message);

        if (message instanceof UpdateMessage) {
            final UpdateMessage updateMessage = (UpdateMessage) message;
            update(updateMessage);
        }

        else if (message == NodeMessage.GETRESULT) {
            sendResult();
        }

        else if (message instanceof ProductionNodeConfiguration) {
            final ProductionNodeConfiguration configuration = (ProductionNodeConfiguration) message;
            configure(configuration);
        }
    }

    protected void sendResult() {
        logger.info(actorString() + " sending " + memory.size() + ".");
        final UpdateMessage result = new UpdateMessage(null, null, memory);
        getSender().tell(result, getSelf());
    }

    protected void update(final UpdateMessage updateMessage) {
        final Collection<Tuple> updateTuples = updateMessage.getTuples();

        switch (updateMessage.getUpdateType()) {
        case POSITIVE:
            for (final Tuple tuple : updateTuples) {
                memory.add(tuple);
            }
            break;
        case NEGATIVE:
            for (final Tuple tuple : updateTuples) {
                memory.remove(tuple);
            }
            break;
        }
        readyImmediately(updateMessage);
    }

}
