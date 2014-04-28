package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.cache.DistributedMultiMap;
import hu.bme.mit.incqueryd.cache.TupleCache;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.google.common.collect.ImmutableSet;

/**
 * Indexer node for the {@link BetaNode}s.
 *
 * @author szarnyasg
 *
 */
public class Indexer {

    protected final DistributedMultiMap<Tuple, Tuple> map;

    protected final List<Integer> joinMask;

    public Indexer(final List<Integer> joinMask) {
        this.joinMask = joinMask;
        map = new TupleCache(Collections.<String>emptyList()).getMultiMap(UUID.randomUUID().toString());
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

    public DistributedMultiMap<Tuple, Tuple> getMap() {
		return map;
	}
    
    public int getSize() {
        return map.size();
    }

}
