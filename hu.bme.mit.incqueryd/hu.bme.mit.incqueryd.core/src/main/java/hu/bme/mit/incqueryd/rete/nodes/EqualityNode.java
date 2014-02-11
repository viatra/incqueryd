package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;

/**
 * The EqualityNode and InequalityNode are types of alpha node. They check whether certain elements in the tuple,
 * selected by a pattern mask associated with the node, are all equal (EqualityNode) or all different from a subject
 * element specified by its index (InequalityNode). These nodes propagate updates that match these criteria and ignore
 * those that does not. They have no internal memory; the pull operation is performed by pulling the contents of parent
 * nodes and filtering them. [Bergmann's MSc thesis, p.39]
 * 
 * @author szarnyasg
 * 
 */
public class EqualityNode extends AlphaNode {

	EqualityFilterRecipe recipe;

	public EqualityNode(final EqualityFilterRecipe recipe) {
		super();
		this.recipe = recipe;
	}

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		final EList<Integer> indices = recipe.getIndices();

		final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();
		Set<Tuple> resultTuples;

		if (indices.size() <= 1) {
			// nothing to compare
			resultTuples = incomingTuples;
		} else {
			resultTuples = new HashSet<Tuple>();

			for (final Tuple tuple : incomingTuples) {
				if (checkCondition(tuple, indices)) {
					resultTuples.add(tuple);
				}
			}
		}
		final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());

		return resultChangeSet;
	}

	protected boolean checkCondition(final Tuple tuple, final List<Integer> indices) {
		// the mask's first item determines the reference value's index
		final Object referenceValue = tuple.get(indices.get(0));

		// unlike for the InequalityNode, the cycle starts from 1 as the item on position 0 is the reference value
		for (int i = 1; i < indices.size(); i++) {
			final Object value = tuple.get(indices.get(i));
			// if we found an unequal pair, return false 
			if (!referenceValue.equals(value)) {
				return false;
			}
		}

		return true;
	}

}
