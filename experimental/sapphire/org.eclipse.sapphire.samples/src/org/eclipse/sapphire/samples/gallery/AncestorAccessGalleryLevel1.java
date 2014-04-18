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

public interface AncestorAccessGalleryLevel1 extends Element
{
    ElementType TYPE = new ElementType( AncestorAccessGalleryLevel1.class );
    
    // *** Text ***
    
    @XmlBinding( path = "text" )
    @Label( standard = "level 1 text" )
    
    ValueProperty PROP_TEXT = new ValueProperty( TYPE, "Text" );
    
    Value<String> getText();
    void setText( String value );
    
    // *** List ***
    
    @Type( base = AncestorAccessGalleryLevel2.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "child", type = AncestorAccessGalleryLevel2.class ) )
    
    ListProperty PROP_LIST = new ListProperty( TYPE, "List" );
    
    ElementList<AncestorAccessGalleryLevel2> getList();
    
}
