package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.BetaNodeConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateType;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;

import java.util.Set;

public class AntiJoinActor extends BetaActor {

    private AntiJoinNode getAntiJoinNode() {
        return (AntiJoinNode) reteNode;
    }
    
    public AntiJoinActor() {
        super();
    }

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final BetaNodeConfiguration configuration = (BetaNodeConfiguration) incQueryDConfiguration;
        super.configure(configuration);
    }

    @Override
    protected UpdateMessage joinNewTuples(final Set<Tuple> newTuples, final ReteNodeSlot nodeSlot,
            final UpdateType updateType) {
//        UpdateType propagatedUpdateType = null;
//
//        // determining the propagated update's type (see the Javadoc for the class)
//        // remark: the concept of "important updates" is not yet implemented
//        switch (updateType) {
//        case POSITIVE:
//            propagatedUpdateType = nodeSlot == ReteNodeSlot.PRIMARY ? UpdateType.POSITIVE : UpdateType.NEGATIVE;
//            break;
//        case NEGATIVE:
//            propagatedUpdateType = nodeSlot == ReteNodeSlot.PRIMARY ? UpdateType.NEGATIVE : UpdateType.POSITIVE;
//            break;
//        }
//
//        logger.info(actorString() + " NodeSlot: " + nodeSlot);
//        final Indexer newTuplesIndexer = nodeSlot == ReteNodeSlot.PRIMARY ? leftIndexer : rightIndexer;
//        final Indexer existingTuplesIndexer = nodeSlot == ReteNodeSlot.PRIMARY ? rightIndexer : leftIndexer;
//
//        final Set<Tuple> result = new HashSet<>();
//
//        // save the new tuples to the indexer's memory
//        newTuplesIndexer.add(newTuples);
//
//        for (final Tuple newTuple : newTuples) {
//            final Tuple extractedTuple = newTuplesIndexer.getJoinMask().extract(newTuple);
//            final Set<Tuple> matchingTuples = existingTuplesIndexer.get(extractedTuple);
//
//            // see the Javadoc for the class
//            switch (nodeSlot) {
//            case PRIMARY:
//                if ((updateType == UpdateType.POSITIVE && matchingTuples.isEmpty())
//                        || (updateType == UpdateType.NEGATIVE && !matchingTuples.isEmpty())) {
//                    result.add(newTuple);
//                }
//                break;
//            case SECONDARY:
//                if ((updateType == UpdateType.POSITIVE && !matchingTuples.isEmpty())
//                        || (updateType == UpdateType.NEGATIVE && !matchingTuples.isEmpty())) {
//                    for (final Tuple tuple : matchingTuples) {
//                        result.add(tuple);
//                    }
//                }
//                break;
//            default:
//                break;
//            }
//        }
//
//        UpdateMessage propagatedUpdateMessage = null;
//        if (!result.isEmpty() && targetActor != null) {
//            propagatedUpdateMessage = new UpdateMessage(propagatedUpdateType, nextNodeSlot, result);
//        }
//
//        return propagatedUpdateMessage;
        return null;
    }
}
