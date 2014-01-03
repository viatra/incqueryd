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

package org.eclipse.sapphire.samples.contacts;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ExecutableElement;
import org.eclipse.sapphire.Transient;
import org.eclipse.sapphire.TransientProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.ProgressMonitor;
import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.modeling.annotations.DelegateImplementation;
import org.eclipse.sapphire.modeling.annotations.Derived;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.samples.contacts.internal.SendContactOpMessageBodyDerivedValueService;
import org.eclipse.sapphire.samples.contacts.internal.SendContactOpMethods;
import org.eclipse.sapphire.samples.contacts.internal.SendContactToPossibleValuesService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface SendContactOp extends ExecutableElement
{
    ElementType TYPE = new ElementType(SendContactOp.class);
    
    // *** Contact ***

    @Type( base = Contact.class )

    TransientProperty PROP_CONTACT = new TransientProperty( TYPE, "Contact" );

    Transient<Contact> getContact();
    void setContact( Contact value );

    // *** To ***

    @Label( standard = "to", full = "message destination" )
    @Required
    @Service( impl = SendContactToPossibleValuesService.class )
    
    ValueProperty PROP_TO = new ValueProperty( TYPE, "To" );

    Value<String> getTo();
    void setTo( String value );
    
    // *** MessageBody ***
    
    @Label( standard = "message body" )
    @Derived
    @Service( impl = SendContactOpMessageBodyDerivedValueService.class )
    
    ValueProperty PROP_MESSAGE_BODY = new ValueProperty( TYPE, "MessageBody" );
    
    Value<String> getMessageBody();
    
    // ** execute **
    
    @DelegateImplementation( SendContactOpMethods.class )
    
    Status execute( ProgressMonitor monitor );

}
