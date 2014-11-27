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

/**
 * [...] alpha nodes are connected with an edge to a parent node (usually the input node or another alpha node); they
 * filter the contents of the parent node according to some constant criteria (e.g. type). [Bergmann's MSc thesis, p.27]
 * 
 * @author szarnyasg
 * 
 */
public interface AlphaNode extends ReteNode {

    public ChangeSet update(final ChangeSet incomingChangeSet);

}
