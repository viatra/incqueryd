/**
 */
package hu.bme.mit.incqueryd.inventory;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inventory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.inventory.Inventory#getConnectionString <em>Connection String</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.inventory.Inventory#getMachineSet <em>Machine Set</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.inventory.Inventory#getMaster <em>Master</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.inventory.InventoryPackage#getInventory()
 * @model
 * @generated
 */
public interface Inventory extends EObject {
	/**
	 * Returns the value of the '<em><b>Connection String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection String</em>' attribute.
	 * @see #setConnectionString(String)
	 * @see hu.bme.mit.incqueryd.inventory.InventoryPackage#getInventory_ConnectionString()
	 * @model unique="false"
	 * @generated
	 */
	String getConnectionString();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.inventory.Inventory#getConnectionString <em>Connection String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection String</em>' attribute.
	 * @see #getConnectionString()
	 * @generated
	 */
	void setConnectionString(String value);

	/**
	 * Returns the value of the '<em><b>Machine Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Set</em>' containment reference.
	 * @see #setMachineSet(MachineSet)
	 * @see hu.bme.mit.incqueryd.inventory.InventoryPackage#getInventory_MachineSet()
	 * @model containment="true"
	 * @generated
	 */
	MachineSet getMachineSet();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.inventory.Inventory#getMachineSet <em>Machine Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Set</em>' containment reference.
	 * @see #getMachineSet()
	 * @generated
	 */
	void setMachineSet(MachineSet value);

	/**
	 * Returns the value of the '<em><b>Master</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Master</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Master</em>' reference.
	 * @see #setMaster(MachineInstance)
	 * @see hu.bme.mit.incqueryd.inventory.InventoryPackage#getInventory_Master()
	 * @model
	 * @generated
	 */
	MachineInstance getMaster();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.inventory.Inventory#getMaster <em>Master</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Master</em>' reference.
	 * @see #getMaster()
	 * @generated
	 */
	void setMaster(MachineInstance value);

} // Inventory
