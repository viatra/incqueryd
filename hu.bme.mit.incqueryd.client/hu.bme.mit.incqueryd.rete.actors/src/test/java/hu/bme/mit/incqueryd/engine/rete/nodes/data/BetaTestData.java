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

/**
 * 
 * @author szarnyasg
 * 
 */
public class BetaTestData {

	protected ChangeSet primaryChangeSet;
	protected ChangeSet secondaryChangeSet;
	protected ChangeSet expectedFirstChangeSet;
	protected ChangeSet expectedSecondChangeSet;

	public BetaTestData(final ChangeSet primaryChangeSet, final ChangeSet secondaryChangeSet,
			final ChangeSet expectedFirstChangeSet, final ChangeSet expectedSecondChangeSet) {
		super();
		this.primaryChangeSet = primaryChangeSet;
		this.secondaryChangeSet = secondaryChangeSet;
		this.expectedFirstChangeSet = expectedFirstChangeSet;
		this.expectedSecondChangeSet = expectedSecondChangeSet;
	}

	public ChangeSet getPrimaryChangeSet() {
		return primaryChangeSet;
	}

	public ChangeSet getSecondaryChangeSet() {
		return secondaryChangeSet;
	}

	public ChangeSet getExpectedFirstChangeSet() {
		return expectedFirstChangeSet;
	}
	
	public ChangeSet getExpectedSecondChangeSet() {
		return expectedSecondChangeSet;
	}
}
