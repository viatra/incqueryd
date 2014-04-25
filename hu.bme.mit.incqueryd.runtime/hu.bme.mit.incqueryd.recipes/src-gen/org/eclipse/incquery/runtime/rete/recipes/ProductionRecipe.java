/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Production Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The production node represents the output of the Rete network,
 * from which the results of a query can be read.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe#getMappedIndices <em>Mapped Indices</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getProductionRecipe()
 * @model
 * @generated
 */
public interface ProductionRecipe extends MultiParentNodeRecipe
{
  /**
   * Returns the value of the '<em><b>Mapped Indices</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.Integer},
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * String -> Index map.
   * Indicates the positions of parameters.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Mapped Indices</em>' map.
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getProductionRecipe_MappedIndices()
   * @model mapType="org.eclipse.incquery.runtime.rete.recipes.StringIndexMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.incquery.runtime.rete.recipes.Index>"
   * @generated
   */
  EMap<String, Integer> getMappedIndices();

  /**
   * Returns the value of the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Traceability link to defining pattern object (from EMFPatternLanguage)
   * TODO unused?
   * <!-- end-model-doc -->
   * @return the value of the '<em>Pattern</em>' attribute.
   * @see #setPattern(Object)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getProductionRecipe_Pattern()
   * @model unique="false"
   * @generated
   */
  Object getPattern();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe#getPattern <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' attribute.
   * @see #getPattern()
   * @generated
   */
  void setPattern(Object value);

} // ProductionRecipe
