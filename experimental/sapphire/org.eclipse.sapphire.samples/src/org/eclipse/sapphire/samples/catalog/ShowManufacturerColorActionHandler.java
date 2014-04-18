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

package org.eclipse.sapphire.samples.catalog;

import org.eclipse.sapphire.DisposeEvent;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireAction;
import org.eclipse.sapphire.ui.SapphireActionHandler;
import org.eclipse.sapphire.ui.SapphireEditorPagePart;
import org.eclipse.sapphire.ui.def.ActionHandlerDef;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ShowManufacturerColorActionHandler extends SapphireActionHandler 
{
    public static final String ATTRIBUTE = "ColorCode";
    
    private CatalogEditorPageState state;
    
    @Override
    public void init( final SapphireAction action,
                      final ActionHandlerDef def )
    {
        super.init( action, def );
        
        this.state = (CatalogEditorPageState) getPart().nearest( SapphireEditorPagePart.class ).state();
        
        final Listener listener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                setChecked( ShowManufacturerColorActionHandler.this.state.getAttribute( ATTRIBUTE, false ) );
            }
        };
        
        this.state.attach( listener, CatalogEditorPageState.PROP_ATTRIBUTES.name() + "/*" );
        
        setChecked( this.state.getAttribute( ATTRIBUTE, false ) );
        
        attach
        (
            new FilteredListener<DisposeEvent>()
            {
                @Override
                protected void handleTypedEvent( final DisposeEvent event )
                {
                    ShowManufacturerColorActionHandler.this.state.detach( listener, CatalogEditorPageState.PROP_ATTRIBUTES.name() + "/*" );
                }
            }
        );
    }

    @Override
    protected Object run( final Presentation context )
    {
        this.state.setAttribute( ATTRIBUTE, ! this.state.getAttribute( ATTRIBUTE, false ) );
        
        return null;
    }
    
}

