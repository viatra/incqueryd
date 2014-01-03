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

package org.eclipse.sapphire.samples.newfile;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.SapphireDialog;
import org.eclipse.sapphire.workspace.ui.CreateWorkspaceFileWizard;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class OpenCreateFileWizardHandler extends AbstractHandler
{
    public Object execute( final ExecutionEvent event )
    {
        final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow( event );
        
        final CreateFileOp operation = CreateFileOp.TYPE.instantiate();
        
        try
        {
            final SapphireDialog selectRootDialog = new SapphireDialog
            (
                window.getShell(), operation,
                DefinitionLoader.context( getClass() ).sdef( "CreateFileWizard" ).dialog( "CustomizeDialog" )
            );
            
            if( selectRootDialog.open() == Dialog.OK )
            {
                final CreateWorkspaceFileWizard<CreateFileOp> createFileWizard = new CreateWorkspaceFileWizard<CreateFileOp>
                (
                    operation,
                    DefinitionLoader.context( getClass() ).sdef( "CreateFileWizard" ).wizard( "CreateFileWizard" )
                );
                
                final WizardDialog createFileWizardDialog = new WizardDialog( window.getShell(), createFileWizard );
                
                createFileWizardDialog.open();
            }
        }
        finally
        {
            operation.dispose();
        }
        
        return null;
    }
    
}
