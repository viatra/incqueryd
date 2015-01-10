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
package hu.bme.mit.incqueryd.engine.rete.comparison;

import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.util.Map;
import java.util.Map.Entry;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/**
 * 
 * @author szarnyasg
 * @param <V>
 * 
 */
public class ConditionExpression {

	private final String expression;
	private final Map<String, Integer> parameterIndices;

	public ConditionExpression(final String expression, final Map<String, Integer> parameterIndices) {
		this.expression = expression;
		this.parameterIndices = parameterIndices;
	}

	public boolean satisfiesCondition(final Tuple tuple) {
		// Creates and enters a Context. The Context stores information
		// about the execution environment of a script.
		final Context cx = Context.enter();
		try {
			// Initialize the standard objects (Object, Function, etc.)
			// This must be done before scripts can be executed. Returns
			// a scope object that we use in later calls.
			final Scriptable scope = cx.initStandardObjects();
			for (final Entry<String, Integer> entry : parameterIndices.entrySet()) {
				scope.put(entry.getKey(), scope, tuple.get(entry.getValue()));
			}

			// Now evaluate the string we've colected.
			final Object result = cx.evaluateString(scope, expression, "<cmd>", 1, null);

			return (boolean) result;

		} finally {
			Context.exit();
		}
	}

}
