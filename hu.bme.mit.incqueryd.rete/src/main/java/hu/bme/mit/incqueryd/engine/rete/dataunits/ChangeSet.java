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
		return "ChangeSet, changeType=" + changeType + ", " + getTuples().size() + " tuples, [tuples=" + tuples + "]";
	}

	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof ChangeSet))
			return false;
		final ChangeSet changeSet = (ChangeSet) o;

		// comparing fields
		return getChangeType().equals(changeSet.getChangeType()) //
				&& getTuples().equals(changeSet.getTuples());
	}

}
