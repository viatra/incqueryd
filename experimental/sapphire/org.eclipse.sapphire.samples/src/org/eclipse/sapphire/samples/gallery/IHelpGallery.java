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

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Documentation;
import org.eclipse.sapphire.modeling.annotations.Documentation.Topic;
import org.eclipse.sapphire.modeling.annotations.DocumentationMergeStrategy;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.NumericRange;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.samples.gallery.internal.PositiveIntegerDocumentationService;

/**
 * @author <a href="mailto:ling.hao@oracle.com">Ling Hao</a>
 */

public interface IHelpGallery extends Element
{
    ElementType TYPE = new ElementType( IHelpGallery.class );

    // *** Simple ***

    @Type( base = Integer.class )
    @Label( standard = "simple" )
    @XmlBinding( path = "simple" )
    
    @Documentation
    ( 
        content = "Content help for simple integer. Option to [b]show in bold.[/b]" +
                "[br/]" +
                " Please note text in [b]  bold tag  [/b]   are trimmed.",
        mergeStrategy=DocumentationMergeStrategy.APPEND,
        topics = 
        {
            @Topic( label = "wikipedia integer", url = "http://en.wikipedia.org/wiki/Integer" ),
            @Topic( label = "wikipedia integer (computer science)", url = "http://en.wikipedia.org/wiki/Integer_%28computer_science%29" )
        }
    )

    ValueProperty PROP_SIMPLE = new ValueProperty( TYPE, "Simple" );

    Value<Integer> getSimple();
    void setSimple( String val );
    void setSimple( Integer val );
    
    // *** Positive ***
    
    @Type( base = Integer.class )
    @Label( standard = "positive" )
    @NumericRange( min = "0" )
    @Service( impl = PositiveIntegerDocumentationService.class )
    @XmlBinding( path = "positive" )

    ValueProperty PROP_POSITIVE = new ValueProperty( TYPE, "Positive" );

    Value<Integer> getPositive();
    void setPositive( String val );
    void setPositive( Integer val );

    // *** RangeConstrainedWithDefault ***
    
    @Type( base = Integer.class )
    @Label( standard = "range constrained with default" )
    @NumericRange( min = "5", max = "7000" )
    @DefaultValue( text = "1000" )
    @XmlBinding( path = "range-constrained-with-default" )

    ValueProperty PROP_RANGE_CONSTRAINED_WITH_DEFAULT = new ValueProperty( TYPE, "RangeConstrainedWithDefault" );

    Value<Integer> getRangeConstrainedWithDefault();
    void setRangeConstrainedWithDefault( String val );
    void setRangeConstrainedWithDefault( Integer val );
 
    // *** Code ***
    
    @Label( standard = "code" )
    @XmlBinding( path = "code" )
    @Documentation( content = "Content help containing code tag which preserves the spaces." +
            "[pbr/]" +
            "[code]" +
            "<actions>\n" +
            "    <action-group>\n" +
            "        <action>\n" +
            "            <class>MyAction1</class>\n" +
            "        </action>\n" +
            "        <action>\n" +
            "            <class>MyAction2</class>\n" +
            "        </action>\n" +
            "    </action-group>\n" +
            "</actions>" +
            "[/code]" )

    ValueProperty PROP_CODE = new ValueProperty( TYPE, "Code" );

    Value<String> getCode();
    void setCode( String code );

    // *** SimpleChoice ***

    @Type( base = ThreeChoiceAnswer.class )
    @Label( standard = "simple choice" )
    @XmlBinding( path = "simple-choice" )
    @Documentation( content = " Content help for simple choice " +
                "[ul]" +
                "[li]yes[/li]" +
                "[li]maybe[/li]" +
                "[li]no[/li]" +
                "[/ul]" )

    ValueProperty PROP_SIMPLE_CHOICE = new ValueProperty( TYPE, "SimpleChoice" );

    Value<ThreeChoiceAnswer> getSimpleChoice();
    void setSimpleChoice( String val );
    void setSimpleChoice( ThreeChoiceAnswer val );

}
