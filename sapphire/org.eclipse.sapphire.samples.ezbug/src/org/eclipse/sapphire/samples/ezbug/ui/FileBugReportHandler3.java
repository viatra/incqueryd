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
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sapphire.samples.ezbug.FileBugReportOp;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.SapphireWizard;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class FileBugReportHandler3 extends AbstractHandler
{
    public Object execute( final ExecutionEvent event )
    {
        final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow( event );
        
        final SapphireWizard<FileBugReportOp> wizard = new SapphireWizard<FileBugReportOp>
        ( 
            FileBugReportOp.TYPE,
            DefinitionLoader.context( FileBugReportOp.class ).sdef( "EzBug" ).wizard( "FileBugReportWizard" )
        );
        
        final WizardDialog dialog = new WizardDialog( window.getShell(), wizard );
        
        dialog.open();
        
        return null;
    }
    
}
