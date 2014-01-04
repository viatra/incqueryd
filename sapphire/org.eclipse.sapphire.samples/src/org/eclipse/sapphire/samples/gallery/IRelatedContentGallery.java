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
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.annotations.Whitespace;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlValueBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IRelatedContentGallery extends Element
{
    ElementType TYPE = new ElementType( IRelatedContentGallery.class );
    
    // *** Measurement ***
    
    @Type( base = Integer.class )
    @Label( standard = "measurement" )
    @XmlBinding( path = "measurement/amount" )
    
    ValueProperty PROP_MEASUREMENT = new ValueProperty( TYPE, "Measurement" );
    
    Value<Integer> getMeasurement();
    void setMeasurement( String value );
    void setMeasurement( Integer value );
    
    // *** MeasurementUnits ***
    
    @Type( base = SizeUnits.class )
    @Label( standard = "measurement units" )
    @DefaultValue( text = "inch" )
    @XmlBinding( path = "measurement/units" )
    
    ValueProperty PROP_MEASUREMENT_UNITS = new ValueProperty( TYPE, "MeasurementUnits" );
    
    Value<SizeUnits> getMeasurementUnits();
    void setMeasurementUnits( String value );
    void setMeasurementUnits( SizeUnits value );

    // *** MeasurementOfArea ***
    
    @Type( base = Boolean.class )
    @Label( standard = "area" )
    @DefaultValue( text = "false" )
    @XmlBinding( path = "measurement/area" )
    
    ValueProperty PROP_MEASUREMENT_OF_AREA = new ValueProperty( TYPE, "MeasurementOfArea" );
    
    Value<Boolean> getMeasurementOfArea();
    void setMeasurementOfArea( String value );
    void setMeasurementOfArea( Boolean value );
    
    // *** Description ***
    
    @Label( standard = "description" )
    @LongString
    @Whitespace( collapse = true )
    @XmlValueBinding( path = "description" )
    
    ValueProperty PROP_DESCRIPTION = new ValueProperty( TYPE, "Description" );
    
    Value<String> getDescription();
    void setDescription( String value );

}
