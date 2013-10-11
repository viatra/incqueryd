package distributed.rete.comparison;

import java.io.Serializable;

import distributed.rete.datastructure.Tuple;


public class ConditionExpression implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int index;
	protected ComparisonOperator comparisonOperator;
	protected int operand;

	public ConditionExpression(int index, ComparisonOperator comparisonOperator, int operand) {
		this.index = index;
		this.comparisonOperator = comparisonOperator;
		this.operand = operand;
	}
	
	public boolean compareTuple(Tuple tuple) {
		int tupleField = (int)tuple.get(index);
		return Compare.compare(tupleField, operand, comparisonOperator);
	}
	
}
