package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.util.List;
import java.util.Set;

public class TestData {

	protected Set<Tuple> primarySet;
	protected Set<Tuple> secondarySet;
	protected List<Change> changes;
	protected List<ChangeSet> expectedChangeSets;
	
	public TestData(final Set<Tuple> primarySet, final Set<Tuple> secondarySet,
			final List<Change> changes, final List<ChangeSet> expectedChangeSets) {
		super();
		this.primarySet = primarySet;
		this.secondarySet = secondarySet;
		this.changes = changes;
		this.expectedChangeSets = expectedChangeSets;
	}

	public Set<Tuple> getPrimarySet() {
		return primarySet;
	}

	public Set<Tuple> getSecondarySet() {
		return secondarySet;
	}

	public List<Change> getChanges() {
		return changes;
	}

	public List<ChangeSet> getExpectedChangeSets() {
		return expectedChangeSets;
	}
	
}
