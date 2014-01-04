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

import static org.eclipse.sapphire.ui.forms.swt.GridLayoutUtil.gdfill;
import static org.eclipse.sapphire.ui.forms.swt.GridLayoutUtil.glayout;

import org.eclipse.sapphire.samples.ezbug.FileBugReportOp;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.SapphireForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class FileBugReportView extends ViewPart
{
    private FileBugReportOp operation;
    
    @Override
    public void createPartControl( final Composite parent )
    {
        parent.setBackground( parent.getDisplay().getSystemColor( SWT.COLOR_WHITE ) );
        parent.setBackgroundMode( SWT.INHERIT_DEFAULT );
        parent.setLayout( glayout( 1, 0, 0 ) );
        
        this.operation = FileBugReportOp.TYPE.instantiate();
        
        final SapphireForm control = new SapphireForm
        (
            parent, this.operation.getBugReport(),
            DefinitionLoader.context( FileBugReportOp.class ).sdef( "EzBug" ).form( "BugReportFormScrolled" )
        );

        control.setLayoutData( gdfill() );
    }

    @Override
    public void setFocus()
    {
    }
    
    @Override
    public void dispose()
    {
        super.dispose();
        
        if( this.operation != null )
        {
            this.operation.dispose();
        }
    }
    
}
