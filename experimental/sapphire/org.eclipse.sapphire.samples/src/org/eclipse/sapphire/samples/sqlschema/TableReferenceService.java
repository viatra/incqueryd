/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Shenxue Zhou - initial implementation and ongoing maintenance
 *    Konstantin Komissarchik - initial implementation and ongoing maintenance
 ******************************************************************************/

package org.eclipse.sapphire.samples.sqlschema;

import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.services.ReferenceService;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public class TableReferenceService extends ReferenceService 
{
    private Listener listener;
    
	@Override
    protected void init()
    {
        super.init();
        
        this.listener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                broadcast();
            }
        };
        
        context( Schema.class ).attach( this.listener, "Tables/Name" );
    }

    @Override
    public Object resolve( final String reference ) 
    {
        if( reference != null )
        {
            final Schema schema = context( Schema.class );
            
            for( Table table : schema.getTables() )
            {
                if( reference.equals( table.getName().text() ) )
                {
                    return table;
                }
            }
        }
        
        return null;
    }

    @Override
    public void dispose()
    {
        context( Schema.class ).detach( this.listener, "Tables/Name" );
        this.listener = null;
        
        super.dispose();
    }

}
