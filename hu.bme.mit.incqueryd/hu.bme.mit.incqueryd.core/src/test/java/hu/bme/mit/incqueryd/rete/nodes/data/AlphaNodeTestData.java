package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

public abstract class AlphaNodeTestData {
    
	protected ChangeSet incomingChangeSet;
    protected ChangeSet expectedChangeSet;
    
    public AlphaNodeTestData(final ChangeSet incomingChangeSet, final ChangeSet expectedChangeSet) {
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
