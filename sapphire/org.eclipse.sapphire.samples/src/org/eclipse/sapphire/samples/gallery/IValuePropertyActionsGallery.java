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

package org.eclipse.sapphire.samples.gallery;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ImpliedElementProperty;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IValuePropertyActionsGallery extends Element
{
    ElementType TYPE = new ElementType( IValuePropertyActionsGallery.class );
    
    // *** Entities ***
    
    @Type( base = IValuePropertyActionsGalleryEntity.class )
    @Label( standard = "entities" )
    @XmlListBinding( mappings = @XmlListBinding.Mapping( element = "entity", type = IValuePropertyActionsGalleryEntity.class ) )
    
    ListProperty PROP_ENTITIES = new ListProperty( TYPE, "Entities" );
    
    ElementList<IValuePropertyActionsGalleryEntity> getEntities();
    
    // *** Reference ***
    
    @Label( standard = "reference" )
    @PossibleValues( property = "Entities/Name", invalidValueMessage = "{0} is not a known entity." )
    @XmlBinding( path = "reference" )
    
    ValueProperty PROP_REFERENCE = new ValueProperty( TYPE, "Reference" );
    
    Value<String> getReference();
    void setReference( String value );
    
    // *** References ***
    
    @Type( base = IValuePropertyActionsGalleryReference.class )
    @Label( standard = "references" )
    @XmlListBinding( path = "references", mappings = @XmlListBinding.Mapping( element = "reference", type = IValuePropertyActionsGalleryReference.class ) )
    
    ListProperty PROP_REFERENCES = new ListProperty( TYPE, "References" );
    
    ElementList<IValuePropertyActionsGalleryReference> getReferences();
    
    // *** Actuators ***
    
    @Type( base = ActuatorsGallery.class )
    @XmlBinding( path = "actuators" )

    ImpliedElementProperty PROP_ACTUATORS = new ImpliedElementProperty( TYPE, "Actuators" );
    
    ActuatorsGallery getActuators();
 
}
