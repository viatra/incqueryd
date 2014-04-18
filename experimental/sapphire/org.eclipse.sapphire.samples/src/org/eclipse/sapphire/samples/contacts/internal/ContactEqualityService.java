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

import static org.eclipse.sapphire.modeling.util.MiscUtil.equal;

import org.eclipse.sapphire.samples.contacts.Contact;
import org.eclipse.sapphire.services.EqualityService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ContactEqualityService extends EqualityService
{
    @Override
    public boolean doEquals( final Object obj )
    {
        if( obj instanceof Contact )
        {
            final Contact c1 = context( Contact.class );
            final Contact c2 = (Contact) obj;
            
            return equal( c1.getName().text(), c2.getName().text() );
        }
        else
        {
            return false;
        }
    }

    @Override
    public int doHashCode()
    {
        final Contact c = context( Contact.class );
        final String name = c.getName().text();
        
        return ( name == null ? 1 : name.hashCode() );
    }
    
}
