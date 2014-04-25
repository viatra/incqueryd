/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eval Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Computes the result of expression evaluation and suffixes the result
 * to output tuples as the last element.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getEvalRecipe()
 * @model
 * @generated
 */
public interface EvalRecipe extends ExpressionEnforcerRecipe
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.incquery.runtime.rete.recipes.EvalRecipe%> _this = this;\n<%org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe%> _parent = _this.getParent();\nint _arity = _parent.getArity();\nint _plus = (1 + _arity);\nreturn _plus;'"
   * @generated
   */
  int getArity();

} // EvalRecipe
