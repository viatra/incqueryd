package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.JoinSide;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class JoinNode extends BetaNode {

	protected Indexer leftIndexer;
	protected Indexer rightIndexer;

	public JoinNode(final TupleMask leftMask, final TupleMask rightMask) {
		this.leftIndexer = new Indexer(leftMask);
		this.rightIndexer = new Indexer(rightMask);
	}
	
	public ChangeSet update(final ChangeSet incomingChangeSet, final JoinSide joinSide) {
		
		final Collection<Tuple> incomingTuples = incomingChangeSet.getTuples(); 
		
		final Indexer newTuplesIndexer = joinSide == JoinSide.PRIMARY ? leftIndexer : rightIndexer;
		final Indexer existingTuplesIndexer = joinSide == JoinSide.PRIMARY ? rightIndexer : leftIndexer;

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
				final Tuple leftTuple = joinSide == JoinSide.PRIMARY ? newTuple : matchingTuple;
				final Tuple rightTuple = joinSide == JoinSide.PRIMARY ? matchingTuple : newTuple;

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
