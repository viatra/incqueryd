/**
 */
package arch;

import infrastructure.InfrastructurePackage;

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
 * @see arch.ArchFactory
 * @model kind="package"
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
	ArchPackage eINSTANCE = arch.impl.ArchPackageImpl.init();

	/**
	 * The meta object id for the '{@link arch.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arch.impl.ConfigurationImpl
	 * @see arch.impl.ArchPackageImpl#getConfiguration()
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
	 * The feature id for the '<em><b>Recipe Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__RECIPE_IMPORTS = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MAPPINGS = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link arch.impl.RecipeImportImpl <em>Recipe Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arch.impl.RecipeImportImpl
	 * @see arch.impl.ArchPackageImpl#getRecipeImport()
	 * @generated
	 */
	int RECIPE_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPE_IMPORT__IMPORT_URI = 0;

	/**
	 * The number of structural features of the '<em>Recipe Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPE_IMPORT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Recipe Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPE_IMPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link arch.impl.InfrastructureMappingImpl <em>Infrastructure Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arch.impl.InfrastructureMappingImpl
	 * @see arch.impl.ArchPackageImpl#getInfrastructureMapping()
	 * @generated
	 */
	int INFRASTRUCTURE_MAPPING = 2;

	/**
	 * The feature id for the '<em><b>Trace Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_MAPPING__TRACE_INFO = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_MAPPING__MACHINE = InfrastructurePackage.ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link arch.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arch.impl.RoleImpl
	 * @see arch.impl.ArchPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 3;

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
	 * The meta object id for the '{@link arch.impl.ReteRoleImpl <em>Rete Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arch.impl.ReteRoleImpl
	 * @see arch.impl.ArchPackageImpl#getReteRole()
	 * @generated
	 */
	int RETE_ROLE = 4;

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
	 * The meta object id for the '{@link arch.impl.CacheRoleImpl <em>Cache Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arch.impl.CacheRoleImpl
	 * @see arch.impl.ArchPackageImpl#getCacheRole()
	 * @generated
	 */
	int CACHE_ROLE = 5;

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
	 * Returns the meta object for class '{@link arch.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see arch.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link arch.Configuration#getRecipeImports <em>Recipe Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Recipe Imports</em>'.
	 * @see arch.Configuration#getRecipeImports()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_RecipeImports();

	/**
	 * Returns the meta object for the containment reference list '{@link arch.Configuration#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see arch.Configuration#getMappings()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Mappings();

	/**
	 * Returns the meta object for class '{@link arch.RecipeImport <em>Recipe Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recipe Import</em>'.
	 * @see arch.RecipeImport
	 * @generated
	 */
	EClass getRecipeImport();

	/**
	 * Returns the meta object for the attribute '{@link arch.RecipeImport#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see arch.RecipeImport#getImportURI()
	 * @see #getRecipeImport()
	 * @generated
	 */
	EAttribute getRecipeImport_ImportURI();

	/**
	 * Returns the meta object for class '{@link arch.InfrastructureMapping <em>Infrastructure Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Mapping</em>'.
	 * @see arch.InfrastructureMapping
	 * @generated
	 */
	EClass getInfrastructureMapping();

	/**
	 * Returns the meta object for the containment reference '{@link arch.InfrastructureMapping#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Machine</em>'.
	 * @see arch.InfrastructureMapping#getMachine()
	 * @see #getInfrastructureMapping()
	 * @generated
	 */
	EReference getInfrastructureMapping_Machine();

	/**
	 * Returns the meta object for the containment reference list '{@link arch.InfrastructureMapping#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see arch.InfrastructureMapping#getRoles()
	 * @see #getInfrastructureMapping()
	 * @generated
	 */
	EReference getInfrastructureMapping_Roles();

	/**
	 * Returns the meta object for class '{@link arch.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see arch.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for class '{@link arch.ReteRole <em>Rete Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rete Role</em>'.
	 * @see arch.ReteRole
	 * @generated
	 */
	EClass getReteRole();

	/**
	 * Returns the meta object for the reference '{@link arch.ReteRole#getNodeRecipe <em>Node Recipe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Recipe</em>'.
	 * @see arch.ReteRole#getNodeRecipe()
	 * @see #getReteRole()
	 * @generated
	 */
	EReference getReteRole_NodeRecipe();

	/**
	 * Returns the meta object for class '{@link arch.CacheRole <em>Cache Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cache Role</em>'.
	 * @see arch.CacheRole
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
		 * The meta object literal for the '{@link arch.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arch.impl.ConfigurationImpl
		 * @see arch.impl.ArchPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Recipe Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__RECIPE_IMPORTS = eINSTANCE.getConfiguration_RecipeImports();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__MAPPINGS = eINSTANCE.getConfiguration_Mappings();

		/**
		 * The meta object literal for the '{@link arch.impl.RecipeImportImpl <em>Recipe Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arch.impl.RecipeImportImpl
		 * @see arch.impl.ArchPackageImpl#getRecipeImport()
		 * @generated
		 */
		EClass RECIPE_IMPORT = eINSTANCE.getRecipeImport();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPE_IMPORT__IMPORT_URI = eINSTANCE.getRecipeImport_ImportURI();

		/**
		 * The meta object literal for the '{@link arch.impl.InfrastructureMappingImpl <em>Infrastructure Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arch.impl.InfrastructureMappingImpl
		 * @see arch.impl.ArchPackageImpl#getInfrastructureMapping()
		 * @generated
		 */
		EClass INFRASTRUCTURE_MAPPING = eINSTANCE.getInfrastructureMapping();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_MAPPING__MACHINE = eINSTANCE.getInfrastructureMapping_Machine();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_MAPPING__ROLES = eINSTANCE.getInfrastructureMapping_Roles();

		/**
		 * The meta object literal for the '{@link arch.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arch.impl.RoleImpl
		 * @see arch.impl.ArchPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '{@link arch.impl.ReteRoleImpl <em>Rete Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arch.impl.ReteRoleImpl
		 * @see arch.impl.ArchPackageImpl#getReteRole()
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
		 * The meta object literal for the '{@link arch.impl.CacheRoleImpl <em>Cache Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arch.impl.CacheRoleImpl
		 * @see arch.impl.ArchPackageImpl#getCacheRole()
		 * @generated
		 */
		EClass CACHE_ROLE = eINSTANCE.getCacheRole();

	}

} //ArchPackage