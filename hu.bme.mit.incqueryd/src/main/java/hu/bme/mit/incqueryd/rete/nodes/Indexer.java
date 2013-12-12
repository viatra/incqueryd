package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Indexer node for
 * 
 * @author szarnyasg
 * 
 */
public class Indexer {

    protected Multimap<Tuple, Tuple> map = ArrayListMultimap.create();
    // protected Multimap<Tuple, Tuple> map = TreeMultimap.create();

    protected TupleMask joinMask;

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

    public Multimap<Tuple, Tuple> getMap() {
        return map;
    }

}
