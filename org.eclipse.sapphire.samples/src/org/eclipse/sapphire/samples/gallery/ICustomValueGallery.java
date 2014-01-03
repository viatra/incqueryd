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
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Services;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.samples.gallery.internal.RectangleToStringConversionService;
import org.eclipse.sapphire.samples.gallery.internal.StringToRectangleConversionService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface ICustomValueGallery extends Element
{
    ElementType TYPE = new ElementType( ICustomValueGallery.class );
    
    // *** Rectangle ***
    
    @Type( base = Rectangle.class )
    @Label( standard = "rectangle" )
    @XmlBinding( path = "rectangle" )

    @Services
    (
        {
            @Service( impl = StringToRectangleConversionService.class ),
            @Service( impl = RectangleToStringConversionService.class )
        }
    )
    
    ValueProperty PROP_RECTANGLE = new ValueProperty( TYPE, "Rectangle" );
    
    Value<Rectangle> getRectangle();
    void setRectangle( String value );
    void setRectangle( Rectangle value );
    
    // *** Circle ***
    
    @Type( base = Circle.class )
    @Label( standard = "circle" )
    @XmlBinding( path = "circle" )
    
    ValueProperty PROP_CIRCLE = new ValueProperty( TYPE, "Circle" );
    
    Value<Circle> getCircle();
    void setCircle( String value );
    void setCircle( Circle value );
    
}
