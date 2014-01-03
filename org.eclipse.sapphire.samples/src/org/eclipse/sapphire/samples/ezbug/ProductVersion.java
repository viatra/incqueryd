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

package org.eclipse.sapphire.samples.ezbug;

import org.eclipse.sapphire.modeling.annotations.EnumSerialization;
import org.eclipse.sapphire.modeling.annotations.Label;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "product version" )

public enum ProductVersion
{
    @Label( standard = "1.0" )
    @EnumSerialization( primary = "1.0" )
    
    V_1_0,
    
    @Label( standard = "1.5" )
    @EnumSerialization( primary = "1.5" )

    V_1_5,
    
    @Label( standard = "1.6" )
    @EnumSerialization( primary = "1.6" )
    
    V_1_6,
    
    @Label( standard = "2.0" )
    @EnumSerialization( primary = "2.0" )
    
    V_2_0,
    
    @Label( standard = "2.3" )
    @EnumSerialization( primary = "2.3" )
    
    V_2_3,
    
    @Label( standard = "2.4" )
    @EnumSerialization( primary = "2.4" )
    
    V_2_4,
    
    @Label( standard = "2.5" )
    @EnumSerialization( primary = "2.5" )
    
    V_2_5
}
