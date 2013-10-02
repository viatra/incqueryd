//package distributed.rete.actors;
//
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//import distributed.rete.actors.messages.UpdateMessage;
//import distributed.rete.actors.messages.UpdateType;
//import distributed.rete.configuration.ReteNodeConfiguration;
//import distributed.rete.datastructure.JoinSide;
//import distributed.rete.datastructure.Tuple;
//import distributed.rete.datastructure.TupleMask;
//
///**
// * Implementation of the TrimmerNode.
// * 
// * @author szarnyasg
// * 
// */
//public class TrimmerNode extends ReteActor {
//
//	protected TupleMask tupleMask;
//	protected JoinSide targetJoinSide;
//
//	public Collection<Tuple> filter(final Collection<Tuple> tuples) {
//		final Set<Tuple> result = new HashSet<>();
//		for (final Tuple tuple : tuples) {
//			if (tupleMask.filter(tuple)) {
//				final Tuple transformed = tupleMask.extract(tuple);
//				result.add(transformed);
//			}
//		}
//		return result;
//	}
//
//	@Override
//	public void onReceive(final Object message) throws Exception {
//		if (message instanceof UpdateMessage) {
//			final UpdateMessage updateMessage = (UpdateMessage) message;			
//			update(updateMessage);
//		}
//
//		else {
//			unhandledMessage(message);
//		}
//	}
//
//	protected void update(final UpdateMessage updateMessage) {
//		final Collection<Tuple> tuples = updateMessage.getTuples();
//		final Collection<Tuple> filteredTuples = filter(tuples);
//
//		final UpdateMessage propagatedUpdateMessage = new UpdateMessage(UpdateType.POSITIVE, targetJoinSide, filteredTuples);		
//		if (targetActor == null) {
//			targetActor = getContext().actorFor(targetActorPath);
//		}
//		targetActor.tell(propagatedUpdateMessage, getSelf());
//	}
//
//	@Override
//	protected void configure(final ReteNodeConfiguration reteNodeConfiguration) {
//		
//		
//	}
//
//}
