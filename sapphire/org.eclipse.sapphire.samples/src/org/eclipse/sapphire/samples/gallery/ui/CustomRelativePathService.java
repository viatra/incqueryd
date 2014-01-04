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

package org.eclipse.sapphire.samples.gallery.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sapphire.modeling.Path;
import org.eclipse.sapphire.services.RelativePathService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class CustomRelativePathService extends RelativePathService
{
    @Override
    public List<Path> roots()
    {
        final List<Path> roots = new ArrayList<Path>();
        
        roots.add( new Path( "c:/Windows" ) );
        roots.add( new Path( "c:/Program Files" ) );
        
        return roots;
    }
    
}
