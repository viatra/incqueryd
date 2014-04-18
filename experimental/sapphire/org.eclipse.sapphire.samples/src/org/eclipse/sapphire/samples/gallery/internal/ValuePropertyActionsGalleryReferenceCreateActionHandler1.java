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

import org.eclipse.sapphire.DisposeEvent;
import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.samples.gallery.IValuePropertyActionsGallery;
import org.eclipse.sapphire.samples.gallery.IValuePropertyActionsGalleryEntity;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireAction;
import org.eclipse.sapphire.ui.def.ActionHandlerDef;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ValuePropertyActionsGalleryReferenceCreateActionHandler1 extends ValuePropertyActionsGalleryReferenceCreateActionHandlerBase
{
    @Override
    public void init( final SapphireAction action,
                      final ActionHandlerDef def )
    {
        super.init( action, def );
        
        final Listener listener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                refreshActionState();
            }
        };
        
        final Element element = getModelElement();
        final IValuePropertyActionsGallery gallery = element.nearest( IValuePropertyActionsGallery.class );
        final String propertyName = property().name();
        
        gallery.attach( listener, "Entities/*" );
        element.attach( listener, propertyName );
        
        refreshActionState();
        
        attach
        (
            new FilteredListener<DisposeEvent>()
            {
                @Override
                protected void handleTypedEvent( final DisposeEvent event )
                {
                    gallery.detach( listener, "Entities/*" );
                    element.detach( listener, propertyName );
                }
            }
        );
    }
    
    private void refreshActionState()
    {
        final String entityName = ( (Value<?>) property() ).text();
        
        final boolean newEnablementState = ( entityName != null && ! isEntityDefined( entityName ) );
        setEnabled( newEnablementState );
        
        final String newLabel = ( entityName == null ? "create" : "create " + entityName );
        setLabel( newLabel );
    }

    @Override
    protected Object run( final Presentation context )
    {
        final Element element = getModelElement();
        final String entityName = ( (Value<?>) property() ).text();
        
        if( entityName != null && ! isEntityDefined( entityName ) )
        {
            final IValuePropertyActionsGalleryEntity entity = element.nearest( IValuePropertyActionsGallery.class ).getEntities().insert();
            entity.setName( entityName );
        }
        
        return null;
    }
    
}
