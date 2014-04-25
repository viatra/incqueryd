package hu.bme.mit.incqueryd.cache.hazelcast;

import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import java.util.Collection;
import java.util.Set;

import org.redisson.core.RMap;

import com.google.common.base.Supplier;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

public class RedisMultiMap<K, V> implements DistributedMultiMap<K, V> {

	private final Multimap<K, V> multiMap;

	public RedisMultiMap(final RMap<K, Collection<V>> rMap) {
		this.multiMap = Multimaps.newSetMultimap(rMap, new Supplier<Set<V>>() {
			public Set<V> get() {
				return Sets.newHashSet();
			}
		});
	}

	public boolean put(final K key, final V value) {
		return multiMap.put(key, value);
	}

	public Collection<V> get(final K key) {
		return multiMap.get(key);
	}

	public Set<K> keySet() {
		return multiMap.keySet();
	}

	public int size() {
		return multiMap.size();
	}

	public void remove(final K key, final V value) {
		// TODO Auto-generated method stub

	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
