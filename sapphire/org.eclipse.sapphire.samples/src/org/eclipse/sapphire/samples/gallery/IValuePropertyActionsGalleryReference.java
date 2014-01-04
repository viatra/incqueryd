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
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.xml.annotations.XmlValueBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "reference" )

public interface IValuePropertyActionsGalleryReference extends Element
{
    ElementType TYPE = new ElementType( IValuePropertyActionsGalleryReference.class );
    
    // *** Reference ***
    
    @Label( standard = "reference" )
    @PossibleValues( property = "../Entities/Name", invalidValueMessage = "{0} is not a known entity." )
    @XmlValueBinding( path = "" )
    
    ValueProperty PROP_REFERENCE = new ValueProperty( TYPE, "Reference" );
    
    Value<String> getReference();
    void setReference( String value );
 
}
