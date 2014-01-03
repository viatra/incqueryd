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

package org.eclipse.sapphire.samples.reading;

import java.util.Date;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Serialization;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface Entry extends Element
{
    ElementType TYPE = new ElementType( Entry.class );
    
    // *** DateFinished ***
    
    @Type( base = Date.class )
    @Label( standard = "date finished" )
    @Serialization( primary = "yyyy-MM-dd" )
    @Required
    
    ValueProperty PROP_DATE_FINISHED = new ValueProperty( TYPE, "DateFinished" );
    
    Value<Date> getDateFinished();
    void setDateFinished( String value );
    void setDateFinished( Date value );
    
    // *** Title ***
    
    @Label( standard = "title" )
    @Required
    
    ValueProperty PROP_TITLE = new ValueProperty( TYPE, "Title" );
    
    Value<String> getTitle();
    void setTitle( String value );
    
    // *** Author ***
    
    @Label( standard = "author" )
    @Required
    
    ValueProperty PROP_AUTHOR = new ValueProperty( TYPE, "Author" );
    
    Value<String> getAuthor();
    void setAuthor( String value );
    
    // *** Genre ***
    
    @Label( standard = "genre" )
    
    ValueProperty PROP_GENRE = new ValueProperty( TYPE, "Genre" );
    
    Value<String> getGenre();
    void setGenre( String value );
    
    // *** Isbn ***
    
    @Label( standard = "ISBN" )
    @XmlBinding( path = "ISBN" )
    
    ValueProperty PROP_ISBN = new ValueProperty( TYPE, "Isbn" );
    
    Value<String> getIsbn();
    void setIsbn( String value );
    
    // *** Pages ***
    
    @Type( base = Integer.class )
    @Label( standard = "pages" )
    
    ValueProperty PROP_PAGES = new ValueProperty( TYPE, "Pages" );
    
    Value<Integer> getPages();
    void setPages( String value );
    void setPages( Integer value );
    
    // *** Notes ***
    
    @Label( standard = "notes" )
    @LongString
    
    ValueProperty PROP_NOTES = new ValueProperty( TYPE, "Notes" );
    
    Value<String> getNotes();
    void setNotes( String value );
    
}
