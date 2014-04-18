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

import static org.eclipse.sapphire.util.StringUtil.UTF8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.sapphire.samples.internal.SapphireSamplesPlugin;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ZipCodeRepository
{
    private static boolean initialized = false;
    
    private static Map<IndexKey,List<ZipCodeRecord>> index
        = new HashMap<IndexKey,List<ZipCodeRecord>>();
    
    public static SortedSet<String> getZipCodes( final String stateCode,
                                                 final String city )
    {
        final TreeSet<String> result = new TreeSet<String>();
        
        for( ZipCodeRecord record : find( null, stateCode, city ) )
        {
            result.add( record.getZipCode() );
        }
        
        return result;
    }
    
    public static SortedSet<String> getStateCodes( final String zipCode,
                                                   final String city )
    {
        final TreeSet<String> result = new TreeSet<String>();
        
        for( ZipCodeRecord record : find( zipCode, null, city ) )
        {
            result.add( record.getStateCode() );
        }
        
        return result;
    }
    
    public static SortedSet<String> getCities( final String zipCode,
                                               final String stateCode )
    {
        final TreeSet<String> result = new TreeSet<String>();
        
        for( ZipCodeRecord record : find( zipCode, stateCode, null ) )
        {
            result.add( record.getCity() );
        }
        
        return result;
    }
    
    public static List<ZipCodeRecord> find( final String zipCode,
                                            final String stateCode,
                                            final String city )
    {
        initialize();
        
        List<ZipCodeRecord> result = index.get( new IndexKey( zipCode, stateCode, city ) );
        
        if( result != null )
        {
            result = Collections.unmodifiableList( result );
        }
        else
        {
            result = Collections.emptyList();
        }
        
        return result;
    }
    
    private static synchronized void initialize()
    {
        if( initialized )
        {
            return;
        }
        
        final URL zipCodesRepositoryUrl
            = FileLocator.find( SapphireSamplesPlugin.getBundle(), new Path( "zipcodes/zipcodes.txt" ), null );
        
        try
        {
            final InputStream in = zipCodesRepositoryUrl.openStream();
            
            try
            {
                final BufferedReader r = new BufferedReader( new InputStreamReader( in, UTF8 ) );
                
                for( String line = r.readLine(); line != null; line = r.readLine() )
                {
                    final String[] segments = line.split( "\\|\\|" );
                    
                    if( segments.length == 6 )
                    {
                        final String zipCode = segments[ 0 ];
                        final String stateCode = segments[ 3 ];
                        final String city = segments[ 4 ];
                        final String county = segments[ 5 ];
                        
                        final ZipCodeRecord record = new ZipCodeRecord( zipCode, stateCode, county, city );
                        
                        addToIndex( new IndexKey( null, null, null ), record );
                        addToIndex( new IndexKey( record.getZipCode(), null, null ), record );
                        addToIndex( new IndexKey( null, record.getStateCode(), null ), record );
                        addToIndex( new IndexKey( null, null, record.getCity() ), record );
                        addToIndex( new IndexKey( record.getZipCode(), record.getStateCode(), null ), record );
                        addToIndex( new IndexKey( record.getZipCode(), null, record.getCity() ), record );
                        addToIndex( new IndexKey( null, record.getStateCode(), record.getCity() ), record );
                    }
                }
            }
            finally
            {
                try
                {
                    in.close();
                }
                catch( IOException e ) {}
            }
        }
        catch( IOException e )
        {
            SapphireSamplesPlugin.log( e );
        }
        
        initialized = true;
    }
    
    private static void addToIndex( final IndexKey indexKey,
                                    final ZipCodeRecord record )
    {
        List<ZipCodeRecord> list = index.get( indexKey );
        
        if( list == null )
        {
            list = new ArrayList<ZipCodeRecord>();
            index.put( indexKey, list );
        }
        
        list.add( record );
    }
    
    
    private static final class IndexKey
    {
        private final String zip;
        private final String state;
        private final String city;
        
        public IndexKey( final String zip,
                         final String state,
                         final String city )
        {
            this.zip = zip;
            this.state = state;
            this.city = city;
        }
        
        public boolean equals( final Object obj )
        {
            if( ! ( obj instanceof IndexKey ) )
            {
                return false;
            }
            
            final IndexKey k = (IndexKey) obj;
            
            return equal( this.zip, k.zip ) && equal( this.state, k.state ) && equal( this.city, k.city );
        }
        
        public int hashCode()
        {
            int hashCode = ( this.zip != null ? this.zip.toLowerCase().hashCode() : 1 );
            hashCode *= ( this.state != null ? this.state.toLowerCase().hashCode() : 1 );
            hashCode *= ( this.city != null ? this.city.toLowerCase().hashCode() : 1 );
            
            return hashCode;
        }

        private static boolean equal( final String obj1, 
                                      final String obj2 )
        {
            boolean objectsAreEqual = false;
            
            if( obj1 == obj2 )
            {
                objectsAreEqual = true;
            }
            else if( obj1 != null && obj2 != null )
            {
                objectsAreEqual = obj1.equalsIgnoreCase( obj2 );
            }

            return objectsAreEqual;
        }
    }

}
