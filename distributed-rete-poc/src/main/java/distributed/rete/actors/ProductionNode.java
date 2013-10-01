package distributed.rete.actors;


import java.util.ArrayList;
import java.util.Collection;

import akka.actor.ActorRef;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.configuration.ProductionNodeConfiguration;
import distributed.rete.datastructure.Tuple;

/**
 * Finally, a distinguished production node for each pattern collects the
 * matches of the pattern. [Bergmann's MSc thesis, p. 27]
 * 
 * @author szarnyasg
 * 
 */
public class ProductionNode extends ReteActor {

	protected Collection<Tuple> memory = new ArrayList<>();
	protected ActorRef coordinator;
	
	@Override
	public void onReceive(Object message) throws Exception {
		super.onReceive(message);
		
		if (message instanceof UpdateMessage) {
			UpdateMessage updateMessage = (UpdateMessage) message;
			update(updateMessage);
		}

		else if (message instanceof ProductionNodeConfiguration) {
			ProductionNodeConfiguration c = (ProductionNodeConfiguration) message;
			configure(c.coordinator);
		}

		else if (message == NodeMessage.GETRESULT) {
			sendResult();
		}
		
		else {
			unhandledMessage(message);
		}
	}

	protected void sendResult() {
		System.out.println(actorString() + " sending " + memory.size() + ".");
		UpdateMessage result = new UpdateMessage(null, null, memory);
		getSender().tell(result, getSelf());
	}

	private void configure(ActorRef coordinator) {
		this.coordinator = coordinator;

		System.out.println(actorString() + " telling INITIALIZED to " + coordinator);
		coordinator.tell(NodeMessage.INITIALIZED, getSelf());
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
