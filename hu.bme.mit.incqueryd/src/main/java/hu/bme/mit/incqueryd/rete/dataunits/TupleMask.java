package hu.bme.mit.incqueryd.rete.dataunits;

import hu.bme.mit.incqueryd.rete.comparison.ConditionExpression;

import java.io.Serializable;
import java.util.List;

public class TupleMask implements Serializable {

	private static final long serialVersionUID = 1L;
	protected List<Integer> mask;
	protected List<Integer> thresholds;
	protected List<ConditionExpression> conditionExpressions;

	public TupleMask(final List<Integer> mask) {
		this.mask = mask;
	}
	
	public TupleMask(final List<Integer> mask, final List<ConditionExpression> conditionExpressions) {
		this.mask = mask;
		this.conditionExpressions = conditionExpressions;
	}

	public boolean filter(final Tuple tuple) {
		boolean result = true;
		for (final ConditionExpression conditionExpression : conditionExpressions) {
			result &= conditionExpression.compareTuple(tuple);
		}
		return result;
	}

	public Tuple extract(final Tuple tuple) {
		final Object[] result = new Object[mask.size()];
		for (int i = 0; i < mask.size(); i++) {
			result[i] = tuple.get(mask.get(i));
		}
		return new TupleImpl(result);
	}

	public List<Integer> getMask() {
		return mask;
	}
}
