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

package org.eclipse.sapphire.samples.po;

import java.math.BigDecimal;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Derived;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.NumericRange;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "entry" )

public interface PurchaseOrderEntry extends Element
{
    ElementType TYPE = new ElementType( PurchaseOrderEntry.class );
    
    // *** Item ***
    
    @Label( standard = "item" )
    @Required
    
    ValueProperty PROP_ITEM = new ValueProperty( TYPE, "Item" );
    
    Value<String> getItem();
    void setItem( String value );
    
    // *** Description ***
    
    @Label( standard = "description" )
    @LongString
    
    ValueProperty PROP_DESCRIPTION = new ValueProperty( TYPE, "Description" );
    
    Value<String> getDescription();
    void setDescription( String value );
    
    // *** Quantity ***
    
    @Type( base = Integer.class )
    @Label( standard = "quantity" )
    @Required
    @DefaultValue( text = "1" )
    
    ValueProperty PROP_QUANTITY = new ValueProperty( TYPE, "Quantity" );
    
    Value<Integer> getQuantity();
    void setQuantity( String value );
    void setQuantity( Integer value );
    
    // *** UnitPrice ***
    
    @Type( base = BigDecimal.class )
    @Label( standard = "unit price" )
    @NumericRange( min = "0" )
    @Required
    
    ValueProperty PROP_UNIT_PRICE = new ValueProperty( TYPE, "UnitPrice" );
    
    Value<BigDecimal> getUnitPrice();
    void setUnitPrice( String value );
    void setUnitPrice( BigDecimal value );
    
    // *** Total ***
    
    @Type( base = BigDecimal.class )
    @Label( standard = "total" )
    @Derived( text = "${ Scale( UnitPrice * Scale( Quantity, 2 ), 2 ) }" )
    
    ValueProperty PROP_TOTAL = new ValueProperty( TYPE, "Total" );
    
    Value<BigDecimal> getTotal();
    
}
