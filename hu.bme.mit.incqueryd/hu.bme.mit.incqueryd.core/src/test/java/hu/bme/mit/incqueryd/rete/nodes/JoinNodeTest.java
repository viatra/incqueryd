package hu.bme.mit.incqueryd.rete.nodes;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;

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
	protected BetaNode createBetaNode(final BetaRecipe recipe) {
		return new JoinNode(recipe);
	}

}
