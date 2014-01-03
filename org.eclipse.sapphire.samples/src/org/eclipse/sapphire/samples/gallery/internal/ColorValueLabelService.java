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

package org.eclipse.sapphire.samples.gallery.internal;

import org.eclipse.sapphire.services.ValueLabelService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ColorValueLabelService extends ValueLabelService
{
    @Override
    public String provide( final String value )
    {
        if( value != null )
        {
            if( value.equalsIgnoreCase( "red" ) )
            {
                return "Red [FF0000]";
            }
            else if( value.equalsIgnoreCase( "orange" ) )
            {
                return "Orange [FF8A00]";
            }
            else if( value.equalsIgnoreCase( "yellow" ) )
            {
                return "Yellow [FFF200]";
            }
            else if( value.equalsIgnoreCase( "green" ) )
            {
                return "Green [00BC00]";
            }
            else if( value.equalsIgnoreCase( "blue" ) )
            {
                return "Blue [0000FF]";
            }
            else if( value.equalsIgnoreCase( "violet" ) )
            {
                return "Violet [8A00FF]";
            }
        }
        
        return value;
    }
    
}
