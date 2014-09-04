/**
 */
package resources;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link resources.Machine#getIp <em>Ip</em>}</li>
 *   <li>{@link resources.Machine#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link resources.Machine#getMemoryUnit <em>Memory Unit</em>}</li>
 *   <li>{@link resources.Machine#getCPUs <em>CP Us</em>}</li>
 * </ul>
 * </p>
 *
 * @see resources.ResourcesPackage#getMachine()
 * @model
 * @generated
 */
public interface Machine extends EObject {
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
	 * @see resources.ResourcesPackage#getMachine_Ip()
	 * @model unique="false"
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link resources.Machine#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

	/**
	 * Returns the value of the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Size</em>' attribute.
	 * @see #setMemorySize(int)
	 * @see resources.ResourcesPackage#getMachine_MemorySize()
	 * @model unique="false"
	 * @generated
	 */
	int getMemorySize();

	/**
	 * Sets the value of the '{@link resources.Machine#getMemorySize <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Size</em>' attribute.
	 * @see #getMemorySize()
	 * @generated
	 */
	void setMemorySize(int value);

	/**
	 * Returns the value of the '<em><b>Memory Unit</b></em>' attribute.
	 * The literals are from the enumeration {@link resources.MemoryUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Unit</em>' attribute.
	 * @see resources.MemoryUnit
	 * @see #setMemoryUnit(MemoryUnit)
	 * @see resources.ResourcesPackage#getMachine_MemoryUnit()
	 * @model unique="false"
	 * @generated
	 */
	MemoryUnit getMemoryUnit();

	/**
	 * Sets the value of the '{@link resources.Machine#getMemoryUnit <em>Memory Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Unit</em>' attribute.
	 * @see resources.MemoryUnit
	 * @see #getMemoryUnit()
	 * @generated
	 */
	void setMemoryUnit(MemoryUnit value);

	/**
	 * Returns the value of the '<em><b>CP Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CP Us</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CP Us</em>' attribute.
	 * @see #setCPUs(int)
	 * @see resources.ResourcesPackage#getMachine_CPUs()
	 * @model unique="false"
	 * @generated
	 */
	int getCPUs();

	/**
	 * Sets the value of the '{@link resources.Machine#getCPUs <em>CP Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CP Us</em>' attribute.
	 * @see #getCPUs()
	 * @generated
	 */
	void setCPUs(int value);

} // Machine
