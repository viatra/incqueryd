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
import org.eclipse.sapphire.ElementHandle;
import org.eclipse.sapphire.ElementProperty;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlElementBinding;
import org.eclipse.sapphire.samples.gallery.internal.ElementPropertyCustomGalleryServices;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface ElementPropertyCustomGallery extends Element
{
    ElementType TYPE = new ElementType( ElementPropertyCustomGallery.class );
    
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
    
    // *** Element ***
    
    @Type( base = IChildElement.class )
    @Service( impl = ElementPropertyCustomGalleryServices.ElementPossibleTypesService.class )
    
    @XmlElementBinding
    (
        path = "element", 
        mappings = 
        {
            @XmlElementBinding.Mapping( element = "child", type = IChildElement.class ),
            @XmlElementBinding.Mapping( element = "child-with-integer", type = IChildElementWithInteger.class ),
            @XmlElementBinding.Mapping( element = "child-with-enum", type = IChildElementWithEnum.class )
        }
    )
    
    ElementProperty PROP_ELEMENT = new ElementProperty( TYPE, "Element" );
    
    ElementHandle<IChildElement> getElement();

}
