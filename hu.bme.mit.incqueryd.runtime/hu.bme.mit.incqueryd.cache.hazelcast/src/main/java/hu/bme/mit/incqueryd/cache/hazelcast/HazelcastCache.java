package hu.bme.mit.incqueryd.cache.hazelcast;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastCache implements DistributedCache {

	private final HazelcastInstance instance;

	public HazelcastCache() {
		this(Collections.<String>emptyList());
	}
	
	public HazelcastCache(final List<String> ipAddresses) {
		if (ipAddresses.isEmpty()) {
			instance = Hazelcast.newHazelcastInstance();
		} else {
			final ClientConfig clientConfig = new ClientConfig();
	        clientConfig.getNetworkConfig().setAddresses(ipAddresses);
			instance = HazelcastClient.newHazelcastClient(clientConfig);
		}
	}
	
	public <K, V> DistributedMultiMap<K, V> getMultiMap(String name) {
		return new HazelcastMultiMap<K, V>(instance.<K, V> getMultiMap(name));
	}

	@Override
	public <E> Set<E> getSet(String name) {
		return instance.getSet(name);
	}

}
