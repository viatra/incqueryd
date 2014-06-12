package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.elasticsearch.common.base.Throwables;

import com.google.common.collect.Maps;

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

    private final JavaScriptExpressionEvaluator expressionEvaluator;
	private final Map<String, Integer> parameterIndices;

    TermEvaluatorNode(final CheckRecipe recipe) {
    	expressionEvaluator = (JavaScriptExpressionEvaluator) recipe.getExpression().getEvaluator();
    	parameterIndices = Maps.newHashMap();
    	for (final Entry<String, Integer> entry : recipe.getMappedIndices()) {
			parameterIndices.put(entry.getKey(), entry.getValue());
		}
    }

    @Override
    public ChangeSet update(final ChangeSet incomingChangeSet) {
        final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();
        final Set<Tuple> resultTuples = new HashSet<>();

        for (final Tuple tuple : incomingTuples) {
            if (satisfiesCondition(tuple)) {
                resultTuples.add(tuple);
            }
        }

        final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
        return resultChangeSet;
    }

    public boolean satisfiesCondition(final Tuple tuple) {
        try {
			return (boolean) expressionEvaluator.evaluateExpression(new TupleValueProvider(tuple, parameterIndices));
		} catch (Exception e) {
			Throwables.propagate(e);
			return false;
		}
    }

}
