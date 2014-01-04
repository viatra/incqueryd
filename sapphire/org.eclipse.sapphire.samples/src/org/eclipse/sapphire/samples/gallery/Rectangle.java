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

import org.eclipse.sapphire.modeling.annotations.Label;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "rectangle" )

public final class Rectangle
{
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    
    public Rectangle( final int x,
                      final int y,
                      final int width,
                      final int height )
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public int x()
    {
        return this.x;
    }
    
    public int y()
    {
        return this.y;
    }
    
    public int width()
    {
        return this.width;
    }
    
    public int height()
    {
        return this.height;
    }

    @Override
    public String toString()
    {
        final StringBuilder buf = new StringBuilder();

        buf.append( "rectangle( " );
        buf.append( this.x );
        buf.append( ", " );
        buf.append( this.y );
        buf.append( ", " );
        buf.append( this.width );
        buf.append( ", " );
        buf.append( this.height );
        buf.append( " )" );
        
        return buf.toString();
    }
    
}
