/**
 */
package infrastructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link infrastructure.Cluster#getReteMachines <em>Rete Machines</em>}</li>
 *   <li>{@link infrastructure.Cluster#getCacheMachines <em>Cache Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @see infrastructure.InfrastructurePackage#getCluster()
 * @model
 * @generated
 */
public interface Cluster extends ElementWithTraceInfo
{
  /**
   * Returns the value of the '<em><b>Rete Machines</b></em>' containment reference list.
   * The list contents are of type {@link infrastructure.Machine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rete Machines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rete Machines</em>' containment reference list.
   * @see infrastructure.InfrastructurePackage#getCluster_ReteMachines()
   * @model containment="true"
   * @generated
   */
  EList<Machine> getReteMachines();

  /**
   * Returns the value of the '<em><b>Cache Machines</b></em>' containment reference list.
   * The list contents are of type {@link infrastructure.Machine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cache Machines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cache Machines</em>' containment reference list.
   * @see infrastructure.InfrastructurePackage#getCluster_CacheMachines()
   * @model containment="true"
   * @generated
   */
  EList<Machine> getCacheMachines();

} // Cluster
