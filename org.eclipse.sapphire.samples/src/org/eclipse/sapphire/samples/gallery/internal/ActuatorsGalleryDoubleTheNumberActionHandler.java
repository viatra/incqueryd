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

package org.eclipse.sapphire.samples.gallery.internal;

import org.eclipse.sapphire.samples.gallery.ActuatorsGallery;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireActionHandler;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ActuatorsGalleryDoubleTheNumberActionHandler extends SapphireActionHandler
{
    @Override
    protected Object run( final Presentation context )
    {
        final ActuatorsGallery element = (ActuatorsGallery) context.part().getModelElement();
        final int original = element.getNumber().content();
        final int doubled = original * 2;
        element.setNumber( doubled );
        
        return null;
    }
    
}
