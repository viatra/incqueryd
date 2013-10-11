package distributed.rete.comparison;

public class Compare {
	public static boolean compare(int a, int b, ComparisonOperator comparisonOperator) {
		switch (comparisonOperator) {
		case EQUALS:
			return a == b;
		case GREATER_THAN:
			return a > b;
		case GREATER_THAN_OR_EQUAL:
			return a >= b;
		case LESS_THAN:
			return a < b;
		case LESS_THAN_OR_EQUAL:
			return a <= b;
		case NOT_EQUALS:
			return a != b;
		default:
			return false;
		}
	}
}
