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
package hu.bme.mit.incqueryd.engine.exceptions;

/**
 * 
 * @author szarnyasg
 *
 */
public class DatabaseClientException extends Exception {

    private static final long serialVersionUID = 1L;

    public DatabaseClientException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
