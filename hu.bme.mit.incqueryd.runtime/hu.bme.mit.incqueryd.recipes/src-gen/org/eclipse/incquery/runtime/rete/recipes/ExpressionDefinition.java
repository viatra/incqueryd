/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionDefinition#getEvaluator <em>Evaluator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getExpressionDefinition()
 * @model abstract="true"
 * @generated
 */
public interface ExpressionDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Evaluator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Evaluator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Evaluator</em>' attribute.
   * @see #setEvaluator(Object)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getExpressionDefinition_Evaluator()
   * @model unique="false"
   * @generated
   */
  Object getEvaluator();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionDefinition#getEvaluator <em>Evaluator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Evaluator</em>' attribute.
   * @see #getEvaluator()
   * @generated
   */
  void setEvaluator(Object value);

} // ExpressionDefinition
