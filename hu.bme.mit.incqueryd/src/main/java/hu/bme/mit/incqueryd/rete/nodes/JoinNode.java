package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class JoinNode extends AbstractJoinNode {

	public JoinNode(final TupleMask leftMask, final TupleMask rightMask) {
		super(leftMask, rightMask);
	}

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet, final ReteNodeSlot slot) {
		final Collection<Tuple> incomingTuples = incomingChangeSet.getTuples(); 
		
		final Indexer newTuplesIndexer = slot == ReteNodeSlot.PRIMARY ? leftIndexer : rightIndexer;
		final Indexer existingTuplesIndexer = slot == ReteNodeSlot.PRIMARY ? rightIndexer : leftIndexer;

		// save the new tuples to the indexer's memory
		newTuplesIndexer.add(incomingTuples);

		// TODO: investigate why using a HashSet introduces an ugly heisenbug in the code
		final Collection<Tuple> resultTuples = new HashSet<>();
		//Collection<Tuple> resultTuples = new ArrayList<>();
		
		final List<Integer> rightTupleMask = rightIndexer.getJoinMask().getMask();

		for (final Tuple newTuple : incomingTuples) {
			final Tuple extractedTuple = newTuplesIndexer.getJoinMask().extract(newTuple);
			final Collection<Tuple> matchingTuples = existingTuplesIndexer.get(extractedTuple);

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

				final Tuple tuple = new TupleImpl(resultTuple);
				resultTuples.add(tuple);
			}
		}

		final ChangeSet propagatedChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
		return propagatedChangeSet;
	}

}
