/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Shenxue Zhou - initial implementation and ongoing maintenance
 ******************************************************************************/

package org.eclipse.sapphire.samples.officespace;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 */

public interface OfficeSpace extends Element
{
    ElementType TYPE = new ElementType( OfficeSpace.class );
    
    // *** Name ***
    
    @Required
    @XmlBinding( path = "name" )
    
    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );
    
    Value<String> getName();
    void setName( String value );
    
    // *** Buildings ***
    
    @Type( base = Building.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "building", type = Building.class ) )

    ListProperty PROP_BUILDINGS = new ListProperty( TYPE, "Buildings" );
    
    ElementList<Building> getBuildings();

}
