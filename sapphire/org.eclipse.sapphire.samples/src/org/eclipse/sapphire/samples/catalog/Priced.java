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

import java.math.BigDecimal;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Derived;
import org.eclipse.sapphire.modeling.annotations.NumericRange;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Priced extends Element
{
    ElementType TYPE = new ElementType( Priced.class );
    
    // *** BasePrice ***
    
    @Type( base = BigDecimal.class )
    @Required
    @NumericRange( min = "0" )
    @XmlBinding( path = "Price" )
    
    ValueProperty PROP_BASE_PRICE = new ValueProperty( TYPE, "BasePrice" );
    
    Value<BigDecimal> getBasePrice();
    void setBasePrice( String value );
    void setBasePrice( BigDecimal value );
    
    // *** Discount ***
    
    @Type( base = BigDecimal.class )
    @DefaultValue( text = "0" )
    @NumericRange( min = "0" )
    @XmlBinding( path = "Discount" )
    
    ValueProperty PROP_DISCOUNT = new ValueProperty( TYPE, "Discount" );
    
    Value<BigDecimal> getDiscount();
    void setDiscount( String value );
    void setDiscount( BigDecimal value );
    
    // *** Price ***
    
    @Type( base = BigDecimal.class )
    @Derived( text = "${ Scale( BasePrice, 2 ) - Scale( Discount, 2 ) }" )
    
    ValueProperty PROP_PRICE = new ValueProperty( TYPE, "Price" );
    
    Value<BigDecimal> getPrice();
    
}
