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

package hu.bme.mit.incqueryd.reteeditor;

import hu.bme.mit.incqueryd.reteeditor.iternal.AlphaNodeReferenceService;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ReferenceValue;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Reference;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface AlphaNodeRef extends Element
{
    ElementType TYPE = new ElementType( AlphaNodeRef.class );
    
    // *** Entity ***
    
    @Reference( target = AlphaNode.class )
    @Service( impl = AlphaNodeReferenceService.class )
    @Required
    @PossibleValues( property = "/Entities/Name" )

    ValueProperty PROP_ALPHANODE = new ValueProperty( TYPE, "AlphaNode" );

    ReferenceValue<String,AlphaNode> getAlphaNode();
    void setAlphaNode( String value );
    
}
