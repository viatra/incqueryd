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

package org.eclipse.sapphire.samples.sqlschema;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 */

public interface Table extends Element 
{
    ElementType TYPE = new ElementType( Table.class );
    
    // *** Name ***
    
    @XmlBinding( path = "name" )
    @Label( standard = "name" )
    @Required

    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );

    Value<String> getName();
    void setName( String name );

    // *** Columns ***
    
    @Type( base = Column.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "column", type = Column.class ) )
    
    ListProperty PROP_COLUMNS = new ListProperty( TYPE, "Columns" );
    
    ElementList<Column> getColumns();    

    // *** ForeignKeys ***
    
    @Type( base = ForeignKey.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "foreign-key", type = ForeignKey.class ) )

    ListProperty PROP_FOREIGN_KEYS = new ListProperty( TYPE, "ForeignKeys" );
    
    ElementList<ForeignKey> getForeignKeys();
    
}
