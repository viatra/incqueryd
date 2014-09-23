/**
 */
package inventory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link inventory.Machine#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link inventory.Machine#getCost <em>Cost</em>}</li>
 *   <li>{@link inventory.Machine#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link inventory.Machine#getMemoryUnit <em>Memory Unit</em>}</li>
 *   <li>{@link inventory.Machine#getCPUs <em>CP Us</em>}</li>
 *   <li>{@link inventory.Machine#getOverheads <em>Overheads</em>}</li>
 * </ul>
 * </p>
 *
 * @see inventory.InventoryPackage#getMachine()
 * @model abstract="true"
 * @generated
 */
public interface Machine extends EObject {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(long)
	 * @see inventory.InventoryPackage#getMachine_Identifier()
	 * @model unique="false"
	 * @generated
	 */
	long getIdentifier();

	/**
	 * Sets the value of the '{@link inventory.Machine#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(long value);

	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #setCost(int)
	 * @see inventory.InventoryPackage#getMachine_Cost()
	 * @model unique="false"
	 * @generated
	 */
	int getCost();

	/**
	 * Sets the value of the '{@link inventory.Machine#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(int value);

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
	 * @see inventory.InventoryPackage#getMachine_MemorySize()
	 * @model unique="false"
	 * @generated
	 */
	int getMemorySize();

	/**
	 * Sets the value of the '{@link inventory.Machine#getMemorySize <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Size</em>' attribute.
	 * @see #getMemorySize()
	 * @generated
	 */
	void setMemorySize(int value);

	/**
	 * Returns the value of the '<em><b>Memory Unit</b></em>' attribute.
	 * The literals are from the enumeration {@link inventory.MemoryUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Unit</em>' attribute.
	 * @see inventory.MemoryUnit
	 * @see #setMemoryUnit(MemoryUnit)
	 * @see inventory.InventoryPackage#getMachine_MemoryUnit()
	 * @model unique="false"
	 * @generated
	 */
	MemoryUnit getMemoryUnit();

	/**
	 * Sets the value of the '{@link inventory.Machine#getMemoryUnit <em>Memory Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Unit</em>' attribute.
	 * @see inventory.MemoryUnit
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
	 * @see inventory.InventoryPackage#getMachine_CPUs()
	 * @model unique="false"
	 * @generated
	 */
	int getCPUs();

	/**
	 * Sets the value of the '{@link inventory.Machine#getCPUs <em>CP Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CP Us</em>' attribute.
	 * @see #getCPUs()
	 * @generated
	 */
	void setCPUs(int value);

	/**
	 * Returns the value of the '<em><b>Overheads</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overheads</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overheads</em>' attribute list.
	 * @see inventory.InventoryPackage#getMachine_Overheads()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getOverheads();

} // Machine
