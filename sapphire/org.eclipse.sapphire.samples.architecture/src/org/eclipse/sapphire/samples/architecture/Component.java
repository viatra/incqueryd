/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation and ongoing maintenance
 *    Shenxue Zhou - include the node positioning info in the model
 ******************************************************************************/

package org.eclipse.sapphire.samples.architecture;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ImpliedElementProperty;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Enablement;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Component extends Element
{
    ElementType TYPE = new ElementType( Component.class );
    
    // *** Name ***
    
    @Required
    @XmlBinding( path = "name" )
    
    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );
    
    Value<String> getName();
    void setName( String value );
    
    // *** Description ***
    
    @LongString
    @XmlBinding( path = "description" )
    
    ValueProperty PROP_DESCRIPTION = new ValueProperty( TYPE, "Description" );
    
    Value<String> getDescription();
    void setDescription( String value );
    
    // *** Dependencies ***
    
    @Type( base = ComponentDependency.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "dependency", type = ComponentDependency.class ) )

    ListProperty PROP_DEPENDENCIES = new ListProperty( TYPE, "Dependencies" );
    
    ElementList<ComponentDependency> getDependencies();
    
    // *** Provider ***
    
    @Label( standard = "provider" )
    @Enablement( expr = "${ VersionMatches( Root().Version, '[1.1' ) }" )
    @XmlBinding( path = "provider" )
    
    ValueProperty PROP_PROVIDER = new ValueProperty( TYPE, "Provider" );
    
    Value<String> getProvider();
    void setProvider( String value );
    
    // *** Copyright ***
    
    @Label( standard = "copyright" )
    @Enablement( expr = "${ VersionMatches( Root().Version, '[1.1' ) }" )
    @LongString
    @XmlBinding( path = "copyright" )
    
    ValueProperty PROP_COPYRIGHT = new ValueProperty( TYPE, "Copyright" );
    
    Value<String> getCopyright();
    void setCopyright( String value );
    
    // *** Position ***
    
    @Type( base = Position.class )
    @XmlBinding( path = "position")
    
    ImpliedElementProperty PROP_POSITION = new ImpliedElementProperty( TYPE, "Position" );

    Position getPosition();    
    
}
