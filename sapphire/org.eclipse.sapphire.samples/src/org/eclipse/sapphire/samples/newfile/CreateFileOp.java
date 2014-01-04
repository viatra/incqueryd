/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation
 ******************************************************************************/

package org.eclipse.sapphire.samples.newfile;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.FileExtensions;
import org.eclipse.sapphire.modeling.annotations.Image;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.workspace.CreateWorkspaceFileOp;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface CreateFileOp extends CreateWorkspaceFileOp
{
    ElementType TYPE = new ElementType( CreateFileOp.class );

    // *** Type ***
    
    @Label( standard = "file type" )
    
    enum FileType
    {
        @Label( standard = "Java" )
        @Image( path = "JavaFile.png" )
        
        JAVA,
        
        @Label( standard = "XML" )
        @Image( path = "XmlFile.png" )
        
        XML,
        
        @Label( standard = "text" )
        @Image( path = "TextFile.png" )
        
        TEXT
    }
    
    @Type( base = FileType.class )
    @Label( standard = "type" )
    @DefaultValue( text = "text" )
    
    ValueProperty PROP_TYPE = new ValueProperty( TYPE, "Type" );
    
    Value<FileType> getType();
    void setType( String value );
    void setType( FileType value );
    
    // *** File ***

    @FileExtensions( expr = "${ Type == 'java' ? 'java' : ( Type == 'xml' ? 'xml' : 'txt' ) }" )
    
    ValueProperty PROP_FILE = new ValueProperty( TYPE, CreateWorkspaceFileOp.PROP_FILE );

}
