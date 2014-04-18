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

package org.eclipse.sapphire.samples.catalog;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.ui.forms.MasterDetailsEditorPageState;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface CatalogEditorPageState extends MasterDetailsEditorPageState
{
    ElementType TYPE = new ElementType( CatalogEditorPageState.class );
    
    // *** ShowManufacturer ***
    
    @Type( base = Boolean.class )
    @DefaultValue( text = "false" )

    ValueProperty PROP_SHOW_MANUFACTURER = new ValueProperty( TYPE, "ShowManufacturer" );
    
    Value<Boolean> getShowManufacturer();
    void setShowManufacturer( String value );
    void setShowManufacturer( Boolean value );
    
    // *** ShowPrice ***
    
    @Type( base = Boolean.class )
    @DefaultValue( text = "false" )

    ValueProperty PROP_SHOW_PRICE = new ValueProperty( TYPE, "ShowPrice" );
    
    Value<Boolean> getShowPrice();
    void setShowPrice( String value );
    void setShowPrice( Boolean value );
    
}
