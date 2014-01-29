package hu.bme.mit.incqueryd.cache.hazelcast;
import java.util.Collection;
import java.util.Set;

import com.hazelcast.core.MultiMap;

import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

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

}
