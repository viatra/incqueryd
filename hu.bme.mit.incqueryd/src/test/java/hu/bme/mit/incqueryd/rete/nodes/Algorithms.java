package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.util.Collection;

/**
 * Algorithms for using the Rete nodes.
 * @author szarnyasg
 *
 */
public class Algorithms {
	
	public static ChangeSet join(final AbstractJoinNode joinNode, final Collection<Tuple> primaryTuples, final Collection<Tuple> secondaryTuples) {
		final ChangeSet primaryChangeSet = new ChangeSet(primaryTuples, ChangeType.POSITIVE);
		final ChangeSet secondaryChangeSet = new ChangeSet(secondaryTuples, ChangeType.POSITIVE);

		// this is the correct order for the antijoin operations
		// new tuples from the secondary slot
		final ChangeSet joinedTuples1 = joinNode.update(secondaryChangeSet, ReteNodeSlot.SECONDARY);		
		// new tuples from the primary slot
		final ChangeSet joinedTuples2 = joinNode.update(primaryChangeSet, ReteNodeSlot.PRIMARY);
		
		return joinedTuples2;
	}
	
}
