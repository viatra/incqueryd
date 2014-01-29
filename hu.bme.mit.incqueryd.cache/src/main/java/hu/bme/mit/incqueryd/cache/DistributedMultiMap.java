package hu.bme.mit.incqueryd.cache;

import java.util.Collection;
import java.util.Set;

public interface DistributedMultiMap<K, V> {

	Collection<V> get(K key);

	Set<K> keySet();

	boolean put(K key, V value);

}
