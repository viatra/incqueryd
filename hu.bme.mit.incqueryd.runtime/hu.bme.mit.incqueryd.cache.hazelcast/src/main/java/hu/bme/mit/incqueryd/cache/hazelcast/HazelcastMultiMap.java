/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.cache.hazelcast;

import hu.bme.mit.incqueryd.cache.DistributedMultiMap;

import java.util.Collection;
import java.util.Set;

import com.hazelcast.core.MultiMap;

public class HazelcastMultiMap<K, V> implements DistributedMultiMap<K, V> {

	private final MultiMap<K, V> multiMap;

	public HazelcastMultiMap(final MultiMap<K, V> multiMap) {
		this.multiMap = multiMap;
	}

	public boolean put(final K key, final V value) {
		return multiMap.put(key, value);
	}

	public Collection<V> get(final K key) {
		return multiMap.get(key);
	}

	public Set<K> keySet() {
		return multiMap.keySet();
	}

	public int size() {
		return multiMap.size();
	}

	public void remove(final K key, final V value) {
		// TODO Auto-generated method stub
		
	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
