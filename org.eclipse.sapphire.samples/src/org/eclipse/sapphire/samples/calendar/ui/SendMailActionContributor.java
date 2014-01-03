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

package org.eclipse.sapphire.samples.calendar.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sapphire.samples.calendar.integrated.IAttendee;
import org.eclipse.sapphire.ui.assist.PropertyEditorAssistContext;
import org.eclipse.sapphire.ui.assist.PropertyEditorAssistContribution;
import org.eclipse.sapphire.ui.assist.PropertyEditorAssistContributor;
import org.eclipse.sapphire.ui.assist.PropertyEditorAssistSection;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class SendMailActionContributor extends PropertyEditorAssistContributor
{
    @Override
    public void contribute( final PropertyEditorAssistContext context )
    {
        final IAttendee attendee = (IAttendee) context.getPart().getLocalModelElement();
        
        if( attendee.getEMail().text() != null )
        {
            final PropertyEditorAssistContribution.Factory contribution = PropertyEditorAssistContribution.factory();
            
            contribution.text( "<p><a href=\"action\" nowrap=\"true\">Send mail...</a></p>" );
            
            contribution.link
            (
                "action",
                new Runnable()
                {
                    public void run()
                    {
                        MessageDialog.openInformation( context.getShell(), "Mail", "Launch e-mail client here..."  );
                    }
                }
            );
            
            final PropertyEditorAssistSection section = context.getSection( SECTION_ID_ACTIONS );
            section.addContribution( contribution.create() );
        }
    }
    
}
