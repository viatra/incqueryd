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
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 */

public interface Column extends Element 
{
    ElementType TYPE = new ElementType( Column.class );
    
    // *** Name ***
    
    @Label( standard = "name" )
    @Required
    @XmlBinding( path = "name" )

    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );

    Value<String> getName();
    void setName( String name );
    
    // *** Type ***
    
    @Type( base = ColumnType.class )
    @Label( standard = "type" )
    @Required
    @XmlBinding( path = "type" )
    
    ValueProperty PROP_TYPE = new ValueProperty( TYPE, "Type" );
    
    Value<ColumnType> getType();
    void setType( String value );
    void setType( ColumnType value );
    
    // *** IsPrimaryKey ***
    
	@Type( base = Boolean.class )
	@Label( standard = "primary key" )
	@XmlBinding( path = "is-primary-key" )
	@DefaultValue(text = "false")
	
	ValueProperty PROP_IS_PRIMARY_KEY = new ValueProperty( TYPE, "IsPrimaryKey" );
	
	Value<Boolean> getIsPrimaryKey();
	void setIsPrimaryKey( String value );
	void setIsPrimaryKey( Boolean value );    

}
