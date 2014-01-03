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
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface SplitFormGallery extends Element
{
    ElementType TYPE = new ElementType( SplitFormGallery.class );
    
    // *** List1 ***
    
    @Type( base = SplitFormGalleryListEntry.class )
    @Label( standard = "list 1" )
    @XmlListBinding( path = "list-1", mappings = @XmlListBinding.Mapping( element = "entry", type = SplitFormGalleryListEntry.class ) )
    
    ListProperty PROP_LIST_1 = new ListProperty( TYPE, "List1" );
    
    ElementList<SplitFormGalleryListEntry> getList1();
    
    // *** List2 ***
    
    @Type( base = SplitFormGalleryListEntry.class )
    @Label( standard = "list 2" )
    @XmlListBinding( path = "list-2", mappings = @XmlListBinding.Mapping( element = "entry", type = SplitFormGalleryListEntry.class ) )
    
    ListProperty PROP_LIST_2 = new ListProperty( TYPE, "List2" );
    
    ElementList<SplitFormGalleryListEntry> getList2();

    // *** List3 ***
    
    @Type( base = SplitFormGalleryListEntry.class )
    @Label( standard = "list 3" )
    @XmlListBinding( path = "list-3", mappings = @XmlListBinding.Mapping( element = "entry", type = SplitFormGalleryListEntry.class ) )
    
    ListProperty PROP_LIST_3 = new ListProperty( TYPE, "List3" );
    
    ElementList<SplitFormGalleryListEntry> getList3();

    // *** List4 ***
    
    @Type( base = SplitFormGalleryListEntry.class )
    @Label( standard = "list 4" )
    @XmlListBinding( path = "list-4", mappings = @XmlListBinding.Mapping( element = "entry", type = SplitFormGalleryListEntry.class ) )
    
    ListProperty PROP_LIST_4 = new ListProperty( TYPE, "List4" );
    
    ElementList<SplitFormGalleryListEntry> getList4();

    // *** String1 ***
    
    @Label( standard = "string 1" )
    @XmlBinding( path = "string-1" )
    
    ValueProperty PROP_STRING_1 = new ValueProperty( TYPE, "String1" );
    
    Value<String> getString1();
    void setString1( String value );
    
    // *** String2 ***
    
    @Label( standard = "string 2" )
    @XmlBinding( path = "string-2" )
    
    ValueProperty PROP_STRING_2 = new ValueProperty( TYPE, "String2" );
    
    Value<String> getString2();
    void setString2( String value );

}
