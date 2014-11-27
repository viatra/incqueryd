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
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.engine.rete.dataunits.TupleMask;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;

/**
 * The other kind of dual input nodes is the NotNode, that filters all tuples from its primary input slot that do NOT
 * have a matching tuple on the secondary side. Not every work mentions a node with a similar role; some of those that
 * do, refer to it as a NAND node (although the semantics are closer to the Boole expression "alfa and not beta"); the
 * node actually conforms to the anti-join operation in relational algebra.
 * 
 * [Primary slot:] If an update is received from the primary slot, the tuples with the same signature are looked up from
 * the secondary slot;
 * 
 * the update is propagated on outgoing edges if and only if there are no matching tuples in the secondary slot.
 * 
 * [Comment: the update type stays the same, i.e. a positive update is propagated as a positive update. If a negative
 * update is received from the primary slot, the tuples with the same signature are looked up from the secondary slot;
 * 
 * the update is propagated on outgoing edges if and only if there are no matching tuples in the secondary slot (else,
 * it would be unnecessary to propagate the update).]
 * 
 * [Secondary slot:] If a positive update is received at the secondary slot, (no action is taken unless it was an
 * important update, in which case) the set of tuples with the same signature is retrieved from the primary node [=
 * slot] and every one of them is propagated as a negative update message. Receiving negative updates at the secondary
 * slot involves a similar procedure, but this time positive updates will be propagated. [Bergmann's MSc thesis, p.38]
 * 
 * In short:
 * 
 * Positive update
 * 
 * * on the primary slot: send a positive update of the tuple (if there ARE NO MATCHES on the secondary indexer)
 * 
 * * on the secondary slot: send a negative update of the matches (if there IS A MATCH on the primary indexer)
 * 
 * Negative update
 * 
 * * on the primary slot: send a negative update of the tuple (if there IS A MATCH on the secondary indexer)
 * 
 * * on the secondary slot: send a positive update of the matches (if there IS A MATCH on the primary indexer)
 * 
 * (+ positive, - negative, 1 primary, 2 secondary)
 * 
 * +1 --> +
 * 
 * +2 --> -
 * 
 * -1 --> -
 * 
 * -2 --> +
 * 
 * @author szarnyasg
 * 
 */
public class AntiJoinNode extends BetaNode {

	AntiJoinNode(final AntiJoinRecipe recipe, final List<String> cacheMachineIps) {
		super(recipe, cacheMachineIps);
	}

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet, final ReteNodeSlot slot) {
		final Set<Tuple> incomingDelta = incomingChangeSet.getTuples();
		final ChangeType incomingChangeType = incomingChangeSet.getChangeType();

		ChangeType propagatedChangeType = null;

		// determining the propagated update's type (see the Javadoc for the class)
		// remark: important updates are not yet implemented
		switch (incomingChangeType) {
		case POSITIVE:
			propagatedChangeType = slot == ReteNodeSlot.PRIMARY ? ChangeType.POSITIVE : ChangeType.NEGATIVE;
			break;
		case NEGATIVE:
			propagatedChangeType = slot == ReteNodeSlot.PRIMARY ? ChangeType.NEGATIVE : ChangeType.POSITIVE;
			break;
		default:
			break;
		}

		final Set<Tuple> deltaT = new HashSet<>();

		switch (slot) {
		case PRIMARY:
			final Set<Tuple> deltaP = incomingDelta;

			for (final Tuple tuple : deltaP) {

				final Tuple projectedTuple = TupleMask.project(tuple, primaryIndexer.getJoinMask());
				final Set<Tuple> matches = secondaryIndexer.get(projectedTuple);

				if (matches.isEmpty()) {
					deltaT.add(tuple);
				}
			}
			break;
			
		case SECONDARY:
			final Set<Tuple> deltaS = incomingDelta;
			
			
			for (final Tuple tuple : deltaS) {
				final Tuple projectedTuple = TupleMask.project(tuple, secondaryIndexer.getJoinMask());
				final Set<Tuple> matches = primaryIndexer.get(projectedTuple);

				deltaT.addAll(matches);
			}

			if (incomingChangeType == ChangeType.NEGATIVE) {
				final Set<Tuple> s = new HashSet<>();
				s.addAll(secondaryIndexer.getMap().values());
				s.removeAll(deltaS);
				final Set<Tuple> sMinusDeltaS = s;
				
				final Set<Tuple> projectedSMinusDeltaS = new HashSet<>();
				for (final Tuple tuple : sMinusDeltaS) {
					final Tuple projectedTuple  = TupleMask.project(tuple, secondaryIndexer.getJoinMask());
					projectedSMinusDeltaS.add(projectedTuple);					
				}
								
				final Collection<Tuple> p = primaryIndexer.getMap().values();
				for (final Tuple tuple : p) {
					final Tuple projectedP = TupleMask.project(tuple, primaryIndexer.getJoinMask());
					if (projectedSMinusDeltaS.contains(projectedP)) {
						deltaT.remove(tuple);
					}
				}
				
			}
			break;
			
		default:
			break;
		}

		switch (slot) {
		case PRIMARY:
			primaryIndexer.add(incomingDelta, incomingChangeType);
			break;
		case SECONDARY:
			secondaryIndexer.add(incomingDelta, incomingChangeType);
			break;
		default:
			break;
		}
		

		final ChangeSet propagatedChangeSet = new ChangeSet(deltaT, propagatedChangeType);
		return propagatedChangeSet;
	}

}
