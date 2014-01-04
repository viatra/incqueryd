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

package org.eclipse.sapphire.samples.journal;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.ModelRelativePath;
import org.eclipse.sapphire.modeling.Path;
import org.eclipse.sapphire.modeling.annotations.Image;
import org.eclipse.sapphire.modeling.annotations.MustExist;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Image( path = "File.png" )

public interface File extends Element
{
    ElementType TYPE = new ElementType( File.class );
    
    // *** Path ***
    
    @Type( base = Path.class )
    @ModelRelativePath
    @MustExist
    
    ValueProperty PROP_PATH = new ValueProperty( TYPE, "Path" );
    
    Value<Path> getPath();
    void getPath( String value );
    void getPath( Path value );
    
}
