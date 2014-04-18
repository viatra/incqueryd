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

package org.eclipse.sapphire.samples.calendar.integrated;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.sapphire.ConversionService;
import org.eclipse.sapphire.Resource;
import org.eclipse.sapphire.samples.calendar.integrated.internal.CalendarResource;
import org.eclipse.sapphire.samples.contacts.ContactRepository;

/**
 * Implementation of ConversionService that is capable of converting an IFile to a Resource for the 
 * calendar sample.
 * 
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class CalendarResourceConversionService extends ConversionService<IFile,Resource>
{
    public CalendarResourceConversionService()
    {
        super( IFile.class, Resource.class );
    }

    @Override
    public Resource convert( final IFile file )
    {
        final org.eclipse.sapphire.samples.calendar.ICalendar calendarModel 
            = org.eclipse.sapphire.samples.calendar.ICalendar.TYPE.instantiate( file ); 
        
        final IFile contactsFile = file.getParent().getFile( new Path( "contacts.xml" ) );
        final ContactRepository contactsModel = ContactRepository.TYPE.instantiate( contactsFile );
        
        return new CalendarResource( calendarModel, contactsModel );
    }
    
}
