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

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.samples.gallery.IValuePropertyActionsGallery;
import org.eclipse.sapphire.samples.gallery.IValuePropertyActionsGalleryEntity;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireAction;
import org.eclipse.sapphire.ui.def.ActionHandlerDef;
import org.eclipse.sapphire.ui.forms.swt.FormComponentPresentation;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ValuePropertyActionsGalleryReferenceCreateActionHandler2 extends ValuePropertyActionsGalleryReferenceCreateActionHandlerBase
{
    @Override
    public void init( final SapphireAction action,
                      final ActionHandlerDef def )
    {
        super.init( action, def );

        setLabel( "create custom..." );
    }

    @Override
    protected Object run( final Presentation context )
    {
        final IInputValidator inputValidator = new IInputValidator()
        {
            public String isValid( final String text )
            {
                if( text == null )
                {
                    return "Entity name must be specified.";
                }
                else
                {
                    final String trimmed = text.trim();

                    if( trimmed.length() == 0 )
                    {
                        return "Entity name must be specified.";
                    }
                    else if( isEntityDefined( trimmed ) )
                    {
                        return MessageFormat.format( "Entity \"{0}\" already exists.", trimmed );
                    }
                }
                
                return null;
            }
        };
        
        final InputDialog dialog = new InputDialog( ( (FormComponentPresentation) context ).shell(), "Create", "Create a new entity with the specified name.", "", inputValidator );
        
        if( dialog.open() != Window.CANCEL )
        {
            final String entityName = dialog.getValue();
            final Element element = getModelElement();
            
            final IValuePropertyActionsGalleryEntity entity = element.nearest( IValuePropertyActionsGallery.class ).getEntities().insert();
            entity.setName( entityName );
            
            ( (Value<?>) property() ).write( entityName );
        }
        
        return null;
    }
    
}
