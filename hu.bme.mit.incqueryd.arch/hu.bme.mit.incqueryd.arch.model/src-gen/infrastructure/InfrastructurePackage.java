/**
 */
package infrastructure;

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
 * @see infrastructure.InfrastructureFactory
 * @model kind="package"
 * @generated
 */
public interface InfrastructurePackage extends EPackage {
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
	 * The meta object id for the '{@link infrastructure.ElementWithTraceInfo <em>Element With Trace Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see infrastructure.ElementWithTraceInfo
	 * @see infrastructure.impl.InfrastructurePackageImpl#getElementWithTraceInfo()
	 * @generated
	 */
	int ELEMENT_WITH_TRACE_INFO = 2;

	/**
	 * The feature id for the '<em><b>Trace Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_TRACE_INFO__TRACE_INFO = 0;

	/**
	 * The number of structural features of the '<em>Element With Trace Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Element With Trace Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link infrastructure.impl.MachineImpl <em>Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see infrastructure.impl.MachineImpl
	 * @see infrastructure.impl.InfrastructurePackageImpl#getMachine()
	 * @generated
	 */
	int MACHINE = 0;

	/**
	 * The feature id for the '<em><b>Trace Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__TRACE_INFO = ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__NAME = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__IP = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__PROCESSES = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_FEATURE_COUNT = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_OPERATION_COUNT = ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link infrastructure.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see infrastructure.impl.ProcessImpl
	 * @see infrastructure.impl.InfrastructurePackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Trace Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__TRACE_INFO = ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PORT = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__MEMORY = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__MACHINE = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OPERATION_COUNT = ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the attribute '{@link infrastructure.Machine#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see infrastructure.Machine#getName()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Name();

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
	 * Returns the meta object for the containment reference list '{@link infrastructure.Machine#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see infrastructure.Machine#getProcesses()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Processes();

	/**
	 * Returns the meta object for class '{@link infrastructure.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see infrastructure.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the attribute '{@link infrastructure.Process#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see infrastructure.Process#getPort()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Port();

	/**
	 * Returns the meta object for the attribute '{@link infrastructure.Process#getMemory <em>Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory</em>'.
	 * @see infrastructure.Process#getMemory()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Memory();

	/**
	 * Returns the meta object for the container reference '{@link infrastructure.Process#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Machine</em>'.
	 * @see infrastructure.Process#getMachine()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Machine();

	/**
	 * Returns the meta object for class '{@link infrastructure.ElementWithTraceInfo <em>Element With Trace Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element With Trace Info</em>'.
	 * @see infrastructure.ElementWithTraceInfo
	 * @generated
	 */
	EClass getElementWithTraceInfo();

	/**
	 * Returns the meta object for the attribute '{@link infrastructure.ElementWithTraceInfo#getTraceInfo <em>Trace Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace Info</em>'.
	 * @see infrastructure.ElementWithTraceInfo#getTraceInfo()
	 * @see #getElementWithTraceInfo()
	 * @generated
	 */
	EAttribute getElementWithTraceInfo_TraceInfo();

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
	interface Literals {
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__NAME = eINSTANCE.getMachine_Name();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__IP = eINSTANCE.getMachine_Ip();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__PROCESSES = eINSTANCE.getMachine_Processes();

		/**
		 * The meta object literal for the '{@link infrastructure.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see infrastructure.impl.ProcessImpl
		 * @see infrastructure.impl.InfrastructurePackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__PORT = eINSTANCE.getProcess_Port();

		/**
		 * The meta object literal for the '<em><b>Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__MEMORY = eINSTANCE.getProcess_Memory();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__MACHINE = eINSTANCE.getProcess_Machine();

		/**
		 * The meta object literal for the '{@link infrastructure.ElementWithTraceInfo <em>Element With Trace Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see infrastructure.ElementWithTraceInfo
		 * @see infrastructure.impl.InfrastructurePackageImpl#getElementWithTraceInfo()
		 * @generated
		 */
		EClass ELEMENT_WITH_TRACE_INFO = eINSTANCE.getElementWithTraceInfo();

		/**
		 * The meta object literal for the '<em><b>Trace Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_WITH_TRACE_INFO__TRACE_INFO = eINSTANCE.getElementWithTraceInfo_TraceInfo();

	}

} //InfrastructurePackage
