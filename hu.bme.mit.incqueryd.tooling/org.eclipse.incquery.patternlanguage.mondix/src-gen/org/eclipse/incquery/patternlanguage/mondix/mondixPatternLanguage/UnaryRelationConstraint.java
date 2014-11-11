/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage;

import hu.bme.mit.incqueryd.mondixschema.Relation;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Relation Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getUnaryRelationConstraint()
 * @model
 * @generated
 */
public interface UnaryRelationConstraint extends Constraint
{
  /**
   * Returns the value of the '<em><b>Relation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relation</em>' reference.
   * @see #setRelation(Relation)
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getUnaryRelationConstraint_Relation()
   * @model
   * @generated
   */
  Relation getRelation();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint#getRelation <em>Relation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relation</em>' reference.
   * @see #getRelation()
   * @generated
   */
  void setRelation(Relation value);

  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(VariableReference)
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getUnaryRelationConstraint_Variable()
   * @model containment="true"
   * @generated
   */
  VariableReference getVariable();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(VariableReference value);

} // UnaryRelationConstraint
