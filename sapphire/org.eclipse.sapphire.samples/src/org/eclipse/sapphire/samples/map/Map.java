/******************************************************************************
 * Copyright (c) 2013 Oracle and Accenture
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation
 *    Kamesh Sampath - [355751] General improvement of XML root binding API
 *    Konstantin Komissarchik - miscellaneous improvements    
 ******************************************************************************/

package org.eclipse.sapphire.samples.map;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.modeling.annotations.DelegateImplementation;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;
import org.eclipse.sapphire.samples.map.internal.MapMethods;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 * @author <a href="mailto:kamesh.sampath@accenture.com">Kamesh Sampath</a>
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@XmlBinding( path = "map")

public interface Map extends Element
{
    ElementType TYPE = new ElementType( Map.class );
    
    // *** Locations ***

    @Type( base = Location.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "location", type = Location.class ) )
    
    ListProperty PROP_LOCATIONS = new ListProperty( TYPE, "Locations" );
    
    ElementList<Location> getLocations();
    
    // ** Method: findLocation
    
    @DelegateImplementation( MapMethods.class )
    
    Location findLocation( String name );
    
    // ** Method: hasLocation
    
    @DelegateImplementation( MapMethods.class )
    
    boolean hasLocation( String name );
    
    // *** Routes ***
    
    @Type( base = Route.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "route", type = Route.class ) )
    
    ListProperty PROP_ROUTES = new ListProperty( TYPE, "Routes" );
    
    ElementList<Route> getRoutes();
    
}
