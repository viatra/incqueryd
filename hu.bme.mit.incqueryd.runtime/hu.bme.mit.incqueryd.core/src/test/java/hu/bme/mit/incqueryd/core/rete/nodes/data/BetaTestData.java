package hu.bme.mit.incqueryd.core.rete.nodes.data;

import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet;

/**
 * 
 * @author szarnyasg
 * 
 */
public class BetaTestData {

	protected ChangeSet primaryChangeSet;
	protected ChangeSet secondaryChangeSet;
	protected ChangeSet expectedFirstChangeSet;
	protected ChangeSet expectedSecondChangeSet;

	public BetaTestData(final ChangeSet primaryChangeSet, final ChangeSet secondaryChangeSet,
			final ChangeSet expectedFirstChangeSet, final ChangeSet expectedSecondChangeSet) {
		super();
		this.primaryChangeSet = primaryChangeSet;
		this.secondaryChangeSet = secondaryChangeSet;
		this.expectedFirstChangeSet = expectedFirstChangeSet;
		this.expectedSecondChangeSet = expectedSecondChangeSet;
	}

	public ChangeSet getPrimaryChangeSet() {
		return primaryChangeSet;
	}

	public ChangeSet getSecondaryChangeSet() {
		return secondaryChangeSet;
	}

	public ChangeSet getExpectedFirstChangeSet() {
		return expectedFirstChangeSet;
	}
	
	public ChangeSet getExpectedSecondChangeSet() {
		return expectedSecondChangeSet;
	}
}
