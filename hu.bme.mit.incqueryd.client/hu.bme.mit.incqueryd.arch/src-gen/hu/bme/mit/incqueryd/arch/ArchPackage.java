/**
 */
package hu.bme.mit.incqueryd.arch;

import hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see hu.bme.mit.incqueryd.arch.ArchFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='hu.bme.mit.incqueryd'"
 * @generated
 */
public interface ArchPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "arch";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://incquery.net/arch";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "arch";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchPackage eINSTANCE = hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl
	 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Trace Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__TRACE_INFO = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

	/**
	 * The feature id for the '<em><b>Connection String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__CONNECTION_STRING = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Machines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MACHINES = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Recipes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__RECIPES = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MAPPINGS = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Coordinator Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__COORDINATOR_MACHINE = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Monitoring Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MONITORING_MACHINE = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incqueryd.arch.impl.InfrastructureMappingImpl <em>Infrastructure Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incqueryd.arch.impl.InfrastructureMappingImpl
	 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getInfrastructureMapping()
	 * @generated
	 */
	int INFRASTRUCTURE_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Trace Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_MAPPING__TRACE_INFO = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_MAPPING__PROCESS = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_MAPPING__ROLES = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Infrastructure Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_MAPPING_FEATURE_COUNT = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Infrastructure Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_MAPPING_OPERATION_COUNT = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incqueryd.arch.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incqueryd.arch.impl.RoleImpl
	 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 2;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incqueryd.arch.impl.ReteRoleImpl <em>Rete Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incqueryd.arch.impl.ReteRoleImpl
	 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getReteRole()
	 * @generated
	 */
	int RETE_ROLE = 3;

	/**
	 * The feature id for the '<em><b>Node Recipe</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETE_ROLE__NODE_RECIPE = ROLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rete Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETE_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rete Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETE_ROLE_OPERATION_COUNT = ROLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incqueryd.arch.impl.CacheRoleImpl <em>Cache Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incqueryd.arch.impl.CacheRoleImpl
	 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getCacheRole()
	 * @generated
	 */
	int CACHE_ROLE = 4;

	/**
	 * The number of structural features of the '<em>Cache Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cache Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ROLE_OPERATION_COUNT = ROLE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incqueryd.arch.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see hu.bme.mit.incqueryd.arch.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incqueryd.arch.Configuration#getConnectionString <em>Connection String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection String</em>'.
	 * @see hu.bme.mit.incqueryd.arch.Configuration#getConnectionString()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_ConnectionString();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incqueryd.arch.Configuration#getMachines <em>Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machines</em>'.
	 * @see hu.bme.mit.incqueryd.arch.Configuration#getMachines()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Machines();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.incqueryd.arch.Configuration#getRecipes <em>Recipes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Recipes</em>'.
	 * @see hu.bme.mit.incqueryd.arch.Configuration#getRecipes()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Recipes();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incqueryd.arch.Configuration#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see hu.bme.mit.incqueryd.arch.Configuration#getMappings()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Mappings();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incqueryd.arch.Configuration#getCoordinatorMachine <em>Coordinator Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Coordinator Machine</em>'.
	 * @see hu.bme.mit.incqueryd.arch.Configuration#getCoordinatorMachine()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_CoordinatorMachine();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incqueryd.arch.Configuration#getMonitoringMachine <em>Monitoring Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitoring Machine</em>'.
	 * @see hu.bme.mit.incqueryd.arch.Configuration#getMonitoringMachine()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_MonitoringMachine();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incqueryd.arch.InfrastructureMapping <em>Infrastructure Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Mapping</em>'.
	 * @see hu.bme.mit.incqueryd.arch.InfrastructureMapping
	 * @generated
	 */
	EClass getInfrastructureMapping();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incqueryd.arch.InfrastructureMapping#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process</em>'.
	 * @see hu.bme.mit.incqueryd.arch.InfrastructureMapping#getProcess()
	 * @see #getInfrastructureMapping()
	 * @generated
	 */
	EReference getInfrastructureMapping_Process();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incqueryd.arch.InfrastructureMapping#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see hu.bme.mit.incqueryd.arch.InfrastructureMapping#getRoles()
	 * @see #getInfrastructureMapping()
	 * @generated
	 */
	EReference getInfrastructureMapping_Roles();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incqueryd.arch.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see hu.bme.mit.incqueryd.arch.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incqueryd.arch.ReteRole <em>Rete Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rete Role</em>'.
	 * @see hu.bme.mit.incqueryd.arch.ReteRole
	 * @generated
	 */
	EClass getReteRole();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incqueryd.arch.ReteRole#getNodeRecipe <em>Node Recipe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Recipe</em>'.
	 * @see hu.bme.mit.incqueryd.arch.ReteRole#getNodeRecipe()
	 * @see #getReteRole()
	 * @generated
	 */
	EReference getReteRole_NodeRecipe();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incqueryd.arch.CacheRole <em>Cache Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cache Role</em>'.
	 * @see hu.bme.mit.incqueryd.arch.CacheRole
	 * @generated
	 */
	EClass getCacheRole();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchFactory getArchFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl
		 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Connection String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__CONNECTION_STRING = eINSTANCE.getConfiguration_ConnectionString();

		/**
		 * The meta object literal for the '<em><b>Machines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__MACHINES = eINSTANCE.getConfiguration_Machines();

		/**
		 * The meta object literal for the '<em><b>Recipes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__RECIPES = eINSTANCE.getConfiguration_Recipes();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__MAPPINGS = eINSTANCE.getConfiguration_Mappings();

		/**
		 * The meta object literal for the '<em><b>Coordinator Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__COORDINATOR_MACHINE = eINSTANCE.getConfiguration_CoordinatorMachine();

		/**
		 * The meta object literal for the '<em><b>Monitoring Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__MONITORING_MACHINE = eINSTANCE.getConfiguration_MonitoringMachine();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incqueryd.arch.impl.InfrastructureMappingImpl <em>Infrastructure Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incqueryd.arch.impl.InfrastructureMappingImpl
		 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getInfrastructureMapping()
		 * @generated
		 */
		EClass INFRASTRUCTURE_MAPPING = eINSTANCE.getInfrastructureMapping();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_MAPPING__PROCESS = eINSTANCE.getInfrastructureMapping_Process();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_MAPPING__ROLES = eINSTANCE.getInfrastructureMapping_Roles();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incqueryd.arch.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incqueryd.arch.impl.RoleImpl
		 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incqueryd.arch.impl.ReteRoleImpl <em>Rete Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incqueryd.arch.impl.ReteRoleImpl
		 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getReteRole()
		 * @generated
		 */
		EClass RETE_ROLE = eINSTANCE.getReteRole();

		/**
		 * The meta object literal for the '<em><b>Node Recipe</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETE_ROLE__NODE_RECIPE = eINSTANCE.getReteRole_NodeRecipe();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incqueryd.arch.impl.CacheRoleImpl <em>Cache Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incqueryd.arch.impl.CacheRoleImpl
		 * @see hu.bme.mit.incqueryd.arch.impl.ArchPackageImpl#getCacheRole()
		 * @generated
		 */
		EClass CACHE_ROLE = eINSTANCE.getCacheRole();

	}

} //ArchPackage
