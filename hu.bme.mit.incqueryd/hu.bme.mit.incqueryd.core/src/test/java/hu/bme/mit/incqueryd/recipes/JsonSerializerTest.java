package hu.bme.mit.incqueryd.recipes;

import hu.bme.mit.incqueryd.util.RecipeSerializer;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

public class JsonSerializerTest {

	@Test
	public void serializeTest() throws IOException {
		System.out.println("Serialize.");

		final BetaRecipe recipe = RecipesFactory.eINSTANCE.createJoinRecipe();
		final Mask primaryMask = RecipesFactory.eINSTANCE.createMask();
		primaryMask.getSourceIndices().addAll(Arrays.asList(2));
		final Mask secondaryMask = RecipesFactory.eINSTANCE.createMask();
		secondaryMask.getSourceIndices().addAll(Arrays.asList(0));
		
		final ProjectionIndexer primaryParent = RecipesFactory.eINSTANCE.createProjectionIndexer();
		primaryParent.setMask(primaryMask);
		recipe.setLeftParent(primaryParent);

		final ProjectionIndexer secondaryParent = RecipesFactory.eINSTANCE.createProjectionIndexer();
		secondaryParent.setMask(secondaryMask);
		recipe.setRightParent(secondaryParent);
		
		RecipeSerializer.serialize(recipe, "model.json");
	}

//	@Test
//	public void deserialize() throws IOException {
//		System.out.println("Deserialize.");
//
//		final EObject eObject = RecipeSerializer.deserialize("model.json");
//		System.out.println(eObject);
//	}
	/**{
  "primaryChangeSet":{"tuples":[{"tuple":[5,6,7]},{"tuple":[10,11,7]}],"changeType":"POSITIVE"},
  "secondaryChangeSet":{"tuples":[{"tuple":[7,8]}],"changeType":"POSITIVE"},
  "primaryMask":[2],
  "secondaryMask":[0],
  "antiJoinExpectedResults":{"tuples":[],"changeType":"POSITIVE"},
  "joinExpectedResults":{"tuples":[{"tuple":[10,11,7,8]},{"tuple":[5,6,7,8]}],"changeType":"POSITIVE"}
}*/
}
