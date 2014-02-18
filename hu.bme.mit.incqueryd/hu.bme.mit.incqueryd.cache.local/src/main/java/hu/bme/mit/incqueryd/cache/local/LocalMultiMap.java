package hu.bme.mit.incqueryd.cache.local;

import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Multimap;

public class LocalMultiMap<K, V> implements DistributedMultiMap<K, V> {

	private final Multimap<K, V> multimap;

	public LocalMultiMap(final Multimap<K, V> multimap) {
		this.multimap = multimap;
	}

	@Override
	public boolean put(final K key, final V value) {
		return multimap.put(key, value);
	}

	@Override
	public Collection<V> get(final K key) {
		return multimap.get(key);
	}

	@Override
	public Set<K> keySet() {
		return multimap.keySet();
	}

	@Override
	public int size() {
		return multimap.size();
	}
	
	@Override
	public void remove(final K key, final V value) {
		multimap.remove(key, value);
	}

}
