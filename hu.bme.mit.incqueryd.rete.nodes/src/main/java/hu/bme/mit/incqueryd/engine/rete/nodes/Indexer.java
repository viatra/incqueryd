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

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.engine.rete.dataunits.TupleMask;

import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;

/**
 * Indexer node for the {@link BetaNode}s.
 *
 * @author szarnyasg
 *
 */
public class Indexer {

    protected final HashMultimap<Tuple, Tuple> map;

    protected final List<Integer> joinMask;

    public Indexer(final List<Integer> joinMask) {
        this.joinMask = joinMask;
//        map = new TupleCache().getMultiMap(UUID.randomUUID().toString());
        map = HashMultimap.create();
    }

    public List<Integer> getJoinMask() {
        return joinMask;
    }

    public void add(final Set<Tuple> tuples, final ChangeType changeType) {
        for (final Tuple tuple : tuples) {
            add(tuple, changeType);
        }
    }

    public void add(final Tuple tuple, final ChangeType changeType) {
        final Tuple extractedTuple = TupleMask.project(tuple, joinMask);
        switch (changeType) {
        case POSITIVE:
            map.put(extractedTuple, tuple);        	
        	break;
        case NEGATIVE:
        	map.remove(extractedTuple, tuple);
        	break;
        default:
        	break;
        }
    }
    
    public Set<Tuple> get(final Tuple tuple) {
        // converting a Collection<Tuple> to Set<Tuple>
        return ImmutableSet.copyOf(map.get(tuple));
    }

    public HashMultimap<Tuple, Tuple> getMap() {
		return map;
	}
    
    public int getSize() {
        return map.size();
    }

}
