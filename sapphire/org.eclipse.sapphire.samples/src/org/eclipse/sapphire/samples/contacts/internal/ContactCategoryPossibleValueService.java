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

import java.util.Set;

import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.samples.contacts.Contact;
import org.eclipse.sapphire.samples.contacts.ContactRepository;
import org.eclipse.sapphire.services.PossibleValuesService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ContactCategoryPossibleValueService extends PossibleValuesService
{
    @Override
    protected void fillPossibleValues( final Set<String> values )
    {
        values.add( "Personal" );
        
        final Contact c = context( Contact.class );
        final ContactRepository cdb = c.nearest( ContactRepository.class );
        
        if( cdb != null )
        {
            for( Contact contact : cdb.getContacts() )
            {
                if( contact != c )
                {
                    values.add( contact.getCategory().text( true ) );
                }
            }
        }
    }

    @Override
    public Status.Severity getInvalidValueSeverity( final String invalidValue )
    {
        return Status.Severity.OK;
    }
    
}
