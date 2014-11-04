/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage
 * @generated
 */
public interface MondixPatternLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MondixPatternLanguageFactory eINSTANCE = org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.MondixPatternLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Node Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Constraint</em>'.
   * @generated
   */
  NodeConstraint createNodeConstraint();

  /**
   * Returns a new object of class '<em>Edge Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Edge Constraint</em>'.
   * @generated
   */
  EdgeConstraint createEdgeConstraint();

  /**
   * Returns a new object of class '<em>Mondix Pattern Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mondix Pattern Model</em>'.
   * @generated
   */
  MondixPatternModel createMondixPatternModel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MondixPatternLanguagePackage getMondixPatternLanguagePackage();

} //MondixPatternLanguageFactory
