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

package org.eclipse.sapphire.samples.uml;

import org.eclipse.sapphire.modeling.annotations.EnumSerialization;
import org.eclipse.sapphire.modeling.annotations.Label;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public enum Accessibility
{
    @Label( standard = "public" )
    @EnumSerialization( primary = "public" )
    
    PUBLIC,
    
    @Label( standard = "package protected" )
    @EnumSerialization( primary = "package-protected" )
    
    PACKAGE_PROTECTED,

    @Label( standard = "protected" )
    @EnumSerialization( primary = "protected" )
    
    PROTECTED,

    @Label( standard = "private" )
    @EnumSerialization( primary = "private" )
    
    PRIVATE
}
