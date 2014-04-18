package hu.bme.mit.incqueryd.recipes;

import hu.bme.mit.incqueryd.util.RecipeDeserializer;
import hu.bme.mit.incqueryd.util.RecipeSerializer;

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

		RecipeSerializer.serializeToFile(recipe, "src/test/resources/recipe.json");
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

		final String model = RecipeSerializer.serializeToString(recipe);
		System.out.println(model);
	}

}
