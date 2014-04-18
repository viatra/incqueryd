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

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sapphire.samples.contacts.Contact;
import org.eclipse.sapphire.samples.contacts.ContactRepository;
import org.eclipse.sapphire.samples.contacts.SendContactOp;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireActionHandler;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.FormComponentPresentation;
import org.eclipse.sapphire.ui.forms.swt.SapphireWizard;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class SendContactActionHandler extends SapphireActionHandler
{
    @Override
    protected Object run( final Presentation context )
    {
        final Contact contact = (Contact) getModelElement();
        
        final SendContactOp operation = SendContactOp.TYPE.instantiate();
        
        try
        {
            operation.setContact( contact );
            
            final SapphireWizard<SendContactOp> wizard = new SapphireWizard<SendContactOp>
            ( 
                operation, 
                DefinitionLoader.context( ContactRepository.class ).sdef( "ContactRepositoryEditor" ).wizard( "SendContactWizard" )
            );
            
            final WizardDialog dialog = new WizardDialog( ( (FormComponentPresentation) context ).shell(), wizard );
            
            dialog.open();
        }
        finally
        {
            operation.dispose();
        }
        
        return null;
    }
    
}
