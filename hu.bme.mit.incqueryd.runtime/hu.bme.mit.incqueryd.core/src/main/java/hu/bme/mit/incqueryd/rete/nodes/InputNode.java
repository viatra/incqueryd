package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

public class InputNode implements AlphaNode {

	/**
	 * Input node implementation. Currently, the input node has no memory the tuples are cached wherever necessary (e.g.
	 * in BetaNodes).
	 */
	InputNode(final TypeInputRecipe recipe) {
		super();
	}

	// protected final Set<Tuple> tuples;
	 
	public int tuples() {
		return 0;
	}

	public double getMemoryConsumption() {
		// return tuples.size() > 0 ? (double) RamUsageEstimator.sizeOf(tuples) / RamUsageEstimator.ONE_MB : 0;
		return 0;
	}

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		return incomingChangeSet;
	}

}
