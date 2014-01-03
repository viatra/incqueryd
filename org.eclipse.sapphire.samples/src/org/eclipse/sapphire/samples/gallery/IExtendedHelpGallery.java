/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ling Hao - initial implementation and ongoing maintenance
 *    Konstantin Komissarchik - [350340] Eliminate DocumentationProvider annotation in favor of service approach
 ******************************************************************************/

package org.eclipse.sapphire.samples.gallery;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Documentation;
import org.eclipse.sapphire.modeling.annotations.Documentation.Topic;
import org.eclipse.sapphire.modeling.annotations.DocumentationMergeStrategy;
import org.eclipse.sapphire.modeling.annotations.Label;

/**
 * @author <a href="mailto:ling.hao@oracle.com">Ling Hao</a>
 */

@Label( standard = "extended help gallery" )
@Documentation ( content = "Content help for extended help gallery." )

public interface IExtendedHelpGallery extends IHelpGallery
{
    ElementType TYPE = new ElementType( IExtendedHelpGallery.class );

    // *** Simple ***

    @Documentation
    ( 
        content = "Content help for extended simple integer",
        mergeStrategy = DocumentationMergeStrategy.APPEND,
        topics = 
        {
            @Topic( label = "another wikipedia integer entry", url = "http://en.wikipedia.org/wiki/Integer" )
        }
    )

    ValueProperty PROP_SIMPLE = new ValueProperty( TYPE, IHelpGallery.PROP_SIMPLE );
    
    // *** Positive ***
    
    @Documentation( content = "Content help for extended positive integer" )

    ValueProperty PROP_POSITIVE = new ValueProperty( TYPE, IHelpGallery.PROP_POSITIVE );

    // *** RangeConstrainedWithDefault ***
    
    ValueProperty PROP_RANGE_CONSTRAINED_WITH_DEFAULT = new ValueProperty( TYPE, IHelpGallery.PROP_RANGE_CONSTRAINED_WITH_DEFAULT );
 
    // *** SimpleChoice ***
    
    @Documentation( content = " Content help for simple choice [ol][li]yes[/li][li]maybe[/li][li]no[/li][/ol]", mergeStrategy = DocumentationMergeStrategy.REPLACE )

    ValueProperty PROP_SIMPLE_CHOICE = new ValueProperty( TYPE, IHelpGallery.PROP_SIMPLE_CHOICE );
}
