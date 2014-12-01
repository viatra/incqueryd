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
package hu.bme.mit.incqueryd.engine.rete.nodes;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.common.collect.Maps;

/**
 * TermEvaluatorNode [...] deserves special mention because it diverges significantly from the classic RETE concept. It
 * evaluates a GTASM expression on tuples and filters those tuples for which it evaluates to true. It is similar to an
 * alpha node, with one key difference: the filtering condition is not required to be constant. The filtering condition
 * is an arbitrary GTASM term, it is considered as a black box. [Bergmann's MSc thesis, p.41]
 * 
 * The current implementation is a simplified version of the one defined above.
 * 
 * @author szarnyasg
 * 
 */
public class CheckNode implements AlphaNode {

	private final String expression;
	private final Map<String, Integer> mappedIndices;
	// private final Set<String> inputParameterNames;

	CheckNode(final CheckRecipe recipe) {
		final Object[] evaluator = (Object[]) recipe.getExpression().getEvaluator();
		expression = (String) evaluator[0];

		// converting from EMap to Map
		mappedIndices = Maps.newHashMap();
		for (final Entry<String, Integer> entry : recipe.getMappedIndices()) {
			mappedIndices.put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();
		final Set<Tuple> resultTuples = new HashSet<>();

		for (final Tuple tuple : incomingTuples) {
			if (satisfiesCondition(tuple)) {
				resultTuples.add(tuple);
			}
		}

		final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
		return resultChangeSet;
	}

	protected boolean satisfiesCondition(final Tuple tuple) {
		final Context context = Context.enter();
		try {
			final Scriptable scope = context.initStandardObjects();
			for (final String parameterName : mappedIndices.keySet()) {
				final Integer index = mappedIndices.get(parameterName);
				final Object value = tuple.get(index);
				scope.put(parameterName, scope, value);
			}
			
			final Boolean result = (Boolean) context.evaluateString(scope, expression, "<cmd>", 1, null);
			return result;
		} finally {
			Context.exit();
		}
	}

}
