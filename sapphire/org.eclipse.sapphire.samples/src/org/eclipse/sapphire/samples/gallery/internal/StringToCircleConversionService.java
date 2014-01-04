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

package org.eclipse.sapphire.samples.gallery.internal;

import org.eclipse.sapphire.ConversionService;
import org.eclipse.sapphire.samples.gallery.Circle;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class StringToCircleConversionService extends ConversionService<String,Circle>
{
    public StringToCircleConversionService()
    {
        super( String.class, Circle.class );
    }

    @Override
    public Circle convert( final String string )
    {
        final String[] segments = string.split( "," );
        
        if( segments.length == 3 )
        {
            try
            {
                final int x = Integer.parseInt( segments[ 0 ].trim() );
                final int y = Integer.parseInt( segments[ 1 ].trim() );
                final int radius = Integer.parseInt( segments[ 2 ].trim() );
                
                return new Circle( x, y, radius );
            }
            catch( NumberFormatException e )
            {
                // Intentionally ignored.
            }
        }
        
        return null;
    }

}
