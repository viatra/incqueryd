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

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.ModelRelativePath;
import org.eclipse.sapphire.modeling.Path;
import org.eclipse.sapphire.modeling.annotations.AbsolutePath;
import org.eclipse.sapphire.modeling.annotations.FileExtensions;
import org.eclipse.sapphire.modeling.annotations.FileSystemResourceType;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.MustExist;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.annotations.ValidFileSystemResourceType;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;
import org.eclipse.sapphire.samples.gallery.ui.CustomRelativePathService;
import org.eclipse.sapphire.workspace.ProjectRelativePath;
import org.eclipse.sapphire.workspace.WorkspaceRelativePath;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IBrowseSupportGallery extends Element
{
    ElementType TYPE = new ElementType( IBrowseSupportGallery.class );
    
    // *** AbsoluteFilePath ***
    
    @Type( base = Path.class )
    @Label( standard = "absolute file path" )
    @AbsolutePath
    @ValidFileSystemResourceType( FileSystemResourceType.FILE )
    @FileExtensions( expr = "jar,zip" )
    @MustExist
    @XmlBinding( path = "absolute-file-path" )
    
    ValueProperty PROP_ABSOLUTE_FILE_PATH = new ValueProperty( TYPE, "AbsoluteFilePath" );
    
    Value<Path> getAbsoluteFilePath();
    void setAbsoluteFilePath( String value );
    void setAbsoluteFilePath( Path value );

    // *** AbsoluteFolderPath ***
    
    @Type( base = Path.class )
    @Label( standard = "absolute folder path" )
    @AbsolutePath
    @ValidFileSystemResourceType( FileSystemResourceType.FOLDER )
    @MustExist
    @XmlBinding( path = "absolute-folder-path" )
    
    ValueProperty PROP_ABSOLUTE_FOLDER_PATH = new ValueProperty( TYPE, "AbsoluteFolderPath" );
    
    Value<Path> getAbsoluteFolderPath();
    void setAbsoluteFolderPath( String value );
    void setAbsoluteFolderPath( Path value );
    
    // *** RelativeFilePath ***
    
    @Type( base = Path.class )
    @Label( standard = "relative file path" )
    @Service( impl = CustomRelativePathService.class )
    @ValidFileSystemResourceType( FileSystemResourceType.FILE )
    @FileExtensions( expr = "dll" )
    @MustExist
    @XmlBinding( path = "relative-file-path" )
    
    ValueProperty PROP_RELATIVE_FILE_PATH = new ValueProperty( TYPE, "RelativeFilePath" );
    
    Value<Path> getRelativeFilePath();
    void setRelativeFilePath( String value );
    void setRelativeFilePath( Path value );
    
    // *** ModelRelativePath ***
    
    @Type( base = Path.class )
    @Label( standard = "model relative path" )
    @ModelRelativePath
    @ValidFileSystemResourceType( FileSystemResourceType.FILE )
    @MustExist
    @XmlBinding( path = "model-relative-path" )
    
    ValueProperty PROP_MODEL_RELATIVE_PATH = new ValueProperty( TYPE, "ModelRelativePath" );
    
    Value<Path> getModelRelativePath();
    void setModelRelativePath( String value );
    void setModelRelativePath( Path value );
    
    // *** WorkspaceRelativePath ***
    
    @Type( base = Path.class )
    @Label( standard = "workspace relative path" )
    @WorkspaceRelativePath
    @MustExist
    @XmlBinding( path = "workspace-relative-path" )
    
    ValueProperty PROP_WORKSPACE_RELATIVE_PATH = new ValueProperty( TYPE, "WorkspaceRelativePath" );
    
    Value<Path> getWorkspaceRelativePath();
    void setWorkspaceRelativePath( String value );
    void setWorkspaceRelativePath( Path value );
    
    // *** ProjectRelativePath ***
    
    @Type( base = Path.class )
    @Label( standard = "project relative path" )
    @ProjectRelativePath
    @MustExist
    @XmlBinding( path = "project-relative-path" )
    
    ValueProperty PROP_PROJECT_RELATIVE_PATH = new ValueProperty( TYPE, "ProjectRelativePath" );
    
    Value<Path> getProjectRelativePath();
    void setProjectRelativePath( String value );
    void setProjectRelativePath( Path value );
    
    // *** MultiOptionPath ***
    
    @Type( base = Path.class )
    @Label( standard = "multi option path" )
    @XmlBinding( path = "multi-option-path" )

    ValueProperty PROP_MULTI_OPTION_PATH = new ValueProperty( TYPE, "MultiOptionPath" );
    
    Value<Path> getMultiOptionPath();
    void setMultiOptionPath( String value );
    void setMultiOptionPath( Path value );
    
    // *** List ***
    
    @Type( base = IBrowseSupportGalleryListEntry.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "list-entry", type = IBrowseSupportGalleryListEntry.class ) )
    @Label( standard = "list" )
    
    ListProperty PROP_LIST = new ListProperty( TYPE, "List" );
    
    ElementList<IBrowseSupportGalleryListEntry> getList();
    
}
