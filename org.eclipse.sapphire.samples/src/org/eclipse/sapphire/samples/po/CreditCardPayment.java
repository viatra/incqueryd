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

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.EnumSerialization;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "credit card" )

public interface CreditCardPayment extends Payment
{
    ElementType TYPE = new ElementType( CreditCardPayment.class );
    
    // *** Number ***
    
    @Label( standard = "number" )
    @Required
    
    ValueProperty PROP_NUMBER = new ValueProperty( TYPE, "Number" );
    
    Value<String> getNumber();
    void setNumber( String value );
    
    // *** Expiration ***
    
    @Label( standard = "expiration" )
    @Required
    
    ValueProperty PROP_EXPIRATION = new ValueProperty( TYPE, "Expiration" );
    
    Value<String> getExpiration();
    void setExpiration( String value );
    
    // *** Type ***
    
    @Label( standard = "type" )

    public enum CreditCardType
    {
        @Label( standard = "VISA" )
        @EnumSerialization( primary = "visa" )

        VISA,
        
        @Label( standard = "MasterCard" )
        @EnumSerialization( primary = "mc" )

        MASTER_CARD,

        
        @Label( standard = "American Express" )
        @EnumSerialization( primary = "amex" )

        AMERICAN_EXPRESS
    }
    
    @Type( base = CreditCardType.class )
    @Label( standard = "type" )
    @Required
    
    ValueProperty PROP_TYPE = new ValueProperty( TYPE, "Type" );
    
    Value<CreditCardType> getType();
    void setType( String value );
    void setType( CreditCardType value );

    // *** Bank ***
    
    @Label( standard = "bank" )
    
    ValueProperty PROP_BANK = new ValueProperty( TYPE, "Bank" );
    
    Value<String> getBank();
    void setBank( String value );
    
}
