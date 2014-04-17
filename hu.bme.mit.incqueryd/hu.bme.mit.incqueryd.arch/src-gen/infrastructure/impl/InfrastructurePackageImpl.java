/**
 */
package infrastructure.impl;

import arch.ArchPackage;

import arch.impl.ArchPackageImpl;

import infrastructure.Cluster;
import infrastructure.GraphStore;
import infrastructure.InfrastructureFactory;
import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;
import infrastructure.ServiceNode;
import infrastructure.Storage;
import infrastructure.StorageKind;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfrastructurePackageImpl extends EPackageImpl implements InfrastructurePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass clusterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass storageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass machineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass graphStoreEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass infrastructureNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum storageKindEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see infrastructure.InfrastructurePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private InfrastructurePackageImpl()
  {
    super(eNS_URI, InfrastructureFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link InfrastructurePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static InfrastructurePackage init()
  {
    if (isInited) return (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);

    // Obtain or create and register package
    InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InfrastructurePackageImpl());

    isInited = true;

    // Obtain or create and register interdependencies
    ArchPackageImpl theArchPackage = (ArchPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ArchPackage.eNS_URI) instanceof ArchPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ArchPackage.eNS_URI) : ArchPackage.eINSTANCE);

    // Create package meta-data objects
    theInfrastructurePackage.createPackageContents();
    theArchPackage.createPackageContents();

    // Initialize created meta-data
    theInfrastructurePackage.initializePackageContents();
    theArchPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theInfrastructurePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(InfrastructurePackage.eNS_URI, theInfrastructurePackage);
    return theInfrastructurePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCluster()
  {
    return clusterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCluster_InfrastructureNodes()
  {
    return (EReference)clusterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCluster_ServiceNodes()
  {
    return (EReference)clusterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStorage()
  {
    return storageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStorage_Maximum()
  {
    return (EAttribute)storageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStorage_Used()
  {
    return (EAttribute)storageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStorage_Free()
  {
    return (EAttribute)storageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStorage_Kind()
  {
    return (EAttribute)storageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMachine()
  {
    return machineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMachine_Storage()
  {
    return (EReference)machineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMachine_Host()
  {
    return (EAttribute)machineEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMachine_Ip()
  {
    return (EAttribute)machineEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGraphStore()
  {
    return graphStoreEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGraphStore_RequiredStorage()
  {
    return (EReference)graphStoreEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGraphStore_UsedStorage()
  {
    return (EReference)graphStoreEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGraphStore_Master()
  {
    return (EReference)graphStoreEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGraphStore_Slave()
  {
    return (EReference)graphStoreEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInfrastructureNode()
  {
    return infrastructureNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceNode()
  {
    return serviceNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getStorageKind()
  {
    return storageKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfrastructureFactory getInfrastructureFactory()
  {
    return (InfrastructureFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    clusterEClass = createEClass(CLUSTER);
    createEReference(clusterEClass, CLUSTER__INFRASTRUCTURE_NODES);
    createEReference(clusterEClass, CLUSTER__SERVICE_NODES);

    storageEClass = createEClass(STORAGE);
    createEAttribute(storageEClass, STORAGE__MAXIMUM);
    createEAttribute(storageEClass, STORAGE__USED);
    createEAttribute(storageEClass, STORAGE__FREE);
    createEAttribute(storageEClass, STORAGE__KIND);

    machineEClass = createEClass(MACHINE);
    createEReference(machineEClass, MACHINE__STORAGE);
    createEAttribute(machineEClass, MACHINE__HOST);
    createEAttribute(machineEClass, MACHINE__IP);

    graphStoreEClass = createEClass(GRAPH_STORE);
    createEReference(graphStoreEClass, GRAPH_STORE__REQUIRED_STORAGE);
    createEReference(graphStoreEClass, GRAPH_STORE__USED_STORAGE);
    createEReference(graphStoreEClass, GRAPH_STORE__MASTER);
    createEReference(graphStoreEClass, GRAPH_STORE__SLAVE);

    infrastructureNodeEClass = createEClass(INFRASTRUCTURE_NODE);

    serviceNodeEClass = createEClass(SERVICE_NODE);

    // Create enums
    storageKindEEnum = createEEnum(STORAGE_KIND);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    ArchPackage theArchPackage = (ArchPackage)EPackage.Registry.INSTANCE.getEPackage(ArchPackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    clusterEClass.getESuperTypes().add(theArchPackage.getElementWithTraceInfo());
    storageEClass.getESuperTypes().add(this.getInfrastructureNode());
    machineEClass.getESuperTypes().add(this.getInfrastructureNode());
    graphStoreEClass.getESuperTypes().add(this.getServiceNode());
    infrastructureNodeEClass.getESuperTypes().add(theArchPackage.getElementWithTraceInfo());
    serviceNodeEClass.getESuperTypes().add(theArchPackage.getElementWithTraceInfo());

    // Initialize classes, features, and operations; add parameters
    initEClass(clusterEClass, Cluster.class, "Cluster", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCluster_InfrastructureNodes(), this.getInfrastructureNode(), null, "infrastructureNodes", null, 0, -1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCluster_ServiceNodes(), this.getServiceNode(), null, "serviceNodes", null, 0, -1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(storageEClass, Storage.class, "Storage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStorage_Maximum(), theEcorePackage.getELong(), "maximum", null, 0, 1, Storage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStorage_Used(), theEcorePackage.getELong(), "used", null, 0, 1, Storage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStorage_Free(), theEcorePackage.getELong(), "free", null, 0, 1, Storage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStorage_Kind(), this.getStorageKind(), "kind", null, 0, 1, Storage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(machineEClass, Machine.class, "Machine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMachine_Storage(), this.getStorage(), null, "storage", null, 0, -1, Machine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMachine_Host(), theEcorePackage.getEString(), "host", null, 0, 1, Machine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMachine_Ip(), theEcorePackage.getEString(), "ip", null, 0, 1, Machine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(graphStoreEClass, GraphStore.class, "GraphStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGraphStore_RequiredStorage(), this.getStorage(), null, "requiredStorage", null, 0, -1, GraphStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGraphStore_UsedStorage(), this.getStorage(), null, "usedStorage", null, 0, -1, GraphStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGraphStore_Master(), this.getMachine(), null, "master", null, 0, 1, GraphStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGraphStore_Slave(), this.getMachine(), null, "slave", null, 0, 1, GraphStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(infrastructureNodeEClass, InfrastructureNode.class, "InfrastructureNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(serviceNodeEClass, ServiceNode.class, "ServiceNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(storageKindEEnum, StorageKind.class, "StorageKind");
    addEEnumLiteral(storageKindEEnum, StorageKind.MEMORY);
    addEEnumLiteral(storageKindEEnum, StorageKind.HARDDRIVE);
    addEEnumLiteral(storageKindEEnum, StorageKind.SSD);
    addEEnumLiteral(storageKindEEnum, StorageKind.NETWORK);

    // Create resource
    createResource(eNS_URI);
  }

} //InfrastructurePackageImpl
