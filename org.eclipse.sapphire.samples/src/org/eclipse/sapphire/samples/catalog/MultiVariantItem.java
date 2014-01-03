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

import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.modeling.annotations.CountConstraint;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "multi-variant item" )

public interface MultiVariantItem extends Item
{
    ElementType TYPE = new ElementType( MultiVariantItem.class );
    
    // *** Variants ***
    
    @Type( base = ItemVariant.class )
    @CountConstraint( min = 1 )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "Variant", type = ItemVariant.class ) )
    
    ListProperty PROP_VARIANTS = new ListProperty( TYPE, "Variants" );
    
    ElementList<ItemVariant> getVariants();
    
}
