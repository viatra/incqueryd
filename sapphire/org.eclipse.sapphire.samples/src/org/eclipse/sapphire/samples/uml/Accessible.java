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

package org.eclipse.sapphire.samples.uml;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Enablement;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Accessible extends Element
{
    ElementType TYPE = new ElementType( Accessible.class );
    
    // *** Accessibility ***
    
    @Type( base = Accessibility.class )
    @Label( standard = "accessibility" )
    @DefaultValue( text = "public" )
    @Enablement( expr = "${ Parent.Kind == 'class' }" )
    
    ValueProperty PROP_ACCESSIBILITY = new ValueProperty( TYPE, "Accessibility" );
    
    Value<Accessibility> getAccessibility();
    void setAccessibility( String value );
    void setAccessibility( Accessibility value );
    
}
