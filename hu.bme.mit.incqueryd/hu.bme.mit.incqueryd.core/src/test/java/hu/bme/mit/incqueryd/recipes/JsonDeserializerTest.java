package hu.bme.mit.incqueryd.recipes;

import hu.bme.mit.incqueryd.util.RecipeSerializer;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.junit.Test;

public class JsonDeserializerTest {
	@Test
	public void deserialize() throws IOException {		
		final EObject eObject = RecipeSerializer.deserialize("model.json");
		System.out.println(eObject);
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
