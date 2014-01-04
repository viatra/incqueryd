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
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface VisibleWhenGallery extends Element
{
    ElementType TYPE = new ElementType( VisibleWhenGallery.class );
    
    // *** Value ***
    
    ValueProperty PROP_VALUE = new ValueProperty( TYPE, "Value" );
    
    Value<String> getValue();
    void setValue( String value );
    
    // *** ValueVisible ***
    
    @Type( base = Boolean.class )
    @DefaultValue( text = "true" )
    
    ValueProperty PROP_VALUE_VISIBLE = new ValueProperty( TYPE, "ValueVisible" );
    
    Value<Boolean> getValueVisible();
    void setValueVisible( String value );
    void setValueVisible( Boolean value );
    
    // *** List ***
    
    @Type( base = StringValueElement.class )
    
    ListProperty PROP_LIST = new ListProperty( TYPE, "List" );
    
    ElementList<StringValueElement> getList();
    
    // *** ListVisible ***
    
    @Type( base = Boolean.class )
    @DefaultValue( text = "true" )

    ValueProperty PROP_LIST_VISIBLE = new ValueProperty( TYPE, "ListVisible" );
    
    Value<Boolean> getListVisible();
    void setListVisible( String value );
    void setListVisible( Boolean value );
    
}
