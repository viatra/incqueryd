package hu.bme.mit.incqueryd.cache.local;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;

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

}
