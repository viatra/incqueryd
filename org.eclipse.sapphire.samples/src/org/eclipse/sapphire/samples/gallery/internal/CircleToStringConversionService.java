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
import org.eclipse.sapphire.samples.gallery.Circle;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class CircleToStringConversionService extends ConversionService<Circle,String>
{
    public CircleToStringConversionService()
    {
        super( Circle.class, String.class );
    }

    @Override
    public String convert( final Circle circle )
    {
        final StringBuilder buf = new StringBuilder();

        buf.append( circle.x() );
        buf.append( ", " );
        buf.append( circle.y() );
        buf.append( ", " );
        buf.append( circle.radius() );
        
        return buf.toString();
    }

}
