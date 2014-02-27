package hu.bme.mit.incqueryd.rete.nodes;


import java.util.Arrays;

import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;


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
	protected BetaNode createBetaNode() {
		final JoinRecipe recipe = RecipesFactory.eINSTANCE.createJoinRecipe();
		final ProjectionIndexer leftParent = this.createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexer rightParent = this.createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final JoinNode node = new JoinNode(recipe);
		return node;
	}

}
