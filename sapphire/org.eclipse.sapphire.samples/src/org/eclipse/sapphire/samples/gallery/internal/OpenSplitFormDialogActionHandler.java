/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation
 ******************************************************************************/

package org.eclipse.sapphire.samples.gallery.internal;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.samples.gallery.IGallery;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireActionHandler;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.FormComponentPresentation;
import org.eclipse.sapphire.ui.forms.swt.SapphireDialog;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public class OpenSplitFormDialogActionHandler extends SapphireActionHandler
{
    @Override
    protected Object run( final Presentation context )
    {
        final Element element = context.part().getLocalModelElement();
        
        final SapphireDialog dialog = new SapphireDialog
        (
            ( (FormComponentPresentation) context ).shell(), element, 
            DefinitionLoader.context( IGallery.class ).sdef( "GalleryEditor" ).dialog( "SplitFormDialog" )
        );
        
        dialog.open();
        
        return null;
    }
    
}
