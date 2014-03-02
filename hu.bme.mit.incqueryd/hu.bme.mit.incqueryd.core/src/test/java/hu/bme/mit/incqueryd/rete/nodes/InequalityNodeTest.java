package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.util.RecipeDeserializer;

import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;

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
	protected AlphaNode createAlphaNode(String recipeFile) throws IOException {
		final InequalityFilterRecipe recipe = (InequalityFilterRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));
		final InequalityNode filterNode = new InequalityNode(recipe);
		return filterNode;
	}

}
