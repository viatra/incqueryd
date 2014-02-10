package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.cache.DistributedMultiMap;
import hu.bme.mit.incqueryd.cache.local.LocalCache;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.HashSet;
import java.util.Set;

/**
 * Indexer node for the {@link BetaNode}s.
 *
 * @author szarnyasg
 *
 */
public class Indexer {

    protected final DistributedMultiMap<Tuple, Tuple> map = new LocalCache().getMultiMap("");

    protected final TupleMask joinMask;

    public Indexer(final TupleMask joinMask) {
        this.joinMask = joinMask;
    }

    public TupleMask getJoinMask() {
        return joinMask;
    }

    public void add(final Set<Tuple> tuples) {
        for (final Tuple tuple : tuples) {
            add(tuple);
        }
    }

    public void add(final Tuple tuple) {
        final Tuple extractedTuple = joinMask.extract(tuple);
        map.put(extractedTuple, tuple);
    }

    public Set<Tuple> get(final Tuple tuple) {
        // converting a Collection<Tuple> to Set<Tuple>
        return new HashSet<Tuple>(map.get(tuple));
    }

    public int getSize() {
        return map.size();
    }

}
