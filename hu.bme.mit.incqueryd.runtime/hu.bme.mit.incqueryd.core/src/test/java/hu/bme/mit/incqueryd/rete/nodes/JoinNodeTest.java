package hu.bme.mit.incqueryd.rete.nodes;


import hu.bme.mit.incqueryd.util.RecipeDeserializer;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;


/**
 * Test cases for the {@link JoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class JoinNodeTest extends BetaNodeTest {

	public JoinNodeTest() {
		super("Join");
	}

	@Override
	protected BetaNode createBetaNode(String recipeFile) throws IOException {
		final JoinRecipe recipe = (JoinRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));
		final JoinNode node = new JoinNode(recipe, Collections.<String>emptyList());
		return node;
	}

}
