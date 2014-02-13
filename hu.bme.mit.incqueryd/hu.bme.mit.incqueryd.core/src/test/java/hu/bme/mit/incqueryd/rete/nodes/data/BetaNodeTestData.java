package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

import java.util.List;

/**
 * 
 * @author szarnyasg
 * 
 */
public class BetaNodeTestData {

    protected ChangeSet primaryChangeSet;
    protected ChangeSet secondaryChangeSet;
    protected List<Integer> primaryMask;
    protected List<Integer> secondaryMask;

    protected ChangeSet antiJoinExpectedResults;
    protected ChangeSet joinExpectedResults;
    
    public BetaNodeTestData(final ChangeSet primaryChangeSet, final ChangeSet secondaryChangeSet,
            final List<Integer> primaryMask, final List<Integer> secondaryMask, final ChangeSet expectedResults,
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

    public List<Integer> getPrimaryMask() {
        return primaryMask;
    }

    public List<Integer> getSecondaryMask() {
        return secondaryMask;
    }

    public ChangeSet getAntiJoinExpectedResults() {
        return antiJoinExpectedResults;
    }

    public ChangeSet getJoinExpectedResults() {
        return joinExpectedResults;
    }

}
