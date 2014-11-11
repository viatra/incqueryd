/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl;

import hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.Variable;

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MondixPatternLanguagePackageImpl extends EPackageImpl implements MondixPatternLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryRelationConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryRelationConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mondixPatternModelEClass = null;

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
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MondixPatternLanguagePackageImpl()
  {
    super(eNS_URI, MondixPatternLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link MondixPatternLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MondixPatternLanguagePackage init()
  {
    if (isInited) return (MondixPatternLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(MondixPatternLanguagePackage.eNS_URI);

    // Obtain or create and register package
    MondixPatternLanguagePackageImpl theMondixPatternLanguagePackage = (MondixPatternLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MondixPatternLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MondixPatternLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    MondixSchemaPackage.eINSTANCE.eClass();
    PatternLanguagePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theMondixPatternLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theMondixPatternLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMondixPatternLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MondixPatternLanguagePackage.eNS_URI, theMondixPatternLanguagePackage);
    return theMondixPatternLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryRelationConstraint()
  {
    return unaryRelationConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryRelationConstraint_Relation()
  {
    return (EReference)unaryRelationConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryRelationConstraint_Variable()
  {
    return (EReference)unaryRelationConstraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinaryRelationConstraint()
  {
    return binaryRelationConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryRelationConstraint_Relation()
  {
    return (EReference)binaryRelationConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryRelationConstraint_Source()
  {
    return (EReference)binaryRelationConstraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryRelationConstraint_Target()
  {
    return (EReference)binaryRelationConstraintEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMondixPatternModel()
  {
    return mondixPatternModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MondixPatternLanguageFactory getMondixPatternLanguageFactory()
  {
    return (MondixPatternLanguageFactory)getEFactoryInstance();
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
    variableEClass = createEClass(VARIABLE);

    unaryRelationConstraintEClass = createEClass(UNARY_RELATION_CONSTRAINT);
    createEReference(unaryRelationConstraintEClass, UNARY_RELATION_CONSTRAINT__RELATION);
    createEReference(unaryRelationConstraintEClass, UNARY_RELATION_CONSTRAINT__VARIABLE);

    binaryRelationConstraintEClass = createEClass(BINARY_RELATION_CONSTRAINT);
    createEReference(binaryRelationConstraintEClass, BINARY_RELATION_CONSTRAINT__RELATION);
    createEReference(binaryRelationConstraintEClass, BINARY_RELATION_CONSTRAINT__SOURCE);
    createEReference(binaryRelationConstraintEClass, BINARY_RELATION_CONSTRAINT__TARGET);

    mondixPatternModelEClass = createEClass(MONDIX_PATTERN_MODEL);
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
    MondixSchemaPackage theMondixSchemaPackage = (MondixSchemaPackage)EPackage.Registry.INSTANCE.getEPackage(MondixSchemaPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    variableEClass.getESuperTypes().add(thePatternLanguagePackage.getVariable());
    unaryRelationConstraintEClass.getESuperTypes().add(thePatternLanguagePackage.getConstraint());
    binaryRelationConstraintEClass.getESuperTypes().add(thePatternLanguagePackage.getConstraint());
    mondixPatternModelEClass.getESuperTypes().add(thePatternLanguagePackage.getPatternModel());

    // Initialize classes and features; add operations and parameters
    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unaryRelationConstraintEClass, UnaryRelationConstraint.class, "UnaryRelationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnaryRelationConstraint_Relation(), theMondixSchemaPackage.getRelation(), null, "relation", null, 0, 1, UnaryRelationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryRelationConstraint_Variable(), thePatternLanguagePackage.getVariableReference(), null, "variable", null, 0, 1, UnaryRelationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binaryRelationConstraintEClass, BinaryRelationConstraint.class, "BinaryRelationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryRelationConstraint_Relation(), theMondixSchemaPackage.getRelation(), null, "relation", null, 0, 1, BinaryRelationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinaryRelationConstraint_Source(), thePatternLanguagePackage.getVariableReference(), null, "source", null, 0, 1, BinaryRelationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinaryRelationConstraint_Target(), thePatternLanguagePackage.getValueReference(), null, "target", null, 0, 1, BinaryRelationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mondixPatternModelEClass, MondixPatternModel.class, "MondixPatternModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //MondixPatternLanguagePackageImpl
