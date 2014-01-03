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
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.samples.address.Address;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface ShippingInformation extends Address
{
    ElementType TYPE = new ElementType( ShippingInformation.class );
    
    // *** Name ***
    
    @Label( standard = "name" )
    @Required
    @DefaultValue( text = "${ Parent().BillingInformation.Name }" )
    
    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );
    
    Value<String> getName();
    void setName( String value );
    
    // *** Organization ***
    
    @Label( standard = "organization" )
    @DefaultValue( text = "${ Parent().BillingInformation.Organization }" )
    
    ValueProperty PROP_ORGANIZATION = new ValueProperty( TYPE, "Organization" );
    
    Value<String> getOrganization();
    void setOrganization( String value );
    
    // *** Street ***

    @DefaultValue( text = "${ Parent().BillingInformation.Street }" )

    ValueProperty PROP_STREET = new ValueProperty( TYPE, Address.PROP_STREET );
    
    // *** City ***

    @DefaultValue( text = "${ Parent().BillingInformation.City }" )

    ValueProperty PROP_CITY = new ValueProperty( TYPE, Address.PROP_CITY );

    // *** State ***

    @DefaultValue( text = "${ Parent().BillingInformation.State }" )

    ValueProperty PROP_STATE = new ValueProperty( TYPE, Address.PROP_STATE );

    // *** ZipCode ***

    @DefaultValue( text = "${ Parent().BillingInformation.ZipCode }" )

    ValueProperty PROP_ZIP_CODE = new ValueProperty( TYPE, Address.PROP_ZIP_CODE );

}
