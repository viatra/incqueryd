package hu.bme.mit.incqueryd.core.rete.nodes;

import hu.bme.mit.incqueryd.core.util.RecipeDeserializer;

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
