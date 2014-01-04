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

import java.util.Set;

import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.samples.gallery.CustomColor;
import org.eclipse.sapphire.samples.gallery.IGallery;
import org.eclipse.sapphire.services.PossibleValuesService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ColorPossibleValuesService extends PossibleValuesService
{
    private final Listener listener = new FilteredListener<PropertyContentEvent>()
    {
        @Override
        protected void handleTypedEvent( final PropertyContentEvent event )
        {
            broadcast();
        }
    };
    
    @Override
    protected void init()
    {
        super.init();
        
        context( IGallery.class ).attach( this.listener, "/CustomColors/Name" );
    }

    @Override
    protected void fillPossibleValues( final Set<String> values )
    {
        values.add( "Red" );
        values.add( "Orange" );
        values.add( "Yellow" );
        values.add( "Green" );
        values.add( "Blue" );
        values.add( "Violet" );
        
        final IGallery gallery = context( IGallery.class );
        
        for( CustomColor color : gallery.getCustomColors() )
        {
            final String name = color.getName().text();
            
            if( name != null )
            {
                values.add( name );
            }
        }
    }
    
    @Override
    public boolean isCaseSensitive()
    {
        return false;
    }

    @Override
    public void dispose()
    {
        super.dispose();
        
        context( IGallery.class ).detach( this.listener, "/CustomColors/Name" );
    }

}
