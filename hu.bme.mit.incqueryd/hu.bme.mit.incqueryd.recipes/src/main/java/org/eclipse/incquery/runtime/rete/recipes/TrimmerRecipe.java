/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trimmer Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Implements projection without uniqueness checking.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe#getMask <em>Mask</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getTrimmerRecipe()
 * @model
 * @generated
 */
public interface TrimmerRecipe extends AlphaRecipe
{
  /**
   * Returns the value of the '<em><b>Mask</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mask</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mask</em>' containment reference.
   * @see #setMask(Mask)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getTrimmerRecipe_Mask()
   * @model containment="true"
   * @generated
   */
  Mask getMask();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe#getMask <em>Mask</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mask</em>' containment reference.
   * @see #getMask()
   * @generated
   */
  void setMask(Mask value);

} // TrimmerRecipe
