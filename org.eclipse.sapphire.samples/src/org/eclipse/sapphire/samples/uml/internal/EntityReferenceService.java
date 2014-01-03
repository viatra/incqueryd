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

package org.eclipse.sapphire.samples.uml.internal;

import org.eclipse.sapphire.samples.uml.Entity;
import org.eclipse.sapphire.services.ReferenceService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class EntityReferenceService extends ReferenceService
{
    @Override
    public Object resolve( final String reference ) 
    {
        if( reference != null )
        {
            for( final Entity entity : context( org.eclipse.sapphire.samples.uml.System.class ).getEntities() )
            {
                if( reference.equals( entity.getName().text() ) )
                {
                    return entity;
                }
            }
        }
        
        return null;
    }

}
