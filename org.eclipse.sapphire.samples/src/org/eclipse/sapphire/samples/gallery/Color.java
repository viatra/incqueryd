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

import org.eclipse.sapphire.modeling.annotations.EnumSerialization;
import org.eclipse.sapphire.modeling.annotations.Image;
import org.eclipse.sapphire.modeling.annotations.Label;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "color" )

public enum Color
{
    @EnumSerialization( primary = "red" )
    @Label( standard = "Red [FF0000]" )
    @Image( path = "org/eclipse/sapphire/samples/SquareRed.png" )
    
    RED,
    
    @EnumSerialization( primary = "orange" )
    @Label( standard = "Orange [FF8A00]" )
    @Image( path = "org/eclipse/sapphire/samples/SquareOrange.png" )
    
    ORANGE,
    
    @EnumSerialization( primary = "yellow" )
    @Label( standard = "Yellow [FFF200]" )
    @Image( path = "org/eclipse/sapphire/samples/SquareYellow.png" )
    
    YELLOW,
    
    @EnumSerialization( primary = "green" )
    @Label( standard = "Green [00BC00]" )
    @Image( path = "org/eclipse/sapphire/samples/SquareGreen.png" )
    
    GREEN,
    
    @EnumSerialization( primary = "blue" )
    @Label( standard = "Blue [0000FF]" )
    @Image( path = "org/eclipse/sapphire/samples/SquareBlue.png" )
    
    BLUE,
    
    @EnumSerialization( primary = "violet" )
    @Label( standard = "Violet [8A00FF]" )
    @Image( path = "org/eclipse/sapphire/samples/SquareViolet.png" )
    
    VIOLET

}
