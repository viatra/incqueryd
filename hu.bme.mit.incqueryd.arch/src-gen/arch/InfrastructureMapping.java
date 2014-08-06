/**
 */
package arch;

import infrastructure.ElementWithTraceInfo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arch.InfrastructureMapping#getRoles <em>Roles</em>}</li>
 *   <li>{@link arch.InfrastructureMapping#getMachines <em>Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @see arch.ArchPackage#getInfrastructureMapping()
 * @model
 * @generated
 */
public interface InfrastructureMapping extends ElementWithTraceInfo {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link arch.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see arch.ArchPackage#getInfrastructureMapping_Roles()
	 * @model
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Machines</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machines</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machines</em>' reference.
	 * @see #setMachines(infrastructure.Process)
	 * @see arch.ArchPackage#getInfrastructureMapping_Machines()
	 * @model
	 * @generated
	 */
	infrastructure.Process getMachines();

	/**
	 * Sets the value of the '{@link arch.InfrastructureMapping#getMachines <em>Machines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machines</em>' reference.
	 * @see #getMachines()
	 * @generated
	 */
	void setMachines(infrastructure.Process value);

} // InfrastructureMapping
