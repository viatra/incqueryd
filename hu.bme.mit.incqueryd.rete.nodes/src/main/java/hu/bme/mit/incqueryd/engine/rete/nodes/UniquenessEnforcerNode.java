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
package hu.bme.mit.incqueryd.engine.rete.nodes;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;

import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

public class UniquenessEnforcerNode implements AlphaNode {

	UniquenessEnforcerNode(final UniquenessEnforcerRecipe recipe) {
	}
	
	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
		return incomingChangeSet;
	}

}
