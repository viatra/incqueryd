package hu.bme.mit.incqueryd.rete.nodes;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;

/**
 * Test cases for the {@link AntiJoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class AntiJoinNodeTest extends BetaNodeTest {

	public AntiJoinNodeTest() {
		super("AntiJoin");
	}
	
	@Override
	protected BetaNode createBetaNode(final BetaRecipe recipe) {
		return new AntiJoinNode(recipe);
	}

}
