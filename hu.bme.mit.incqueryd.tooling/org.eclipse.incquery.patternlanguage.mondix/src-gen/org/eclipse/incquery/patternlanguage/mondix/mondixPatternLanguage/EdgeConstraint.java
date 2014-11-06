/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getEdgeConstraint()
 * @model
 * @generated
 */
public interface EdgeConstraint extends Constraint
{
  /**
   * Returns the value of the '<em><b>Ref Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Type</em>' attribute.
   * @see #setRefType(String)
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getEdgeConstraint_RefType()
   * @model
   * @generated
   */
  String getRefType();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getRefType <em>Ref Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Type</em>' attribute.
   * @see #getRefType()
   * @generated
   */
  void setRefType(String value);

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
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getEdgeConstraint_Source()
   * @model containment="true"
   * @generated
   */
  VariableReference getSource();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getSource <em>Source</em>}' containment reference.
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
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getEdgeConstraint_Target()
   * @model containment="true"
   * @generated
   */
  ValueReference getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ValueReference value);

} // EdgeConstraint
