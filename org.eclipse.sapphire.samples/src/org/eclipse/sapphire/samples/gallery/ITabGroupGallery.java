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
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.java.JavaTypeKind;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.NumericRange;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface ITabGroupGallery extends Element
{
    ElementType TYPE = new ElementType( ITabGroupGallery.class );
    
    // *** TypeKind ***
    
    @Type( base = JavaTypeKind.class )
    @DefaultValue( text = "class" )
    
    ValueProperty PROP_TYPE_KIND = new ValueProperty( TYPE, "TypeKind" );
    
    Value<JavaTypeKind> getTypeKind();
    void setTypeKind( String value );
    void setTypeKind( JavaTypeKind value );
    
    // *** Property1 ***
    
    @Type( base = Integer.class )
    @NumericRange( min = "1", max = "5" )
    @DefaultValue( text = "1" )
    @Label( standard = "property 1" )
    @XmlBinding( path = "property-1" )
    
    ValueProperty PROP_PROPERTY_1 = new ValueProperty( TYPE, "Property1" );
    
    Value<Integer> getProperty1();
    void setProperty1( String value );
    void setProperty1( Integer value );
    
    // *** Property2 ***
    
    @Type( base = Integer.class )
    @NumericRange( min = "1", max = "5" )
    @DefaultValue( text = "1" )
    @Label( standard = "property 2" )
    @XmlBinding( path = "property-2" )
    
    ValueProperty PROP_PROPERTY_2 = new ValueProperty( TYPE, "Property2" );
    
    Value<Integer> getProperty2();
    void setProperty2( String value );
    void setProperty2( Integer value );
    
    // *** Property3 ***
    
    @Type( base = Integer.class )
    @NumericRange( min = "1", max = "5" )
    @DefaultValue( text = "1" )
    @Label( standard = "property 3" )
    @XmlBinding( path = "property-3" )
    
    ValueProperty PROP_PROPERTY_3 = new ValueProperty( TYPE, "Property3" );
    
    Value<Integer> getProperty3();
    void setProperty3( String value );
    void setProperty3( Integer value );
    
    // *** Property4 ***
    
    @Type( base = Integer.class )
    @NumericRange( min = "1", max = "5" )
    @DefaultValue( text = "1" )
    @Label( standard = "property 4" )
    @XmlBinding( path = "property-4" )
    
    ValueProperty PROP_PROPERTY_4 = new ValueProperty( TYPE, "Property4" );
    
    Value<Integer> getProperty4();
    void setProperty4( String value );
    void setProperty4( Integer value );
    
}
