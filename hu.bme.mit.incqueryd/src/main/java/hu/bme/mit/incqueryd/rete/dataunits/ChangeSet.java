package hu.bme.mit.incqueryd.rete.dataunits;

import java.util.Set;

/**
 * Class for storing the change set: a collection of tuples and the type of change (positive or negative) 
 *  
 * @author szarnyasg
 * 
 */
public class ChangeSet {

	public ChangeSet(final Set<Tuple> tuples, final ChangeType changeType) {
		super();
		this.tuples = tuples;
		this.changeType = changeType;
	}

	protected Set<Tuple> tuples;
	protected ChangeType changeType;

	public Set<Tuple> getTuples() {
		return tuples;
	}

	public ChangeType getChangeType() {
		return changeType;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof ChangeSet)) return false;
		
		System.out.println("X");
		final ChangeSet changeSet = (ChangeSet) o;
		
		// comparing fields
		if (getChangeType() != changeSet.getChangeType()) return false;
			
		System.out.println("Y");
		
		System.out.println(getTuples().getClass());
		System.out.println(changeSet.getTuples().getClass());
		
		return getTuples().equals(changeSet.getTuples());
	}

}
