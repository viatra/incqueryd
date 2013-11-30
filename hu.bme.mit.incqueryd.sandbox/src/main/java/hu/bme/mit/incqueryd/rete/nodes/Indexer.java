package hu.bme.mit.incqueryd.rete.nodes;


import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.Collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Indexer node for 
 * @author szarnyasg
 *
 */
public class Indexer {

	protected Multimap<Tuple, Tuple> map = ArrayListMultimap.create();
	//protected Multimap<Tuple, Tuple> map = TreeMultimap.create();

	protected TupleMask joinMask;

	public Indexer(final TupleMask joinMask) {
		this.joinMask = joinMask;
	}

	public TupleMask getJoinMask() {
		return joinMask;
	}

	public void add(final Collection<Tuple> tuples) {
		for (final Tuple tuple : tuples) {
			add(tuple);
		}
	}

	public void add(final Tuple tuple) {
		final Tuple extractedTuple = joinMask.extract(tuple);
		map.put(extractedTuple, tuple);
	}

	public Collection<Tuple> get(final Tuple tuple) {
		return map.get(tuple);
	}

	public int getSize() {
		return map.size();
	}
	
	public Multimap<Tuple, Tuple> getMap() {
		return map;
	}

}
