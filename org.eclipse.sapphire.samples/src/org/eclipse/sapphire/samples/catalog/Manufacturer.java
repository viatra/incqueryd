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
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Manufacturer extends Element
{
    ElementType TYPE = new ElementType( Manufacturer.class );
    
    // *** Name ***
    
    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );
    
    Value<String> getName();
    void setName( String value );
    
    // *** Items ***
    
    @Type( base = Item.class, possible = { SingleVariantItem.class, MultiVariantItem.class } )
    
    @XmlListBinding
    (
        mappings = 
        {
            @XmlListBinding.Mapping( element = "Item", type = SingleVariantItem.class ),
            @XmlListBinding.Mapping( element = "MultiVariantItem", type = MultiVariantItem.class )
        }
    )
    
    ListProperty PROP_ITEMS = new ListProperty( TYPE, "Items" );
    
    ElementList<Item> getItems();
    
}
