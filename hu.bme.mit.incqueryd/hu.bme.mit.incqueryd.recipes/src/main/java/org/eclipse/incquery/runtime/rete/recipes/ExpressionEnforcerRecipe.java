/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Enforcer Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for Rete nodes that evaluate an expression.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe#getMappedIndices <em>Mapped Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getExpressionEnforcerRecipe()
 * @model abstract="true"
 * @generated
 */
public interface ExpressionEnforcerRecipe extends AlphaRecipe
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Provides traceability to expression representation.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Expression</em>' attribute.
   * @see #setExpression(Object)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getExpressionEnforcerRecipe_Expression()
   * @model unique="false"
   * @generated
   */
  Object getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe#getExpression <em>Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' attribute.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Object value);

  /**
   * Returns the value of the '<em><b>Mapped Indices</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.Integer},
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * String -> Index map.
   * Maps variable names in the expression to tuple indices.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Mapped Indices</em>' map.
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getExpressionEnforcerRecipe_MappedIndices()
   * @model mapType="org.eclipse.incquery.runtime.rete.recipes.StringIndexMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.incquery.runtime.rete.recipes.Index>"
   * @generated
   */
  EMap<String, Integer> getMappedIndices();

} // ExpressionEnforcerRecipe
