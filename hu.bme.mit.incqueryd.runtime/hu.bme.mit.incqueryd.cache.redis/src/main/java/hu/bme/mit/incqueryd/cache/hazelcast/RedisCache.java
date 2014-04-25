package hu.bme.mit.incqueryd.cache.hazelcast;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import java.util.Collection;
import java.util.Set;

import org.redisson.Config;
import org.redisson.Redisson;


public class RedisCache implements DistributedCache {

	private final Config config = new Config();
	private final Redisson redisson = Redisson.create(config);

	public <K, V> DistributedMultiMap<K, V> getMultiMap(String name) {
		return new RedisMultiMap<K, V>(redisson.<K, Collection<V>>getMap(name));
	}

	public <E> Set<E> getSet(String name) {
		return redisson.getSet(name);
	}

}
