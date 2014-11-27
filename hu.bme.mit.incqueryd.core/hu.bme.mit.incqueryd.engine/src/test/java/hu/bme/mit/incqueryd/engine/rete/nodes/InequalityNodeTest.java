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
import hu.bme.mit.incqueryd.engine.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.engine.rete.nodes.InequalityNode;
import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

/**
 * Test cases for the {@link InequalityNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class InequalityNodeTest extends AlphaNodeTest {
	
	public InequalityNodeTest() {
		super("Inequality");
	}
	
	@Override
	protected AlphaNode createAlphaNode(final String recipeFile) throws IOException {
		final InequalityFilterRecipe recipe = (InequalityFilterRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));
		final InequalityNode filterNode = new InequalityNode(recipe);
		return filterNode;
	}

	@Override
	@Test
	public void test() {
		final InequalityFilterRecipe recipe = RecipesFactory.eINSTANCE.createInequalityFilterRecipe();
		recipe.setSubject(0);
		recipe.getInequals().add(1);
		
		final InequalityNode node = new InequalityNode(recipe);
		final Set<Tuple> tuples = new HashSet<>();
		tuples.add(new Tuple(1, 1));
		tuples.add(new Tuple(1, 2));
		
		final ChangeSet changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
		final ChangeSet result = node.update(changeSet);
		
		System.out.println(result);
		
	}
	
}
