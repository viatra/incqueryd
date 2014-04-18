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

package org.eclipse.sapphire.samples.catalog;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Item extends Element
{
    ElementType TYPE = new ElementType( Item.class );
    
    // *** Name ***
    
    @Required
    @XmlBinding( path = "Name" )
    
    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );
    
    Value<String> getName();
    void setName( String value );
    
    // *** Category ***
    
    @PossibleValues( property = "/Items/Category", caseSensitive = false, invalidValueSeverity = Status.Severity.OK )
    @XmlBinding( path = "Category" )
    
    ValueProperty PROP_CATEGORY = new ValueProperty( TYPE, "Category" );
    
    Value<String> getCategory();
    void setCategory( String value );
    
    // *** Manufacturer ***
    
    @PossibleValues( property = "/Items/Manufacturer", caseSensitive = false, invalidValueSeverity = Status.Severity.OK )
    @XmlBinding( path = "Manufacturer" )
    
    ValueProperty PROP_MANUFACTURER = new ValueProperty( TYPE, "Manufacturer" );
    
    Value<String> getManufacturer();
    void setManufacturer( String value );

    // *** Description ***
    
    @LongString
    @XmlBinding( path = "Description" )
    
    ValueProperty PROP_DESCRIPTION = new ValueProperty( TYPE, "Description" );
    
    Value<String> getDescription();
    void setDescription( String value );
    
}
