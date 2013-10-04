package distributed.rete.actors;

import java.util.ArrayList;
import java.util.Collection;

import akka.actor.ActorRef;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.configuration.IncQueryDConfiguration;
import distributed.rete.configuration.ProductionNodeConfiguration;
import distributed.rete.datastructure.Tuple;

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
	
	protected void configure(final IncQueryDConfiguration reteNodeConfiguration) {
		final ProductionNodeConfiguration conf = (ProductionNodeConfiguration) reteNodeConfiguration; 
		
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

		else {
			unhandledMessage(message);
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
