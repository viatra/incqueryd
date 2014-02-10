package hu.bme.mit.incqueryd.cache.hazelcast;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastCache implements DistributedCache {

	private final Config config = new Config();
	private final HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);

	public <K, V> DistributedMultiMap<K, V> getMultiMap(String name) {
		return new HazelcastMultiMap<K, V>(instance.<K, V> getMultiMap(name));
	}

}
