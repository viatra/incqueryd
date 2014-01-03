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
import org.eclipse.sapphire.modeling.Status.Severity;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Services;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.samples.gallery.internal.ColorPossibleValuesService;
import org.eclipse.sapphire.samples.gallery.internal.ColorValueImageService;
import org.eclipse.sapphire.samples.gallery.internal.ColorValueLabelService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface PossibleValuesGalleryListItem extends Element
{
    ElementType TYPE = new ElementType( PossibleValuesGalleryListItem.class );
    
    // *** Color ***
    
    @Label( standard = "color" )
    @XmlBinding( path = "color" )
    
    @DefaultValue( text = "Green" )

    @Services
    ( 
        {
            @Service( impl = ColorPossibleValuesService.class ),
            @Service( impl = ColorValueLabelService.class, context = Service.Context.METAMODEL ),
            @Service( impl = ColorValueImageService.class, context = Service.Context.METAMODEL )
        }
    )
    
    ValueProperty PROP_COLOR = new ValueProperty( TYPE, "Color" );
    
    Value<String> getColor();
    void setColor( String value );
    
    // *** Shape ***
    
    @Label( standard = "shape" )
    @XmlBinding( path = "shape" )
    
    @PossibleValues
    (
        values =
        {
            "Circle",
            "Rectangle",
            "Square",
            "Triangle"
        },
        invalidValueSeverity = Severity.WARNING
    )
    
    @DefaultValue( text = "Circle" )
    
    ValueProperty PROP_SHAPE = new ValueProperty( TYPE, "Shape" );
    
    Value<String> getShape();
    void setShape( String value );
    
}
