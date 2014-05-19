/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClass;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfProperty;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RdfPatternLanguagePackageImpl extends EPackageImpl implements RdfPatternLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iriPrefixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iriEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rdfClassConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rdfPropertyConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rdfCheckConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rdfLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rdfPatternModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rdfClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rdfPropertyEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private RdfPatternLanguagePackageImpl()
  {
    super(eNS_URI, RdfPatternLanguageFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link RdfPatternLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static RdfPatternLanguagePackage init()
  {
    if (isInited) return (RdfPatternLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(RdfPatternLanguagePackage.eNS_URI);

    // Obtain or create and register package
    RdfPatternLanguagePackageImpl theRdfPatternLanguagePackage = (RdfPatternLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RdfPatternLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RdfPatternLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    PatternLanguagePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theRdfPatternLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theRdfPatternLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theRdfPatternLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(RdfPatternLanguagePackage.eNS_URI, theRdfPatternLanguagePackage);
    return theRdfPatternLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIriPrefix()
  {
    return iriPrefixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIriPrefix_Name()
  {
    return (EAttribute)iriPrefixEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIriPrefix_Value()
  {
    return (EAttribute)iriPrefixEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIri()
  {
    return iriEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIri_Prefix()
  {
    return (EReference)iriEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIri_Value()
  {
    return (EAttribute)iriEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRdfClassConstraint()
  {
    return rdfClassConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfClassConstraint_Type()
  {
    return (EReference)rdfClassConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfClassConstraint_Variable()
  {
    return (EReference)rdfClassConstraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRdfPropertyConstraint()
  {
    return rdfPropertyConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfPropertyConstraint_RefType()
  {
    return (EReference)rdfPropertyConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfPropertyConstraint_Source()
  {
    return (EReference)rdfPropertyConstraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfPropertyConstraint_Target()
  {
    return (EReference)rdfPropertyConstraintEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRdfCheckConstraint()
  {
    return rdfCheckConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfCheckConstraint_Variables()
  {
    return (EReference)rdfCheckConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRdfCheckConstraint_Expression()
  {
    return (EAttribute)rdfCheckConstraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRdfLiteral()
  {
    return rdfLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRdfLiteral_LexicalForm()
  {
    return (EAttribute)rdfLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfLiteral_Datatype()
  {
    return (EReference)rdfLiteralEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRdfLiteral_Language()
  {
    return (EAttribute)rdfLiteralEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRdfPatternModel()
  {
    return rdfPatternModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRdfPatternModel_BaseIriValue()
  {
    return (EAttribute)rdfPatternModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfPatternModel_IriPrefixes()
  {
    return (EReference)rdfPatternModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRdfClass()
  {
    return rdfClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfClass_Class()
  {
    return (EReference)rdfClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRdfProperty()
  {
    return rdfPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRdfProperty_Property()
  {
    return (EReference)rdfPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfPatternLanguageFactory getRdfPatternLanguageFactory()
  {
    return (RdfPatternLanguageFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    iriPrefixEClass = createEClass(IRI_PREFIX);
    createEAttribute(iriPrefixEClass, IRI_PREFIX__NAME);
    createEAttribute(iriPrefixEClass, IRI_PREFIX__VALUE);

    iriEClass = createEClass(IRI);
    createEReference(iriEClass, IRI__PREFIX);
    createEAttribute(iriEClass, IRI__VALUE);

    rdfClassConstraintEClass = createEClass(RDF_CLASS_CONSTRAINT);
    createEReference(rdfClassConstraintEClass, RDF_CLASS_CONSTRAINT__TYPE);
    createEReference(rdfClassConstraintEClass, RDF_CLASS_CONSTRAINT__VARIABLE);

    rdfPropertyConstraintEClass = createEClass(RDF_PROPERTY_CONSTRAINT);
    createEReference(rdfPropertyConstraintEClass, RDF_PROPERTY_CONSTRAINT__REF_TYPE);
    createEReference(rdfPropertyConstraintEClass, RDF_PROPERTY_CONSTRAINT__SOURCE);
    createEReference(rdfPropertyConstraintEClass, RDF_PROPERTY_CONSTRAINT__TARGET);

    rdfCheckConstraintEClass = createEClass(RDF_CHECK_CONSTRAINT);
    createEReference(rdfCheckConstraintEClass, RDF_CHECK_CONSTRAINT__VARIABLES);
    createEAttribute(rdfCheckConstraintEClass, RDF_CHECK_CONSTRAINT__EXPRESSION);

    rdfLiteralEClass = createEClass(RDF_LITERAL);
    createEAttribute(rdfLiteralEClass, RDF_LITERAL__LEXICAL_FORM);
    createEReference(rdfLiteralEClass, RDF_LITERAL__DATATYPE);
    createEAttribute(rdfLiteralEClass, RDF_LITERAL__LANGUAGE);

    rdfPatternModelEClass = createEClass(RDF_PATTERN_MODEL);
    createEAttribute(rdfPatternModelEClass, RDF_PATTERN_MODEL__BASE_IRI_VALUE);
    createEReference(rdfPatternModelEClass, RDF_PATTERN_MODEL__IRI_PREFIXES);

    rdfClassEClass = createEClass(RDF_CLASS);
    createEReference(rdfClassEClass, RDF_CLASS__CLASS);

    rdfPropertyEClass = createEClass(RDF_PROPERTY);
    createEReference(rdfPropertyEClass, RDF_PROPERTY__PROPERTY);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    PatternLanguagePackage thePatternLanguagePackage = (PatternLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(PatternLanguagePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    rdfClassConstraintEClass.getESuperTypes().add(thePatternLanguagePackage.getConstraint());
    rdfPropertyConstraintEClass.getESuperTypes().add(thePatternLanguagePackage.getConstraint());
    rdfCheckConstraintEClass.getESuperTypes().add(thePatternLanguagePackage.getConstraint());
    rdfLiteralEClass.getESuperTypes().add(thePatternLanguagePackage.getLiteralValueReference());
    rdfPatternModelEClass.getESuperTypes().add(thePatternLanguagePackage.getPatternModel());
    rdfClassEClass.getESuperTypes().add(thePatternLanguagePackage.getEntityType());
    rdfPropertyEClass.getESuperTypes().add(thePatternLanguagePackage.getRelationType());

    // Initialize classes and features; add operations and parameters
    initEClass(iriPrefixEClass, IriPrefix.class, "IriPrefix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIriPrefix_Name(), ecorePackage.getEString(), "name", null, 0, 1, IriPrefix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIriPrefix_Value(), ecorePackage.getEString(), "value", null, 0, 1, IriPrefix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iriEClass, Iri.class, "Iri", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIri_Prefix(), this.getIriPrefix(), null, "prefix", null, 0, 1, Iri.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIri_Value(), ecorePackage.getEString(), "value", null, 0, 1, Iri.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rdfClassConstraintEClass, RdfClassConstraint.class, "RdfClassConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRdfClassConstraint_Type(), thePatternLanguagePackage.getEntityType(), null, "type", null, 0, 1, RdfClassConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRdfClassConstraint_Variable(), thePatternLanguagePackage.getVariableReference(), null, "variable", null, 0, 1, RdfClassConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rdfPropertyConstraintEClass, RdfPropertyConstraint.class, "RdfPropertyConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRdfPropertyConstraint_RefType(), thePatternLanguagePackage.getRelationType(), null, "refType", null, 0, 1, RdfPropertyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRdfPropertyConstraint_Source(), thePatternLanguagePackage.getVariableReference(), null, "source", null, 0, 1, RdfPropertyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRdfPropertyConstraint_Target(), thePatternLanguagePackage.getValueReference(), null, "target", null, 0, 1, RdfPropertyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rdfCheckConstraintEClass, RdfCheckConstraint.class, "RdfCheckConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRdfCheckConstraint_Variables(), thePatternLanguagePackage.getVariableReference(), null, "variables", null, 0, -1, RdfCheckConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRdfCheckConstraint_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, RdfCheckConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rdfLiteralEClass, RdfLiteral.class, "RdfLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRdfLiteral_LexicalForm(), ecorePackage.getEString(), "lexicalForm", null, 0, 1, RdfLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRdfLiteral_Datatype(), this.getIri(), null, "datatype", null, 0, 1, RdfLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRdfLiteral_Language(), ecorePackage.getEString(), "language", null, 0, 1, RdfLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rdfPatternModelEClass, RdfPatternModel.class, "RdfPatternModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRdfPatternModel_BaseIriValue(), ecorePackage.getEString(), "baseIriValue", null, 0, 1, RdfPatternModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRdfPatternModel_IriPrefixes(), this.getIriPrefix(), null, "iriPrefixes", null, 0, -1, RdfPatternModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rdfClassEClass, RdfClass.class, "RdfClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRdfClass_Class(), this.getIri(), null, "class", null, 0, 1, RdfClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rdfPropertyEClass, RdfProperty.class, "RdfProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRdfProperty_Property(), this.getIri(), null, "property", null, 0, 1, RdfProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //RdfPatternLanguagePackageImpl
