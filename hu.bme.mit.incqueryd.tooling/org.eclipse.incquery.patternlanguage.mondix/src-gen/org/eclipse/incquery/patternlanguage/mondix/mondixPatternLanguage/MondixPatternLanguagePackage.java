/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage;

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
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.UnaryRelationConstraintImpl <em>Unary Relation Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.UnaryRelationConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getUnaryRelationConstraint()
   * @generated
   */
  int UNARY_RELATION_CONSTRAINT = 1;

  /**
   * The feature id for the '<em><b>Relation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_RELATION_CONSTRAINT__RELATION = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_RELATION_CONSTRAINT__VARIABLE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Relation Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_RELATION_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.BinaryRelationConstraintImpl <em>Binary Relation Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.BinaryRelationConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getBinaryRelationConstraint()
   * @generated
   */
  int BINARY_RELATION_CONSTRAINT = 2;

  /**
   * The feature id for the '<em><b>Relation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_RELATION_CONSTRAINT__RELATION = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_RELATION_CONSTRAINT__SOURCE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_RELATION_CONSTRAINT__TARGET = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Relation Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_RELATION_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 3;

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
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint <em>Unary Relation Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Relation Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint
   * @generated
   */
  EClass getUnaryRelationConstraint();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint#getRelation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Relation</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint#getRelation()
   * @see #getUnaryRelationConstraint()
   * @generated
   */
  EReference getUnaryRelationConstraint_Relation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint#getVariable()
   * @see #getUnaryRelationConstraint()
   * @generated
   */
  EReference getUnaryRelationConstraint_Variable();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint <em>Binary Relation Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Relation Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint
   * @generated
   */
  EClass getBinaryRelationConstraint();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getRelation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Relation</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getRelation()
   * @see #getBinaryRelationConstraint()
   * @generated
   */
  EReference getBinaryRelationConstraint_Relation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getSource()
   * @see #getBinaryRelationConstraint()
   * @generated
   */
  EReference getBinaryRelationConstraint_Source();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getTarget()
   * @see #getBinaryRelationConstraint()
   * @generated
   */
  EReference getBinaryRelationConstraint_Target();

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
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.UnaryRelationConstraintImpl <em>Unary Relation Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.UnaryRelationConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getUnaryRelationConstraint()
     * @generated
     */
    EClass UNARY_RELATION_CONSTRAINT = eINSTANCE.getUnaryRelationConstraint();

    /**
     * The meta object literal for the '<em><b>Relation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_RELATION_CONSTRAINT__RELATION = eINSTANCE.getUnaryRelationConstraint_Relation();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_RELATION_CONSTRAINT__VARIABLE = eINSTANCE.getUnaryRelationConstraint_Variable();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.BinaryRelationConstraintImpl <em>Binary Relation Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.BinaryRelationConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguagePackageImpl#getBinaryRelationConstraint()
     * @generated
     */
    EClass BINARY_RELATION_CONSTRAINT = eINSTANCE.getBinaryRelationConstraint();

    /**
     * The meta object literal for the '<em><b>Relation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_RELATION_CONSTRAINT__RELATION = eINSTANCE.getBinaryRelationConstraint_Relation();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_RELATION_CONSTRAINT__SOURCE = eINSTANCE.getBinaryRelationConstraint_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_RELATION_CONSTRAINT__TARGET = eINSTANCE.getBinaryRelationConstraint_Target();

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
