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

package org.eclipse.sapphire.samples.contacts;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlNamespace;
import org.eclipse.sapphire.samples.address.Address;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@XmlNamespace( uri = "http://www.eclipse.org/sapphire/samples/address", prefix = "a" )

public interface ContactAddress extends Address
{
    ElementType TYPE = new ElementType( ContactAddress.class );
    
    // *** Street ***

    @XmlBinding( path = "a:street" )

    ValueProperty PROP_STREET = new ValueProperty( TYPE, Address.PROP_STREET );
    
    // *** City ***

    @XmlBinding( path = "a:city" )

    ValueProperty PROP_CITY = new ValueProperty( TYPE, Address.PROP_CITY );

    // *** State ***

    @XmlBinding( path = "a:state" )

    ValueProperty PROP_STATE = new ValueProperty( TYPE, Address.PROP_STATE );

    // *** ZipCode ***

    @XmlBinding( path = "a:zip" )

    ValueProperty PROP_ZIP_CODE = new ValueProperty( TYPE, Address.PROP_ZIP_CODE );

}
