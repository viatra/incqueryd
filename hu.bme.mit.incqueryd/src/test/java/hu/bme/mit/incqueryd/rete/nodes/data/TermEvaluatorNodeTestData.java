package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.comparison.ConditionExpression;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

import java.util.Collection;

/**
 * 
 * @author szarnyasg
 *
 */
public class TermEvaluatorNodeTestData {

    final ChangeSet changeSet;
    final Collection<ConditionExpression> conditionExpressions;
    
    final ChangeSet expectedResults;

    public TermEvaluatorNodeTestData(final ChangeSet changeSet, final Collection<ConditionExpression> conditionExpressions,
            final ChangeSet expectedResults) {
        super();
        this.changeSet = changeSet;
        this.conditionExpressions = conditionExpressions;
        this.expectedResults = expectedResults;
    }
 
    public ChangeSet getChangeSet() {
        return changeSet;
    }
    
    public Collection<ConditionExpression> getConditionExpressions() {
        return conditionExpressions;
    }
    
    public ChangeSet getExpectedResults() {
        return expectedResults;
    }
    
}
