/**
 */
package hu.bme.mit.incqueryd.infrastructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.Machine#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.Machine#getIp <em>Ip</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.Machine#getProcesses <em>Processes</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage#getMachine()
 * @model
 * @generated
 */
public interface Machine extends ElementWithTraceInfo {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage#getMachine_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.infrastructure.Machine#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(String)
	 * @see hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage#getMachine_Ip()
	 * @model unique="false"
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.infrastructure.Machine#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incqueryd.infrastructure.Process}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.incqueryd.infrastructure.Process#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage#getMachine_Processes()
	 * @see hu.bme.mit.incqueryd.infrastructure.Process#getMachine
	 * @model opposite="machine" containment="true"
	 * @generated
	 */
	EList<hu.bme.mit.incqueryd.infrastructure.Process> getProcesses();

} // Machine
