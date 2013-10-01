package clustergraphloader.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import clustergraphloader.graphml.Divider;

/**
 * Test cases for the {@link Divider} class.
 * @author szarnyasg
 *
 */
public class DividerTest {
	
	@Test
	public void test1() {
		int[] result = Divider.divide(15, 3);		
		
		assertEquals(result.length, 3);
		
		assertEquals(5, result[0]);
		assertEquals(5, result[1]);
		assertEquals(5, result[2]);
	}
	
	@Test	
	public void test2() {
		int[] result = Divider.divide(15, 4);
		
		assertEquals(6, result[0]);
		assertEquals(3, result[1]);
		assertEquals(3, result[2]);
		assertEquals(3, result[3]);
	}
	
	@Test
	public void test3() {
		int[] result = Divider.divide(4, 1);
		
		assertEquals(4, result[0]);
	}
	
	@Test(expected = ArithmeticException.class)
	public void test4() {
		int[] result = Divider.divide(4, 0);		
	}
	
}
