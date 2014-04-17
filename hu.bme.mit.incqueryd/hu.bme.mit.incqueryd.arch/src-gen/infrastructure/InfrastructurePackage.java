/**
 */
package infrastructure;

import arch.ArchPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see infrastructure.InfrastructureFactory
 * @model kind="package"
 * @generated
 */
public interface InfrastructurePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "infrastructure";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://incquery.net/d/infrastructure";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "inf";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  InfrastructurePackage eINSTANCE = infrastructure.impl.InfrastructurePackageImpl.init();

  /**
   * The meta object id for the '{@link infrastructure.impl.ClusterImpl <em>Cluster</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see infrastructure.impl.ClusterImpl
   * @see infrastructure.impl.InfrastructurePackageImpl#getCluster()
   * @generated
   */
  int CLUSTER = 0;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER__TRACE_INFO = ArchPackage.ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Infrastructure Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER__INFRASTRUCTURE_NODES = ArchPackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Service Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER__SERVICE_NODES = ArchPackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cluster</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER_FEATURE_COUNT = ArchPackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Cluster</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER_OPERATION_COUNT = ArchPackage.ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link infrastructure.impl.InfrastructureNodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see infrastructure.impl.InfrastructureNodeImpl
   * @see infrastructure.impl.InfrastructurePackageImpl#getInfrastructureNode()
   * @generated
   */
  int INFRASTRUCTURE_NODE = 4;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_NODE__TRACE_INFO = ArchPackage.ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_NODE_FEATURE_COUNT = ArchPackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_NODE_OPERATION_COUNT = ArchPackage.ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link infrastructure.impl.StorageImpl <em>Storage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see infrastructure.impl.StorageImpl
   * @see infrastructure.impl.InfrastructurePackageImpl#getStorage()
   * @generated
   */
  int STORAGE = 1;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE__TRACE_INFO = INFRASTRUCTURE_NODE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Maximum</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE__MAXIMUM = INFRASTRUCTURE_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Used</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE__USED = INFRASTRUCTURE_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Free</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE__FREE = INFRASTRUCTURE_NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE__KIND = INFRASTRUCTURE_NODE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Storage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_FEATURE_COUNT = INFRASTRUCTURE_NODE_FEATURE_COUNT + 4;

  /**
   * The number of operations of the '<em>Storage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_OPERATION_COUNT = INFRASTRUCTURE_NODE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link infrastructure.impl.MachineImpl <em>Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see infrastructure.impl.MachineImpl
   * @see infrastructure.impl.InfrastructurePackageImpl#getMachine()
   * @generated
   */
  int MACHINE = 2;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE__TRACE_INFO = INFRASTRUCTURE_NODE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Storage</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE__STORAGE = INFRASTRUCTURE_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Host</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE__HOST = INFRASTRUCTURE_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ip</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE__IP = INFRASTRUCTURE_NODE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE_FEATURE_COUNT = INFRASTRUCTURE_NODE_FEATURE_COUNT + 3;

  /**
   * The number of operations of the '<em>Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE_OPERATION_COUNT = INFRASTRUCTURE_NODE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link infrastructure.impl.ServiceNodeImpl <em>Service Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see infrastructure.impl.ServiceNodeImpl
   * @see infrastructure.impl.InfrastructurePackageImpl#getServiceNode()
   * @generated
   */
  int SERVICE_NODE = 5;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_NODE__TRACE_INFO = ArchPackage.ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

  /**
   * The number of structural features of the '<em>Service Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_NODE_FEATURE_COUNT = ArchPackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Service Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_NODE_OPERATION_COUNT = ArchPackage.ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link infrastructure.impl.GraphStoreImpl <em>Graph Store</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see infrastructure.impl.GraphStoreImpl
   * @see infrastructure.impl.InfrastructurePackageImpl#getGraphStore()
   * @generated
   */
  int GRAPH_STORE = 3;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_STORE__TRACE_INFO = SERVICE_NODE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Required Storage</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_STORE__REQUIRED_STORAGE = SERVICE_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Used Storage</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_STORE__USED_STORAGE = SERVICE_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Master</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_STORE__MASTER = SERVICE_NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Slave</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_STORE__SLAVE = SERVICE_NODE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Graph Store</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_STORE_FEATURE_COUNT = SERVICE_NODE_FEATURE_COUNT + 4;

  /**
   * The number of operations of the '<em>Graph Store</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_STORE_OPERATION_COUNT = SERVICE_NODE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link infrastructure.StorageKind <em>Storage Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see infrastructure.StorageKind
   * @see infrastructure.impl.InfrastructurePackageImpl#getStorageKind()
   * @generated
   */
  int STORAGE_KIND = 6;


  /**
   * Returns the meta object for class '{@link infrastructure.Cluster <em>Cluster</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cluster</em>'.
   * @see infrastructure.Cluster
   * @generated
   */
  EClass getCluster();

  /**
   * Returns the meta object for the containment reference list '{@link infrastructure.Cluster#getInfrastructureNodes <em>Infrastructure Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Infrastructure Nodes</em>'.
   * @see infrastructure.Cluster#getInfrastructureNodes()
   * @see #getCluster()
   * @generated
   */
  EReference getCluster_InfrastructureNodes();

  /**
   * Returns the meta object for the containment reference list '{@link infrastructure.Cluster#getServiceNodes <em>Service Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Service Nodes</em>'.
   * @see infrastructure.Cluster#getServiceNodes()
   * @see #getCluster()
   * @generated
   */
  EReference getCluster_ServiceNodes();

  /**
   * Returns the meta object for class '{@link infrastructure.Storage <em>Storage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Storage</em>'.
   * @see infrastructure.Storage
   * @generated
   */
  EClass getStorage();

  /**
   * Returns the meta object for the attribute '{@link infrastructure.Storage#getMaximum <em>Maximum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Maximum</em>'.
   * @see infrastructure.Storage#getMaximum()
   * @see #getStorage()
   * @generated
   */
  EAttribute getStorage_Maximum();

  /**
   * Returns the meta object for the attribute '{@link infrastructure.Storage#getUsed <em>Used</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Used</em>'.
   * @see infrastructure.Storage#getUsed()
   * @see #getStorage()
   * @generated
   */
  EAttribute getStorage_Used();

  /**
   * Returns the meta object for the attribute '{@link infrastructure.Storage#getFree <em>Free</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Free</em>'.
   * @see infrastructure.Storage#getFree()
   * @see #getStorage()
   * @generated
   */
  EAttribute getStorage_Free();

  /**
   * Returns the meta object for the attribute '{@link infrastructure.Storage#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see infrastructure.Storage#getKind()
   * @see #getStorage()
   * @generated
   */
  EAttribute getStorage_Kind();

  /**
   * Returns the meta object for class '{@link infrastructure.Machine <em>Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Machine</em>'.
   * @see infrastructure.Machine
   * @generated
   */
  EClass getMachine();

  /**
   * Returns the meta object for the reference list '{@link infrastructure.Machine#getStorage <em>Storage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Storage</em>'.
   * @see infrastructure.Machine#getStorage()
   * @see #getMachine()
   * @generated
   */
  EReference getMachine_Storage();

  /**
   * Returns the meta object for the attribute '{@link infrastructure.Machine#getHost <em>Host</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Host</em>'.
   * @see infrastructure.Machine#getHost()
   * @see #getMachine()
   * @generated
   */
  EAttribute getMachine_Host();

  /**
   * Returns the meta object for the attribute '{@link infrastructure.Machine#getIp <em>Ip</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ip</em>'.
   * @see infrastructure.Machine#getIp()
   * @see #getMachine()
   * @generated
   */
  EAttribute getMachine_Ip();

  /**
   * Returns the meta object for class '{@link infrastructure.GraphStore <em>Graph Store</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Graph Store</em>'.
   * @see infrastructure.GraphStore
   * @generated
   */
  EClass getGraphStore();

  /**
   * Returns the meta object for the reference list '{@link infrastructure.GraphStore#getRequiredStorage <em>Required Storage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Required Storage</em>'.
   * @see infrastructure.GraphStore#getRequiredStorage()
   * @see #getGraphStore()
   * @generated
   */
  EReference getGraphStore_RequiredStorage();

  /**
   * Returns the meta object for the reference list '{@link infrastructure.GraphStore#getUsedStorage <em>Used Storage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Used Storage</em>'.
   * @see infrastructure.GraphStore#getUsedStorage()
   * @see #getGraphStore()
   * @generated
   */
  EReference getGraphStore_UsedStorage();

  /**
   * Returns the meta object for the reference '{@link infrastructure.GraphStore#getMaster <em>Master</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Master</em>'.
   * @see infrastructure.GraphStore#getMaster()
   * @see #getGraphStore()
   * @generated
   */
  EReference getGraphStore_Master();

  /**
   * Returns the meta object for the reference '{@link infrastructure.GraphStore#getSlave <em>Slave</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Slave</em>'.
   * @see infrastructure.GraphStore#getSlave()
   * @see #getGraphStore()
   * @generated
   */
  EReference getGraphStore_Slave();

  /**
   * Returns the meta object for class '{@link infrastructure.InfrastructureNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see infrastructure.InfrastructureNode
   * @generated
   */
  EClass getInfrastructureNode();

  /**
   * Returns the meta object for class '{@link infrastructure.ServiceNode <em>Service Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Node</em>'.
   * @see infrastructure.ServiceNode
   * @generated
   */
  EClass getServiceNode();

  /**
   * Returns the meta object for enum '{@link infrastructure.StorageKind <em>Storage Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Storage Kind</em>'.
   * @see infrastructure.StorageKind
   * @generated
   */
  EEnum getStorageKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  InfrastructureFactory getInfrastructureFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link infrastructure.impl.ClusterImpl <em>Cluster</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see infrastructure.impl.ClusterImpl
     * @see infrastructure.impl.InfrastructurePackageImpl#getCluster()
     * @generated
     */
    EClass CLUSTER = eINSTANCE.getCluster();

    /**
     * The meta object literal for the '<em><b>Infrastructure Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLUSTER__INFRASTRUCTURE_NODES = eINSTANCE.getCluster_InfrastructureNodes();

    /**
     * The meta object literal for the '<em><b>Service Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLUSTER__SERVICE_NODES = eINSTANCE.getCluster_ServiceNodes();

    /**
     * The meta object literal for the '{@link infrastructure.impl.StorageImpl <em>Storage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see infrastructure.impl.StorageImpl
     * @see infrastructure.impl.InfrastructurePackageImpl#getStorage()
     * @generated
     */
    EClass STORAGE = eINSTANCE.getStorage();

    /**
     * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STORAGE__MAXIMUM = eINSTANCE.getStorage_Maximum();

    /**
     * The meta object literal for the '<em><b>Used</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STORAGE__USED = eINSTANCE.getStorage_Used();

    /**
     * The meta object literal for the '<em><b>Free</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STORAGE__FREE = eINSTANCE.getStorage_Free();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STORAGE__KIND = eINSTANCE.getStorage_Kind();

    /**
     * The meta object literal for the '{@link infrastructure.impl.MachineImpl <em>Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see infrastructure.impl.MachineImpl
     * @see infrastructure.impl.InfrastructurePackageImpl#getMachine()
     * @generated
     */
    EClass MACHINE = eINSTANCE.getMachine();

    /**
     * The meta object literal for the '<em><b>Storage</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACHINE__STORAGE = eINSTANCE.getMachine_Storage();

    /**
     * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACHINE__HOST = eINSTANCE.getMachine_Host();

    /**
     * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACHINE__IP = eINSTANCE.getMachine_Ip();

    /**
     * The meta object literal for the '{@link infrastructure.impl.GraphStoreImpl <em>Graph Store</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see infrastructure.impl.GraphStoreImpl
     * @see infrastructure.impl.InfrastructurePackageImpl#getGraphStore()
     * @generated
     */
    EClass GRAPH_STORE = eINSTANCE.getGraphStore();

    /**
     * The meta object literal for the '<em><b>Required Storage</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAPH_STORE__REQUIRED_STORAGE = eINSTANCE.getGraphStore_RequiredStorage();

    /**
     * The meta object literal for the '<em><b>Used Storage</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAPH_STORE__USED_STORAGE = eINSTANCE.getGraphStore_UsedStorage();

    /**
     * The meta object literal for the '<em><b>Master</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAPH_STORE__MASTER = eINSTANCE.getGraphStore_Master();

    /**
     * The meta object literal for the '<em><b>Slave</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAPH_STORE__SLAVE = eINSTANCE.getGraphStore_Slave();

    /**
     * The meta object literal for the '{@link infrastructure.impl.InfrastructureNodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see infrastructure.impl.InfrastructureNodeImpl
     * @see infrastructure.impl.InfrastructurePackageImpl#getInfrastructureNode()
     * @generated
     */
    EClass INFRASTRUCTURE_NODE = eINSTANCE.getInfrastructureNode();

    /**
     * The meta object literal for the '{@link infrastructure.impl.ServiceNodeImpl <em>Service Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see infrastructure.impl.ServiceNodeImpl
     * @see infrastructure.impl.InfrastructurePackageImpl#getServiceNode()
     * @generated
     */
    EClass SERVICE_NODE = eINSTANCE.getServiceNode();

    /**
     * The meta object literal for the '{@link infrastructure.StorageKind <em>Storage Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see infrastructure.StorageKind
     * @see infrastructure.impl.InfrastructurePackageImpl#getStorageKind()
     * @generated
     */
    EEnum STORAGE_KIND = eINSTANCE.getStorageKind();

  }

} //InfrastructurePackage
