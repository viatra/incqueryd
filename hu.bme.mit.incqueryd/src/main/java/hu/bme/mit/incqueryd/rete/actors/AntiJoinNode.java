//package hu.bme.mit.incqueryd.rete.actors;
//
//import incqueryd.retenodes.messages.UpdateMessage;
//import incqueryd.retenodes.messages.UpdateType;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import distributed.rete.datastructure.NodeSlot;
//import distributed.rete.datastructure.Tuple;
//
///**
// * The other kind of dual input nodes is the NotNode, that filters all tuples from its primary input slot that do NOT have a matching tuple on the secondary
// * side. Not every work mentions a node with a similar role; some of those that do, refer to it as a NAND node (although the semantics are closer to the Boole
// * expression "alfa and not beta"); the node actually conforms to the anti-join operation in relational algebra.
// * 
// * [Primary slot:] If an update is received from the primary slot, the tuples with the same signature are looked up from the secondary slot;
// * 
// * the update is propagated on outgoing edges if and only if there are no matching tuples in the secondary slot.
// * 
// * [Comment: the update type stays the same, i.e. a positive update is propagated as a positive update. If a negative update is received from the primary slot,
// * the tuples with the same signature are looked up from the secondary slot;
// * 
// * the update is propagated on outgoing edges if and only if there are no matching tuples in the secondary slot (else, it would be unnecessary to propagate the
// * update).]
// * 
// * [Secondary slot:] If a positive update is received at the secondary slot, (no action is taken unless it was an important update, in which case) the set of
// * tuples with the same signature is retrieved from the primary node [= slot] and every one of them is propagated as a negative update message. Receiving
// * negative updates at the secondary slot involves a similar procedure, but this time positive updates will be propagated. [Bergmann's MSc thesis, p.38]
// * 
// * In short:
// * 
// * Positive update
// * 
// * * on the primary slot: send a positive update of the tuple (if there ARE NO MATCHES on the secondary indexer)
// * 
// * * on the secondary slot: send a negative update of the matches (if there IS A MATCH on the primary indexer)
// * 
// * Negative update
// * 
// * * on the primary slot: send a negative update of the tuple (if there IS A MATCH on the secondary indexer)
// * 
// * * on the secondary slot: send a positive update of the matches (if there IS A MATCH on the primary indexer)
// * 
// * (+ positive, - negative, 1 primary, 2 secondary)
// * 
// * +1 --> +
// * 
// * +2 --> -
// * 
// * -1 --> -
// * 
// * -2 --> +
// * 
// * @author szarnyasg
// * 
// */
//public class AntiJoinNode extends AbstractJoinNode {
//
//	public AntiJoinNode() {
//		super();
//	}
//
//	@Override
//	protected UpdateMessage joinNewTuples(Set<Tuple> newTuples, NodeSlot nodeSlot, UpdateType updateType) {
//		UpdateType propagatedUpdateType = null;
//
//		// determining the propagated update's type (see the Javadoc for the
//		// class)
//		// remark: important updates are not yet implemented
//		switch (updateType) {
//		case POSITIVE:
//			propagatedUpdateType = nodeSlot == ReteNodeSlot.PRIMARY ? UpdateType.POSITIVE : UpdateType.NEGATIVE;
//			break;
//		case NEGATIVE:
//			propagatedUpdateType = nodeSlot == ReteNodeSlot.PRIMARY ? UpdateType.NEGATIVE : UpdateType.POSITIVE;
//			break;
//		}
//
//		logger.info(actorString() + " NodeSlot: " + nodeSlot);
//		Indexer newTuplesIndexer = nodeSlot == ReteNodeSlot.PRIMARY ? leftIndexer : rightIndexer;
//		Indexer existingTuplesIndexer = nodeSlot == ReteNodeSlot.PRIMARY ? rightIndexer : leftIndexer;
//
//		List<Tuple> result = new ArrayList<>();
//
//		// save the new tuples to the indexer's memory
//		newTuplesIndexer.add(newTuples);
//
//		for (Tuple newTuple : newTuples) {
//			Tuple extractedTuple = newTuplesIndexer.getJoinMask().extract(newTuple);
//			Set<Tuple> matchingTuples = existingTuplesIndexer.get(extractedTuple);
//
//			// see the Javadoc for the class
//			switch (nodeSlot) {
//			case PRIMARY:
//				if ((updateType == UpdateType.POSITIVE && matchingTuples.isEmpty()) || (updateType == UpdateType.NEGATIVE && !matchingTuples.isEmpty())) {
//					result.add(newTuple);
//				}
//				break;
//			case SECONDARY:
//				if ((updateType == UpdateType.POSITIVE && !matchingTuples.isEmpty()) || (updateType == UpdateType.NEGATIVE && !matchingTuples.isEmpty())) {
//					for (Tuple tuple : matchingTuples) {
//						result.add(tuple);
//					}
//				}
//				break;
//			default:
//				break;
//			}
//		}
//
//		UpdateMessage propagatedUpdateMessage = null;
//		if (!result.isEmpty() && targetActor != null) {
//			propagatedUpdateMessage = new UpdateMessage(propagatedUpdateType, nextNodeSlot, result);
//		}
//
//		return propagatedUpdateMessage;
//	}
// }
