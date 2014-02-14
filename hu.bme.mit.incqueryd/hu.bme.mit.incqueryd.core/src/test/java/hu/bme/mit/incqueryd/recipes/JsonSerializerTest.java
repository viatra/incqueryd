package hu.bme.mit.incqueryd.recipes;

import hu.bme.mit.incqueryd.util.RecipeSerializer;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

public class JsonSerializerTest {

	private static final EObject JoinRecipe = null;

	@Test
	public void serializeTest() throws IOException {
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

	@Test
	public void deserialize() throws IOException {
		final EObject eObject = RecipeSerializer.deserialize("model.json");
		System.out.println(eObject);
	}

	@Test
	public void serializeToStringTest() throws IOException {
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

		final String model = RecipeSerializer.serializeToString(recipe);
		System.out.println(model);
	}

	@Test
	public void deserializeFromStringTest() throws IOException {
		final String model = "{\n" + "  \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//JoinRecipe\",\n"
				+ "  \"leftParent\" : {\n"
				+ "    \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//ProjectionIndexer\",\n"
				+ "    \"mask\" : {\n"
				+ "      \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//Mask\",\n"
				+ "      \"sourceIndices\" : [ 2 ]\n" + "    }\n" + "  },\n" + "  \"rightParent\" : {\n"
				+ "    \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//ProjectionIndexer\",\n"
				+ "    \"mask\" : {\n"
				+ "      \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//Mask\",\n"
				+ "      \"sourceIndices\" : [ 0 ]\n" + "    }\n" + "  }\n" + "}";
		final EObject eObject = RecipeSerializer.deserializeFromString(model);
		final JoinRecipe recipe =  (JoinRecipe) eObject;
		System.out.println(recipe.getLeftParent().getMask().getSourceIndices());
		System.out.println(recipe.getRightParent().getMask().getSourceIndices());
	}

}
