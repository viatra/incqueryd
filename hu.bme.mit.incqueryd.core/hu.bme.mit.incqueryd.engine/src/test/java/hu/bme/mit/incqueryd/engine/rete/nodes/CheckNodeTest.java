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
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.engine.rete.nodes.CheckNode;

import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExpressionDefinition;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class CheckNodeTest {

	@Test
	public void test() {
		final CheckRecipe recipe = RecipesFactory.eINSTANCE.createCheckRecipe();
		final ExpressionDefinition expressionDefinition = RecipesFactory.eINSTANCE.createExpressionDefinition();
		
		final Object[] evaluator = new Object[2];
		
		// the first Object is the expression
		evaluator[0] = "x <= 0";
		// the second Object contains the names of the variables in the expression
		evaluator[1] = ImmutableSet.<String>of("x");
		
		expressionDefinition.setEvaluator(evaluator);
		
		recipe.setExpression(expressionDefinition);
		recipe.getMappedIndices().put("x", 0);
		
		final CheckNode checkNode = new CheckNode(recipe);
		final Set<Tuple> tuples = ImmutableSet.of(new Tuple(-4), new Tuple(-3), new Tuple(-2), new Tuple(-1), new Tuple(0), new Tuple(1));
		
		final ChangeSet changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
		final ChangeSet results = checkNode.update(changeSet);
		
		System.out.println(results);
		
	}
}
