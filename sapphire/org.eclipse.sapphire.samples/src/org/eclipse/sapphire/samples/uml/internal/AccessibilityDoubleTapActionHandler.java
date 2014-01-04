package org.eclipse.sapphire.samples.uml.internal;

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

import org.eclipse.sapphire.samples.uml.Accessibility;
import org.eclipse.sapphire.samples.uml.Accessible;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireActionHandler;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class AccessibilityDoubleTapActionHandler extends SapphireActionHandler 
{
	@Override
	protected Object run( final Presentation context ) 
	{
		final Accessible accessible = (Accessible) getPart().getLocalModelElement();
		final Accessibility accessibility = accessible.getAccessibility().content();
		final Accessibility[] all = Accessibility.values();
		
		boolean found = false;
		Accessibility next = null;
		
		for( Accessibility a : all )
		{
		    if( a == accessibility )
		    {
		        found = true;
		    }
		    else if( found )
		    {
		        next = a;
		        break;
		    }
		}
		
		if( found && next == null )
		{
		    next = all[ 0 ];
		}
		
		accessible.setAccessibility( next );
		
		return null;
	}

}
