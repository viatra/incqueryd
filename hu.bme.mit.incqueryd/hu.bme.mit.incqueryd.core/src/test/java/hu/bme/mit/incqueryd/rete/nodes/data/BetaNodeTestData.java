package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

/**
 * 
 * @author szarnyasg
 * 
 */
public class BetaNodeTestData {

	protected ChangeSet primaryChangeSet;
	protected ChangeSet secondaryChangeSet;
	protected ChangeSet expectedChangeSet;

	public BetaNodeTestData(final ChangeSet primaryChangeSet, final ChangeSet secondaryChangeSet,
			final ChangeSet expectedChangeSet) {
		super();
		this.primaryChangeSet = primaryChangeSet;
		this.secondaryChangeSet = secondaryChangeSet;
		this.expectedChangeSet = expectedChangeSet;
	}

	public ChangeSet getPrimaryChangeSet() {
		return primaryChangeSet;
	}

	public ChangeSet getSecondaryChangeSet() {
		return secondaryChangeSet;
	}

	public ChangeSet getExpectedChangeSet() {
		return expectedChangeSet;
	}
	
}
