package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

/**
 * Algorithms for using the Rete nodes.
 * 
 * @author szarnyasg
 * 
 */
public class Algorithms {

	public static ChangeSet join(final BetaNode joinNode, final ChangeSet primaryChangeSet,
			final ChangeSet secondaryChangeSet) {
		// this is the correct order for the antijoin operations
		// new tuples from the secondary slot
		// final ChangeSet joinedTuples1 =
//		joinNode.update(secondaryChangeSet, ReteNodeSlot.SECONDARY);
		// new tuples from the primary slot

		return null;
	}

}
