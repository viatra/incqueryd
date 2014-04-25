package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

public class AlphaTestData {
    
	protected ChangeSet incomingChangeSet;
    protected ChangeSet expectedChangeSet;
    
    public AlphaTestData(final ChangeSet incomingChangeSet, final ChangeSet expectedChangeSet) {
		this.incomingChangeSet = incomingChangeSet;
		this.expectedChangeSet = expectedChangeSet;
	}
    
    public ChangeSet getIncomingChangeSet() {
		return incomingChangeSet;
	}
  
    public ChangeSet getExpectedChangeSet() {
		return expectedChangeSet;
	}
    
}
