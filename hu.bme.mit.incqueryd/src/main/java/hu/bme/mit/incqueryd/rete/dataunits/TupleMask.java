package hu.bme.mit.incqueryd.rete.dataunits;

import java.io.Serializable;
import java.util.List;


public class TupleMask implements Serializable {

	private static final long serialVersionUID = 1L;
	protected List<Integer> mask;
	protected List<Integer> thresholds;
//	protected List<ConditionExpression> conditionExpressions;
	
	public TupleMask(List<Integer> mask) {
//		, List<ConditionExpression> conditionExpressions) {
		this.mask = mask;
//		this.conditionExpressions = conditionExpressions;
	}

//	public boolean filter(Tuple tuple) {
//		boolean result = true;
//		for (ConditionExpression conditionExpression : conditionExpressions) {
//			result &= conditionExpression.compareTuple(tuple);
//		}
//		return result;
//	}
	
	public Tuple extract(Tuple tuple) {
		Object[] result = new Object[mask.size()];
		for (int i = 0; i < mask.size(); i++) {
			result[i] = tuple.get(mask.get(i)); 
		}
		return new TupleImpl(result);
	}

	public List<Integer> getMask() {
		return mask;
	}
}
