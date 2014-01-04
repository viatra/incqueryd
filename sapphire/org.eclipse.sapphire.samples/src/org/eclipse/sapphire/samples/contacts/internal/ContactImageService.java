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

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.ImageData;
import org.eclipse.sapphire.ImageService;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.samples.contacts.Contact;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ContactImageService extends ImageService
{
    private static final ImageData IMG_PERSON = ImageData.readFromClassLoader( Contact.class, "Contact.png" ).required();
    private static final ImageData IMG_PERSON_FADED = ImageData.readFromClassLoader( Contact.class, "ContactFaded.png" ).required();
    
    private Listener listener;
    
    @Override
    protected void initImageService()
    {
        this.listener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                refresh();
            }
        };
        
        context( Element.class ).attach( this.listener, "EMail" );
    }

    @Override
    protected ImageData compute()
    {
        if( context( Contact.class ).getEMail().content() == null )
        {
            return IMG_PERSON_FADED;
        }
        else
        {
            return IMG_PERSON;
        }
    }

    @Override
    public void dispose()
    {
        super.dispose();
        
        context( Element.class ).detach( this.listener, "EMail" );
    }
    
}
