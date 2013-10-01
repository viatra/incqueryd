package distributed.rete.actors;

import java.util.ArrayList;
import java.util.Collection;

import akka.actor.ActorRef;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.UpdateMessage;
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

	protected void configure(ProductionNodeConfiguration configuration) {
		this.coordinator = configuration.coordinator;

		logger.info(actorString() + " telling INITIALIZED to " + coordinator);
		coordinator.tell(NodeMessage.INITIALIZED, getSelf());
	}

	@Override
	public void onReceive(Object message) throws Exception {
		super.onReceive(message);

		if (message instanceof UpdateMessage) {
			UpdateMessage updateMessage = (UpdateMessage) message;
			update(updateMessage);
		}

		else if (message == NodeMessage.GETRESULT) {
			sendResult();
		}

		else if (message instanceof ProductionNodeConfiguration) {
			ProductionNodeConfiguration configuration = (ProductionNodeConfiguration) message;
			configure(configuration);
		}

		else {
			unhandledMessage(message);
		}
	}

	protected void sendResult() {
		logger.info(actorString() + " sending " + memory.size() + ".");
		UpdateMessage result = new UpdateMessage(null, null, memory);
		logger.info("telling");
		getSender().tell(result, getSelf());
		logger.info("/telling");
	}

	protected void update(UpdateMessage updateMessage) {
		Collection<Tuple> updateTuples = updateMessage.getTuples();

		switch (updateMessage.getUpdateType()) {
		case POSITIVE:
			for (Tuple tuple : updateTuples) {
				memory.add(tuple);
			}
			break;
		case NEGATIVE:
			for (Tuple tuple : updateTuples) {
				memory.remove(tuple);
			}
			break;
		}
		readyImmediately(updateMessage);
	}

}
