package hu.bme.mit.incqueryd.rete.actors;
//package incqueryd.retenodes;
//
//
//import java.util.Collection;
//
//import com.google.common.collect.ArrayListMultimap;
//import com.google.common.collect.Multimap;
//
//import distributed.rete.datastructure.Tuple;
//import distributed.rete.datastructure.TupleMask;
//
//public class Indexer {
//
//	protected Multimap<Tuple, Tuple> map = ArrayListMultimap.create();
//
//	protected TupleMask joinMask;
//
//	public Indexer(TupleMask joinMask) {
//		this.joinMask = joinMask;
//	}
//
//	public TupleMask getJoinMask() {
//		return joinMask;
//	}
//
//	public void add(Set<Tuple> tuples) {
//		for (Tuple tuple : tuples) {
//			add(tuple);
//		}
//	}
//
//	public void add(Tuple tuple) {
//		Tuple extractedTuple = joinMask.extract(tuple);
//		map.put(extractedTuple, tuple);
//	}
//
//	public Set<Tuple> get(Tuple tuple) {
//		return map.get(tuple);
//	}
//
//	public int getSize() {
//		return map.size();
//	}
//	
//	public Multimap<Tuple, Tuple> getMap() {
//		return map;
//	}
//
//}
