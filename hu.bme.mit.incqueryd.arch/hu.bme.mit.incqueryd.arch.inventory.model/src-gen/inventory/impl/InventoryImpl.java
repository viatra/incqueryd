/**
 */
package inventory.impl;

import inventory.Inventory;
import inventory.InventoryPackage;
import inventory.MachineInstance;
import inventory.MachineSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inventory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link inventory.impl.InventoryImpl#getConnectionString <em>Connection String</em>}</li>
 *   <li>{@link inventory.impl.InventoryImpl#getMachineSet <em>Machine Set</em>}</li>
 *   <li>{@link inventory.impl.InventoryImpl#getMaster <em>Master</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InventoryImpl extends MinimalEObjectImpl.Container implements Inventory {
	/**
	 * The default value of the '{@link #getConnectionString() <em>Connection String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionString()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionString() <em>Connection String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionString()
	 * @generated
	 * @ordered
	 */
	protected String connectionString = CONNECTION_STRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMachineSet() <em>Machine Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineSet()
	 * @generated
	 * @ordered
	 */
	protected MachineSet machineSet;

	/**
	 * The cached value of the '{@link #getMaster() <em>Master</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaster()
	 * @generated
	 * @ordered
	 */
	protected MachineInstance master;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InventoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InventoryPackage.Literals.INVENTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionString() {
		return connectionString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionString(String newConnectionString) {
		String oldConnectionString = connectionString;
		connectionString = newConnectionString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InventoryPackage.INVENTORY__CONNECTION_STRING, oldConnectionString, connectionString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineSet getMachineSet() {
		return machineSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMachineSet(MachineSet newMachineSet, NotificationChain msgs) {
		MachineSet oldMachineSet = machineSet;
		machineSet = newMachineSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InventoryPackage.INVENTORY__MACHINE_SET, oldMachineSet, newMachineSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachineSet(MachineSet newMachineSet) {
		if (newMachineSet != machineSet) {
			NotificationChain msgs = null;
			if (machineSet != null)
				msgs = ((InternalEObject)machineSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InventoryPackage.INVENTORY__MACHINE_SET, null, msgs);
			if (newMachineSet != null)
				msgs = ((InternalEObject)newMachineSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InventoryPackage.INVENTORY__MACHINE_SET, null, msgs);
			msgs = basicSetMachineSet(newMachineSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InventoryPackage.INVENTORY__MACHINE_SET, newMachineSet, newMachineSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineInstance getMaster() {
		if (master != null && master.eIsProxy()) {
			InternalEObject oldMaster = (InternalEObject)master;
			master = (MachineInstance)eResolveProxy(oldMaster);
			if (master != oldMaster) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InventoryPackage.INVENTORY__MASTER, oldMaster, master));
			}
		}
		return master;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineInstance basicGetMaster() {
		return master;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaster(MachineInstance newMaster) {
		MachineInstance oldMaster = master;
		master = newMaster;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InventoryPackage.INVENTORY__MASTER, oldMaster, master));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InventoryPackage.INVENTORY__MACHINE_SET:
				return basicSetMachineSet(null, msgs);
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
			case InventoryPackage.INVENTORY__CONNECTION_STRING:
				return getConnectionString();
			case InventoryPackage.INVENTORY__MACHINE_SET:
				return getMachineSet();
			case InventoryPackage.INVENTORY__MASTER:
				if (resolve) return getMaster();
				return basicGetMaster();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InventoryPackage.INVENTORY__CONNECTION_STRING:
				setConnectionString((String)newValue);
				return;
			case InventoryPackage.INVENTORY__MACHINE_SET:
				setMachineSet((MachineSet)newValue);
				return;
			case InventoryPackage.INVENTORY__MASTER:
				setMaster((MachineInstance)newValue);
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
			case InventoryPackage.INVENTORY__CONNECTION_STRING:
				setConnectionString(CONNECTION_STRING_EDEFAULT);
				return;
			case InventoryPackage.INVENTORY__MACHINE_SET:
				setMachineSet((MachineSet)null);
				return;
			case InventoryPackage.INVENTORY__MASTER:
				setMaster((MachineInstance)null);
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
			case InventoryPackage.INVENTORY__CONNECTION_STRING:
				return CONNECTION_STRING_EDEFAULT == null ? connectionString != null : !CONNECTION_STRING_EDEFAULT.equals(connectionString);
			case InventoryPackage.INVENTORY__MACHINE_SET:
				return machineSet != null;
			case InventoryPackage.INVENTORY__MASTER:
				return master != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (connectionString: ");
		result.append(connectionString);
		result.append(')');
		return result.toString();
	}

} //InventoryImpl
