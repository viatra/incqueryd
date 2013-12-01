package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;

/**
 * The key components are the beta nodes, that have two separate input slots, each connected to a node in the network. [Bergmann's MSc thesis, p.27]
 * 
 * @author szarnyasg
 * 
 */
public abstract class BetaNode extends ReteNode {

	abstract public ChangeSet update(final ChangeSet incomingChangeSet, final ReteNodeSlot slot);

}
