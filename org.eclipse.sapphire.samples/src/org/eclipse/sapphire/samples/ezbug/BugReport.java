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

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface BugReport extends Element
{
    ElementType TYPE = new ElementType( BugReport.class );
    
    // *** CustomerId ***
    
    @XmlBinding( path = "customer" )
    @Label( standard = "&customer ID" )

    ValueProperty PROP_CUSTOMER_ID = new ValueProperty( TYPE, "CustomerId" );

    Value<String> getCustomerId();
    void setCustomerId( String value );

    // *** Title ***
    
    @XmlBinding( path = "title" )
    @Label( standard = "&title" )
    @Required

    ValueProperty PROP_TITLE = new ValueProperty( TYPE, "Title" );

    Value<String> getTitle();
    void setTitle( String value );
    
    // *** Details ***
    
    @XmlBinding( path = "details" )
    @Label( standard = "&details" )
    @LongString
    @Required

    ValueProperty PROP_DETAILS = new ValueProperty( TYPE, "Details" );

    Value<String> getDetails();
    void setDetails( String value );
    
    // *** ProductVersion ***

    @Type( base = ProductVersion.class )
    @XmlBinding( path = "version" )
    @Label( standard = "&version" )
    @DefaultValue( text = "2.5" )

    ValueProperty PROP_PRODUCT_VERSION = new ValueProperty( TYPE, "ProductVersion" );

    Value<ProductVersion> getProductVersion();
    void setProductVersion( String value );
    void setProductVersion( ProductVersion value );
    
    // *** ProductStage ***

    @Type( base = ProductStage.class )
    @XmlBinding( path = "stage" )
    @Label( standard = "&stage" )
    @DefaultValue( text = "final" )

    ValueProperty PROP_PRODUCT_STAGE = new ValueProperty( TYPE, "ProductStage" );

    Value<ProductStage> getProductStage();
    void setProductStage( String value );
    void setProductStage( ProductStage value );
    
    // *** Hardware ***

    @Type( base = HardwareItem.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "hardware-item", type = HardwareItem.class ) )
    @Label( standard = "&hardware" )
    
    ListProperty PROP_HARDWARE = new ListProperty( TYPE, "Hardware" );
    
    ElementList<HardwareItem> getHardware();
    
}
