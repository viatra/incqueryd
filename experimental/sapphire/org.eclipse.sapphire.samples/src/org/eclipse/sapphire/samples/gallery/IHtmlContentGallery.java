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
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IHtmlContentGallery extends Element
{
    ElementType TYPE = new ElementType( IHtmlContentGallery.class );
    
    // *** City ***
    
    @Label( standard = "city" )
    @DefaultValue( text = "Seattle" )
    @XmlBinding( path = "city" )
    
    ValueProperty PROP_CITY = new ValueProperty( TYPE, "City" );
    
    Value<String> getCity();
    
    void setCity( String value );
    
    // *** State ***
    
    @Label( standard = "state" )
    @DefaultValue( text = "WA" )
    @XmlBinding( path = "state" )
    
    ValueProperty PROP_STATE = new ValueProperty( TYPE, "State" );
    
    Value<String> getState();
    void setState( String value );
    
    // *** Url ***
    
    @Label( standard = "URL" )
    @DefaultValue( text = "http://www.eclipse.org" )
    @XmlBinding( path = "url" )
    
    ValueProperty PROP_URL = new ValueProperty( TYPE, "Url" );
    
    Value<String> getUrl();
    void setUrl( String value );

}
