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
package hu.bme.mit.incqueryd.engine.rete.nodes.data;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.util.List;
import java.util.Set;

public class TestData {

	protected Set<Tuple> primarySet;
	protected Set<Tuple> secondarySet;
	protected List<Change> changes;
	protected List<ChangeSet> expectedChangeSets;
	
	public TestData(final Set<Tuple> primarySet, final Set<Tuple> secondarySet,
			final List<Change> changes, final List<ChangeSet> expectedChangeSets) {
		super();
		this.primarySet = primarySet;
		this.secondarySet = secondarySet;
		this.changes = changes;
		this.expectedChangeSets = expectedChangeSets;
	}

	public Set<Tuple> getPrimarySet() {
		return primarySet;
	}

	public Set<Tuple> getSecondarySet() {
		return secondarySet;
	}

	public List<Change> getChanges() {
		return changes;
	}

	public List<ChangeSet> getExpectedChangeSets() {
		return expectedChangeSets;
	}
	
}
