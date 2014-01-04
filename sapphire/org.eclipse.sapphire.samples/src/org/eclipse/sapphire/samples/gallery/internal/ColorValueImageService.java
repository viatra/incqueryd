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

import static org.eclipse.sapphire.ImageData.readFromClassLoader;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.sapphire.ImageData;
import org.eclipse.sapphire.services.ValueImageService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ColorValueImageService extends ValueImageService
{
    private final Map<String,ImageData> images = new HashMap<String,ImageData>();

    @Override
    public ImageData provide( final String value )
    {
        ImageData image = this.images.get( value );
        
        if( image == null && value != null )
        {
            final String imageResourceName;
            
            if( value.equalsIgnoreCase( "red" ) )
            {
                imageResourceName = "SquareRed.png";
            }
            else if( value.equalsIgnoreCase( "orange" ) )
            {
                imageResourceName = "SquareOrange.png";
            }
            else if( value.equalsIgnoreCase( "yellow" ) )
            {
                imageResourceName = "SquareYellow.png";
            }
            else if( value.equalsIgnoreCase( "green" ) )
            {
                imageResourceName = "SquareGreen.png";
            }
            else if( value.equalsIgnoreCase( "blue" ) )
            {
                imageResourceName = "SquareBlue.png";
            }
            else if( value.equalsIgnoreCase( "violet" ) )
            {
                imageResourceName = "SquareViolet.png";
            }
            else
            {
                imageResourceName = "SquareQuestionMark.png";
            }

            final String imageResourcePath = "org/eclipse/sapphire/samples/" + imageResourceName;
            image = readFromClassLoader( ColorValueImageService.class, imageResourcePath ).required();
        }
        
        return image;
    }
    
}
