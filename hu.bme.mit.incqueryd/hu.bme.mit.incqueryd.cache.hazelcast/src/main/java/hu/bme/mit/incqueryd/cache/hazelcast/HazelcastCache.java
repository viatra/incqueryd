package hu.bme.mit.incqueryd.cache.hazelcast;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.DistributedMultiMap;


public class HazelcastCache implements DistributedCache {

	private final Config cfg = new Config();
    private final HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);

	public <K, V> DistributedMultiMap<K, V> getMultiMap(String name) {
		return new HazelcastMultiMap<K, V>(instance.<K, V>getMultiMap(name));
	}

}
