package hu.bme.mit.incqueryd.core.rete.messages;

public class QueryIndexer {
	
	public QueryIndexer(String typeName) {
		this.typeName = typeName;
	}
	
	protected String typeName;
	
	public String getTypeName() {
		return typeName;
	}
}
