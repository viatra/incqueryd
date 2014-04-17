/**
 */
package arch;

import infrastructure.Cluster;

import org.eclipse.emf.common.util.EList;

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arch.Configuration#getClusters <em>Clusters</em>}</li>
 *   <li>{@link arch.Configuration#getReteRecipes <em>Rete Recipes</em>}</li>
 *   <li>{@link arch.Configuration#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see arch.ArchPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends ElementWithTraceInfo
{
  /**
   * Returns the value of the '<em><b>Clusters</b></em>' containment reference list.
   * The list contents are of type {@link infrastructure.Cluster}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clusters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clusters</em>' containment reference list.
   * @see arch.ArchPackage#getConfiguration_Clusters()
   * @model containment="true"
   * @generated
   */
  EList<Cluster> getClusters();

  /**
   * Returns the value of the '<em><b>Rete Recipes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.runtime.rete.recipes.ReteRecipe}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rete Recipes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rete Recipes</em>' containment reference list.
   * @see arch.ArchPackage#getConfiguration_ReteRecipes()
   * @model containment="true"
   * @generated
   */
  EList<ReteRecipe> getReteRecipes();

  /**
   * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
   * The list contents are of type {@link arch.InfrastructureMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mappings</em>' containment reference list.
   * @see arch.ArchPackage#getConfiguration_Mappings()
   * @model containment="true"
   * @generated
   */
  EList<InfrastructureMapping> getMappings();

} // Configuration
