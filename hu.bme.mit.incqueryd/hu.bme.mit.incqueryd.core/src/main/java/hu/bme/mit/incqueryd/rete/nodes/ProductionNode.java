package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;

/**
 * Technically, a production node is not an alpha node. However, it has the same semantics as an alpha node so it is
 * easier to implement this way.
 * 
 * @author szarnyasg
 * 
 */
public class ProductionNode extends AlphaNode {

	protected final ProductionRecipe recipe;
	
	ProductionNode(final ProductionRecipe recipe) {
        super();
        this.recipe = recipe;
	}
	
    @Override
    public ChangeSet update(final ChangeSet incomingChangeSet) {
        return null;
    }

}
