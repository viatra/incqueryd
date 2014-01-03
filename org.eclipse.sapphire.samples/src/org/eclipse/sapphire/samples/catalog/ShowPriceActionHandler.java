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

public final class ShowPriceActionHandler extends SapphireActionHandler 
{
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
                setChecked( ShowPriceActionHandler.this.state.getShowPrice().content() );
            }
        };
        
        this.state.property( CatalogEditorPageState.PROP_SHOW_PRICE ).attach( listener );
        
        setChecked( this.state.getShowPrice().content() );
        
        attach
        (
            new FilteredListener<DisposeEvent>()
            {
                @Override
                protected void handleTypedEvent( final DisposeEvent event )
                {
                    ShowPriceActionHandler.this.state.property( CatalogEditorPageState.PROP_SHOW_PRICE ).detach( listener );
                }
            }
        );
    }

    @Override
    protected Object run( final Presentation context )
    {
        this.state.setShowPrice( ! this.state.getShowPrice().content() );
        
        return null;
    }
    
}

