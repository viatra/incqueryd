/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregator Join Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An aggregator join node is a beta node that performs an aggregation operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe#getAggregator <em>Aggregator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getAggregatorJoinRecipe()
 * @model
 * @generated
 */
public interface AggregatorJoinRecipe extends BetaRecipe
{
  /**
   * Returns the value of the '<em><b>Aggregator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aggregator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aggregator</em>' containment reference.
   * @see #setAggregator(AggregatorRecipe)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getAggregatorJoinRecipe_Aggregator()
   * @model containment="true"
   * @generated
   */
  AggregatorRecipe getAggregator();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe#getAggregator <em>Aggregator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aggregator</em>' containment reference.
   * @see #getAggregator()
   * @generated
   */
  void setAggregator(AggregatorRecipe value);

} // AggregatorJoinRecipe
