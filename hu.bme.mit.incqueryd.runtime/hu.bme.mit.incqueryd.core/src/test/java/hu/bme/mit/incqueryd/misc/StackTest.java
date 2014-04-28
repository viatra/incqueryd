package hu.bme.mit.incqueryd.misc;

import org.junit.Test;

import scala.collection.immutable.Stack;
import scala.collection.immutable.Stack$;

public class StackTest {

	@Test
	public void scalaToString() {
		final Stack<Integer> scalaStack = Stack$.MODULE$.<Integer> empty().push(1).push(2);
		System.err.println("Scala stack: " + scalaStack);
	}
	
	@Test
	public void javaToString() {
		final java.util.Stack<Object> javaStack = new java.util.Stack<>();
		javaStack.push(1);
		javaStack.push(2);
		System.err.println("Java stack: " + javaStack);
	}
}
