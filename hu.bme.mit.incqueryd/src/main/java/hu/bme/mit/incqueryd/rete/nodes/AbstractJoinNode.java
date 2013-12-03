package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

public abstract class AbstractJoinNode extends BetaNode {

	protected Indexer primaryIndexer;
	protected Indexer secondaryIndexer;

	public AbstractJoinNode(final TupleMask leftMask, final TupleMask rightMask) {
		this.primaryIndexer = new Indexer(leftMask);
		this.secondaryIndexer = new Indexer(rightMask);
	}

}
