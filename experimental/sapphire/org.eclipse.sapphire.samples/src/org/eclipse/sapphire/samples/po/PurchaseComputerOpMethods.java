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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.sapphire.modeling.ProgressMonitor;
import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.util.MutableReference;
import org.eclipse.swt.widgets.Display;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class PurchaseComputerOpMethods
{
    public static final Status execute( final PurchaseComputerOp context, final ProgressMonitor monitor )
    {
        final Display display = Display.getDefault();
        
        if( display.getThread() != Thread.currentThread() )
        {
            final MutableReference<Status> result = new MutableReference<Status>();
            
            display.syncExec
            (
                new Runnable()
                {
                    public void run()
                    {
                        result.set( execute( context, monitor ) );
                    }
                }
            );
            
            return result.get();
        }

        final PurchaseOrder po = context.getPurchaseOrder().content();
        
        add( po, context.getProcessor().content() );
        add( po, context.getMemory().content() );
        add( po, context.getStorage().content() );
        add( po, context.getVideoCard().content() );
        
        return Status.createOkStatus();
    }
    
    private static void add( final PurchaseOrder po, final String item )
    {
        if( item != null )
        {
            final Matcher matcher = Pattern.compile( "(.*) - \\$([0-9]+)" ).matcher( item );
            
            if( matcher.find() )
            {
                final PurchaseOrderEntry entry = po.getEntries().insert();
                
                entry.setDescription( matcher.group( 1 ) );
                entry.setItem( Integer.toHexString( entry.getDescription().content().hashCode() ).toUpperCase() );
                entry.setUnitPrice( matcher.group( 2 ) );
            }
        }
    }
}
