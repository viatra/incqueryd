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

package org.eclipse.sapphire.samples.gallery;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class Circle
{
    private final int x;
    private final int y;
    private final int radius;
    
    public Circle( final int x,
                   final int y,
                   final int radius )
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public int x()
    {
        return this.x;
    }
    
    public int y()
    {
        return this.y;
    }
    
    public int radius()
    {
        return this.radius;
    }

    @Override
    public String toString()
    {
        final StringBuilder buf = new StringBuilder();

        buf.append( "circle( " );
        buf.append( this.x );
        buf.append( ", " );
        buf.append( this.y );
        buf.append( ", " );
        buf.append( this.radius );
        buf.append( " )" );
        
        return buf.toString();
    }
    
}
