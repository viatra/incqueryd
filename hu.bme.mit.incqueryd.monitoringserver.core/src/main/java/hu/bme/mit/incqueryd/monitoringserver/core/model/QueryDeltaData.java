package hu.bme.mit.incqueryd.monitoringserver.core.model;

import hu.bme.mit.incqueryd.monitoringserver.core.data.StringTuple;

import java.util.Set;

public class QueryDeltaData {
	
	private char changeType;
	
	private Set<StringTuple> tuples;
	
	public QueryDeltaData(char changed, Set<StringTuple> resultSet) {
		this.changeType = changed;
		this.tuples = resultSet;
	}

	public char getChanged() {
		return changeType;
	}
	
	public Set<StringTuple> getResultSet() {
		return tuples;
	}
	
	public void setChanged(char changed) {
		this.changeType = changed;
	}
	
	public void setResultSet(Set<StringTuple> resultSet) {
		this.tuples = resultSet;
	}

}
