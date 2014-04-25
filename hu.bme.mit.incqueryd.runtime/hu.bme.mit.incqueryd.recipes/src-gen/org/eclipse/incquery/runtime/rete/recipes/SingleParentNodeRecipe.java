/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Parent Node Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for single-parent node recipes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getSingleParentNodeRecipe()
 * @model abstract="true"
 * @generated
 */
public interface SingleParentNodeRecipe extends ReteNodeRecipe
{
  /**
   * Returns the value of the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' reference.
   * @see #setParent(ReteNodeRecipe)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getSingleParentNodeRecipe_Parent()
   * @model
   * @generated
   */
  ReteNodeRecipe getParent();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe#getParent <em>Parent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' reference.
   * @see #getParent()
   * @generated
   */
  void setParent(ReteNodeRecipe value);

} // SingleParentNodeRecipe
