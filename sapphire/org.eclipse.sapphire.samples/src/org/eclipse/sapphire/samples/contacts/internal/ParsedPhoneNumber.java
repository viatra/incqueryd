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

package org.eclipse.sapphire.samples.contacts.internal;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ParsedPhoneNumber
{
    private String areaCode;
    private String localNumber;
    
    public ParsedPhoneNumber( final String phoneNumber )
    {
        this.areaCode = null;
        this.localNumber = null;
        
        if( phoneNumber != null && phoneNumber.startsWith( "(" ) )
        {
            final int closingParen = phoneNumber.indexOf( ')' );
            
            if( closingParen != -1 )
            {
                this.areaCode = phoneNumber.substring( 1, closingParen );
                
                if( closingParen + 1 < phoneNumber.length() )
                {
                    this.localNumber = phoneNumber.substring( closingParen + 1 ).trim();
                }
            }
        }
        
        if( this.areaCode == null )
        {
            this.localNumber = phoneNumber;
        }
    }
    
    public String getAreaCode()
    {
        return this.areaCode;
    }
    
    public void setAreaCode( final String areaCode )
    {
        this.areaCode = areaCode;
    }
    
    public String getLocalNumber()
    {
        return this.localNumber;
    }
    
    public void setLocalNumber( final String localNumber )
    {
        this.localNumber = localNumber;
    }
    
    public String toString()
    {
        if( this.areaCode == null && this.localNumber == null )
        {
            return "";
        }
        else
        {
            final StringBuilder buf = new StringBuilder();
            
            if( this.areaCode != null && this.areaCode.length() > 0 )
            {
                buf.append( '(' );
                buf.append( this.areaCode );
                buf.append( ')' );
            }
            
            if( this.localNumber != null )
            {
                if( buf.length() > 0 )
                {
                    buf.append( ' ' );
                }
                
                buf.append( this.localNumber );
            }
            
            return buf.toString();
        }
    }
}
