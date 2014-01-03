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

package org.eclipse.sapphire.samples.calendar.ui;

import java.util.List;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.samples.calendar.integrated.CalendarEditor;
import org.eclipse.sapphire.samples.calendar.integrated.IAttendee;
import org.eclipse.sapphire.samples.contacts.Contact;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.forms.JumpActionHandler;
import org.eclipse.sapphire.ui.forms.MasterDetailsContentNodePart;
import org.eclipse.sapphire.ui.forms.MasterDetailsContentOutline;
import org.eclipse.sapphire.ui.forms.MasterDetailsEditorPagePart;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ContactDetailsJumpHandler extends JumpActionHandler
{
    @Override
    protected void initDependencies( final List<String> dependencies )
    {
        super.initDependencies( dependencies );
        dependencies.add( IAttendee.PROP_IN_CONTACT_REPOSITORY.name() );
    }

    @Override
    protected boolean computeEnablementState()
    {
        if( super.computeEnablementState() == true )
        {
            final IAttendee attendee = (IAttendee) getModelElement();
            return attendee.isInContactRepository().content();
        }
        
        return false;
    }

    @Override
    protected Object run( final Presentation context )
    {
        final CalendarEditor editor = context.part().nearest( CalendarEditor.class );
        jump( editor, getModelElement() );
        return null;
    }

    public static void jump( final CalendarEditor editor,
                             final Element modelElement )
    {
        final IAttendee attendee = (IAttendee) modelElement;
        final String name = attendee.getName().text();
        
        if( name != null )
        {
            Contact contact = null;
            
            for( Contact c : editor.getContactRepository().getContacts() )
            {
                if( name.equals( c.getName().text() ) )
                {
                    contact = c;
                    break;
                }
            }
            
            if( contact != null )
            {
                final MasterDetailsEditorPagePart contactsFormPage = (MasterDetailsEditorPagePart) editor.getEditorPagePart( "Contacts" );
                final MasterDetailsContentOutline outline = contactsFormPage.outline();
                final MasterDetailsContentNodePart contactNode = outline.getRoot().findNode( contact );
                
                if( contactNode != null )
                {
                    contactNode.select();
                    editor.showPage( contactsFormPage );
                }
            }
        }
    }
    
}
