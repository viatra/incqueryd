/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ling Hao - initial implementation and ongoing maintenance
 *    Konstantin Komissarchik - [342098] Separate dependency on org.eclipse.core.runtime (part 1)
 *    Konstantin Komissarchik - [350340] Eliminate DocumentationProvider annotation in favor of service approach
 ******************************************************************************/

package org.eclipse.sapphire.samples.gallery.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.sapphire.services.DocumentationService;

/**
 * @author <a href="mailto:ling.hao@oracle.com">Ling Hao</a>
 */

public class PositiveIntegerDocumentationService extends DocumentationService 
{
    @Override
    public String content()
    {
        return "Positive integers are all the whole numbers greater than zero: 1, 2, 3, 4, 5, ......";
    }

    @Override
    public List<Topic> topics()
    {
        final Topic resource = new Topic( "wikipedia positive number", "http://en.wikipedia.org/wiki/Positive_number" );
        return Collections.singletonList( resource );
    }

}
