/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation and ongoing maintenance
 ******************************************************************************/

package hu.bme.mit.incqueryd.reteeditor.iternal;

import hu.bme.mit.incqueryd.reteeditor.AlphaNode;

import org.eclipse.sapphire.services.ReferenceService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class AlphaNodeReferenceService extends ReferenceService {
	@Override
	public Object resolve(final String reference) {
		if (reference != null) {
			for (final AlphaNode alphaNode : context(hu.bme.mit.incqueryd.reteeditor.ReteNetwork.class).getAlphaNodes()) {
				if (reference.equals(alphaNode.getName().text())) {
					return alphaNode;
				}
			}
		}

		return null;
	}

}
