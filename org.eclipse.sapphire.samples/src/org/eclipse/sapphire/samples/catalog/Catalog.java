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
import org.eclipse.sapphire.modeling.annotations.ReadOnly;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.CustomXmlListBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@XmlBinding( path = "Catalog" )

public interface Catalog extends Element
{
    ElementType TYPE = new ElementType( Catalog.class );
    
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
    
    // *** Categories ***
    
    @Type( base = Category.class )
    @ReadOnly
    @CustomXmlListBinding( impl = CategoriesBinding.class )
    
    ListProperty PROP_CATEGORIES = new ListProperty( TYPE, "Categories" );
    
    ElementList<Category> getCategories();
    
    // *** Manufacturers ***
    
    @Type( base = Manufacturer.class )
    @ReadOnly
    @CustomXmlListBinding( impl = ManufacturersBinding.class )
    
    ListProperty PROP_MANUFACTURERS = new ListProperty( TYPE, "Manufacturers" );
    
    ElementList<Manufacturer> getManufacturers();
    
}
