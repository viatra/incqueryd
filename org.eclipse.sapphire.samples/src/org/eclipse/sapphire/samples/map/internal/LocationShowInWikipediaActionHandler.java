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

package org.eclipse.sapphire.samples.map.internal;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.sapphire.LoggingService;
import org.eclipse.sapphire.Sapphire;
import org.eclipse.sapphire.samples.map.Location;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireActionHandler;
import org.eclipse.sapphire.ui.diagram.editor.DiagramNodePart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

/**
 * Action handler for Sapphire.Diagram.Node.Default and Sample.Map.Location.ShowInWikipedia actions 
 * for destination nodes. The implementation opens a browser to the Wikipedia entry for the destination.
 * 
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class LocationShowInWikipediaActionHandler extends SapphireActionHandler
{
    @Override
    protected Object run( final Presentation context )
    {
        final DiagramNodePart part = (DiagramNodePart) context.part();
        final Location location = (Location) part.getModelElement();
        final String locationName = location.getName().text();

        if( locationName != null )
        {
            try
            {
                final IWorkbenchBrowserSupport support = PlatformUI.getWorkbench().getBrowserSupport();
                final IWebBrowser browser = support.getExternalBrowser();
                
                final URL url = new URL( "http://en.wikipedia.org/wiki/" + locationName );
                
                browser.openURL( url );
            }
            catch( MalformedURLException e )
            {
                Sapphire.service( LoggingService.class ).log( e );
            }
            catch( PartInitException e ) 
            {
                Sapphire.service( LoggingService.class ).log( e );
            }
        }
        
        return null;
    }

}
