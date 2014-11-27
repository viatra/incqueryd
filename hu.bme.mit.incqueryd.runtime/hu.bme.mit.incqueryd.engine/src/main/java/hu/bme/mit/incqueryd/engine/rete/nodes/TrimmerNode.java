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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;

/**
 * The TrimmerNode has a pattern mask and outputs the contents of its parent transformed by the mask. On receiving an
 * update, it uses the mask to transform the tuple contained in the update and propagate the result as an update. It
 * does not have an internal memory; the pull operation is performed by pulling the parents and transforming their
 * contents again. It is important to note that several tuples can have the same signature, so even when receiving
 * updates containing different tuples, the updates sent by this node can contain the same tuple, thus violating the
 * uniqueness principle. [Bergmann's MSc thesis, p.39-40]
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerNode implements AlphaNode {

	protected TrimmerRecipe recipe;

    TrimmerNode(final TrimmerRecipe recipe) {
        super();
        this.recipe = recipe;
    }

    @Override
    public ChangeSet update(final ChangeSet incomingChangeSet) {
        final List<Integer> mask = recipe.getMask().getSourceIndices();

        final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();

        final Set<Tuple> resultTuples = new HashSet<>();
        for (final Tuple incomingTuple : incomingTuples) {

            // generating the new tuple from the incoming tuple (projection according to the mask)
            final ArrayList<Object> resultTupleList = new ArrayList<>(mask.size());
            for (final Integer element : mask) {
                resultTupleList.add(incomingTuple.get(element));
            }

            final Tuple tuple = new Tuple(resultTupleList.toArray());
            resultTuples.add(tuple);
        }

        final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
        return resultChangeSet;
    }

}
