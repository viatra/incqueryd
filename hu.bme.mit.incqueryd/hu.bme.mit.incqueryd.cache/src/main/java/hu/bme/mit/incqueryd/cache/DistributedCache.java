package hu.bme.mit.incqueryd.cache;

public interface DistributedCache {

    <K, V> DistributedMultiMap<K, V> getMultiMap(String name);

}