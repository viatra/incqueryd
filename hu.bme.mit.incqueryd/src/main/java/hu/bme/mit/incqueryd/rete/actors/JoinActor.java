package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JoinActor extends BetaActor {

    public JoinActor() {
        super();
    }

    /**
     * Join the newly arrived tuples to the old ones in the opposite side's indexer.
     * 
     * @return
     */
    @Override
    protected UpdateMessage joinNewTuples(final Set<Tuple> newTuples, final ReteNodeSlot nodeSlot, final UpdateType updateType) {
        // int n = 0;

        final Indexer newTuplesIndexer = nodeSlot == ReteNodeSlot.PRIMARY ? leftIndexer : rightIndexer;
        final Indexer existingTuplesIndexer = nodeSlot == ReteNodeSlot.PRIMARY ? rightIndexer : leftIndexer;

        newTuplesIndexer.add(newTuples);

        final Set<Tuple> result = new HashSet<>();
        final List<Integer> rightTupleMask = rightIndexer.getJoinMask().getMask();

        for (final Tuple newTuple : newTuples) {
            final Tuple extractedTuple = newTuplesIndexer.getJoinMask().extract(newTuple);
            final Set<Tuple> matchingTuples = existingTuplesIndexer.get(extractedTuple);

            // for each matching tuple, create a result tuple
            for (final Tuple matchingTuple : matchingTuples) {
                final int size = newTuple.size() - extractedTuple.size() + matchingTuple.size();
                final Object[] resultTuple = new Object[size];

                // assemble the result tuple
                final Tuple leftTuple = nodeSlot == ReteNodeSlot.PRIMARY ? newTuple : matchingTuple;
                final Tuple rightTuple = nodeSlot == ReteNodeSlot.PRIMARY ? matchingTuple : newTuple;

                // copy from the left tuple
                for (int i = 0; i < leftTuple.size(); i++) {
                    resultTuple[i] = leftTuple.get(i);
                }

                // copy from the right tuple -- skip the duplicate attributes
                int j = 0;
                for (int i = 0; i < rightTuple.size(); i++) {
                    if (!rightTupleMask.contains(i)) {
                        resultTuple[leftTuple.size() + j] = rightTuple.get(i);
                        j++;
                    }
                }

                final Tuple tuple = new TupleImpl(resultTuple);
                // logger.info(tuple);
                result.add(tuple);
                // n++;
                // logger.info("n = " + n + ", result size = " +
                // result.size());
            }

        }

        UpdateMessage propagatedUpdateMessage = null;
        if (!result.isEmpty() && targetActor != null) {
            propagatedUpdateMessage = new UpdateMessage(updateType, nextNodeSlot, result);
        }

        return propagatedUpdateMessage;
    }
}
