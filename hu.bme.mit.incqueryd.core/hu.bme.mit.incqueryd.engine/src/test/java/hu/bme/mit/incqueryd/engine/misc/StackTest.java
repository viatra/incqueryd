/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.misc;

import org.junit.Test;

import scala.collection.immutable.Stack;
import scala.collection.immutable.Stack$;

public class StackTest {

	@Test
	public void scalaToString() {
		final Stack<Integer> scalaStack = Stack$.MODULE$.<Integer> empty().push(1).push(2);
		System.out.println("Scala stack: " + scalaStack);
	}
	
	@Test
	public void javaToString() {
		final java.util.Stack<Object> javaStack = new java.util.Stack<>();
		javaStack.push(1);
		javaStack.push(2);
		System.out.println("Java stack: " + javaStack);
	}
}
