/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Computes the result of the boolean expression evaluation and
 * only passes tuples for which the result is true.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getCheckRecipe()
 * @model
 * @generated
 */
public interface CheckRecipe extends ExpressionEnforcerRecipe
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.incquery.runtime.rete.recipes.CheckRecipe%> _this = this;\n<%org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe%> _parent = _this.getParent();\nint _arity = _parent.getArity();\nreturn _arity;'"
   * @generated
   */
  int getArity();

} // CheckRecipe
