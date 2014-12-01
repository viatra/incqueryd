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
package hu.bme.mit.incqueryd.engine.cache;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.DistributedMultiMap;
import hu.bme.mit.incqueryd.cache.local.LocalCache;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.util.Set;

public class TupleCache {

//	private final boolean distributed;
	private final DistributedCache cache;

//	public TupleCache(final List<String> cacheMachineIps) {
//		distributed = !cacheMachineIps.isEmpty();
//		if (distributed) {
//			cache = new HazelcastCache(cacheMachineIps);
//		} else {
//			cache = new LocalCache();
//		}
//	}
	
	public TupleCache() {
		cache = new LocalCache();
	}

//	public boolean isDistributed() {
//		return distributed;
//	}
	
	public Set<Tuple> getSet(final String setName) {
		return cache.getSet(setName);
	}
	
	public DistributedMultiMap<Tuple, Tuple> getMultiMap(final String multiMapName) {
		return cache.getMultiMap(multiMapName);
	}

}
