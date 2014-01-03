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

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Enablement;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Field extends Accessible
{
    ElementType TYPE = new ElementType( Field.class );
    
    // *** Name ***
    
    @Label( standard = "name" )
    @Required
    
    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );
    
    Value<String> getName();
    void setName( String value );
    
    // *** Type ***
    
    @Label( standard = "type" )
    @Required
    
    ValueProperty PROP_TYPE = new ValueProperty( TYPE, "Type" );
    
    Value<String> getType();
    void setType( String value );
    
    // *** Static ***
    
    @Type( base = Boolean.class )
    @Label( standard = "static" )
    @DefaultValue( text = "false" )
    @Enablement( expr = "${ Parent.Kind == 'class' }" )
    
    ValueProperty PROP_STATIC = new ValueProperty( TYPE, "Static" );
    
    Value<Boolean> getStatic();
    void setStatic( String value );
    void setStatic( Boolean value );
    
    // *** Final ***
    
    @Type( base = Boolean.class )
    @Label( standard = "final" )
    @DefaultValue( text = "false" )
    @Enablement( expr = "${ Parent.Kind == 'class' }" )
    
    ValueProperty PROP_FINAL = new ValueProperty( TYPE, "Final" );
    
    Value<Boolean> getFinal();
    
    void setFinal( String value );
    void setFinal( Boolean value );
    
}
