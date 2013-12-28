package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

/**
 * 
 * @author szarnyasg
 *
 */
public class TrimmerNodeTestData {

    protected ChangeSet changeSet;
    protected TupleMask projectionMask;
    
    protected ChangeSet expectedResults;
    
    public TrimmerNodeTestData(final ChangeSet changeSet, final TupleMask projectionMask, final ChangeSet expectedResults) {
        super();
        this.changeSet = changeSet;
        this.projectionMask = projectionMask;
        this.expectedResults = expectedResults;
    }

    public ChangeSet getChangeSet() {
        return changeSet;
    }
    
    public TupleMask getProjectionMask() {
        return projectionMask;
    }
    
    public ChangeSet getExpectedResults() {
        return expectedResults;
    }
}
