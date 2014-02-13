package hu.bme.mit.incqueryd.recipes;

import hu.bme.mit.incqueryd.util.RecipeSerializer;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.junit.Test;

public class JsonSerializerTest {

	@Test
	public void serializeTest() throws IOException {
		System.out.println("Serialize.");

		final TrimmerRecipe recipe = RecipesFactory.eINSTANCE.createTrimmerRecipe();
		final Mask mask = RecipesFactory.eINSTANCE.createMask();
		mask.getSourceIndices().addAll(Arrays.asList(2, 0));
		recipe.setMask(mask);

		RecipeSerializer.serialize(recipe, "model.json");
	}

	@Test
	public void deserialize() throws IOException {
		System.out.println("Deserialize.");

		EObject eObject = RecipeSerializer.deserialize("model.json");
		System.out.println(eObject);
	}

}
