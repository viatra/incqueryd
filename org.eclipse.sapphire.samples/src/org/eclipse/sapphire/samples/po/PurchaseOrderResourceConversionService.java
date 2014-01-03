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

package org.eclipse.sapphire.samples.po;

import org.eclipse.sapphire.ConversionService;
import org.eclipse.sapphire.MasterConversionService;
import org.eclipse.sapphire.modeling.ByteArrayResourceStore;
import org.eclipse.sapphire.modeling.xml.RootXmlResource;
import org.eclipse.sapphire.modeling.xml.XmlResourceStore;

/**
 * Implementation of ConversionService that is capable of converting a ByteArrayResourceStore to an XmlResource
 * or a Resource. Conversion is only performed if the context element type is PurchaseOrder.
 * 
 * <p>This service implementation is necessary because the default file extension for purchase order files is "po"
 * rather than "xml" and PurchaseOrder element does not have XML binding annotations. The combination of these
 * two factors prevent the framework-provided ConversionService implementations from engaging.</p>
 * 
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class PurchaseOrderResourceConversionService extends ConversionService<Object,RootXmlResource>
{
    public PurchaseOrderResourceConversionService()
    {
        super( Object.class, RootXmlResource.class );
    }

    @Override
    public RootXmlResource convert( final Object object )
    {
        final ByteArrayResourceStore store = service( MasterConversionService.class ).convert( object, ByteArrayResourceStore.class );
        
        if( store != null )
        {
            return new RootXmlResource( new XmlResourceStore( store ) );
        }
        
        return null;
    }
    
}
