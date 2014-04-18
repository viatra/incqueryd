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
import org.eclipse.sapphire.modeling.annotations.NumericRange;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface ILongIntegerValueGallery extends Element
{
    ElementType TYPE = new ElementType( ILongIntegerValueGallery.class );

    // *** Simple ***

    @Type( base = Long.class )
    @Label( standard = "simple" )
    @XmlBinding( path = "simple" )

    ValueProperty PROP_SIMPLE = new ValueProperty( TYPE, "Simple" );

    Value<Long> getSimple();
    void setSimple( String val );
    void setSimple( Long val );
    
    // *** Positive ***
    
    @Type( base = Long.class )
    @Label( standard = "positive" )
    @NumericRange( min = "0" )
    @XmlBinding( path = "positive" )

    ValueProperty PROP_POSITIVE = new ValueProperty( TYPE, "Positive" );

    Value<Long> getPositive();
    void setPositive( String val );
    void setPositive( Long val );

    // *** RangeConstrainedWithDefault ***
    
    @Type( base = Long.class )
    @Label( standard = "range constrained with default" )
    @NumericRange( min = "5", max = "10000000000" )
    @DefaultValue( text = "1000" )
    @XmlBinding( path = "range-constrained-with-default" )

    ValueProperty PROP_RANGE_CONSTRAINED_WITH_DEFAULT = new ValueProperty( TYPE, "RangeConstrainedWithDefault" );

    Value<Long> getRangeConstrainedWithDefault();
    void setRangeConstrainedWithDefault( String val );
    void setRangeConstrainedWithDefault( Long val );
    
}
