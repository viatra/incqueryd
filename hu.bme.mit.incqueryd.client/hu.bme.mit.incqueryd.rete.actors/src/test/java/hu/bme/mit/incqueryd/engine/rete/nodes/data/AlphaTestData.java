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

public class AlphaTestData {
    
	protected ChangeSet incomingChangeSet;
    protected ChangeSet expectedChangeSet;
    
    public AlphaTestData(final ChangeSet incomingChangeSet, final ChangeSet expectedChangeSet) {
		this.incomingChangeSet = incomingChangeSet;
		this.expectedChangeSet = expectedChangeSet;
	}
    
    public ChangeSet getIncomingChangeSet() {
		return incomingChangeSet;
	}
  
    public ChangeSet getExpectedChangeSet() {
		return expectedChangeSet;
	}
    
}
