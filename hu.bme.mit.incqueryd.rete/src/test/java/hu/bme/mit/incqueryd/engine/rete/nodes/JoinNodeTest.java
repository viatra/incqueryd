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


import hu.bme.mit.incqueryd.engine.rete.nodes.BetaNode;
import hu.bme.mit.incqueryd.engine.rete.nodes.JoinNode;
import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;


/**
 * Test cases for the {@link JoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class JoinNodeTest extends BetaNodeTest {

	public JoinNodeTest() {
		super("Join");
	}

	@Override
	protected BetaNode createBetaNode(String recipeFile) throws IOException {
		final JoinRecipe recipe = (JoinRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));
		final JoinNode node = new JoinNode(recipe, Collections.<String>emptyList());
		return node;
	}

}
