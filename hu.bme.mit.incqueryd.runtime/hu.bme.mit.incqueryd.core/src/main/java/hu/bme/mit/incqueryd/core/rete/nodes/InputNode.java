package hu.bme.mit.incqueryd.core.rete.nodes;

import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.core.rete.dataunits.Tuple;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

import com.carrotsearch.sizeof.RamUsageEstimator;

public class InputNode implements AlphaNode {

	/**
	 * Input node implementation.
	 */
	InputNode(final TypeInputRecipe recipe) {
		super();
	}

	protected final Set<Tuple> tuples = new HashSet<>();

	public double getMemoryConsumption() {
		return tuples.size() > 0 ? (double) RamUsageEstimator.sizeOf(tuples) / RamUsageEstimator.ONE_MB : 0;
	}

	public int getTuples() {
		return tuples.size();
	}
	
	@Override
	public ChangeSet update(final ChangeSet changeSet) {
		final Set<Tuple> incomingTuples = changeSet.getTuples();
		switch (changeSet.getChangeType()) {
		case POSITIVE:
			tuples.addAll(incomingTuples);
			break;
		case NEGATIVE:
			tuples.removeAll(incomingTuples);
			break;
		default:
			break;
		}

		return changeSet;
	}

}
