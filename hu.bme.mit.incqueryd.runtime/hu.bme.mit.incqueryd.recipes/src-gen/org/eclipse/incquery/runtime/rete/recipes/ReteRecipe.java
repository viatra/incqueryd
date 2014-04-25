/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rete Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Container for Rete recipes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.ReteRecipe#getRecipeNodes <em>Recipe Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getReteRecipe()
 * @model
 * @generated
 */
public interface ReteRecipe extends EObject
{
  /**
   * Returns the value of the '<em><b>Recipe Nodes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Recipe Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Recipe Nodes</em>' containment reference list.
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getReteRecipe_RecipeNodes()
   * @model containment="true"
   * @generated
   */
  EList<ReteNodeRecipe> getRecipeNodes();

} // ReteRecipe
