/**
 */
package hu.bme.mit.incqueryd.arch;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rete Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.arch.ReteRole#getNodeRecipe <em>Node Recipe</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getReteRole()
 * @model
 * @generated
 */
public interface ReteRole extends Role {
	/**
	 * Returns the value of the '<em><b>Node Recipe</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Recipe</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Recipe</em>' reference.
	 * @see #setNodeRecipe(ReteNodeRecipe)
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getReteRole_NodeRecipe()
	 * @model
	 * @generated
	 */
	ReteNodeRecipe getNodeRecipe();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.arch.ReteRole#getNodeRecipe <em>Node Recipe</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Recipe</em>' reference.
	 * @see #getNodeRecipe()
	 * @generated
	 */
	void setNodeRecipe(ReteNodeRecipe value);

} // ReteRole
