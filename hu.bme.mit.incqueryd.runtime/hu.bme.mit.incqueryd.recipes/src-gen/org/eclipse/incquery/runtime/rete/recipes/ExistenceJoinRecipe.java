/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Existence Join Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Existence joins are TODO
 * 
 * See http://en.wikipedia.org/wiki/Relational_algebra
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getExistenceJoinRecipe()
 * @model abstract="true"
 * @generated
 */
public interface ExistenceJoinRecipe extends BetaRecipe
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe%> _this = this;\n<%org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe%> _leftParent = _this.getLeftParent();\nint _arity = _leftParent.getArity();\nreturn _arity;'"
   * @generated
   */
  int getArity();

} // ExistenceJoinRecipe
