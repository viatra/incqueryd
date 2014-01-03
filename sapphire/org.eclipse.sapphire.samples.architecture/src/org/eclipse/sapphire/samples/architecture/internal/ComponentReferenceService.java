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

package org.eclipse.sapphire.samples.architecture.internal;

import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.samples.architecture.ArchitectureSketch;
import org.eclipse.sapphire.samples.architecture.Component;
import org.eclipse.sapphire.services.ReferenceService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ComponentReferenceService extends ReferenceService
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
        
        context( ArchitectureSketch.class ).attach( this.listener, "Components/Name" );
    }

    @Override
    public Object resolve( final String reference ) 
    {
        if( reference != null )
        {
            final ArchitectureSketch arch = context( ArchitectureSketch.class );
            
            for( Component component : arch.getComponents() )
            {
                if( reference.equals( component.getName().text() ) )
                {
                    return component;
                }
            }
        }
        
        return null;
    }

    @Override
    public void dispose()
    {
        context( ArchitectureSketch.class ).detach( this.listener, "Components/Name" );
        
        super.dispose();
    }

}
