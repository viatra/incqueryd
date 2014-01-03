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

package org.eclipse.sapphire.samples.zipcodes;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ZipCodeRecord
{
    private final String zip;
    private final String state;
    private final String county;
    private final String city;
    
    public ZipCodeRecord( final String zip,
                          final String state,
                          final String county,
                          final String city )
    {
        this.zip = zip;
        this.state = state;
        this.county = county;
        this.city = city;
    }
    
    public String getZipCode()
    {
        return this.zip;
    }
    
    public String getStateCode()
    {
        return this.state;
    }
    
    public String getCounty()
    {
        return this.county;
    }
    
    public String getCity()
    {
        return this.city;
    }
}
