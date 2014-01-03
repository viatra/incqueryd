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

package org.eclipse.sapphire.samples.journal;

import java.util.Date;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Serialization;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Entry extends Element
{
    ElementType TYPE = new ElementType( Entry.class );
    
    // *** Date ***
    
    @Type( base = Date.class )
    @Serialization( primary = "yyyy-MM-dd" )
    @Required
    
    ValueProperty PROP_DATE = new ValueProperty( TYPE, "Date" );
    
    Value<Date> getDate();
    void setDate( String value );
    void setDate( Date value );
    
    // *** Category ***
    
    ValueProperty PROP_CATEGORY = new ValueProperty( TYPE, "Category" );
    
    Value<String> getCategory();
    void setCategory( String value );
    
    // *** Summary ***
    
    @Required
    
    ValueProperty PROP_SUMMARY = new ValueProperty( TYPE, "Summary" );
    
    Value<String> getSummary();
    void setSummary( String value );
    
    // *** Notes ***
    
    @LongString
    
    ValueProperty PROP_NOTES = new ValueProperty( TYPE, "Notes" );
    
    Value<String> getNotes();
    void setNotes( String value );
    
    // *** Files ***
    
    @Type( base = File.class )
    @XmlListBinding( path = "" )

    ListProperty PROP_FILES = new ListProperty( TYPE, "Files" );
    
    ElementList<File> getFiles();
    
}
