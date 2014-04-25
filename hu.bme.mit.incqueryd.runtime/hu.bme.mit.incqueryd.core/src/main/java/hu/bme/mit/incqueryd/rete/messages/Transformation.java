package hu.bme.mit.incqueryd.rete.messages;

import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.io.Serializable;
import java.util.Set;

public class Transformation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected final Set<Tuple> invalids;
	protected final String testCase; 
	
	public Transformation(final Set<Tuple> invalids, final String testCase) {
		super();
		
		this.invalids = invalids;	
		this.testCase = testCase;
	}
	
	public Set<Tuple> getInvalids() {
		return invalids;
	}
	
	public String getTestCase() {
		return testCase;
	}
	
}
