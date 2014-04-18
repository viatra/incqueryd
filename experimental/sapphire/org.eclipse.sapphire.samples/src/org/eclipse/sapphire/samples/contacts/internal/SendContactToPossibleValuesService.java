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
import org.eclipse.sapphire.samples.contacts.SendContactOp;
import org.eclipse.sapphire.services.PossibleValuesService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class SendContactToPossibleValuesService extends PossibleValuesService
{
    @Override
    protected void fillPossibleValues( final Set<String> values )
    {
        final SendContactOp op = context( SendContactOp.class );
        final Contact contact = op.getContact().content();
        
        if( contact != null )
        {
            for( Contact c : contact.nearest( ContactRepository.class ).getContacts() )
            {
                final String email = c.getEMail().text();
                
                if( email != null )
                {
                    values.add( email );
                }
            }
        }
    }

    @Override
    public Status.Severity getInvalidValueSeverity( String invalidValue )
    {
        return Status.Severity.OK;
    }
    
}
