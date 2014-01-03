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

import org.eclipse.sapphire.samples.gallery.IValuePropertyActionsGallery;
import org.eclipse.sapphire.samples.gallery.IValuePropertyActionsGalleryEntity;
import org.eclipse.sapphire.ui.forms.PropertyEditorActionHandler;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public abstract class ValuePropertyActionsGalleryReferenceCreateActionHandlerBase

    extends PropertyEditorActionHandler
    
{
    protected final boolean isEntityDefined( final String entityName )
    {
        for( IValuePropertyActionsGalleryEntity entity : getModelElement().nearest( IValuePropertyActionsGallery.class ).getEntities() )
        {
            final String x = entity.getName().content();
            
            if( x != null && x.equals( entityName ) )
            {
                return true;
            }
        }
        
        return false;
    }
    
}
