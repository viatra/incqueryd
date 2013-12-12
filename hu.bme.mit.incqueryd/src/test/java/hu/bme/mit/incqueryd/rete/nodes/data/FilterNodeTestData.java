package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

/**
 * 
 * @author szarnyasg
 * 
 */
public class FilterNodeTestData {

    protected ChangeSet changeSet;
    protected TupleMask tupleMask;

    protected ChangeSet equalityExpectedResults;
    protected ChangeSet inequalityExpectedResults;

    public FilterNodeTestData(final ChangeSet changeSet, final TupleMask tupleMask,
            final ChangeSet equalityExpectedResults, final ChangeSet inequalityExpectedResults) {
        this.changeSet = changeSet;
        this.tupleMask = tupleMask;
        this.equalityExpectedResults = equalityExpectedResults;
        this.inequalityExpectedResults = inequalityExpectedResults;
    }

    public ChangeSet getChangeSet() {
        return changeSet;
    }

    public TupleMask getTupleMask() {
        return tupleMask;
    }

    public ChangeSet getEqualityExpectedResults() {
        return equalityExpectedResults;
    }

    public ChangeSet getInequalityExpectedResults() {
        return inequalityExpectedResults;
    }

}
