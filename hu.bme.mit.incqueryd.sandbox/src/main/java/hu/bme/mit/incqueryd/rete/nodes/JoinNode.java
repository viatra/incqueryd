package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.JoinSide;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

public class JoinNode extends BetaNode {

	protected Indexer leftIndexer;
	protected Indexer rightIndexer;

	public JoinNode(TupleMask leftMask, TupleMask rightMask) {
		this.leftIndexer = new Indexer(leftMask);
		this.rightIndexer = new Indexer(rightMask);
	}
	
	public ChangeSet joinNewTuples(ChangeSet incomingChangeSet, JoinSide joinSide) {
		
		Collection<Tuple> incomingTuples = incomingChangeSet.getTuples(); 
		
		Indexer newTuplesIndexer = joinSide == JoinSide.PRIMARY ? leftIndexer : rightIndexer;
		Indexer existingTuplesIndexer = joinSide == JoinSide.PRIMARY ? rightIndexer : leftIndexer;

		// save the new tuples to the indexer's memory
		newTuplesIndexer.add(incomingTuples);

		// TODO: investigate why using a HashSet introduces an ugly heisenbug in the code
		// Collection<Tuple> result = new HashSet<>();
		List<Tuple> resultTuples = new ArrayList<>();
		List<Integer> rightTupleMask = rightIndexer.getJoinMask().getMask();

		for (Tuple newTuple : incomingTuples) {
			Tuple extractedTuple = newTuplesIndexer.getJoinMask().extract(newTuple);
			Collection<Tuple> matchingTuples = existingTuplesIndexer.get(extractedTuple);

			// logger.info(extractedTuple);

			// for each matching tuple, create a result tuple
			for (Tuple matchingTuple : matchingTuples) {
				int size = newTuple.size() - extractedTuple.size() + matchingTuple.size();
				Object[] resultTuple = new Object[size];

				// assemble the result tuple
				Tuple leftTuple = joinSide == JoinSide.PRIMARY ? newTuple : matchingTuple;
				Tuple rightTuple = joinSide == JoinSide.PRIMARY ? matchingTuple : newTuple;

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

				Tuple tuple = new TupleImpl(resultTuple);
				resultTuples.add(tuple);
			}

		}

		ChangeSet propagatedChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
		return propagatedChangeSet;
	}

}
