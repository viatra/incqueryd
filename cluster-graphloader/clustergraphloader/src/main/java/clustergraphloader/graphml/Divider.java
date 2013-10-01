package clustergraphloader.graphml;

/**
 * Helper that divides an integer to n approximately equal parts.
 * @author szarnyasg
 *
 */
public class Divider {

	public static int[] divide(int x, int n) {
		int quotient = x / n; // throws Exception if n is zero
		int remainder = x % n;
		int[] result = new int[n];
		
		result[0] = quotient + remainder;
		for (int i = 1; i < n; i++) {
			result[i] = quotient;
		}
		
		return result;		
	}
	
}
