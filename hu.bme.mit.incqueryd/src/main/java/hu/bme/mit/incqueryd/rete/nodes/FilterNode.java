package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class FilterNode extends AlphaNode {

	protected final TupleMask tupleMask;

	public FilterNode(final TupleMask tupleMask) {
		super();
		this.tupleMask = tupleMask;
	}

	protected abstract boolean compare(Object o1, Object o2);
	
	protected boolean checkCondition(final Tuple tuple, final List<Integer> mask) {
		// the mask's first item determines the reference value's index
		final Object referenceValue = tuple.get(tupleMask.getMask().get(0));

		for (int i = 1; i < mask.size(); i++) {
			final Object value = tuple.get(mask.get(i));
			if (!compare(value, referenceValue)) {
				return false;
			}
		}

		return true;
	}
	
	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		final List<Integer> mask = tupleMask.getMask();
		final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();
		Set<Tuple> resultTuples;

		if (mask.size() <= 1) {
			// nothing to compare, all
			resultTuples = incomingTuples;

		} else {
			resultTuples = new HashSet<Tuple>();

			for (final Tuple tuple : incomingTuples) {
				if (checkCondition(tuple, mask)) {
					resultTuples.add(tuple);
				}				
			}

		}
		final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
		
		return resultChangeSet;
	}
}
