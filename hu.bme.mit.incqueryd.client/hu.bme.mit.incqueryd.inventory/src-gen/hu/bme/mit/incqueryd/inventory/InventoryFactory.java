/**
 */
package hu.bme.mit.incqueryd.inventory;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incqueryd.inventory.InventoryPackage
 * @generated
 */
public interface InventoryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InventoryFactory eINSTANCE = hu.bme.mit.incqueryd.inventory.impl.InventoryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Inventory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inventory</em>'.
	 * @generated
	 */
	Inventory createInventory();

	/**
	 * Returns a new object of class '<em>Instance Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Set</em>'.
	 * @generated
	 */
	InstanceSet createInstanceSet();

	/**
	 * Returns a new object of class '<em>Template Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Set</em>'.
	 * @generated
	 */
	TemplateSet createTemplateSet();

	/**
	 * Returns a new object of class '<em>Machine Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Machine Instance</em>'.
	 * @generated
	 */
	MachineInstance createMachineInstance();

	/**
	 * Returns a new object of class '<em>Machine Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Machine Template</em>'.
	 * @generated
	 */
	MachineTemplate createMachineTemplate();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InventoryPackage getInventoryPackage();

} //InventoryFactory
