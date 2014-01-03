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

import org.eclipse.sapphire.Event;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.ReferenceValue;
import org.eclipse.sapphire.services.ReferenceService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ForeignKeyColumnReferenceService extends ColumnReferenceService
{
    private Listener propertyContentListener;
    private Listener referenceServiceListener;
    
    @Override
    protected void init()
    {
        super.init();
        
        this.propertyContentListener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                broadcast();
            }
        };
        
        this.referenceServiceListener = new Listener()
        {
            @Override
            public void handle( final Event event )
            {
                broadcast();
            }
        };
        
        final ReferenceValue<String,Table> rt = context( ForeignKey.class ).getReferencedTable();
        
        rt.attach( this.propertyContentListener );
        rt.service( ReferenceService.class ).attach( this.referenceServiceListener );
    }

    protected Table table()
    {
        return context( ForeignKey.class ).getReferencedTable().resolve();
    }

    @Override
    public void dispose()
    {
        final ForeignKey fk = context( ForeignKey.class );
        
        if( ! fk.disposed() )
        {
            final ReferenceValue<String,Table> rt = fk.getReferencedTable();
            
            rt.detach( this.propertyContentListener );
            rt.service( ReferenceService.class ).detach( this.referenceServiceListener );
        }
        
        this.propertyContentListener = null;
        this.referenceServiceListener = null;
        
        super.dispose();
    }

}
