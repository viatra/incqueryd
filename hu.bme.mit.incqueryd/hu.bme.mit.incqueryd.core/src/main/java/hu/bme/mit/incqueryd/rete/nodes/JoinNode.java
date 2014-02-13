package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;

/**
 * 
 * @author szarnyasg
 *
 */
public class JoinNode extends BetaNode {

    public JoinNode(final BetaRecipe recipe) {
        super(recipe);
    }

    @Override
    public ChangeSet update(final ChangeSet incomingChangeSet, final ReteNodeSlot slot) {
        final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();

        final Indexer newTuplesIndexer = slot == ReteNodeSlot.PRIMARY ? primaryIndexer : secondaryIndexer;
        final Indexer existingTuplesIndexer = slot == ReteNodeSlot.PRIMARY ? secondaryIndexer : primaryIndexer;

        // save the new tuples to the indexer's memory
        newTuplesIndexer.add(incomingTuples);

        final Set<Tuple> resultTuples = new HashSet<>();
        final List<Integer> rightTupleMask = secondaryIndexer.getJoinMask();

        for (final Tuple newTuple : incomingTuples) {
            final Tuple extractedTuple = TupleMask.extract(newTuple, newTuplesIndexer.getJoinMask());
            final Set<Tuple> matchingTuples = existingTuplesIndexer.get(extractedTuple);

            // for each matching tuple, create a result tuple
            for (final Tuple matchingTuple : matchingTuples) {
                final int size = newTuple.size() - extractedTuple.size() + matchingTuple.size();
                final Object[] resultTuple = new Object[size];

                // assemble the result tuple
                final Tuple leftTuple = slot == ReteNodeSlot.PRIMARY ? newTuple : matchingTuple;
                final Tuple rightTuple = slot == ReteNodeSlot.PRIMARY ? matchingTuple : newTuple;

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

                final Tuple tuple = new Tuple(resultTuple);
                resultTuples.add(tuple);
            }
        }

        final ChangeSet propagatedChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
        return propagatedChangeSet;
    }

}
