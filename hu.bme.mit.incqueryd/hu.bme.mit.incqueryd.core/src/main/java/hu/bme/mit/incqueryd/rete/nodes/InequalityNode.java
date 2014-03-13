package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;

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
public class InequalityNode extends AlphaNode {

	protected InequalityFilterRecipe recipe;

	InequalityNode(final InequalityFilterRecipe recipe) {
		super();
		this.recipe = recipe;
	}

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		final Integer subject = recipe.getSubject();
		final EList<Integer> indices = recipe.getInequals();

		final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();
		Set<Tuple> resultTuples;

		if (indices.size() < 1) {
			// nothing to compare
			resultTuples = incomingTuples;
		} else {
			resultTuples = new HashSet<Tuple>();

			for (final Tuple tuple : incomingTuples) {
				if (checkCondition(tuple, subject, indices)) {
					resultTuples.add(tuple);					
				}
			}
		}
		final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());

//		System.out.println("<INEQ>");
//		for (final Tuple tuple : resultChangeSet.getTuples()) {
//			System.out.println(tuple);
//		}
//		System.out.println("</INEQ>");
		

		
		return resultChangeSet;
	}

	protected boolean checkCondition(final Tuple tuple, final Integer subject, final List<Integer> inequals) {
		
		System.out.println(tuple);
		System.out.println(subject);
		System.out.println();
		
		// the mask's first item determines the reference value's index
		final Object referenceValue = tuple.get(subject);
		
		// unlike for the EqualityNode, the cycle starts from 0
		for (int i = 0; i < inequals.size(); i++) {
			final Object value = tuple.get(inequals.get(i));
			
			// if we found an equal pair, return false
			if (referenceValue.equals(value)) {
				return false;
			}
		}

		return true;
	}

}
