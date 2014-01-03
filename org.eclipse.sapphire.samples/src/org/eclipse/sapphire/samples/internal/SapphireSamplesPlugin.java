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

package org.eclipse.sapphire.samples.internal;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

/**
 * @author <a href="mailto:kosta@bea.com">Konstantin Komissarchik</a>
 */

public final class SapphireSamplesPlugin 
{
    public static final String PLUGIN_ID = "org.eclipse.sapphire.samples"; //$NON-NLS-1$
    private static final ILog platformLog = Platform.getLog( getBundle() );
    
    public static Bundle getBundle()
    {
        return Platform.getBundle( PLUGIN_ID );
    }
    
    public static void log( final Exception e )
    {
        final String msg = e.getMessage() + ""; //$NON-NLS-1$
        log( new Status( IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e ) );
    }

    public static void log( final IStatus status )
    {
        platformLog.log( status );
    }
    
    public static ImageDescriptor getImageDescriptor( final String path )
    {
        return AbstractUIPlugin.imageDescriptorFromPlugin( PLUGIN_ID, path );
    }
    
}
