package hu.bme.mit.incqueryd.monitoringserver.core.model;

import hu.bme.mit.incqueryd.monitoringserver.core.data.StringTuple;

import java.util.Set;

public class QueryResultData {
	
	private String changed;
	
	private Set<StringTuple> resultSet;
	
	public QueryResultData(String changed, Set<StringTuple> resultSet) {
		this.changed = changed;
		this.resultSet = resultSet;
	}

	public String getChanged() {
		return changed;
	}
	
	public Set<StringTuple> getResultSet() {
		return resultSet;
	}
	
	public void setChanged(String changed) {
		this.changed = changed;
	}
	
	public void setResultSet(Set<StringTuple> resultSet) {
		this.resultSet = resultSet;
	}

}
