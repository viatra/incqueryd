/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface MondixPatternLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mondixPatternLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/incquery/patternlanguage/mondix/MondixPatternLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mondixPatternLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MondixPatternLanguagePackage eINSTANCE = org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.VariableImpl
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = PatternLanguagePackage.VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = PatternLanguagePackage.VARIABLE__TYPE;

  /**
   * The feature id for the '<em><b>References</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__REFERENCES = PatternLanguagePackage.VARIABLE__REFERENCES;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = PatternLanguagePackage.VARIABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.NodeConstraintImpl <em>Node Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.NodeConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getNodeConstraint()
   * @generated
   */
  int NODE_CONSTRAINT = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CONSTRAINT__TYPE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CONSTRAINT__VARIABLE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Node Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.EdgeConstraintImpl <em>Edge Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.EdgeConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getEdgeConstraint()
   * @generated
   */
  int EDGE_CONSTRAINT = 2;

  /**
   * The feature id for the '<em><b>Ref Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_CONSTRAINT__REF_TYPE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_CONSTRAINT__SOURCE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_CONSTRAINT__TARGET = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Edge Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternModelImpl <em>Mondix Pattern Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternModelImpl
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getMondixPatternModel()
   * @generated
   */
  int MONDIX_PATTERN_MODEL = 3;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONDIX_PATTERN_MODEL__PACKAGE_NAME = PatternLanguagePackage.PATTERN_MODEL__PACKAGE_NAME;

  /**
   * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONDIX_PATTERN_MODEL__PATTERNS = PatternLanguagePackage.PATTERN_MODEL__PATTERNS;

  /**
   * The number of structural features of the '<em>Mondix Pattern Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONDIX_PATTERN_MODEL_FEATURE_COUNT = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint <em>Node Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint
   * @generated
   */
  EClass getNodeConstraint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint#getType()
   * @see #getNodeConstraint()
   * @generated
   */
  EAttribute getNodeConstraint_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint#getVariable()
   * @see #getNodeConstraint()
   * @generated
   */
  EReference getNodeConstraint_Variable();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint <em>Edge Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Edge Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint
   * @generated
   */
  EClass getEdgeConstraint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getRefType <em>Ref Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getRefType()
   * @see #getEdgeConstraint()
   * @generated
   */
  EAttribute getEdgeConstraint_RefType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getSource()
   * @see #getEdgeConstraint()
   * @generated
   */
  EReference getEdgeConstraint_Source();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getTarget()
   * @see #getEdgeConstraint()
   * @generated
   */
  EReference getEdgeConstraint_Target();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel <em>Mondix Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mondix Pattern Model</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel
   * @generated
   */
  EClass getMondixPatternModel();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MondixPatternLanguageFactory getMondixPatternLanguageFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.VariableImpl
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.NodeConstraintImpl <em>Node Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.NodeConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getNodeConstraint()
     * @generated
     */
    EClass NODE_CONSTRAINT = eINSTANCE.getNodeConstraint();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_CONSTRAINT__TYPE = eINSTANCE.getNodeConstraint_Type();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_CONSTRAINT__VARIABLE = eINSTANCE.getNodeConstraint_Variable();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.EdgeConstraintImpl <em>Edge Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.EdgeConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getEdgeConstraint()
     * @generated
     */
    EClass EDGE_CONSTRAINT = eINSTANCE.getEdgeConstraint();

    /**
     * The meta object literal for the '<em><b>Ref Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EDGE_CONSTRAINT__REF_TYPE = eINSTANCE.getEdgeConstraint_RefType();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EDGE_CONSTRAINT__SOURCE = eINSTANCE.getEdgeConstraint_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EDGE_CONSTRAINT__TARGET = eINSTANCE.getEdgeConstraint_Target();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternModelImpl <em>Mondix Pattern Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternModelImpl
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getMondixPatternModel()
     * @generated
     */
    EClass MONDIX_PATTERN_MODEL = eINSTANCE.getMondixPatternModel();

  }

} //MondixPatternLanguagePackage
