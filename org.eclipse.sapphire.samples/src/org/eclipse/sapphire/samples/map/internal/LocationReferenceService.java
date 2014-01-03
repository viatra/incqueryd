/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Shenxue Zhou - initial implementation and ongoing maintenance
 *    Konstantin Komissarchik - miscellaneous improvements
 ******************************************************************************/

package org.eclipse.sapphire.samples.map.internal;

import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.samples.map.Location;
import org.eclipse.sapphire.samples.map.Map;
import org.eclipse.sapphire.services.ReferenceService;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public class LocationReferenceService extends ReferenceService 
{
    private Listener listener;
    
    @Override
    protected void init()
    {
        super.init();
        
        this.listener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                broadcast();
            }
        };
        
        context( Map.class ).attach( this.listener, "Locations/Name" );
    }

    @Override
    public Object resolve(String reference) 
    {
        if (reference != null)
        {
            Map map = context( Map.class );
            for (Location location : map.getLocations())
            {
                if (reference.equals(location.getName().content()))
                {
                    return location;
                }
            }
        }
        return null;
    }

    @Override
    public void dispose()
    {
        context( Map.class ).detach( this.listener, "Locations/Name" );
        
        super.dispose();
    }

}
