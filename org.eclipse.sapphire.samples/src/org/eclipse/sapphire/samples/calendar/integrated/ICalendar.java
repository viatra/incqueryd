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

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Service
(
    impl = CalendarResourceConversionService.class,
    overrides = "Sapphire.ConversionService.IFileToWorkspaceFileResourceStore"
)

public interface ICalendar extends Element
{
    ElementType TYPE = new ElementType( ICalendar.class );
    
    // *** Events ***

    @Type( base = IEvent.class )
    
    ListProperty PROP_EVENTS = new ListProperty( TYPE, "Events" );
    
    ElementList<IEvent> getEvents();
    
}
