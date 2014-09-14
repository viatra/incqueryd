/**
 */
package inventory;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link inventory.TemplateSet#getMachineTemplates <em>Machine Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @see inventory.InventoryPackage#getTemplateSet()
 * @model
 * @generated
 */
public interface TemplateSet extends MachineSet {
	/**
	 * Returns the value of the '<em><b>Machine Templates</b></em>' containment reference list.
	 * The list contents are of type {@link inventory.MachineTemplate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Templates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Templates</em>' containment reference list.
	 * @see inventory.InventoryPackage#getTemplateSet_MachineTemplates()
	 * @model containment="true"
	 * @generated
	 */
	EList<MachineTemplate> getMachineTemplates();

} // TemplateSet
