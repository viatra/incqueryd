package distributed.rete.actors;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.actors.messages.UpdateType;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.Tuple;
import distributed.rete.datastructure.TupleMask;

/**
 * Implementation of the TrimmerNode.
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerNode extends ReteActor {

	protected TupleMask tupleMask;
	protected JoinSide targetJoinSide;

	public Collection<Tuple> filter(Collection<Tuple> tuples) {
		Set<Tuple> result = new HashSet<>();
		for (Tuple tuple : tuples) {
			if (tupleMask.filter(tuple)) {
				Tuple transformed = tupleMask.extract(tuple);
				result.add(transformed);
			}
		}
		return result;
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof UpdateMessage) {
			UpdateMessage updateMessage = (UpdateMessage) message;			
			update(updateMessage);
		}

		else {
			unhandledMessage(message);
		}
	}

	protected void update(UpdateMessage updateMessage) {
		Collection<Tuple> tuples = updateMessage.getTuples();
		Collection<Tuple> filteredTuples = filter(tuples);

		UpdateMessage propagatedUpdateMessage = new UpdateMessage(UpdateType.POSITIVE, targetJoinSide, filteredTuples);		
		if (targetActor == null) {
			targetActor = getContext().actorFor(targetActorPath);
		}
		targetActor.tell(propagatedUpdateMessage, getSelf());
	}

}
