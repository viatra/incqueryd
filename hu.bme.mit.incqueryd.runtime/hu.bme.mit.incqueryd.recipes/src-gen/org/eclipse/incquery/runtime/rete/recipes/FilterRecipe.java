/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for nodes that implement filtering operations.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getFilterRecipe()
 * @model abstract="true"
 * @generated
 */
public interface FilterRecipe extends AlphaRecipe
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.incquery.runtime.rete.recipes.FilterRecipe%> _this = this;\n<%org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe%> _parent = _this.getParent();\nint _arity = _parent.getArity();\nreturn _arity;'"
   * @generated
   */
  int getArity();

} // FilterRecipe
