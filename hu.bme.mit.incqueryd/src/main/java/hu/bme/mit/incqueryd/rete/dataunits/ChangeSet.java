package hu.bme.mit.incqueryd.rete.dataunits;

import java.util.Collection;

/**
 * Class for storing the change set: a collection of tuples and the type of change (positive or negative) 
 *  
 * @author szarnyasg
 * 
 */
public class ChangeSet {

	public ChangeSet(Collection<Tuple> tuples, ChangeType changeType) {
		super();
		this.tuples = tuples;
		this.changeType = changeType;
	}

	protected Collection<Tuple> tuples;
	protected ChangeType changeType;

	public Collection<Tuple> getTuples() {
		return tuples;
	}

	public ChangeType getChangeType() {
		return changeType;
	}

}
