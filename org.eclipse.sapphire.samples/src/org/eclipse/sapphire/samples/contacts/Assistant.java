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

package org.eclipse.sapphire.samples.contacts;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Image;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.LongString;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;
import org.eclipse.sapphire.samples.contacts.internal.AssistantNameValidationService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Image( path = "Contact.png" )

public interface Assistant extends Element
{
    ElementType TYPE = new ElementType( Assistant.class );

    // *** Name ***
    
    @XmlBinding( path = "name" )
    @Label( standard = "name" )
    @Required
    @Service( impl = AssistantNameValidationService.class )

    @PossibleValues
    ( 
        property = "/Contacts/Name", 
        caseSensitive = false, 
        invalidValueMessage = "Could not find contact name \"{0}\" in the repository." 
    )

    ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );

    Value<String> getName();
    void setName( String name );
    
    // *** Notes ***
    
    @XmlBinding( path = "notes" )
    @Label( standard = "notes" )
    @LongString

    ValueProperty PROP_NOTES = new ValueProperty( TYPE, "Notes" );

    Value<String> getNotes();
    void setNotes( String notes );
    
    // *** DelegatedTasks ***
    
    @Type( base = AssistantTask.class )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "task", type = AssistantTask.class ) )
    @Label( standard = "delegated tasks" )
                             
    ListProperty PROP_DELEGATED_TASKS = new ListProperty( TYPE, "DelegatedTasks" );
    
    ElementList<AssistantTask> getDelegatedTasks();
    
}
