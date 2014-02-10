package hu.bme.mit.incqueryd.rete.dataunits;

import java.util.Set;

/**
 * Class for storing the change set: a collection of tuples and the type of change (positive or negative)
 * 
 * @author szarnyasg
 * 
 */
public class ChangeSet {

	protected Set<Tuple> tuples;
	protected ChangeType changeType;

	public ChangeSet(final Set<Tuple> tuples, final ChangeType changeType) {
		super();
		this.tuples = tuples;
		this.changeType = changeType;
	}

	public Set<Tuple> getTuples() {
		return tuples;
	}

	public ChangeType getChangeType() {
		return changeType;
	}

	@Override
	public String toString() {
		return "ChangeSet, " + getTuples().size() + " tuples, [tuples=" + tuples + ", changeType=" + changeType + "]";
	}

	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof ChangeSet))
			return false;
		final ChangeSet changeSet = (ChangeSet) o;

		// comparing fields
		return getChangeType().equals(changeSet.getChangeType()) //
				&& getTuples().equals(changeSet.getTuples());
	}

}
