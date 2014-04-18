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

package org.eclipse.sapphire.samples.gallery;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;
import org.eclipse.sapphire.samples.gallery.internal.ListPropertyCustomGalleryServices;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface ListPropertyCustomGallery extends Element
{
    ElementType TYPE = new ElementType( ListPropertyCustomGallery.class );
    
    // *** AllowChildElementWithInteger ***
    
    @Type( base = Boolean.class )
    @Label( standard = "allow child element with integer" )
    @DefaultValue( text = "true" )
    @XmlBinding( path = "allow-child-with-integer" )
    
    ValueProperty PROP_ALLOW_CHILD_ELEMENT_WITH_INTEGER = new ValueProperty( TYPE, "AllowChildElementWithInteger" );
    
    Value<Boolean> getAllowChildElementWithInteger();
    void setAllowChildElementWithInteger( String value );
    void setAllowChildElementWithInteger( Boolean value );
    
    // *** AllowChildElementWithEnum ***
    
    @Type( base = Boolean.class )
    @Label( standard = "allow child element with enum" )
    @DefaultValue( text = "true" )
    @XmlBinding( path = "allow-child-with-enum" )
    
    ValueProperty PROP_ALLOW_CHILD_ELEMENT_WITH_ENUM = new ValueProperty( TYPE, "AllowChildElementWithEnum" );
    
    Value<Boolean> getAllowChildElementWithEnum();
    void setAllowChildElementWithEnum( String value );
    void setAllowChildElementWithEnum( Boolean value );
    
    // *** List ***
    
    @Type( base = IChildElement.class )
    @Service( impl = ListPropertyCustomGalleryServices.ListPossibleTypesService.class )
    
    @XmlListBinding
    (
        path = "list", 
        mappings = 
        {
            @XmlListBinding.Mapping( element = "child", type = IChildElement.class ),
            @XmlListBinding.Mapping( element = "child-with-integer", type = IChildElementWithInteger.class ),
            @XmlListBinding.Mapping( element = "child-with-enum", type = IChildElementWithEnum.class )
        }
    )
    
    ListProperty PROP_LIST = new ListProperty( TYPE, "List" );
    
    ElementList<IChildElement> getList();

}
