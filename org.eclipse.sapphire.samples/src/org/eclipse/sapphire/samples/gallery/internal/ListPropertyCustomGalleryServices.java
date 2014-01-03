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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.samples.gallery.IChildElement;
import org.eclipse.sapphire.samples.gallery.IChildElementWithEnum;
import org.eclipse.sapphire.samples.gallery.IChildElementWithInteger;
import org.eclipse.sapphire.samples.gallery.ListPropertyCustomGallery;
import org.eclipse.sapphire.services.PossibleTypesService;
import org.eclipse.sapphire.services.PossibleTypesServiceData;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ListPropertyCustomGalleryServices
{
    private ListPropertyCustomGalleryServices() {}
    
    public static final class ListPossibleTypesService extends PossibleTypesService
    {
        @Override
        protected void initPossibleTypesService()
        {
            final Listener listener = new FilteredListener<PropertyContentEvent>()
            {
                @Override
                protected void handleTypedEvent( final PropertyContentEvent event )
                {
                    refresh();
                }
            };
            
            final ListPropertyCustomGallery gallery = context( ListPropertyCustomGallery.class );
            gallery.property( ListPropertyCustomGallery.PROP_ALLOW_CHILD_ELEMENT_WITH_INTEGER ).attach( listener );
            gallery.property( ListPropertyCustomGallery.PROP_ALLOW_CHILD_ELEMENT_WITH_ENUM ).attach( listener );
        }
        
        @Override
        protected PossibleTypesServiceData compute()
        {
            final ListPropertyCustomGallery gallery = context( ListPropertyCustomGallery.class );
            final List<ElementType> types = new ArrayList<ElementType>();
            
            types.add( IChildElement.TYPE );
            
            if( gallery.getAllowChildElementWithInteger().content() )
            {
                types.add( IChildElementWithInteger.TYPE );
            }
            
            if( gallery.getAllowChildElementWithEnum().content() )
            {
                types.add( IChildElementWithEnum.TYPE );
            }
            
            return new PossibleTypesServiceData( types );
        }
    }
    
}
