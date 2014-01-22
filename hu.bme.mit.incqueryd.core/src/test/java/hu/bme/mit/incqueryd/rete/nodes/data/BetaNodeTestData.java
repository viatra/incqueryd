package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

/**
 * 
 * @author szarnyasg
 * 
 */
public class BetaNodeTestData {

    protected ChangeSet primaryChangeSet;
    protected ChangeSet secondaryChangeSet;
    protected TupleMask primaryMask;
    protected TupleMask secondaryMask;

    protected ChangeSet antiJoinExpectedResults;
    protected ChangeSet joinExpectedResults;
    
    public BetaNodeTestData(final ChangeSet primaryChangeSet, final ChangeSet secondaryChangeSet,
            final TupleMask primaryMask, final TupleMask secondaryMask, final ChangeSet expectedResults,
            final ChangeSet antiJoinExpectedResults) {
        super();
        this.primaryChangeSet = primaryChangeSet;
        this.secondaryChangeSet = secondaryChangeSet;
        this.primaryMask = primaryMask;
        this.secondaryMask = secondaryMask;
        this.antiJoinExpectedResults = antiJoinExpectedResults;
        this.joinExpectedResults = expectedResults;
    }

    public ChangeSet getPrimaryChangeSet() {
        return primaryChangeSet;
    }

    public ChangeSet getSecondaryChangeSet() {
        return secondaryChangeSet;
    }

    public TupleMask getPrimaryMask() {
        return primaryMask;
    }

    public TupleMask getSecondaryMask() {
        return secondaryMask;
    }

    public ChangeSet getAntiJoinExpectedResults() {
        return antiJoinExpectedResults;
    }

    public ChangeSet getJoinExpectedResults() {
        return joinExpectedResults;
    }

}
