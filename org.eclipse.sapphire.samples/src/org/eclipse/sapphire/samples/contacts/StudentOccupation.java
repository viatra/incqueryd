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
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Label( standard = "student" )

public interface StudentOccupation extends Occupation
{
    ElementType TYPE = new ElementType( StudentOccupation.class );
    
    // *** EducationalInstitution ***
    
    @Label( standard = "educational institution" )
    @Required
    @XmlBinding( path = "educational-institution" )
    
    ValueProperty PROP_EDUCATIONAL_INSTITUTION = new ValueProperty( TYPE, "EducationalInstitution" );
    
    Value<String> getEducationalInstitution();
    void setEducationalInstitution( String value );
    
    // *** Program ***
    
    @Label( standard = "program" )
    @Required
    @XmlBinding( path = "program" )
    
    ValueProperty PROP_PROGRAM = new ValueProperty( TYPE, "Program" );
    
    Value<String> getProgram();
    void setProgram( String value );

}
