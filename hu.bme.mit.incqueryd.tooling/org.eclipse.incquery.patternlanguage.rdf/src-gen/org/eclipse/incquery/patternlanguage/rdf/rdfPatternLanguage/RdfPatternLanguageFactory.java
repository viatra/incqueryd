/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage
 * @generated
 */
public interface RdfPatternLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RdfPatternLanguageFactory eINSTANCE = org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Base</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Base</em>'.
   * @generated
   */
  Base createBase();

  /**
   * Returns a new object of class '<em>Prefix</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Prefix</em>'.
   * @generated
   */
  Prefix createPrefix();

  /**
   * Returns a new object of class '<em>Iri</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Iri</em>'.
   * @generated
   */
  Iri createIri();

  /**
   * Returns a new object of class '<em>Rdf Check Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rdf Check Constraint</em>'.
   * @generated
   */
  RdfCheckConstraint createRdfCheckConstraint();

  /**
   * Returns a new object of class '<em>Rdf Path Expression Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rdf Path Expression Constraint</em>'.
   * @generated
   */
  RdfPathExpressionConstraint createRdfPathExpressionConstraint();

  /**
   * Returns a new object of class '<em>Type Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Constraint</em>'.
   * @generated
   */
  TypeConstraint createTypeConstraint();

  /**
   * Returns a new object of class '<em>Rdf Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rdf Literal</em>'.
   * @generated
   */
  RdfLiteral createRdfLiteral();

  /**
   * Returns a new object of class '<em>Pattern Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Model</em>'.
   * @generated
   */
  PatternModel createPatternModel();

  /**
   * Returns a new object of class '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class</em>'.
   * @generated
   */
  Class createClass();

  /**
   * Returns a new object of class '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property</em>'.
   * @generated
   */
  Property createProperty();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  RdfPatternLanguagePackage getRdfPatternLanguagePackage();

} //RdfPatternLanguageFactory
