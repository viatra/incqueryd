package hu.bme.mit.incqueryd.cache.local;

import java.util.Set;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Sets;

public class LocalCache implements DistributedCache {

	private final LoadingCache<String, DistributedMultiMap<Object, Object>> multiMaps = CacheBuilder.newBuilder().build(new CacheLoader<String, DistributedMultiMap<Object, Object>>() {

		@Override
		public DistributedMultiMap<Object, Object> load(String key) throws Exception {
			return new LocalMultiMap<>(HashMultimap.create());
		}

	});

	public <K, V> DistributedMultiMap<K, V> getMultiMap(String name) {
		return (DistributedMultiMap<K, V>) multiMaps.getUnchecked(name);
	}

	private final LoadingCache<String, Set<Object>> sets = CacheBuilder.newBuilder().build(new CacheLoader<String, Set<Object>>() {

		@Override
		public Set<Object> load(String key) throws Exception {
			return Sets.newHashSet();
		}

	});

	@Override
	public <E> Set<E> getSet(String name) {
		return (Set<E>) sets.getUnchecked(name);
	}

}
