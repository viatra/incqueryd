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

@Label( standard = "type", full = "hardware type" )

public enum HardwareType
{
    @Label( standard = "CPU" )

    CPU,
    
    @Label( standard = "main board" )
    @EnumSerialization( primary = "Main Board" )
    
    MAIN_BOARD,

    @Label( standard = "RAM" )
    
    RAM,
    
    @Label( standard = "video controller" )
    @EnumSerialization( primary = "Video Controller" )
    
    VIDEO_CONTROLLER,

    @Label( standard = "storage" )
    @EnumSerialization( primary = "Storage" )
    
    STORAGE,
    
    @Label( standard = "other" )
    @EnumSerialization( primary = "Other" )
    
    OTHER
}
