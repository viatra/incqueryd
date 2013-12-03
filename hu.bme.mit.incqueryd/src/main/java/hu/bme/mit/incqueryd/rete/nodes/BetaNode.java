package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

/**
 * The key components are the beta nodes, that have two separate input slots, each connected to a node in the network. [Bergmann's MSc thesis, p.27]
 * 
 * @author szarnyasg
 * 
 */
public abstract class BetaNode extends ReteNode {

	protected Indexer primaryIndexer;
	protected Indexer secondaryIndexer;

	public BetaNode(final TupleMask primaryMask, final TupleMask secondaryMask) {
		this.primaryIndexer = new Indexer(primaryMask);
		this.secondaryIndexer = new Indexer(secondaryMask);
	}
	
	abstract public ChangeSet update(final ChangeSet incomingChangeSet, final ReteNodeSlot slot);

}
