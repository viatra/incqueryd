/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint;
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
  private EClass nodeConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass edgeConstraintEClass = null;

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
  public EClass getNodeConstraint()
  {
    return nodeConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNodeConstraint_Type()
  {
    return (EAttribute)nodeConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeConstraint_Variable()
  {
    return (EReference)nodeConstraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEdgeConstraint()
  {
    return edgeConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEdgeConstraint_RefType()
  {
    return (EAttribute)edgeConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEdgeConstraint_Source()
  {
    return (EReference)edgeConstraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEdgeConstraint_Target()
  {
    return (EReference)edgeConstraintEClass.getEStructuralFeatures().get(2);
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

    nodeConstraintEClass = createEClass(NODE_CONSTRAINT);
    createEAttribute(nodeConstraintEClass, NODE_CONSTRAINT__TYPE);
    createEReference(nodeConstraintEClass, NODE_CONSTRAINT__VARIABLE);

    edgeConstraintEClass = createEClass(EDGE_CONSTRAINT);
    createEAttribute(edgeConstraintEClass, EDGE_CONSTRAINT__REF_TYPE);
    createEReference(edgeConstraintEClass, EDGE_CONSTRAINT__SOURCE);
    createEReference(edgeConstraintEClass, EDGE_CONSTRAINT__TARGET);

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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    variableEClass.getESuperTypes().add(thePatternLanguagePackage.getVariable());
    nodeConstraintEClass.getESuperTypes().add(thePatternLanguagePackage.getConstraint());
    edgeConstraintEClass.getESuperTypes().add(thePatternLanguagePackage.getConstraint());
    mondixPatternModelEClass.getESuperTypes().add(thePatternLanguagePackage.getPatternModel());

    // Initialize classes and features; add operations and parameters
    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nodeConstraintEClass, NodeConstraint.class, "NodeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNodeConstraint_Type(), ecorePackage.getEString(), "type", null, 0, 1, NodeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeConstraint_Variable(), thePatternLanguagePackage.getVariableReference(), null, "variable", null, 0, 1, NodeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(edgeConstraintEClass, EdgeConstraint.class, "EdgeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEdgeConstraint_RefType(), ecorePackage.getEString(), "refType", null, 0, 1, EdgeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEdgeConstraint_Source(), thePatternLanguagePackage.getVariableReference(), null, "source", null, 0, 1, EdgeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEdgeConstraint_Target(), thePatternLanguagePackage.getValueReference(), null, "target", null, 0, 1, EdgeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mondixPatternModelEClass, MondixPatternModel.class, "MondixPatternModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //MondixPatternLanguagePackageImpl
