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

package org.eclipse.sapphire.samples.po;

import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.samples.po.PurchaseComputerOp.Importance;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class PurchaseComputerOpListener extends FilteredListener<PropertyContentEvent>
{
    @Override
    protected void handleTypedEvent( final PropertyContentEvent event )
    {
        final PurchaseComputerOp op = (PurchaseComputerOp) event.property().element();
        
        if( op.getPerformanceImportance().content() != Importance.VERY_IMPORTANT )
        {
            op.setProcessor( null );
            op.setMemory( null );
        }
        
        if( op.getStorageImportance().content() != Importance.VERY_IMPORTANT && op.getPerformanceImportance().content() != Importance.VERY_IMPORTANT )
        {
            op.setStorage( null );
        }
        
        if( op.getGamingImportance().content() != Importance.VERY_IMPORTANT )
        {
            op.setVideoCard( null );
        }
    }

}
