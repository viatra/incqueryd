package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public abstract class FilterNode extends AlphaNode {

	protected final TupleMask tupleMask;

	public FilterNode(final TupleMask tupleMask) {
		super();
		this.tupleMask = tupleMask;
	}

	protected abstract boolean compare(Object o1, Object o2);

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		final List<Integer> mask = tupleMask.getMask();
		final Collection<Tuple> incomingTuples = incomingChangeSet.getTuples();
		Collection<Tuple> resultTuples;

		if (mask.size() <= 1) {
			// nothing to compare, all
			resultTuples = incomingTuples;

		} else {
			resultTuples = new HashSet<Tuple>();

			for (final Tuple tuple : incomingTuples) {
				// the mask's first item determines the reference value's index
				final Object referenceValue = tuple.get(mask.get(0));

				boolean equal = true;
				for (int i = 1; i < mask.size(); i++) {
					final Object value = tuple.get(mask.get(i));
					if (!compare(value, referenceValue)) {
						equal = false;
						break;
					}
				}
				
				if (equal) {
					resultTuples.add(tuple);
				}				
			}

		}
		final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
		
		return resultChangeSet;
	}
}
