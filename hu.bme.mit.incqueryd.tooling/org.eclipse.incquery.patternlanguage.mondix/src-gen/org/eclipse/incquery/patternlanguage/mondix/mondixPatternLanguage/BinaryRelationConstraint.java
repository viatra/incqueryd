/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage;

import hu.bme.mit.incqueryd.mondixschema.Relation;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Relation Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getBinaryRelationConstraint()
 * @model
 * @generated
 */
public interface BinaryRelationConstraint extends Constraint
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
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getBinaryRelationConstraint_Relation()
   * @model
   * @generated
   */
  Relation getRelation();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getRelation <em>Relation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relation</em>' reference.
   * @see #getRelation()
   * @generated
   */
  void setRelation(Relation value);

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
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getBinaryRelationConstraint_Source()
   * @model containment="true"
   * @generated
   */
  VariableReference getSource();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getSource <em>Source</em>}' containment reference.
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
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage#getBinaryRelationConstraint_Target()
   * @model containment="true"
   * @generated
   */
  ValueReference getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ValueReference value);

} // BinaryRelationConstraint
