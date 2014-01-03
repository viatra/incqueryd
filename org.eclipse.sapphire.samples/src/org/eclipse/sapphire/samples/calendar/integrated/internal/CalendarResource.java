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

import java.util.List;

import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.LayeredListPropertyBinding;
import org.eclipse.sapphire.ListPropertyBinding;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.Property;
import org.eclipse.sapphire.PropertyBinding;
import org.eclipse.sapphire.PropertyDef;
import org.eclipse.sapphire.PropertyEvent;
import org.eclipse.sapphire.Resource;
import org.eclipse.sapphire.modeling.ResourceStoreException;
import org.eclipse.sapphire.samples.calendar.integrated.ICalendar;
import org.eclipse.sapphire.samples.calendar.integrated.IEvent;
import org.eclipse.sapphire.samples.contacts.ContactRepository;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class CalendarResource extends Resource
{
    private final org.eclipse.sapphire.samples.calendar.ICalendar base;
    private final ContactRepository contacts;
    
    public CalendarResource( final org.eclipse.sapphire.samples.calendar.ICalendar base,
                             final ContactRepository contacts )
    {
        super( null );
        
        this.base = base;
        this.contacts = contacts;
        
        final Listener listener = new FilteredListener<PropertyEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyEvent event )
            {
                final PropertyDef property = event.property().definition();
                final ICalendar calendar = (ICalendar) element(); 
                
                if( property == org.eclipse.sapphire.samples.calendar.ICalendar.PROP_EVENTS )
                {
                    calendar.getEvents().refresh();
                }
            }
        };
        
        this.base.attach( listener );
    }
    
    public org.eclipse.sapphire.samples.calendar.ICalendar getBase()
    {
        return this.base;
    }
    
    @Override
    @SuppressWarnings( "unchecked" )
    
    public <A> A adapt( final Class<A> adapterType )
    {
        A res;
        
        if( adapterType == ContactRepository.class )
        {
            res = (A) this.contacts;
        }
        else
        {
            res = super.adapt( adapterType );
            
            if( res == null )
            {
                res = this.base.adapt( adapterType );
            }
        }
        
        return res;
    }
    
    @Override
    protected PropertyBinding createBinding( final Property property )
    {
        if( property.definition() == ICalendar.PROP_EVENTS )
        {
            final ListPropertyBinding binding = new LayeredListPropertyBinding()
            {
                private final ElementList<org.eclipse.sapphire.samples.calendar.IEvent> base
                    = CalendarResource.this.base.getEvents();
                
                @Override
                public ElementType type( final Resource resource )
                {
                    return IEvent.TYPE;
                }

                @Override
                protected Resource resource( final Object obj )
                {
                    return new EventResource( CalendarResource.this, (org.eclipse.sapphire.samples.calendar.IEvent) obj );
                }
                
                @Override
                protected List<?> readUnderlyingList()
                {
                    return this.base;
                }

                @Override
                protected Object insertUnderlyingObject( final ElementType type,
                                                         final int position )
                {
                    return this.base.insert( org.eclipse.sapphire.samples.calendar.IEvent.TYPE, position );
                }

                @Override
                public void move( final Resource resource, 
                                  final int position )
                {
                    this.base.move( ( (EventResource) resource ).getBase(), position );
                }

                @Override
                public void remove( final Resource resource )
                {
                    this.base.remove( ( (EventResource) resource ).getBase() );
                }
            };
            
            return binding;
        }
        
        return null;
    }
    
    @Override
    
    public void save()
    
        throws ResourceStoreException
        
    {
        this.base.resource().save();
        this.contacts.resource().save();
    }
    
}
