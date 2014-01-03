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
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.ReadOnly;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.samples.calendar.AttendeeType;
import org.eclipse.sapphire.samples.calendar.integrated.internal.AttendeeImageService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Service( impl = AttendeeImageService.class )

public interface IAttendee extends Element
{
    ElementType TYPE = new ElementType( IAttendee.class );
    
    // *** Name ***
    
    @Label( standard = "name" )
    @Required

    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );

    Value<String> getName();
    void setName( String name );
    
    // *** Type ***
    
    @Type( base = AttendeeType.class )
    @Label( standard = "type" )
    @DefaultValue( text = "REQUIRED" )

    ValueProperty PROP_TYPE = new ValueProperty( TYPE, "Type" );

    Value<AttendeeType> getType();
    void setType( String type );
    void setType( AttendeeType type );
    
    // *** InContactRepository ***
    
    @Type( base = Boolean.class )
    @Label( standard = "in contact repository" )
    @DefaultValue( text = "false" )
    @ReadOnly
    
    ValueProperty PROP_IN_CONTACT_REPOSITORY = new ValueProperty( TYPE, "InContactRepository" );
    
    Value<Boolean> isInContactRepository();
    
    // *** EMail ***
    
    @Label( standard = "E-Mail" )

    ValueProperty PROP_E_MAIL = new ValueProperty( TYPE, "EMail" );

    Value<String> getEMail();
    void setEMail( String email );
    
}
