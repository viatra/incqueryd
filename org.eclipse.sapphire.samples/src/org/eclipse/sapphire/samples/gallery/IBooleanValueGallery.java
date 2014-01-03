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
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IBooleanValueGallery extends Element
{
    ElementType TYPE = new ElementType( IBooleanValueGallery.class );
    
    // *** StringProperty ***
    
    @Label( standard = "string property" )
    @XmlBinding( path = "string" )
    
    ValueProperty PROP_STRING_PROPERTY = new ValueProperty( TYPE, "StringProperty" );
    
    Value<String> getStringProperty();
    void setStringProperty( String value );
    
    // *** BooleanProperty ***
    
    @Type( base = Boolean.class )
    @Label( standard = "boolean property" )
    @XmlBinding( path = "boolean" )
    
    ValueProperty PROP_BOOLEAN_PROPERTY = new ValueProperty( TYPE, "BooleanProperty" );
    
    Value<Boolean> getBooleanProperty();
    void setBooleanProperty( String value );
    void setBooleanProperty( Boolean value );
    
}
