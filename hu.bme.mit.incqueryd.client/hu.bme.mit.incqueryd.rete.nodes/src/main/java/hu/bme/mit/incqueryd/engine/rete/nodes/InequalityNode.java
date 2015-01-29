/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.rete.nodes;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

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
public class InequalityNode implements AlphaNode {

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

		return resultChangeSet;
	}

	protected boolean checkCondition(final Tuple tuple, final Integer subject, final List<Integer> inequals) {
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
