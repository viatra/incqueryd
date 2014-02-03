package hu.bme.mit.incqueryd.cache.local;

import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Multimap;

public class LocalMultiMap<K, V> implements DistributedMultiMap<K, V> {

	private final Multimap<K, V> multimap;

	public LocalMultiMap(Multimap<K, V> multimap) {
		this.multimap = multimap;
	}

	public boolean put(K key, V value) {
		return multimap.put(key, value);
	}

	public Collection<V> get(K key) {
		return multimap.get(key);
	}

	public Set<K> keySet() {
		return multimap.keySet();
	}

	@Override
	public int size() {
		return multimap.size();
	}

}
