package hu.bme.mit.incqueryd.cache;

import java.util.Set;

public interface DistributedCache {

    <K, V> DistributedMultiMap<K, V> getMultiMap(String name);
    
    <E> Set<E> getSet(String name);

}