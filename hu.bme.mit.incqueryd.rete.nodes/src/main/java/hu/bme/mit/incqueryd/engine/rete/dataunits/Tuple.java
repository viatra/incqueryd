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
package hu.bme.mit.incqueryd.engine.rete.dataunits;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Tuple implementation.
 * 
 * @author szarnyasg
 * 
 */
public class Tuple implements Serializable, Comparable<Tuple> {

	private static final long serialVersionUID = 1L;
	protected final List<?> tuple;

	public Tuple(Object... tuple) {
		this.tuple = ImmutableList.copyOf(tuple);
	}

	public Object get(int index) {
		return tuple.get(index);
	}

	public int size() {
		return tuple.size();
	}

	@Override
	public String toString() {
		String result = "<";
		if (tuple.size() > 0) {
			result += tuple.get(0).toString();
			for (int i = 1; i < tuple.size(); i++) {
				result += ", " + tuple.get(i).toString();
			}
		}
		result += ">";
		return result;
	}

	@Override
	public int hashCode() {
		return tuple.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tuple))
			return false;
		return tuple.equals(((Tuple) obj).tuple);
	}

	@Override
	public int compareTo(Tuple o) {
		for (int i = 0; i < o.size(); i++) {
			Long l1 = (Long) get(i); // TODO avoid cast (store Comparables)
			Long l2 = (Long) o.get(i);

			if (!l1.equals(l2)) {
				return -1;
			} // else continue with the for cycle
		}
		return 0;
	}

}
