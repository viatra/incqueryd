package hu.bme.mit.incqueryd.rete.actors;

import org.junit.Test;

import scala.collection.immutable.Stack;
import scala.collection.immutable.Stack$;

public class StackTest {

	@Test
	public void test() {
		final Stack<Integer> scalaStack = Stack$.MODULE$.<Integer> empty().push(1).push(2);
		System.out.println("Scala stack: " + scalaStack);

		final java.util.Stack<Object> javaStack = new java.util.Stack<>();
		javaStack.push(1);
		javaStack.push(2);
		System.out.println("Java stack: " + javaStack);
	}
}
