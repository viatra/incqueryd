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

package org.eclipse.sapphire.samples.calendar;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Image;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Image( path = "org/eclipse/sapphire/samples/contacts/Contact.png" )

public interface IAttendee extends Element
{
    ElementType TYPE = new ElementType( IAttendee.class );

    // *** Name ***
    
    @Label( standard = "name" )
    @Required
    @XmlBinding( path = "name" )

    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );

    Value<String> getName();
    void setName( String name );
    
    // *** Type ***
    
    @Type( base = AttendeeType.class )
    @Label( standard = "type" )
    @DefaultValue( text = "REQUIRED" )
    @XmlBinding( path = "type" )

    ValueProperty PROP_TYPE = new ValueProperty( TYPE, "Type" );

    Value<AttendeeType> getType();
    void setType( String type );
    void setType( AttendeeType type );
    
}
