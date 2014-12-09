/**
 */
package hu.bme.mit.incqueryd.arch;

import hu.bme.mit.incqueryd.infrastructure.ElementWithTraceInfo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.arch.InfrastructureMapping#getProcess <em>Process</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.InfrastructureMapping#getRoles <em>Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getInfrastructureMapping()
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
	 * @see #setProcess(hu.bme.mit.incqueryd.infrastructure.Process)
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getInfrastructureMapping_Process()
	 * @model
	 * @generated
	 */
	hu.bme.mit.incqueryd.infrastructure.Process getProcess();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.arch.InfrastructureMapping#getProcess <em>Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(hu.bme.mit.incqueryd.infrastructure.Process value);

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incqueryd.arch.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getInfrastructureMapping_Roles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Role> getRoles();

} // InfrastructureMapping
