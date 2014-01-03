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

package org.eclipse.sapphire.samples.ezbug.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class FileBugReportHandler4 extends AbstractHandler
{
    public Object execute( final ExecutionEvent event ) throws ExecutionException
    {
        try
        {
            HandlerUtil.getActiveWorkbenchWindow( event ).getActivePage().showView( "org.eclipse.sapphire.samples.fileBugReportView" );
        }
        catch( PartInitException e )
        {
            throw new ExecutionException( "Error while opening view.", e );
        }
        
        return null;
    }
    
}
