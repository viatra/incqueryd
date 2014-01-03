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

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.Path;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IBrowseSupportGalleryListEntry extends Element
{
    ElementType TYPE = new ElementType( IBrowseSupportGalleryListEntry.class );
    
    // *** MultiOptionPath ***
    
    @Type( base = Path.class )
    @Label( standard = "multi option path" )
    @XmlBinding( path = "multi-option-path" )

    ValueProperty PROP_MULTI_OPTION_PATH = new ValueProperty( TYPE, "MultiOptionPath" );
    
    Value<Path> getMultiOptionPath();
    void setMultiOptionPath( String value );
    void setMultiOptionPath( Path value );
    
}
