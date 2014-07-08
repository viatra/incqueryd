/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rdf Check Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfCheckConstraint()
 * @model
 * @generated
 */
public interface RdfCheckConstraint extends Constraint
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' attribute.
   * @see #setExpression(String)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfCheckConstraint_Expression()
   * @model
   * @generated
   */
  String getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint#getExpression <em>Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' attribute.
   * @see #getExpression()
   * @generated
   */
  void setExpression(String value);

} // RdfCheckConstraint
