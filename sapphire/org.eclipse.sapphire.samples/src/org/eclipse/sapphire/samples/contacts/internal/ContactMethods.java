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

import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.samples.contacts.Contact;
import org.eclipse.sapphire.samples.contacts.PhoneNumber;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ContactMethods
{
    public static void removePhoneNumbersByAreaCode( final Contact contact,
                                                     final String areaCode )
    {
        final ElementList<PhoneNumber> list = contact.getPhoneNumbers();
        
        for( PhoneNumber pn : list )
        {
            if( areaCode.equals( pn.getAreaCode().text() ) )
            {
                list.remove( pn );
            }
        }
    }
}
