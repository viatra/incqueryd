package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;

public abstract class BetaNode extends ReteNode {

	abstract public ChangeSet update(final ChangeSet incomingChangeSet, final ReteNodeSlot slot);
	
}
