/******************************************************************************
 * Copyright (c) 2013 Oracle and Accenture
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation
 *    Kamesh Sampath - [355751] General improvement of XML root binding API    
 ******************************************************************************/

package org.eclipse.sapphire.samples.contacts;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlNamespace;
import org.eclipse.sapphire.modeling.xml.annotations.XmlSchema;
import org.eclipse.sapphire.samples.contacts.internal.ContactRepositoryImageService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 * @author <a href="mailto:kamesh.sampath@accenture.com">Kamesh Sampath</a>
 */

@XmlNamespace( uri="http://www.eclipse.org/sapphire/samples/contacts", prefix="c" )
@XmlSchema( namespace="http://www.eclipse.org/sapphire/samples/contacts", location="http://www.eclipse.org/sapphire/samples/contacts/1.0" )
@XmlBinding( path = "c:contacts" )
@Service( impl = ContactRepositoryImageService.class )

public interface ContactRepository extends Element
{
    ElementType TYPE = new ElementType( ContactRepository.class );
    
    // *** Contacts ***

    @Type( base = Contact.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "contact", type = Contact.class ) )
    
    ListProperty PROP_CONTACTS = new ListProperty( TYPE, "Contacts" );
    
    ElementList<Contact> getContacts();
}
