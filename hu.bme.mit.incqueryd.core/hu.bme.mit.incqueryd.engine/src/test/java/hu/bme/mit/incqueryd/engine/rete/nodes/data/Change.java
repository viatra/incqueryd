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
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;

/**
 * 
 * @author makaij
 *
 */
public class Change {

	protected ChangeSet changeSet;
	protected ReteNodeSlot changeSlot;
	
	public Change(final ChangeSet changeSet, final ReteNodeSlot changeSlot) {
		super();
		this.changeSet = changeSet;
		this.changeSlot = changeSlot;
	}
	
	public ChangeSet getChangeSet() {
		return changeSet;
	}
	
	public ReteNodeSlot getChangeSlot() {
		return changeSlot;
	}
	
}
