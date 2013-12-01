package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

public abstract class AbstractJoinNode extends BetaNode {

	protected Indexer leftIndexer;
	protected Indexer rightIndexer;

	public AbstractJoinNode(final TupleMask leftMask, final TupleMask rightMask) {
		this.leftIndexer = new Indexer(leftMask);
		this.rightIndexer = new Indexer(rightMask);
	}

}
