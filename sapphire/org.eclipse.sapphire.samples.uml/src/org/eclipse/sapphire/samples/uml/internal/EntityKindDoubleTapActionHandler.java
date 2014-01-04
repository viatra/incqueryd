package org.eclipse.sapphire.samples.uml.internal;

/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Shenxue Zhou - initial implementation and ongoing maintenance
 ******************************************************************************/

import org.eclipse.sapphire.samples.uml.Entity;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireActionHandler;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 */

public final class EntityKindDoubleTapActionHandler extends SapphireActionHandler 
{
	@Override
	protected Object run( final Presentation context ) 
	{
		Entity entity = (Entity)getPart().getLocalModelElement();
		if (entity.getKind().content() == Entity.Kind.CLASS)
		{
			entity.setKind(Entity.Kind.INTERFACE);
		}
		else 
		{
			entity.setKind(Entity.Kind.CLASS);
		}
		return null;
	}

}
