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
	
	public static ChangeSet join(final AbstractJoinNode joinNode, final Collection<Tuple> leftTuples, final Collection<Tuple> rightTuples) {
		final ChangeSet leftChangeSet = new ChangeSet(leftTuples, ChangeType.POSITIVE);
		final ChangeSet rightChangeSet = new ChangeSet(rightTuples, ChangeType.POSITIVE);

		// this is the correct order for the antijoin operations
		// new tuples from the secondary slot
		final ChangeSet joinedTuples1 = joinNode.update(rightChangeSet, ReteNodeSlot.SECONDARY);		
		// new tuples from the primary slot
		final ChangeSet joinedTuples2 = joinNode.update(leftChangeSet, ReteNodeSlot.PRIMARY);
		
		return joinedTuples2;
	}
	
}
