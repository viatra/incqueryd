/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Beta Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for Beta node recipes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.BetaRecipe#getLeftParent <em>Left Parent</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.BetaRecipe#getRightParent <em>Right Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getBetaRecipe()
 * @model abstract="true"
 * @generated
 */
public interface BetaRecipe extends ReteNodeRecipe
{
  /**
   * Returns the value of the '<em><b>Left Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Parent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Parent</em>' containment reference.
   * @see #setLeftParent(ProjectionIndexerRecipe)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getBetaRecipe_LeftParent()
   * @model containment="true"
   * @generated
   */
  ProjectionIndexerRecipe getLeftParent();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.BetaRecipe#getLeftParent <em>Left Parent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Parent</em>' containment reference.
   * @see #getLeftParent()
   * @generated
   */
  void setLeftParent(ProjectionIndexerRecipe value);

  /**
   * Returns the value of the '<em><b>Right Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *  can be an AggregatorIndexer
   * <!-- end-model-doc -->
   * @return the value of the '<em>Right Parent</em>' containment reference.
   * @see #setRightParent(IndexerRecipe)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getBetaRecipe_RightParent()
   * @model containment="true"
   * @generated
   */
  IndexerRecipe getRightParent();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.BetaRecipe#getRightParent <em>Right Parent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Parent</em>' containment reference.
   * @see #getRightParent()
   * @generated
   */
  void setRightParent(IndexerRecipe value);

} // BetaRecipe
