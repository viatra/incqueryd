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
 ******************************************************************************/

package org.eclipse.sapphire.samples.gallery;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ImpliedElementProperty;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 * @author <a href="mailto:kamesh.sampath@accenture.com">Kamesh Sampath</a>
 */

@XmlBinding( path = "gallery" )

public interface IGallery extends Element
{
    ElementType TYPE = new ElementType( IGallery.class );
    
    // *** CustomColors ***
    
    @Type( base = CustomColor.class )
    
    ListProperty PROP_CUSTOM_COLORS = new ListProperty( TYPE, "CustomColors" );
    
    ElementList<CustomColor> getCustomColors();
    
    // *** IntegerValueGallery ***
    
    @Type( base = IIntegerValueGallery.class )
    @XmlBinding( path = "integer" )

    ImpliedElementProperty PROP_INTEGER_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "IntegerValueGallery" );
    
    IIntegerValueGallery getIntegerValueGallery();
    
    // *** LongIntegerValueGallery ***
    
    @Type( base = ILongIntegerValueGallery.class )
    @XmlBinding( path = "long-integer" )

    ImpliedElementProperty PROP_LONG_INTEGER_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "LongIntegerValueGallery" );
    
    ILongIntegerValueGallery getLongIntegerValueGallery();
    
    // *** BigIntegerValueGallery ***

    @Type( base = IBigIntegerValueGallery.class )
    @XmlBinding( path = "big-integer" )
    
    ImpliedElementProperty PROP_BIG_INTEGER_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "BigIntegerValueGallery" );
    
    IBigIntegerValueGallery getBigIntegerValueGallery();
    
    // *** FloatValueGallery ***

    @Type( base = IFloatValueGallery.class )
    @XmlBinding( path = "float" )
    
    ImpliedElementProperty PROP_FLOAT_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "FloatValueGallery" );
    
    IFloatValueGallery getFloatValueGallery();
    
    // *** DoubleValueGallery ***

    @Type( base = IDoubleValueGallery.class )
    @XmlBinding( path = "double" )
    
    ImpliedElementProperty PROP_DOUBLE_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "DoubleValueGallery" );
    
    IDoubleValueGallery getDoubleValueGallery();
    
    // *** BigDecimalValueGallery ***

    @Type( base = IBigDecimalValueGallery.class )
    @XmlBinding( path = "big-decimal" )
    
    ImpliedElementProperty PROP_BIG_DECIMAL_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "BigDecimalValueGallery" );
    
    IBigDecimalValueGallery getBigDecimalValueGallery();
    
    // *** BooleanValueGallery ***

    @Type( base = IBooleanValueGallery.class )
    @XmlBinding( path = "boolean" )
    
    ImpliedElementProperty PROP_BOOLEAN_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "BooleanValueGallery" );
    
    IBooleanValueGallery getBooleanValueGallery();
    
    // *** EnumValueGallery ***

    @Type( base = IEnumValueGallery.class )
    @XmlBinding( path = "enum" )
    
    ImpliedElementProperty PROP_ENUM_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "EnumValueGallery" );
    
    IEnumValueGallery getEnumValueGallery();
    
    // *** JavaTypeNameValueGallery ***

    @Type( base = IJavaTypeNameValueGallery.class )
    @XmlBinding( path = "java-type-name" )
    
    ImpliedElementProperty PROP_JAVA_TYPE_NAME_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "JavaTypeNameValueGallery" );
    
    IJavaTypeNameValueGallery getJavaTypeNameValueGallery();
    
    // *** CustomValueGallery ***
    
    @Type( base = ICustomValueGallery.class )
    @XmlBinding( path = "custom-value" )
    
    ImpliedElementProperty PROP_CUSTOM_VALUE_GALLERY = new ImpliedElementProperty( TYPE, "CustomValueGallery" );
    
    ICustomValueGallery getCustomValueGallery();
    
    // *** ValuePropertiesGallery ***
    
    @Type( base = IValuePropertiesGallery.class )
    @XmlBinding( path = "value-properties-gallery" )

    ImpliedElementProperty PROP_VALUE_PROPERTIES_GALLERY = new ImpliedElementProperty( TYPE, "ValuePropertiesGallery" );
    
    IValuePropertiesGallery getValuePropertiesGallery();
    
    // *** BrowseSupportGallery ***
    
    @Type( base = IBrowseSupportGallery.class )
    @Label( standard = "browse support gallery" )
    @XmlBinding( path = "browse-support" )
    
    ImpliedElementProperty PROP_BROWSE_SUPPORT_GALLERY = new ImpliedElementProperty( TYPE, "BrowseSupportGallery" );
    
    IBrowseSupportGallery getBrowseSupportGallery();
    
    // *** ElementPropertiesGallery ***
    
    @Type( base = IElementPropertiesGallery.class )
    @XmlBinding( path = "element-properties-gallery" )

    ImpliedElementProperty PROP_ELEMENT_PROPERTIES_GALLERY = new ImpliedElementProperty( TYPE, "ElementPropertiesGallery" );
    
    IElementPropertiesGallery getElementPropertiesGallery();
    
    // *** ListPropertiesGallery ***
    
    @Type( base = ListPropertiesGallery.class )
    @XmlBinding( path = "list-properties-gallery" )

    ImpliedElementProperty PROP_LIST_PROPERTIES_GALLERY = new ImpliedElementProperty( TYPE, "ListPropertiesGallery" );
    
    ListPropertiesGallery getListPropertiesGallery();
    
    // *** ValuePropertyActionsGallery ***
    
    @Type( base = IValuePropertyActionsGallery.class )
    @Label( standard = "value property actions gallery" )
    @XmlBinding( path = "value-property-actions-gallery" )
    
    ImpliedElementProperty PROP_VALUE_PROPERTY_ACTIONS_GALLERY = new ImpliedElementProperty( TYPE, "ValuePropertyActionsGallery" );
    
    IValuePropertyActionsGallery getValuePropertyActionsGallery();
    
    // *** SectionsGallery ***
    
    @Type( base = ISectionsGallery.class )
    @Label( standard = "sections gallery" )
    @XmlBinding( path = "sections-gallery" )
    
    ImpliedElementProperty PROP_SECTIONS_GALLERY = new ImpliedElementProperty( TYPE, "SectionsGallery" );
    
    ISectionsGallery getSectionsGallery();

    // *** VisibleWhenGallery ***
    
    @Type( base = VisibleWhenGallery.class )
    
    ImpliedElementProperty PROP_VISIBLE_WHEN_GALLERY = new ImpliedElementProperty( TYPE, "VisibleWhenGallery" );
    
    VisibleWhenGallery getVisibleWhenGallery();

    // *** HelpGallery ***
    
    @Type( base = IHelpGallery.class )
    @XmlBinding( path = "help" )

    ImpliedElementProperty PROP_HELP_GALLERY = new ImpliedElementProperty( TYPE, "HelpGallery" );
    
    IHelpGallery getHelpGallery();

    // *** ExtendedHelpGallery ***
    
    @Type( base = IExtendedHelpGallery.class )
    @XmlBinding( path = "extended-help" )

    ImpliedElementProperty PROP_EXTENDED_HELP_GALLERY = new ImpliedElementProperty( TYPE, "ExtendedHelpGallery" );
    
    IExtendedHelpGallery getExtendedHelpGallery();

    // *** EnablementGallery ***
    
    @Type( base = IEnablementGallery.class )
    @XmlBinding( path = "enablement" )

    ImpliedElementProperty PROP_ENABLEMENT_GALLERY = new ImpliedElementProperty( TYPE, "EnablementGallery" );
    
    IEnablementGallery getEnablementGallery();
    
    // *** RelatedContentGallery ***
    
    @Type( base = IRelatedContentGallery.class )
    @XmlBinding( path = "related-content" )

    ImpliedElementProperty PROP_RELATED_CONTENT_GALLERY = new ImpliedElementProperty( TYPE, "RelatedContentGallery" );
    
    IRelatedContentGallery getRelatedContentGallery();
    
    // *** HtmlContentGallery ***
    
    @Type( base = IHtmlContentGallery.class )
    @XmlBinding( path = "html-content" )

    ImpliedElementProperty PROP_HTML_CONTENT_GALLERY = new ImpliedElementProperty( TYPE, "HtmlContentGallery" );
    
    IHtmlContentGallery getHtmlContentGallery();
    
    // *** TabGroupGallery ***
    
    @Type( base = ITabGroupGallery.class )
    @XmlBinding( path = "tab-group" )

    ImpliedElementProperty PROP_TAB_GROUP_GALLERY = new ImpliedElementProperty( TYPE, "TabGroupGallery" );
    
    ITabGroupGallery getTabGroupGallery();
    
    // *** AncestorAccessGallery ***
    
    @Type( base = AncestorAccessGalleryLevel1.class )
    @XmlBinding( path = "ancestor-access" )
    
    ImpliedElementProperty PROP_ANCESTOR_ACCESS_GALLERY = new ImpliedElementProperty( TYPE, "AncestorAccessGallery" );
    
    AncestorAccessGalleryLevel1 getAncestorAccessGallery();
    
    // *** SplitFormGallery ***
    
    @Type( base = SplitFormGallery.class )
    @XmlBinding( path = "split-form" )

    ImpliedElementProperty PROP_SPLIT_FORM_GALLERY = new ImpliedElementProperty( TYPE, "SplitFormGallery" );
    
    SplitFormGallery getSplitFormGallery();
    
}
