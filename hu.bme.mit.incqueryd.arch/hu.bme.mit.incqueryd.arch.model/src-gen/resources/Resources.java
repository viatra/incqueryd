/**
 */
package resources;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resources</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link resources.Resources#getMachines <em>Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @see resources.ResourcesPackage#getResources()
 * @model
 * @generated
 */
public interface Resources extends EObject {
	/**
	 * Returns the value of the '<em><b>Machines</b></em>' containment reference list.
	 * The list contents are of type {@link resources.Machine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machines</em>' containment reference list.
	 * @see resources.ResourcesPackage#getResources_Machines()
	 * @model containment="true"
	 * @generated
	 */
	EList<Machine> getMachines();

} // Resources
