/**
 */
package resources;

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
 * @see resources.ResourcesFactory
 * @model kind="package"
 * @generated
 */
public interface ResourcesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resources";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://incquery.net/res";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "res";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcesPackage eINSTANCE = resources.impl.ResourcesPackageImpl.init();

	/**
	 * The meta object id for the '{@link resources.impl.MachineImpl <em>Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see resources.impl.MachineImpl
	 * @see resources.impl.ResourcesPackageImpl#getMachine()
	 * @generated
	 */
	int MACHINE = 0;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__IP = 0;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__MEMORY_SIZE = 1;

	/**
	 * The feature id for the '<em><b>Memory Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__MEMORY_UNIT = 2;

	/**
	 * The feature id for the '<em><b>CP Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__CP_US = 3;

	/**
	 * The number of structural features of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link resources.impl.ResourcesImpl <em>Resources</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see resources.impl.ResourcesImpl
	 * @see resources.impl.ResourcesPackageImpl#getResources()
	 * @generated
	 */
	int RESOURCES = 1;

	/**
	 * The feature id for the '<em><b>Machines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES__MACHINES = 0;

	/**
	 * The number of structural features of the '<em>Resources</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Resources</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link resources.MemoryUnit <em>Memory Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see resources.MemoryUnit
	 * @see resources.impl.ResourcesPackageImpl#getMemoryUnit()
	 * @generated
	 */
	int MEMORY_UNIT = 2;


	/**
	 * Returns the meta object for class '{@link resources.Machine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine</em>'.
	 * @see resources.Machine
	 * @generated
	 */
	EClass getMachine();

	/**
	 * Returns the meta object for the attribute '{@link resources.Machine#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see resources.Machine#getIp()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Ip();

	/**
	 * Returns the meta object for the attribute '{@link resources.Machine#getMemorySize <em>Memory Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size</em>'.
	 * @see resources.Machine#getMemorySize()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_MemorySize();

	/**
	 * Returns the meta object for the attribute '{@link resources.Machine#getMemoryUnit <em>Memory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Unit</em>'.
	 * @see resources.Machine#getMemoryUnit()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_MemoryUnit();

	/**
	 * Returns the meta object for the attribute '{@link resources.Machine#getCPUs <em>CP Us</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CP Us</em>'.
	 * @see resources.Machine#getCPUs()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_CPUs();

	/**
	 * Returns the meta object for class '{@link resources.Resources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resources</em>'.
	 * @see resources.Resources
	 * @generated
	 */
	EClass getResources();

	/**
	 * Returns the meta object for the containment reference list '{@link resources.Resources#getMachines <em>Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machines</em>'.
	 * @see resources.Resources#getMachines()
	 * @see #getResources()
	 * @generated
	 */
	EReference getResources_Machines();

	/**
	 * Returns the meta object for enum '{@link resources.MemoryUnit <em>Memory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Memory Unit</em>'.
	 * @see resources.MemoryUnit
	 * @generated
	 */
	EEnum getMemoryUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourcesFactory getResourcesFactory();

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
		 * The meta object literal for the '{@link resources.impl.MachineImpl <em>Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see resources.impl.MachineImpl
		 * @see resources.impl.ResourcesPackageImpl#getMachine()
		 * @generated
		 */
		EClass MACHINE = eINSTANCE.getMachine();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__IP = eINSTANCE.getMachine_Ip();

		/**
		 * The meta object literal for the '<em><b>Memory Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__MEMORY_SIZE = eINSTANCE.getMachine_MemorySize();

		/**
		 * The meta object literal for the '<em><b>Memory Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__MEMORY_UNIT = eINSTANCE.getMachine_MemoryUnit();

		/**
		 * The meta object literal for the '<em><b>CP Us</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__CP_US = eINSTANCE.getMachine_CPUs();

		/**
		 * The meta object literal for the '{@link resources.impl.ResourcesImpl <em>Resources</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see resources.impl.ResourcesImpl
		 * @see resources.impl.ResourcesPackageImpl#getResources()
		 * @generated
		 */
		EClass RESOURCES = eINSTANCE.getResources();

		/**
		 * The meta object literal for the '<em><b>Machines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCES__MACHINES = eINSTANCE.getResources_Machines();

		/**
		 * The meta object literal for the '{@link resources.MemoryUnit <em>Memory Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see resources.MemoryUnit
		 * @see resources.impl.ResourcesPackageImpl#getMemoryUnit()
		 * @generated
		 */
		EEnum MEMORY_UNIT = eINSTANCE.getMemoryUnit();

	}

} //ResourcesPackage
