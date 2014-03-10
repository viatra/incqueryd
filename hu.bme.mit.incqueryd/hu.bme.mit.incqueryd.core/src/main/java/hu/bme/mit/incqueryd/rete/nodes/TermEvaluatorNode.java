package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.comparison.ConditionExpression;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * TermEvaluatorNode [...] deserves special mention because it diverges significantly from the classic RETE concept. It
 * evaluates a GTASM expression on tuples and filters those tuples for which it evaluates to true. It is similar to an
 * alpha node, with one key difference: the filtering condition is not required to be constant. The filtering condition
 * is an arbitrary GTASM term, it is considered as a black box. [Bergmann's MSc thesis, p.41]
 * 
 * The current implementation is a simplified version of the one defined above.
 * 
 * @author szarnyasg
 * 
 */
public class TermEvaluatorNode extends AlphaNode {

    protected Collection<ConditionExpression> conditionExpressions;

    TermEvaluatorNode(final Collection<ConditionExpression> conditionExpressions) {
        this.conditionExpressions = conditionExpressions;
    }

    @Override
    public ChangeSet update(final ChangeSet incomingChangeSet) {
        final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();
        final Set<Tuple> resultTuples = new HashSet<>();

        for (final Tuple tuple : incomingTuples) {
            if (satisfiesConditions(tuple)) {
                resultTuples.add(tuple);
            }
        }

        final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
        return resultChangeSet;
    }

    public boolean satisfiesConditions(final Tuple tuple) {
        boolean satisfiesConditions = true;
        for (final ConditionExpression conditionExpression : conditionExpressions) {
            satisfiesConditions &= conditionExpression.satisfiesCondition(tuple);
        }
        return satisfiesConditions;
    }

}
