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

package org.eclipse.sapphire.samples.sqlschema;

import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.services.ReferenceService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public class ColumnReferenceService extends ReferenceService
{
    private Table table;
    private Listener listener;

    @Override
    public final Object resolve( final String reference )
    {
        final Table table = table();
        
        if( this.table != table )
        {
            if( this.table != null )
            {
                this.table.detach( listener, "Columns/Name" );
                this.table = null;
            }

            if( table != null )
            {
                if( this.listener == null )
                {
                    this.listener = new FilteredListener<PropertyContentEvent>()
                    {
                        @Override
                        protected void handleTypedEvent( final PropertyContentEvent event )
                        {
                            broadcast();
                        }
                    };
                }
                
                this.table = table;
                this.table.attach( this.listener, "Columns/Name" );
            }
        }
        
        if( table != null && reference != null )
        {
            for( final Column column : table.getColumns() )
            {
                final String n = column.getName().content();
                
                if( n != null && n.equals( reference ) )
                {
                    return column;
                }
            }
        }
        
        return null;
    }
    
    protected Table table()
    {
        return context( Table.class );
    }

    @Override
    public void dispose()
    {
        if( this.table != null )
        {
            this.table.detach( this.listener, "Columns/Name" );
            this.table = null;
            this.listener = null;
        }
        
        super.dispose();
    }
    
}
