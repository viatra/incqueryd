package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.util.RecipeDeserializer;

import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;

/**
 * Test cases for the {@link EqualityNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class EqualityNodeTest extends AlphaNodeTest {

	public EqualityNodeTest() {
		super("Equality");
	}
	
	@Override
	protected AlphaNode createAlphaNode(String recipeFile) throws IOException {
		final EqualityFilterRecipe recipe = (EqualityFilterRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));
		final EqualityNode filterNode = new EqualityNode(recipe);
		return filterNode;
	}

}