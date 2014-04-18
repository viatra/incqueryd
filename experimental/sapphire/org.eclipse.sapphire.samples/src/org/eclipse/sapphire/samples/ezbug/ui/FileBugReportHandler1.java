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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.sapphire.samples.ezbug.FileBugReportOp;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.SapphireDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class FileBugReportHandler1 extends AbstractHandler
{
    public Object execute( final ExecutionEvent event )
    {
        final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow( event );
        
        final FileBugReportOp operation = FileBugReportOp.TYPE.instantiate();
        
        try
        {
            final SapphireDialog dialog = new SapphireDialog
            (
                window.getShell(), operation.getBugReport(),
                DefinitionLoader.context( FileBugReportOp.class ).sdef( "EzBug" ).dialog( "FileBugReportDialog" )
            );
            
            if( dialog.open() == Dialog.OK )
            {
                // Do something. User input is found in the bug report model.
            }
        }
        finally
        {
            operation.dispose();
        }
        
        return null;
    }
    
}
