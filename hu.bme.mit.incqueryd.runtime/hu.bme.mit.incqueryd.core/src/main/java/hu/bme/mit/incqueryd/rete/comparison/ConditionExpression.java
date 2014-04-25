package hu.bme.mit.incqueryd.rete.comparison;

import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

/**
 * 
 * @author szarnyasg
 * 
 */
public class ConditionExpression {

    protected int index;
    protected ComparisonOperator comparisonOperator;
    protected long operand;

    public ConditionExpression(final int index, final ComparisonOperator comparisonOperator, final long operand) {
        this.index = index;
        this.comparisonOperator = comparisonOperator;
        this.operand = operand;
    }

    public boolean satisfiesCondition(final Tuple tuple) {
//        final Long tupleField = (Long) tuple.get(index);
    	final Integer tupleField = (Integer) tuple.get(index);
        return Compare.compare(tupleField, operand, comparisonOperator);
    }

}
