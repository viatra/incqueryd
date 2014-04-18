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

package org.eclipse.sapphire.samples.contacts.internal;

import org.eclipse.sapphire.ValuePropertyBinding;
import org.eclipse.sapphire.modeling.xml.XmlElement;
import org.eclipse.sapphire.modeling.xml.XmlResource;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class AreaCodeBinding extends ValuePropertyBinding
{
    private static final String EL_NUMBER = "number";
    
    @Override
    public String read()
    {
        final XmlElement el = ( (XmlResource) property().element().resource() ).getXmlElement( false );
        
        final String pnStr = el.getChildNodeText( EL_NUMBER );
        final ParsedPhoneNumber pn = new ParsedPhoneNumber( pnStr );

        return pn.getAreaCode();
    }

    @Override
    public void write( final String value )
    {
        final XmlElement el = ( (XmlResource) property().element().resource() ).getXmlElement( false );
        
        final String pnStr = el.getChildNodeText( EL_NUMBER );
        final ParsedPhoneNumber pn = new ParsedPhoneNumber( pnStr );

        pn.setAreaCode( value );
        el.setChildNodeText( EL_NUMBER, pn.toString(), true );
    }
    
}
