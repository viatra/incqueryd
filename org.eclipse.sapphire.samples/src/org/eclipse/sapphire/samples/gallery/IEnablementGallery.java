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
import org.eclipse.sapphire.modeling.annotations.Enablement;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IEnablementGallery extends Element
{
    ElementType TYPE = new ElementType( IEnablementGallery.class );

    // *** ControllingPropBoolean ***
    
    @Type( base = Boolean.class )
    @Label( standard = "boolean controlling property" )
    @DefaultValue( text = "false" )
    @XmlBinding( path = "controlling-prop-boolean" )
    
    ValueProperty PROP_CONTROLLING_PROP_BOOLEAN = new ValueProperty( TYPE, "ControllingPropBoolean" );
    
    Value<Boolean> getControllingPropBoolean();
    void setControllingPropBoolean( String value );
    void setControllingPropBoolean( Boolean value );
    
    // *** ControllingPropEnum ***
    
    @Type( base = ThreeChoiceAnswer.class )
    @Label( standard = "enum controlling property" )
    @DefaultValue( text = "NO" )
    @XmlBinding( path = "controlling-prop-enum" )
    
    ValueProperty PROP_CONTROLLING_PROP_ENUM = new ValueProperty( TYPE, "ControllingPropEnum" );
    
    Value<ThreeChoiceAnswer> getControllingPropEnum();
    void setControllingPropEnum( String value );
    void setControllingPropEnum( ThreeChoiceAnswer value );
    
    // *** DependentProp1 ***
    
    @Label( standard = "dependent property 1" )
    @Enablement( expr = "${ ControllingPropBoolean }" )
    @XmlBinding( path = "dependent-prop-1" )
    
    ValueProperty PROP_DEPENDENT_PROP_1 = new ValueProperty( TYPE, "DependentProp1" );
    
    Value<String> getDependentProp1();
    void setDependentProp1( String value );
    
    // *** DependentProp2 ***
    
    @Label( standard = "dependent property 2" )
    @Enablement( expr = "${ ControllingPropEnum == 'YES' }" )
    @XmlBinding( path = "dependent-prop-2" )
    
    ValueProperty PROP_DEPENDENT_PROP_2 = new ValueProperty( TYPE, "DependentProp2" );
    
    Value<String> getDependentProp2();
    void setDependentProp2( String value );
    
    // *** DependentProp3 ***
    
    @Label( standard = "dependent property 3" )
    @Enablement( expr = "${ ! ControllingPropBoolean && ( ControllingPropEnum == 'YES' || ControllingPropEnum == 'MAYBE' ) }" )
    @XmlBinding( path = "dependent-prop-3" )
    
    ValueProperty PROP_DEPENDENT_PROP_3 = new ValueProperty( TYPE, "DependentProp3" );
    
    Value<String> getDependentProp3();
    void setDependentProp3( String value );

}
