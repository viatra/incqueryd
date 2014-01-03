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

package org.eclipse.sapphire.samples.contacts.ui.internal;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.forms.BrowseActionHandler;
import org.eclipse.sapphire.ui.forms.swt.FormComponentPresentation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class WebSiteUrlBrowseHandler extends BrowseActionHandler
{
    @Override
    public String browse( final Presentation context )
    {
        String val = ( (Value<?>) property() ).text( true );
        val = ( val == null ? "" : val );
        
        final WebSiteUrlDialog dialog = new WebSiteUrlDialog( ( (FormComponentPresentation) context ).shell(), val );
        
        if( dialog.open() == Window.OK )
        {
            return dialog.getUrl();
        }
        else
        {
            return null;
        }
    }
    
    private static class WebSiteUrlDialog
    
        extends Dialog
        
    {
        private String domain = "";
        private String path = "";

        public WebSiteUrlDialog( final Shell shell,
                                 final String url )
        {
            super( shell );
            
            int domainStart = url.indexOf( "//" );
            
            if( domainStart == -1 )
            {
                domainStart = 0;
            }
            else
            {
                domainStart += 2;
            }
            
            if( domainStart < url.length() )
            {
                final int domainEnd = url.indexOf( '/', domainStart );
                
                if( domainEnd == -1 )
                {
                    this.domain = url.substring( domainStart );
                }
                else
                {
                    this.domain = url.substring( domainStart, domainEnd );
                    
                    final int pathStart = domainEnd + 1;
                    
                    if( pathStart < url.length() )
                    {
                        this.path = url.substring( pathStart );
                    }
                }
            }
        }
        
        public String getUrl()
        {
            final StringBuilder buf = new StringBuilder();

            buf.append( "http://" );
            buf.append( this.domain );
            
            if( this.path.length() > 0 )
            {
                buf.append( "/" );
                buf.append( this.path );
            }
            
            return buf.toString();
        }

        @Override
        protected Control createDialogArea( final Composite parent )
        {
            parent.getShell().setText( "URL Editor Dialog" );
            
            final Composite composite = (Composite) super.createDialogArea( parent );
            composite.setLayout( new GridLayout( 3, false ) );
            
            Label label = new Label( composite, SWT.NONE );
            label.setText( "" );
            label.setLayoutData( new GridData() );
            
            label = new Label( composite, SWT.NONE );
            label.setText( "domain" );
            label.setLayoutData( new GridData() );
            
            label = new Label( composite, SWT.NONE );
            label.setText( "path" );
            label.setLayoutData( new GridData() );
            
            label = new Label( composite, SWT.NONE );
            label.setText( "http://" );
            label.setLayoutData( new GridData() );
            
            GridData gd;
            
            final Text domainNameTextField = new Text( composite, SWT.BORDER );
            gd = new GridData( GridData.FILL_HORIZONTAL );
            gd.widthHint = 150;
            domainNameTextField.setLayoutData( gd );
            domainNameTextField.setText( this.domain );
            
            domainNameTextField.addModifyListener
            (
                new ModifyListener()
                {
                    public void modifyText( final ModifyEvent e )
                    {
                        WebSiteUrlDialog.this.domain = domainNameTextField.getText().trim();
                    }
                }
            );
            
            final Text pathTextField = new Text( composite, SWT.BORDER );
            gd = new GridData( GridData.FILL_HORIZONTAL );
            gd.widthHint = 200;
            pathTextField.setLayoutData( gd );
            pathTextField.setText( this.path );
            
            pathTextField.addModifyListener
            (
                new ModifyListener()
                {
                    public void modifyText( final ModifyEvent e )
                    {
                        WebSiteUrlDialog.this.path = pathTextField.getText().trim();
                    }
                }
            );
            
            return composite;
        }
    }
    
}
