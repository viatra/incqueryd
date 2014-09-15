package hu.bme.mit.incqueryd.core.rete.nodes;

import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet;

import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

public class UniquenessEnforcerNode implements AlphaNode {

	UniquenessEnforcerNode(final UniquenessEnforcerRecipe recipe) {
	}
	
	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		return incomingChangeSet;
	}

}
