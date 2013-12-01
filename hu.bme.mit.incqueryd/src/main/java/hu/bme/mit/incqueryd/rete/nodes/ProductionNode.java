package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

/**
 * Technically, a production node is not an alpha node. However, it has the same semantics as an alpha node so it is easier to implement this way.
 * @author szarnyasg
 *
 */
public class ProductionNode extends AlphaNode {

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		// TODO Auto-generated method stub
		return null;
	}

}
