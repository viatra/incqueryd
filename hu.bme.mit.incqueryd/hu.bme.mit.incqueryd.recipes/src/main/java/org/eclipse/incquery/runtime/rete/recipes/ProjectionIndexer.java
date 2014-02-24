/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Projection Indexer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents helper nodes that provide projection indexing for Beta nodes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer#getMask <em>Mask</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getProjectionIndexer()
 * @model
 * @generated
 */
public interface ProjectionIndexer extends SingleParentNodeRecipe
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
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getProjectionIndexer_Mask()
   * @model containment="true"
   * @generated
   */
  Mask getMask();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer#getMask <em>Mask</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mask</em>' containment reference.
   * @see #getMask()
   * @generated
   */
  void setMask(Mask value);

} // ProjectionIndexer
