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

import hu.bme.mit.incqueryd.engine.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.engine.rete.nodes.TrimmerNode;
import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer;

import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;

/**
 * Test cases for the {@link TrimmerNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerNodeTest extends AlphaNodeTest {

	public TrimmerNodeTest() {
		super("Trimmer");
	}

	@Override
	protected AlphaNode createAlphaNode(final String recipeFile) throws IOException {
		final TrimmerRecipe recipe = (TrimmerRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));
		final TrimmerNode trimmerNode = new TrimmerNode(recipe);
		return trimmerNode;
	}

}
