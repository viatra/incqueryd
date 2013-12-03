package hu.bme.mit.incqueryd.rete.comparison;

import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

public class ConditionExpression {

	protected int index;
	protected ComparisonOperator comparisonOperator;
	protected int operand;

	public ConditionExpression(final int index, final ComparisonOperator comparisonOperator, final int operand) {
		this.index = index;
		this.comparisonOperator = comparisonOperator;
		this.operand = operand;
	}
	
	public boolean satisfiesCondition(final Tuple tuple) {
		final Integer tupleField = (Integer) tuple.get(index);
		return Compare.compare(tupleField, operand, comparisonOperator);
	}
	
}
