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
import org.eclipse.sapphire.samples.calendar.integrated.IAttendee;
import org.eclipse.sapphire.samples.contacts.Contact;
import org.eclipse.sapphire.samples.contacts.ContactRepository;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class AttendeeResource extends Resource
{
    private final org.eclipse.sapphire.samples.calendar.IAttendee base;
    private final ContactRepository contacts;
    private final Listener listener;
    
    public AttendeeResource( final Resource parent,
                             final org.eclipse.sapphire.samples.calendar.IAttendee base )
    {
        super( parent );
        
        this.base = base;
        this.contacts = adapt( ContactRepository.class );
        
        this.listener = new FilteredListener<PropertyEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyEvent event )
            {
                final PropertyDef property = event.property().definition();
                final IAttendee attendee = (IAttendee) element();
                
                if( property == org.eclipse.sapphire.samples.calendar.IAttendee.PROP_NAME )
                {
                    attendee.getName().refresh();
                    attendee.isInContactRepository().refresh();
                    attendee.getEMail().refresh();
                }
                else if( property == org.eclipse.sapphire.samples.calendar.IAttendee.PROP_TYPE )
                {
                    attendee.getType().refresh();
                }
                else if( property == ContactRepository.PROP_CONTACTS )
                {
                    attendee.isInContactRepository().refresh();
                    attendee.getEMail().refresh();
                }
                else if( property == Contact.PROP_NAME )
                {
                    attendee.isInContactRepository().refresh();
                    attendee.getEMail().refresh();
                }
                else if( property == Contact.PROP_E_MAIL )
                {
                    attendee.getEMail().refresh();
                }
            }
        };
        
        this.base.attach( this.listener );
        this.contacts.attach( this.listener );
    }
    
    public org.eclipse.sapphire.samples.calendar.IAttendee getBase()
    {
        return this.base;
    }
    
    @Override
    protected PropertyBinding createBinding( final Property property )
    {
        final PropertyDef pdef = property.definition();
        
        if( pdef == IAttendee.PROP_NAME )
        {
            return new ValuePropertyBinding()
            {
                @Override
                public String read()
                {
                    return getBase().getName().text( false );
                }
                
                @Override
                public void write( final String value )
                {
                    getBase().setName( value );
                }
            };
        }
        else if( pdef == IAttendee.PROP_TYPE )
        {
            return new ValuePropertyBinding()
            {
                @Override
                public String read()
                {
                    return getBase().getType().text( false );
                }
                
                @Override
                public void write( final String value )
                {
                    getBase().setType( value );
                }
            };
        }
        else if( pdef == IAttendee.PROP_E_MAIL )
        {
            return new ValuePropertyBinding()
            {
                @Override
                public String read()
                {
                    final Contact c = findContactRecord( false );
                    return ( c != null ? c.getEMail().text() : null );
                }
                
                @Override
                public void write( final String value )
                {
                    final Contact c = findContactRecord( value != null );
                    
                    if( c != null )
                    {
                        c.setEMail( value );
                    }
                }
            };
        }
        else if( pdef == IAttendee.PROP_IN_CONTACT_REPOSITORY )
        {
            return new ValuePropertyBinding()
            {
                @Override
                public String read()
                {
                    return ( findContactRecord( false ) != null ? Boolean.TRUE.toString() : null );
                }
                
                @Override
                public void write( final String value )
                {
                    throw new UnsupportedOperationException();
                }
            };
        }
        
        return null;
    }

    private Contact findContactRecord( final boolean createIfNecessary )
    {
        Contact c = null;
        final String name = this.base.getName().text();
        
        if( name != null )
        {
            for( Contact contact : this.contacts.getContacts() )
            {
                if( name.equals( contact.getName().text() ) )
                {
                    c = contact;
                    break;
                }
            }
    
            if( c == null && createIfNecessary )
            {
                c = this.contacts.getContacts().insert();
                c.setName( name );
            }
    
            for( Contact contact : this.contacts.getContacts() )
            {
                contact.attach( this.listener );
            }
        }
        
        return c;
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

    @Override
    public void dispose()
    {
        super.dispose();
        
        this.base.detach( this.listener );
        this.contacts.detach( this.listener );
    }

}
