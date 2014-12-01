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
package hu.bme.mit.incqueryd.engine.recipes;

import hu.bme.mit.incqueryd.engine.util.EObjectSerializer;
import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

public class JsonSerializerTest {

	@Test
	public void serializeTest() throws IOException {
		final BetaRecipe recipe = RecipesFactory.eINSTANCE.createJoinRecipe();
		final Mask primaryMask = RecipesFactory.eINSTANCE.createMask();
		primaryMask.getSourceIndices().addAll(Arrays.asList(2));
		final Mask secondaryMask = RecipesFactory.eINSTANCE.createMask();
		secondaryMask.getSourceIndices().addAll(Arrays.asList(0));

		final ProjectionIndexerRecipe primaryParent = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		primaryParent.setMask(primaryMask);
		recipe.setLeftParent(primaryParent);

		final ProjectionIndexerRecipe secondaryParent = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		secondaryParent.setMask(secondaryMask);
		recipe.setRightParent(secondaryParent);

		EObjectSerializer.serializeToFile(recipe, "src/test/resources/recipe.json");
		final BetaRecipe br = (BetaRecipe) RecipeDeserializer.deserializeFromFile("src/test/resources/recipe.json");

		System.out.println(br.getLeftParent());
		System.out.println(br.getRightParent());

	}

	@Test
	public void serializeToStringTest() throws IOException {
		final BetaRecipe recipe = RecipesFactory.eINSTANCE.createJoinRecipe();
		final Mask primaryMask = RecipesFactory.eINSTANCE.createMask();
		primaryMask.getSourceIndices().addAll(Arrays.asList(2));
		final Mask secondaryMask = RecipesFactory.eINSTANCE.createMask();
		secondaryMask.getSourceIndices().addAll(Arrays.asList(0));

		final ProjectionIndexerRecipe primaryParent = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		primaryParent.setMask(primaryMask);
		recipe.setLeftParent(primaryParent);

		final ProjectionIndexerRecipe secondaryParent = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		secondaryParent.setMask(secondaryMask);
		recipe.setRightParent(secondaryParent);

		final String model = EObjectSerializer.serializeToString(recipe);
		System.out.println(model);
	}

}
