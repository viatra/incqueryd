package hu.bme.mit.incqueryd.rete.comparison;

import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.io.Serializable;

public class ConditionExpression implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int index;
	protected ComparisonOperator comparisonOperator;
	protected int operand;

	public ConditionExpression(final int index, final ComparisonOperator comparisonOperator, final int operand) {
		this.index = index;
		this.comparisonOperator = comparisonOperator;
		this.operand = operand;
	}
	
	public boolean compareTuple(final Tuple tuple) {
		final Integer tupleField = (Integer) tuple.get(index);
		return Compare.compare(tupleField, operand, comparisonOperator);
	}
	
}
