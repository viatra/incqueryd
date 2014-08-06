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
 *   <li>{@link arch.InfrastructureMapping#getProcess <em>Process</em>}</li>
 *   <li>{@link arch.InfrastructureMapping#getRoles <em>Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see arch.ArchPackage#getInfrastructureMapping()
 * @model
 * @generated
 */
public interface InfrastructureMapping extends ElementWithTraceInfo {
	/**
	 * Returns the value of the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' reference.
	 * @see #setProcess(infrastructure.Process)
	 * @see arch.ArchPackage#getInfrastructureMapping_Process()
	 * @model
	 * @generated
	 */
	infrastructure.Process getProcess();

	/**
	 * Sets the value of the '{@link arch.InfrastructureMapping#getProcess <em>Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(infrastructure.Process value);

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link arch.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see arch.ArchPackage#getInfrastructureMapping_Roles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Role> getRoles();

} // InfrastructureMapping
