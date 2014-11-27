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

import java.util.List;


/**
 *
 * @author szarnyasg
 *
 */
public class TupleMask {

    public static Tuple project(final Tuple tuple, final List<Integer> mask) {
        final Object[] result = new Object[mask.size()];
        for (int i = 0; i < mask.size(); i++) {
            result[i] = tuple.get(mask.get(i));
        }
        return new Tuple(result);
    }

}
