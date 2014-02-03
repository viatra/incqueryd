package hu.bme.mit.incqueryd.cache.local;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import com.google.common.collect.HashMultimap;

public class LocalCache implements DistributedCache {

	public <K, V> DistributedMultiMap<K, V> getMultiMap(String name) {
		return new LocalMultiMap<K, V>(HashMultimap.<K, V> create());
	}

}
