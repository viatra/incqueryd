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

package org.eclipse.sapphire.samples.catalog;

import static java.lang.Math.abs;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.ImageData;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.modeling.el.Function;
import org.eclipse.sapphire.modeling.el.FunctionContext;
import org.eclipse.sapphire.modeling.el.FunctionException;
import org.eclipse.sapphire.modeling.el.FunctionResult;
import org.eclipse.sapphire.ui.PartFunctionContext;
import org.eclipse.sapphire.ui.SapphirePart;
import org.eclipse.sapphire.ui.forms.MasterDetailsEditorPagePart;
import org.eclipse.sapphire.ui.forms.MasterDetailsEditorPageState;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ItemImageFunction extends Function
{
    private final ImageData IMAGE_GENERIC = ImageData.readFromClassLoader( ItemImageFunction.class, "Item.png" ).required();
    
    private final ImageData[] IMAGES =
    {
        ImageData.readFromClassLoader( ItemImageFunction.class, "ItemBlue.png" ).required(),
        ImageData.readFromClassLoader( ItemImageFunction.class, "ItemGreen.png" ).required(),
        ImageData.readFromClassLoader( ItemImageFunction.class, "ItemOrange.png" ).required(),
        ImageData.readFromClassLoader( ItemImageFunction.class, "ItemPurple.png" ).required(),
        ImageData.readFromClassLoader( ItemImageFunction.class, "ItemRed.png" ).required(),
        ImageData.readFromClassLoader( ItemImageFunction.class, "ItemTurquoise.png" ).required(),
        ImageData.readFromClassLoader( ItemImageFunction.class, "ItemYellow.png" ).required()
    };
    
    @Override
    public String name()
    {
        return "CatalogItemImage";
    }

    @Override
    public FunctionResult evaluate( final FunctionContext context )
    {
        if( context instanceof PartFunctionContext )
        {
            final SapphirePart part = ( (PartFunctionContext) context ).part();
            final MasterDetailsEditorPagePart page = part.nearest( MasterDetailsEditorPagePart.class );
            
            if( page != null )
            {
                final Element element = part.getLocalModelElement();
                
                if( element instanceof Item )
                {
                    final Item item = (Item) element;
                    final MasterDetailsEditorPageState state = page.state();
    
                    return new FunctionResult( this, context )
                    {
                        private Listener listener;
                        
                        @Override
                        protected void init()
                        {
                            this.listener = new FilteredListener<PropertyContentEvent>()
                            {
                                @Override
                                protected void handleTypedEvent( final PropertyContentEvent event )
                                {
                                    refresh();
                                }
                            };
                            
                            state.attach( this.listener, MasterDetailsEditorPageState.PROP_ATTRIBUTES.name() + "/*" );
                            element.property( Item.PROP_MANUFACTURER ).attach( this.listener );
                        }
    
                        @Override
                        protected Object evaluate()
                        {
                            final boolean color = state.getAttribute( ShowManufacturerColorActionHandler.ATTRIBUTE, false );
                            
                            if( color )
                            {
                                final String manufacturer = item.getManufacturer().content();
                                final int hashCode = ( manufacturer == null ? 0 : manufacturer.hashCode() );
                                final int index = abs( hashCode ) % IMAGES.length;
                                
                                return IMAGES[ index ];
                            }
                            else
                            {
                                return IMAGE_GENERIC;
                            }
                        }
    
                        @Override
                        public void dispose()
                        {
                            super.dispose();
                            
                            if( this.listener != null )
                            {
                                state.detach( this.listener, MasterDetailsEditorPageState.PROP_ATTRIBUTES.name() + "/*" );
                                element.property( Item.PROP_MANUFACTURER ).detach( this.listener );
                                
                                this.listener = null;
                            }
                        }
                    };
                }
            }
        }
        
        throw new FunctionException( "CatalogItemImage() function cannot be used in this context.");
    }
    
}
