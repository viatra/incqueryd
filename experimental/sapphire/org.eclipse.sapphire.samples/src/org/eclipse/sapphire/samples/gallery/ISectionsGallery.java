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
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface ISectionsGallery extends Element
{
    ElementType TYPE = new ElementType( ISectionsGallery.class );
    
    // *** Text ***
    
    @Label( standard = "text" )
    @XmlBinding( path = "text" )
    
    ValueProperty PROP_TEXT = new ValueProperty( TYPE, "Text" );
    
    Value<String> getText();
    void setText( String value );
    
    // *** ThreeChoiceAnswer ***
    
    @Type( base = ThreeChoiceAnswer.class )
    @Label( standard = "three choice answer" )
    @DefaultValue( text = "no" )
    @XmlBinding( path = "three-choice-answer" )
    
    ValueProperty PROP_THREE_CHOICE_ANSWER = new ValueProperty( TYPE, "ThreeChoiceAnswer" );
    
    Value<ThreeChoiceAnswer> getThreeChoiceAnswer();
    void setThreeChoiceAnswer( String value );
    void setThreeChoiceAnswer( ThreeChoiceAnswer value );
    
}
