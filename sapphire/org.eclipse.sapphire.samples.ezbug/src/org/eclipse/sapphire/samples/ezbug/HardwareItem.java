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

package org.eclipse.sapphire.samples.ezbug;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface HardwareItem extends Element
{
    ElementType TYPE = new ElementType( HardwareItem.class );
    
    // *** Type ***
    
    @Type( base = HardwareType.class )
    @XmlBinding( path = "type" )
    @Label( standard = "type" )
    @Required

    ValueProperty PROP_TYPE = new ValueProperty( TYPE, "Type" );

    Value<HardwareType> getType();
    void setType( String value );
    void setType( HardwareType value );
    
    // *** Make ***
    
    @XmlBinding( path = "make" )
    @Label( standard = "make" )
    @Required

    ValueProperty PROP_MAKE = new ValueProperty( TYPE, "Make" );

    Value<String> getMake();
    void setMake( String value );
    
    // *** ItemModel ***
    
    @XmlBinding( path = "model" )
    @Label( standard = "model" )

    ValueProperty PROP_ITEM_MODEL = new ValueProperty( TYPE, "ItemModel" );

    Value<String> getItemModel();
    void setItemModel( String value );

    // *** Description ***
    
    @XmlBinding( path = "description" )
    @Label( standard = "description" )
    @LongString

    ValueProperty PROP_DESCRIPTION = new ValueProperty( TYPE, "Description" );

    Value<String> getDescription();
    void setDescription( String value );

}
