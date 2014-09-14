/**
 */
package inventory;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link inventory.InstanceSet#getMachineInstances <em>Machine Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see inventory.InventoryPackage#getInstanceSet()
 * @model
 * @generated
 */
public interface InstanceSet extends MachineSet {
	/**
	 * Returns the value of the '<em><b>Machine Instances</b></em>' containment reference list.
	 * The list contents are of type {@link inventory.MachineInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Instances</em>' containment reference list.
	 * @see inventory.InventoryPackage#getInstanceSet_MachineInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<MachineInstance> getMachineInstances();

} // InstanceSet
