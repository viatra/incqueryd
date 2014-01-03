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

package org.eclipse.sapphire.samples.address;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.samples.address.internal.CityPossibleValuesService;
import org.eclipse.sapphire.samples.address.internal.StatePossibleValuesService;
import org.eclipse.sapphire.samples.address.internal.ZipCodePossibleValuesService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Address extends Element
{
    ElementType TYPE = new ElementType( Address.class );
    
    // *** Street ***

    @Label( standard = "street" )
    @Required

    ValueProperty PROP_STREET = new ValueProperty( TYPE, "Street" );

    Value<String> getStreet();
    void setStreet( String street );
    
    // *** City ***

    @Label( standard = "city" )
    @Required
    @Service( impl = CityPossibleValuesService.class )

    ValueProperty PROP_CITY = new ValueProperty( TYPE, "City" );

    Value<String> getCity();
    void setCity( String city );

    // *** State ***

    @Label( standard = "state" )
    @Required
    @Service( impl = StatePossibleValuesService.class )

    ValueProperty PROP_STATE = new ValueProperty( TYPE, "State" );

    Value<String> getState();
    void setState( String state );

    // *** ZipCode ***

    @Label( standard = "ZIP code" )
    @Required
    @Service( impl = ZipCodePossibleValuesService.class )

    ValueProperty PROP_ZIP_CODE = new ValueProperty( TYPE, "ZipCode" );

    Value<String> getZipCode();
    void setZipCode( String zipCode );

}
