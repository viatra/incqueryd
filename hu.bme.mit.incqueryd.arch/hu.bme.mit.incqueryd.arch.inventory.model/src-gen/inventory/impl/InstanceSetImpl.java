/**
 */
package inventory.impl;

import inventory.InstanceSet;
import inventory.InventoryPackage;
import inventory.MachineInstance;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link inventory.impl.InstanceSetImpl#getMachineInstances <em>Machine Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceSetImpl extends MachineSetImpl implements InstanceSet {
	/**
	 * The cached value of the '{@link #getMachineInstances() <em>Machine Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<MachineInstance> machineInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InventoryPackage.Literals.INSTANCE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MachineInstance> getMachineInstances() {
		if (machineInstances == null) {
			machineInstances = new EObjectContainmentEList<MachineInstance>(MachineInstance.class, this, InventoryPackage.INSTANCE_SET__MACHINE_INSTANCES);
		}
		return machineInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InventoryPackage.INSTANCE_SET__MACHINE_INSTANCES:
				return ((InternalEList<?>)getMachineInstances()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InventoryPackage.INSTANCE_SET__MACHINE_INSTANCES:
				return getMachineInstances();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InventoryPackage.INSTANCE_SET__MACHINE_INSTANCES:
				getMachineInstances().clear();
				getMachineInstances().addAll((Collection<? extends MachineInstance>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InventoryPackage.INSTANCE_SET__MACHINE_INSTANCES:
				getMachineInstances().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InventoryPackage.INSTANCE_SET__MACHINE_INSTANCES:
				return machineInstances != null && !machineInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InstanceSetImpl
