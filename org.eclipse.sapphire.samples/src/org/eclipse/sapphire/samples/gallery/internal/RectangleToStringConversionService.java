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

import org.eclipse.sapphire.ConversionService;
import org.eclipse.sapphire.samples.gallery.Rectangle;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class RectangleToStringConversionService extends ConversionService<Rectangle,String>
{
    public RectangleToStringConversionService()
    {
        super( Rectangle.class, String.class );
    }

    @Override
    public String convert( final Rectangle rectangle )
    {
        final StringBuilder buf = new StringBuilder();

        buf.append( rectangle.x() );
        buf.append( ", " );
        buf.append( rectangle.y() );
        buf.append( ", " );
        buf.append( rectangle.width() );
        buf.append( ", " );
        buf.append( rectangle.height() );
        
        return buf.toString();
    }

}
