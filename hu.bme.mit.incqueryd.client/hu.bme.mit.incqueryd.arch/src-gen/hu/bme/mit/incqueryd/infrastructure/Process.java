/**
 */
package hu.bme.mit.incqueryd.infrastructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.Process#getPort <em>Port</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.Process#getMemory <em>Memory</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.Process#getMachine <em>Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends ElementWithTraceInfo {
	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(int)
	 * @see hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage#getProcess_Port()
	 * @model unique="false"
	 * @generated
	 */
	int getPort();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.infrastructure.Process#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(int value);

	/**
	 * Returns the value of the '<em><b>Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory</em>' attribute.
	 * @see #setMemory(int)
	 * @see hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage#getProcess_Memory()
	 * @model unique="false"
	 * @generated
	 */
	int getMemory();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.infrastructure.Process#getMemory <em>Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory</em>' attribute.
	 * @see #getMemory()
	 * @generated
	 */
	void setMemory(int value);

	/**
	 * Returns the value of the '<em><b>Machine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incqueryd.infrastructure.Machine#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' container reference.
	 * @see #setMachine(Machine)
	 * @see hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage#getProcess_Machine()
	 * @see hu.bme.mit.incqueryd.infrastructure.Machine#getProcesses
	 * @model opposite="processes" transient="false"
	 * @generated
	 */
	Machine getMachine();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.infrastructure.Process#getMachine <em>Machine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine</em>' container reference.
	 * @see #getMachine()
	 * @generated
	 */
	void setMachine(Machine value);

} // Process
