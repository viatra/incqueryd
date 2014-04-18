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

package org.eclipse.sapphire.samples.contacts.internal;

import org.eclipse.sapphire.DisposeEvent;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.Property;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.samples.contacts.Contact;
import org.eclipse.sapphire.samples.contacts.ContactRepository;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireAction;
import org.eclipse.sapphire.ui.SapphireActionHandler;
import org.eclipse.sapphire.ui.def.ActionHandlerDef;
import org.eclipse.sapphire.ui.forms.PropertyEditorPart;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class CreateContactActionHandler extends SapphireActionHandler
{
    private Property property;
    
    @Override
    public void init( final SapphireAction action,
                      final ActionHandlerDef def )
    {
        super.init( action, def );
        
        this.property = ( (PropertyEditorPart) getPart() ).property();
        
        final Listener listener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                refreshEnablementState();
            }
        };
        
        this.property.element().nearest( ContactRepository.class ).attach( listener, "Contacts/Name" );
        this.property.attach( listener );
        
        refreshEnablementState();
        
        attach
        (
            new FilteredListener<DisposeEvent>()
            {
                @Override
                protected void handleTypedEvent( final DisposeEvent event )
                {
                    CreateContactActionHandler.this.property.element().nearest( ContactRepository.class ).detach( listener, "Contacts/Name" );
                    CreateContactActionHandler.this.property.detach( listener );
                }
            }
        );
    }
    
    private void refreshEnablementState()
    {
        final String name = ( (Value<?>) this.property ).text();
        final ContactRepository cdb = this.property.element().nearest( ContactRepository.class );
        
        boolean enabled;
        
        if( name == null )
        {
            enabled = false;
        }
        else
        {
            enabled = true;
            
            for( Contact contact : cdb.getContacts() )
            {
                if( name.equals( contact.getName().text() ) )
                {
                    enabled = false;
                    break;
                }
            }
        }
        
        setEnabled( enabled );
    }

    @Override
    protected Object run( final Presentation context )
    {
        final String name = ( (Value<?>) this.property ).text();
        final ContactRepository cdb = this.property.element().nearest( ContactRepository.class );
        
        final Contact newContact = cdb.getContacts().insert();
        newContact.setName( name );
        
        return null;
    }
    
}
