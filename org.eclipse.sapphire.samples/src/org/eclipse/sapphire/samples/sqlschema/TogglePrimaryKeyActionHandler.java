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

package org.eclipse.sapphire.samples.sqlschema;

import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireActionHandler;
import org.eclipse.sapphire.ui.diagram.editor.ShapePart;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 */

public class TogglePrimaryKeyActionHandler extends SapphireActionHandler 
{
	@Override
	protected Object run( final Presentation context ) 
	{
        final ShapePart part = (ShapePart) context.part();
        final Column column = (Column) part.getModelElement();
        boolean isPrimaryKey = column.getIsPrimaryKey().content();
        column.setIsPrimaryKey(!isPrimaryKey);
		return null;
	}

}
