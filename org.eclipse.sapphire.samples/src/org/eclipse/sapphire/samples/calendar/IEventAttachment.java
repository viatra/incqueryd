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

package org.eclipse.sapphire.samples.calendar;

import java.net.URL;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.Path;
import org.eclipse.sapphire.modeling.annotations.FileSystemResourceType;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.annotations.ValidFileSystemResourceType;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.samples.calendar.internal.EventAttachmentLocalCopyRelativePathService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IEventAttachment extends Element
{
    ElementType TYPE = new ElementType( IEventAttachment.class );

    // *** LocalCopyLocation ***
    
    @Type( base = Path.class )
    @Label( standard = "local copy location" )
    @Required
    @Service( impl = EventAttachmentLocalCopyRelativePathService.class )
    @ValidFileSystemResourceType( FileSystemResourceType.FILE )
    @XmlBinding( path = "local-copy" )

    ValueProperty PROP_LOCAL_COPY_LOCATION = new ValueProperty( TYPE, "LocalCopyLocation" );

    Value<Path> getLocalCopyLocation();
    void setLocalCopyLocation( String localCopyLocation );
    void setLocalCopyLocation( Path localCopyLocation );
    
    // *** PublicCopyLocation ***

    @Type( base = URL.class )
    @Label( standard = "public copy location" )
    @Required
    @XmlBinding( path = "public-copy" )

    ValueProperty PROP_PUBLIC_COPY_LOCATION = new ValueProperty( TYPE, "PublicCopyLocation" );

    Value<URL> getPublicCopyLocation();
    void setPublicCopyLocation( String publicCopyLocation );
    void setPublicCopyLocation( URL publicCopyLocation );
    
}
