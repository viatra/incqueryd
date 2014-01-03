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

package org.eclipse.sapphire.samples.gallery;

import org.eclipse.sapphire.modeling.annotations.Label;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "size units" )

public enum SizeUnits
{
    @Label( standard = "inch" )
    
    INCH,
    
    @Label( standard = "foot" )
    
    FOOT,
    
    @Label( standard = "yard" )
    
    YARD,
    
    @Label( standard = "mile" )
    
    MILE,

    @Label( standard = "light year" )
    
    LIGHT_YEAR,
}
