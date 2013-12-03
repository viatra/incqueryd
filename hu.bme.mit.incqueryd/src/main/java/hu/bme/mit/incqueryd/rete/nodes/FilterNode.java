package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

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
		for (final Integer i : mask) {
			System.out.println(i);
		}
		
		
		compare(null, null);
		
		return null;
	}

}
