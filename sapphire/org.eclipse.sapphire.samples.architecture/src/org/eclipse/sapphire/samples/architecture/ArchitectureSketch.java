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
 *    Shenxue Zhou - Modify the sample to store layout info in the model
 ******************************************************************************/

package org.eclipse.sapphire.samples.architecture;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.Version;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.NumericRange;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 * @author <a href="mailto:kamesh.sampath@accenture.com">Kamesh Sampath</a>
 */

@XmlBinding( path = "architecture" )

public interface ArchitectureSketch extends Element
{
    ElementType TYPE = new ElementType( ArchitectureSketch.class );
    
    // *** Version ***
    
    @Type( base = Version.class )
    @Label( standard = "version" )
    @DefaultValue( text = "1.1" )
    @XmlBinding( path = "version" )
    
    ValueProperty PROP_VERSION = new ValueProperty( TYPE, "Version" );
    
    Value<Version> getVersion();
    void setVersion( String value );
    void setVersion( Version value );
    
    // *** Description ***
    
    @LongString
    @XmlBinding( path = "description" )
    
    ValueProperty PROP_DESCRIPTION = new ValueProperty( TYPE, "Description" );
    
    Value<String> getDescription();
    void setDescription( String value );
    
    // *** Components ***
    
    @Type( base = Component.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "component", type = Component.class ) )
    
    ListProperty PROP_COMPONENTS = new ListProperty( TYPE, "Components" );
    
    ElementList<Component> getComponents();
    
    // *** DetailLevel ***
    
    @Type( base = Integer.class )
    @Label( standard = "detail level" )
    @DefaultValue( text = "1" )
    @NumericRange( min = "0" )
    
    ValueProperty PROP_DETAIL_LEVEL = new ValueProperty( TYPE, "DetailLevel" );
    
    Value<Integer> getDetailLevel();
    void setDetailLevel( String value );
    void setDetailLevel( Integer value );
    
	// *** ShowGrid ***
	
	@Type( base = Boolean.class )
	@XmlBinding( path = "show-grid" )
	@DefaultValue( text = "false" )
	@Label( standard = "show grid")
	
	ValueProperty PROP_SHOW_GRID = new ValueProperty(TYPE, "ShowGrid");
	
	Value<Boolean> isShowGrid();
	void setShowGrid( String value );
	void setShowGrid( Boolean value );
    
	// *** ShowGuides ***
	
	@Type( base = Boolean.class )
	@XmlBinding( path = "show-guides" )
	@DefaultValue( text = "false" )
	@Label( standard = "show guides")
	
	ValueProperty PROP_SHOW_GUIDES = new ValueProperty(TYPE, "ShowGuides");
	
	Value<Boolean> isShowGuides();
	void setShowGuides( String value );
	void setShowGuides( Boolean value );
    
}
