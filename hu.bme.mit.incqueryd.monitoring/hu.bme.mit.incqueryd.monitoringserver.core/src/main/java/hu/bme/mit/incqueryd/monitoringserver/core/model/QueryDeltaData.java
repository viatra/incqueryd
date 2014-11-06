package hu.bme.mit.incqueryd.monitoringserver.core.model;

import hu.bme.mit.incqueryd.monitoringserver.core.data.StringTuple;

public class QueryDeltaData {
	
	private char changeType;
	
	private StringTuple tuple;
	
	public QueryDeltaData(char changed, StringTuple resultSet) {
		this.changeType = changed;
		this.tuple = resultSet;
	}

	public char getChanged() {
		return changeType;
	}
	
	public StringTuple getTuple() {
		return tuple;
	}
	
	public void setChanged(char changed) {
		this.changeType = changed;
	}
	
	public void setTuple(StringTuple resultSet) {
		this.tuple = resultSet;
	}

}
