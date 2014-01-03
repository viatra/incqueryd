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

package org.eclipse.sapphire.samples.calendar.integrated.internal;

import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.Property;
import org.eclipse.sapphire.PropertyBinding;
import org.eclipse.sapphire.PropertyDef;
import org.eclipse.sapphire.PropertyEvent;
import org.eclipse.sapphire.Resource;
import org.eclipse.sapphire.ValuePropertyBinding;
import org.eclipse.sapphire.samples.calendar.integrated.IEventAttachment;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class EventAttachmentResource extends Resource
{
    private final org.eclipse.sapphire.samples.calendar.IEventAttachment base;
    
    public EventAttachmentResource( final Resource parent,
                                    final org.eclipse.sapphire.samples.calendar.IEventAttachment base )
    {
        super( parent );
        
        this.base = base;
        
        final Listener listener = new FilteredListener<PropertyEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyEvent event )
            {
                final PropertyDef property = event.property().definition();
                final IEventAttachment attachment = (IEventAttachment) element();
                
                if( property == org.eclipse.sapphire.samples.calendar.IEventAttachment.PROP_LOCAL_COPY_LOCATION )
                {
                    attachment.getLocalCopyLocation().refresh();
                }
                else if( property == org.eclipse.sapphire.samples.calendar.IEventAttachment.PROP_PUBLIC_COPY_LOCATION )
                {
                    attachment.getPublicCopyLocation().refresh();
                }
            }
        };
        
        this.base.attach( listener );
    }
    
    public org.eclipse.sapphire.samples.calendar.IEventAttachment getBase()
    {
        return this.base;
    }
    
    @Override
    protected PropertyBinding createBinding( final Property property )
    {
        final PropertyDef pdef = property.definition();
        
        if( pdef == IEventAttachment.PROP_LOCAL_COPY_LOCATION )
        {
            return new ValuePropertyBinding()
            {
                @Override
                public String read()
                {
                    return getBase().getLocalCopyLocation().text( false );
                }
                
                @Override
                public void write( String value )
                {
                    getBase().setLocalCopyLocation( value );
                }
            };
        }
        else if( pdef == IEventAttachment.PROP_PUBLIC_COPY_LOCATION )
        {
            return new ValuePropertyBinding()
            {
                @Override
                public String read()
                {
                    return getBase().getPublicCopyLocation().text( false );
                }
                
                @Override
                public void write( String value )
                {
                    getBase().setPublicCopyLocation( value );
                }
            };
        }
        
        return null;
    }

    @Override
    public <A> A adapt( final Class<A> adapterType )
    {
        A res = super.adapt( adapterType );
        
        if( res == null )
        {
            res = this.base.adapt( adapterType );
        }
        
        return res;
    }

}
