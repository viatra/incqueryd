/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equality Filter Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe#getIndices <em>Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getEqualityFilterRecipe()
 * @model
 * @generated
 */
public interface EqualityFilterRecipe extends FilterRecipe
{
  /**
   * Returns the value of the '<em><b>Indices</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indices</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indices</em>' attribute list.
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getEqualityFilterRecipe_Indices()
   * @model unique="false" dataType="org.eclipse.incquery.runtime.rete.recipes.Index"
   * @generated
   */
  EList<Integer> getIndices();

} // EqualityFilterRecipe
