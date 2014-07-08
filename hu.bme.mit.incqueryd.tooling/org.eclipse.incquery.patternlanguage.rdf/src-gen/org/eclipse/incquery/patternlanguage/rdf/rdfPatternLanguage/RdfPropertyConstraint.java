/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rdf Property Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPropertyConstraint()
 * @model
 * @generated
 */
public interface RdfPropertyConstraint extends Constraint
{
  /**
   * Returns the value of the '<em><b>Ref Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Type</em>' containment reference.
   * @see #setRefType(Iri)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPropertyConstraint_RefType()
   * @model containment="true"
   * @generated
   */
  Iri getRefType();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getRefType <em>Ref Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Type</em>' containment reference.
   * @see #getRefType()
   * @generated
   */
  void setRefType(Iri value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(VariableReference)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPropertyConstraint_Source()
   * @model containment="true"
   * @generated
   */
  VariableReference getSource();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
  void setSource(VariableReference value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(ValueReference)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPropertyConstraint_Target()
   * @model containment="true"
   * @generated
   */
  ValueReference getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ValueReference value);

} // RdfPropertyConstraint
