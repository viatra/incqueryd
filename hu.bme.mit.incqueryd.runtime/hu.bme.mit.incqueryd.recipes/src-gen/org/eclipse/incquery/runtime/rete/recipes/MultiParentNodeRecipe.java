/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Parent Node Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe#getParents <em>Parents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getMultiParentNodeRecipe()
 * @model abstract="true"
 * @generated
 */
public interface MultiParentNodeRecipe extends ReteNodeRecipe
{
  /**
   * Returns the value of the '<em><b>Parents</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parents</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parents</em>' reference list.
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getMultiParentNodeRecipe_Parents()
   * @model
   * @generated
   */
  EList<ReteNodeRecipe> getParents();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe%> _this = this;\n<%org.eclipse.emf.common.util.EList%><<%org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe%>> _parents = _this.getParents();\n<%org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe%> _get = _parents.get(0);\nint _arity = _get.getArity();\nreturn _arity;'"
   * @generated
   */
  int getArity();

} // MultiParentNodeRecipe
