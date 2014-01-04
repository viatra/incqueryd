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
import org.eclipse.sapphire.ReferenceValue;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.CountConstraint;
import org.eclipse.sapphire.modeling.annotations.MustExist;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Reference;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 */

public interface ForeignKey extends Element 
{
	ElementType TYPE = new ElementType( ForeignKey.class );
	
    // *** ReferencedTable ***
    
    @Reference( target = Table.class )
    @Service( impl = TableReferenceService.class )
    @Required
    @MustExist
    @PossibleValues( property = "/Tables/Name" )
    @XmlBinding( path = "referenced-table" )

    ValueProperty PROP_REFERENCED_TABLE = new ValueProperty( TYPE, "ReferencedTable" );

    ReferenceValue<String,Table> getReferencedTable();
    void setReferencedTable( String value );
    
    // *** ColumnAssociations ***
    
    interface ColumnAssociation extends Element
    {
        ElementType TYPE = new ElementType( ColumnAssociation.class );
        
        // *** LocalColumn ***
        
        @Reference( target = Column.class )
        @Required
        @MustExist
        @PossibleValues( property = "../../Columns/Name" )
        @Service( impl = ColumnReferenceService.class )
        
        ValueProperty PROP_LOCAL_COLUMN = new ValueProperty( TYPE, "LocalColumn" );
        
        ReferenceValue<String,Column> getLocalColumn();
        void setLocalColumn( String value );
        
        // *** ReferencedColumn ***
        
        @Reference( target = Column.class )
        @Required
        @MustExist
        @Service( impl = ForeignKeyColumnReferenceService.class )
        
        ValueProperty PROP_REFERENCED_COLUMN = new ValueProperty( TYPE, "ReferencedColumn" );
        
        ReferenceValue<String,Column> getReferencedColumn();
        void setReferencedColumn( String value );
    }
    
    @Type( base = ColumnAssociation.class )
    @CountConstraint( min = 1 )
    
    ListProperty PROP_COLUMN_ASSOCIATIONS = new ListProperty( TYPE, "ColumnAssociations" );
    
    ElementList<ColumnAssociation> getColumnAssociations();

}
