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

package org.eclipse.sapphire.samples.address.internal;

import java.util.Set;

import org.eclipse.osgi.util.NLS;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.samples.address.Address;
import org.eclipse.sapphire.samples.zipcodes.ZipCodeRepository;
import org.eclipse.sapphire.services.PossibleValuesService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class CityPossibleValuesService extends PossibleValuesService
{
    @Override
    protected void init()
    {
        final Listener listener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                broadcast();
            }
        };
        
        final Address address = context( Address.class );
        
        address.getState().attach( listener );
        address.getZipCode().attach( listener );
    }

    @Override
    protected void fillPossibleValues( final Set<String> values )
    {
        final Address address = context( Address.class );
        final String state = address.getState().text();
        final String zip = address.getZipCode().text();
        
        values.addAll( ZipCodeRepository.getCities( zip, state ) );
    }

    @Override
    public String getInvalidValueMessage( final String invalidValue )
    {
        return NLS.bind( "\"{0}\" is not a valid city for the specified state and ZIP code.", invalidValue );
    }

    @Override
    public boolean isCaseSensitive()
    {
        return false;
    }

}
