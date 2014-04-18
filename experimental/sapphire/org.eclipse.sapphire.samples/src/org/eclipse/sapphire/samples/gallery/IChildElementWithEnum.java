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

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IChildElementWithEnum extends IChildElement
{
    ElementType TYPE = new ElementType( IChildElementWithEnum.class );
    
    // *** EnumValue ***
    
    @Type( base = ThreeChoiceAnswer.class )
    @Label( standard = "enum value" )
    @XmlBinding( path = "enum" )
    
    ValueProperty PROP_ENUM_VALUE = new ValueProperty( TYPE, "EnumValue" );
    
    Value<ThreeChoiceAnswer> getEnumValue();
    void setEnumValue( String value );
    void setEnumValue( ThreeChoiceAnswer value );

}
