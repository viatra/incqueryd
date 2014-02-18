package hu.bme.mit.incqueryd.cache.hazelcast;

import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import java.util.Collection;
import java.util.Set;

import com.hazelcast.core.MultiMap;

public class HazelcastMultiMap<K, V> implements DistributedMultiMap<K, V> {

	private final MultiMap<K, V> multiMap;

	public HazelcastMultiMap(MultiMap<K, V> multiMap) {
		this.multiMap = multiMap;
	}

	public boolean put(K key, V value) {
		return multiMap.put(key, value);
	}

	public Collection<V> get(K key) {
		return multiMap.get(key);
	}

	public Set<K> keySet() {
		return multiMap.keySet();
	}

	public int size() {
		return multiMap.size();
	}

	public void remove(K key, V value) {
		// TODO Auto-generated method stub
		
	}

}
