/**
 */
package hu.bme.mit.incqueryd.arch;

import hu.bme.mit.incqueryd.infrastructure.ElementWithTraceInfo;
import hu.bme.mit.incqueryd.infrastructure.Machine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.arch.Configuration#getConnectionString <em>Connection String</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.Configuration#getMachines <em>Machines</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.Configuration#getRecipes <em>Recipes</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.Configuration#getMappings <em>Mappings</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.Configuration#getCoordinatorMachine <em>Coordinator Machine</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.Configuration#getMonitoringMachine <em>Monitoring Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends ElementWithTraceInfo {
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
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getConfiguration_ConnectionString()
	 * @model unique="false"
	 * @generated
	 */
	String getConnectionString();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.arch.Configuration#getConnectionString <em>Connection String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection String</em>' attribute.
	 * @see #getConnectionString()
	 * @generated
	 */
	void setConnectionString(String value);

	/**
	 * Returns the value of the '<em><b>Machines</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incqueryd.infrastructure.Machine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machines</em>' containment reference list.
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getConfiguration_Machines()
	 * @model containment="true"
	 * @generated
	 */
	EList<Machine> getMachines();

	/**
	 * Returns the value of the '<em><b>Recipes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.incquery.runtime.rete.recipes.ReteRecipe}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recipes</em>' reference list.
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getConfiguration_Recipes()
	 * @model
	 * @generated
	 */
	EList<ReteRecipe> getRecipes();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incqueryd.arch.InfrastructureMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getConfiguration_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<InfrastructureMapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Coordinator Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinator Machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinator Machine</em>' reference.
	 * @see #setCoordinatorMachine(Machine)
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getConfiguration_CoordinatorMachine()
	 * @model
	 * @generated
	 */
	Machine getCoordinatorMachine();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.arch.Configuration#getCoordinatorMachine <em>Coordinator Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordinator Machine</em>' reference.
	 * @see #getCoordinatorMachine()
	 * @generated
	 */
	void setCoordinatorMachine(Machine value);

	/**
	 * Returns the value of the '<em><b>Monitoring Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitoring Machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoring Machine</em>' reference.
	 * @see #setMonitoringMachine(Machine)
	 * @see hu.bme.mit.incqueryd.arch.ArchPackage#getConfiguration_MonitoringMachine()
	 * @model
	 * @generated
	 */
	Machine getMonitoringMachine();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.arch.Configuration#getMonitoringMachine <em>Monitoring Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitoring Machine</em>' reference.
	 * @see #getMonitoringMachine()
	 * @generated
	 */
	void setMonitoringMachine(Machine value);

} // Configuration
