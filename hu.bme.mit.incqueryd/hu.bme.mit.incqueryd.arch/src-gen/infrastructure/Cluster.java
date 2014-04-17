/**
 */
package infrastructure;

import arch.ElementWithTraceInfo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link infrastructure.Cluster#getInfrastructureNodes <em>Infrastructure Nodes</em>}</li>
 *   <li>{@link infrastructure.Cluster#getServiceNodes <em>Service Nodes</em>}</li>
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
   * Returns the value of the '<em><b>Infrastructure Nodes</b></em>' containment reference list.
   * The list contents are of type {@link infrastructure.InfrastructureNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Infrastructure Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Infrastructure Nodes</em>' containment reference list.
   * @see infrastructure.InfrastructurePackage#getCluster_InfrastructureNodes()
   * @model containment="true"
   * @generated
   */
  EList<InfrastructureNode> getInfrastructureNodes();

  /**
   * Returns the value of the '<em><b>Service Nodes</b></em>' containment reference list.
   * The list contents are of type {@link infrastructure.ServiceNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service Nodes</em>' containment reference list.
   * @see infrastructure.InfrastructurePackage#getCluster_ServiceNodes()
   * @model containment="true"
   * @generated
   */
  EList<ServiceNode> getServiceNodes();

} // Cluster
