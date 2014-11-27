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
import hu.bme.mit.incqueryd.engine.rete.nodes.BetaNode;

/**
 * Algorithms for using the Rete nodes.
 * 
 * @author szarnyasg
 * 
 */
public class Algorithms {

	public static ChangeSet join(final BetaNode joinNode, final ChangeSet primaryChangeSet,
			final ChangeSet secondaryChangeSet) {
		// this is the correct order for the antijoin operations
		// new tuples from the secondary slot
		// final ChangeSet joinedTuples1 =
//		joinNode.update(secondaryChangeSet, ReteNodeSlot.SECONDARY);
		// new tuples from the primary slot

		return null;
	}

}
