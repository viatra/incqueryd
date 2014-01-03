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

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.samples.contacts.internal.ManagerNameValidationService;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "job" )

public interface JobOccupation extends Occupation
{
    ElementType TYPE = new ElementType( JobOccupation.class );
    
    // *** Employer ***
    
    @Label( standard = "employer" )
    @Required
    @XmlBinding( path = "employer" )
    
    ValueProperty PROP_EMPLOYER = new ValueProperty( TYPE, "Employer" );
    
    Value<String> getEmployer();
    void setEmployer( String value );
    
    // *** Title ***
    
    @Label( standard = "title" )
    @Required
    @XmlBinding( path = "title" )
    
    ValueProperty PROP_TITLE = new ValueProperty( TYPE, "Title" );
    
    Value<String> getTitle();
    void setTitle( String value );
    
    // *** Manager ***
    
    @Label( standard = "manager" )
    @Service( impl = ManagerNameValidationService.class )
    @XmlBinding( path = "manager" )

    @PossibleValues
    ( 
        property = "/Contacts/Name", 
        caseSensitive = false, 
        invalidValueMessage = "Could not find contact name \"{0}\" in the repository." 
    )

    ValueProperty PROP_MANAGER = new ValueProperty( TYPE, "Manager" );

    Value<String> getManager();
    void setManager( String value );

}
