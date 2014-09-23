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
package hu.bme.mit.incqueryd.cache;

import java.util.Collection;
import java.util.Set;

public interface DistributedMultiMap<K, V> {

	Collection<V> get(K key);

	Set<K> keySet();

	boolean put(K key, V value);

	int size();

	void remove(K key, V value);
	
	Collection<V> values();

}
