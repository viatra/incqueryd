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
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ReferenceValue;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.java.JavaType;
import org.eclipse.sapphire.java.JavaTypeConstraint;
import org.eclipse.sapphire.java.JavaTypeKind;
import org.eclipse.sapphire.java.JavaTypeName;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.MustExist;
import org.eclipse.sapphire.modeling.annotations.Reference;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface IJavaTypeNameValueGallery extends Element
{
    ElementType TYPE = new ElementType( IJavaTypeNameValueGallery.class );

    // *** OptionalAnyType ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "optional any type" )
    @XmlBinding( path = "optional-any-type" )
    
    ValueProperty PROP_OPTIONAL_ANY_TYPE = new ValueProperty( TYPE, "OptionalAnyType" );
    
    ReferenceValue<JavaTypeName,JavaType> getOptionalAnyType();
    void setOptionalAnyType( String value );
    void setOptionalAnyType( JavaTypeName value );

    // *** RequiredClass1 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required class 1" )
    @JavaTypeConstraint( kind = { JavaTypeKind.CLASS, JavaTypeKind.ABSTRACT_CLASS } )
    @MustExist
    @Required
    @XmlBinding( path = "required-class-1" )
    
    ValueProperty PROP_REQUIRED_CLASS_1 = new ValueProperty( TYPE, "RequiredClass1" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredClass1();
    void setRequiredClass1( String value );
    void setRequiredClass1( JavaTypeName value );
    
    // *** RequiredClass2 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required class 2" )
    @JavaTypeConstraint( kind = { JavaTypeKind.CLASS, JavaTypeKind.ABSTRACT_CLASS }, type = "java.util.List" )
    @MustExist
    @Required
    @XmlBinding( path = "required-class-2" )
    
    ValueProperty PROP_REQUIRED_CLASS_2 = new ValueProperty( TYPE, "RequiredClass2" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredClass2();
    void setRequiredClass2( String value );
    void setRequiredClass2( JavaTypeName value );
    
    // *** RequiredClass3 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required class 3" )
    @JavaTypeConstraint( kind = { JavaTypeKind.CLASS, JavaTypeKind.ABSTRACT_CLASS }, type = "java.util.AbstractList" )
    @MustExist
    @Required
    @XmlBinding( path = "required-class-3" )
    
    ValueProperty PROP_REQUIRED_CLASS_3 = new ValueProperty( TYPE, "RequiredClass3" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredClass3();
    void setRequiredClass3( String value );
    void setRequiredClass3( JavaTypeName value );
    
    // *** RequiredClass4 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required class 4" )
    @JavaTypeConstraint( kind = { JavaTypeKind.CLASS, JavaTypeKind.ABSTRACT_CLASS }, type = { "java.util.AbstractList", "java.lang.Cloneable" } )
    @MustExist
    @Required
    @XmlBinding( path = "required-class-4" )
    
    ValueProperty PROP_REQUIRED_CLASS_4 = new ValueProperty( TYPE, "RequiredClass4" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredClass4();
    void setRequiredClass4( String value );
    void setRequiredClass4( JavaTypeName value );
    
    // *** RequiredClass5 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required class 5" )
    @JavaTypeConstraint( kind = JavaTypeKind.CLASS, type = "java.util.AbstractList" )
    @MustExist
    @Required
    @XmlBinding( path = "required-class-5" )
    
    ValueProperty PROP_REQUIRED_CLASS_5 = new ValueProperty( TYPE, "RequiredClass5" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredClass5();
    void setRequiredClass5( String value );
    void setRequiredClass5( JavaTypeName value );

    // *** RequiredInterface1 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required interface 1" )
    @JavaTypeConstraint( kind = JavaTypeKind.INTERFACE )
    @MustExist
    @Required
    @XmlBinding( path = "required-interface-1" )
    
    ValueProperty PROP_REQUIRED_INTERFACE_1 = new ValueProperty( TYPE, "RequiredInterface1" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredInterface1();
    void setRequiredInterface1( String value );
    void setRequiredInterface1( JavaTypeName value );
    
    // *** RequiredInterface2 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required interface 2" )
    @JavaTypeConstraint( kind = JavaTypeKind.INTERFACE, type = "java.util.List" )
    @MustExist
    @Required
    @XmlBinding( path = "required-interface-2" )
    
    ValueProperty PROP_REQUIRED_INTERFACE_2 = new ValueProperty( TYPE, "RequiredInterface2" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredInterface2();
    void setRequiredInterface2( String value );
    void setRequiredInterface2( JavaTypeName value );
    
    // *** RequiredInterface3 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required interface 3" )
    @JavaTypeConstraint( kind = JavaTypeKind.INTERFACE, type = { "java.util.List", "java.lang.Cloneable" } )
    @MustExist
    @Required
    @XmlBinding( path = "required-interface-3" )
    
    ValueProperty PROP_REQUIRED_INTERFACE_3 = new ValueProperty( TYPE, "RequiredInterface3" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredInterface3();
    void setRequiredInterface3( String value );
    void setRequiredInterface3( JavaTypeName value );
    
    // *** RequiredAnnotation1 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required annotation 1" )
    @JavaTypeConstraint( kind = JavaTypeKind.ANNOTATION )
    @MustExist
    @Required
    @XmlBinding( path = "required-annotation-1" )
    
    ValueProperty PROP_REQUIRED_ANNOTATION_1 = new ValueProperty( TYPE, "RequiredAnnotation1" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredAnnotation1();
    void setRequiredAnnotation1( String value );
    void setRequiredAnnotation1( JavaTypeName value );
    
    // *** RequiredEnum1 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required enum 1" )
    @JavaTypeConstraint( kind = JavaTypeKind.ENUM )
    @MustExist
    @Required
    @XmlBinding( path = "required-enum-1" )
    
    ValueProperty PROP_REQUIRED_ENUM_1 = new ValueProperty( TYPE, "RequiredEnum1" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredEnum1();
    void setRequiredEnum1( String value );
    void setRequiredEnum1( JavaTypeName value );
    
    // *** RequiredMixedType1 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required mixed type 1" )
    @JavaTypeConstraint( kind = { JavaTypeKind.CLASS, JavaTypeKind.INTERFACE } )
    @MustExist
    @Required
    @XmlBinding( path = "required-mixed-type-1" )
    
    ValueProperty PROP_REQUIRED_MIXED_TYPE_1 = new ValueProperty( TYPE, "RequiredMixedType1" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredMixedType1();
    void setRequiredMixedType1( String value );
    void setRequiredMixedType1( JavaTypeName value );
    
    // *** RequiredMixedType2 ***
    
    @Type( base = JavaTypeName.class )
    @Reference( target = JavaType.class )
    @Label( standard = "required mixed type 2" )
    @JavaTypeConstraint( kind = { JavaTypeKind.CLASS, JavaTypeKind.INTERFACE, JavaTypeKind.ENUM } )
    @MustExist
    @Required
    @XmlBinding( path = "required-mixed-type-2" )
    
    ValueProperty PROP_REQUIRED_MIXED_TYPE_2 = new ValueProperty( TYPE, "RequiredMixedType2" );
    
    ReferenceValue<JavaTypeName,JavaType> getRequiredMixedType2();
    void setRequiredMixedType2( String value );
    void setRequiredMixedType2( JavaTypeName value );
    
}
