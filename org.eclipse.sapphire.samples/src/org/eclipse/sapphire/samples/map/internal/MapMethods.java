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

package org.eclipse.sapphire.samples.map.internal;

import org.eclipse.sapphire.samples.map.Location;
import org.eclipse.sapphire.samples.map.Map;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class MapMethods 
{
    private MapMethods() {}
    
    public static Location findLocation( final Map map,
                                         final String name )
    {
        if( name == null )
        {
            throw new IllegalArgumentException();
        }
        
        for( Location location : map.getLocations() )
        {
            if( name.equals( location.getName().text() ) )
            {
                return location;
            }
        }
        
        return null;
    }

    public static boolean hasLocation( final Map map,
                                       final String name )
    {
        return ( findLocation( map, name ) != null );
    }

}
