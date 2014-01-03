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

import org.eclipse.sapphire.modeling.xml.StandardXmlNamespaceResolver;
import org.eclipse.sapphire.modeling.xml.XmlDelimitedListBindingImpl;
import org.eclipse.sapphire.modeling.xml.XmlPath;
import org.eclipse.sapphire.samples.contacts.Contact;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ConnectionsListBinding extends XmlDelimitedListBindingImpl
{
    private static final StandardXmlNamespaceResolver NAMESPACE_RESOLVER = new StandardXmlNamespaceResolver( Contact.TYPE );
    private static final XmlPath PATH_CONNECTIONS = new XmlPath( "connections", NAMESPACE_RESOLVER );
    
    public ConnectionsListBinding()
    {
        super( PATH_CONNECTIONS );
    }
    
}
