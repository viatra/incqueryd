/**
 */
package inventory;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link inventory.MachineInstance#getIp <em>Ip</em>}</li>
 * </ul>
 * </p>
 *
 * @see inventory.InventoryPackage#getMachineInstance()
 * @model
 * @generated
 */
public interface MachineInstance extends Machine {
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
	 * @see inventory.InventoryPackage#getMachineInstance_Ip()
	 * @model unique="false"
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link inventory.MachineInstance#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

} // MachineInstance
