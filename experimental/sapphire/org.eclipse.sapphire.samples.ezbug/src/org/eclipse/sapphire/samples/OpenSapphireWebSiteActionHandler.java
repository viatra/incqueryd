/******************************************************************************
 * Copyright (c) 2013 Liferay, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Greg Amerson - initial implementation
 ******************************************************************************/

package org.eclipse.sapphire.samples;

import java.net.URL;

import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireActionHandler;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

/**
 * @author <a href="mailto:gregory.amerson@liferay.com">Greg Amerson</a>
 */

public final class OpenSapphireWebSiteActionHandler extends SapphireActionHandler
{
    @Override
    protected Object run( final Presentation context ) 
    {
        Display.getDefault().asyncExec(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    IWorkbenchBrowserSupport browserSupport = PlatformUI.getWorkbench().getBrowserSupport();

                    IWebBrowser browser =
                        browserSupport.createBrowser(IWorkbenchBrowserSupport.LOCATION_BAR |
                            IWorkbenchBrowserSupport.NAVIGATION_BAR, null, "Sapphire Project", null);

                    browser.openURL(new URL("http://www.eclipse.org/sapphire/"));
                }
                catch (Exception e) 
                {
                    // ignore
                }
            }
        });

        return null;
    }

}
