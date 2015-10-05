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
import java.util.Set;

/**
 * Class for storing the change set: a collection of tuples and the type of change (positive or negative)
 * 
 * @author szarnyasg
 * 
 */
public class ChangeSet implements Serializable {

	private static final long serialVersionUID = 1L;
	protected Set<Tuple> tuples;
	protected ChangeType changeType;

	public ChangeSet(final Set<Tuple> tuples, final ChangeType changeType) {
		super();
		this.tuples = tuples;
		this.changeType = changeType;
	}

	public Set<Tuple> getTuples() {
		return tuples;
	}

	public ChangeType getChangeType() {
		return changeType;
	}

	@Override
	public String toString() {
		return "ChangeSet: changeType=" + changeType + ", " + getTuples().size() + " tuples, [tuples=" + tuples + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((changeType == null) ? 0 : changeType.hashCode());
		result = prime * result + ((tuples == null) ? 0 : tuples.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChangeSet other = (ChangeSet) obj;
		if (changeType != other.changeType)
			return false;
		if (tuples == null) {
			if (other.tuples != null)
				return false;
		} else if (!tuples.equals(other.tuples))
			return false;
		return true;
	}

	public int size() {
		return tuples.size();
	}
	
}
