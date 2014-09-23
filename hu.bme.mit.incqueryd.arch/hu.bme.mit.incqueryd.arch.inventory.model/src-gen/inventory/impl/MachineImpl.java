/**
 */
package inventory.impl;

import inventory.InventoryPackage;
import inventory.Machine;
import inventory.MemoryUnit;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link inventory.impl.MachineImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link inventory.impl.MachineImpl#getCost <em>Cost</em>}</li>
 *   <li>{@link inventory.impl.MachineImpl#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link inventory.impl.MachineImpl#getMemoryUnit <em>Memory Unit</em>}</li>
 *   <li>{@link inventory.impl.MachineImpl#getCPUs <em>CP Us</em>}</li>
 *   <li>{@link inventory.impl.MachineImpl#getOverheads <em>Overheads</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MachineImpl extends MinimalEObjectImpl.Container implements Machine {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final long IDENTIFIER_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected long identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected static final int COST_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected int cost = COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected static final int MEMORY_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected int memorySize = MEMORY_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemoryUnit() <em>Memory Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryUnit()
	 * @generated
	 * @ordered
	 */
	protected static final MemoryUnit MEMORY_UNIT_EDEFAULT = MemoryUnit.MB;

	/**
	 * The cached value of the '{@link #getMemoryUnit() <em>Memory Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryUnit()
	 * @generated
	 * @ordered
	 */
	protected MemoryUnit memoryUnit = MEMORY_UNIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCPUs() <em>CP Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCPUs()
	 * @generated
	 * @ordered
	 */
	protected static final int CP_US_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCPUs() <em>CP Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCPUs()
	 * @generated
	 * @ordered
	 */
	protected int cpUs = CP_US_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverheads() <em>Overheads</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverheads()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> overheads;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InventoryPackage.Literals.MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(long newIdentifier) {
		long oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InventoryPackage.MACHINE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCost(int newCost) {
		int oldCost = cost;
		cost = newCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InventoryPackage.MACHINE__COST, oldCost, cost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMemorySize() {
		return memorySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemorySize(int newMemorySize) {
		int oldMemorySize = memorySize;
		memorySize = newMemorySize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InventoryPackage.MACHINE__MEMORY_SIZE, oldMemorySize, memorySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryUnit getMemoryUnit() {
		return memoryUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemoryUnit(MemoryUnit newMemoryUnit) {
		MemoryUnit oldMemoryUnit = memoryUnit;
		memoryUnit = newMemoryUnit == null ? MEMORY_UNIT_EDEFAULT : newMemoryUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InventoryPackage.MACHINE__MEMORY_UNIT, oldMemoryUnit, memoryUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCPUs() {
		return cpUs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCPUs(int newCPUs) {
		int oldCPUs = cpUs;
		cpUs = newCPUs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InventoryPackage.MACHINE__CP_US, oldCPUs, cpUs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getOverheads() {
		if (overheads == null) {
			overheads = new EDataTypeEList<Integer>(Integer.class, this, InventoryPackage.MACHINE__OVERHEADS);
		}
		return overheads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InventoryPackage.MACHINE__IDENTIFIER:
				return getIdentifier();
			case InventoryPackage.MACHINE__COST:
				return getCost();
			case InventoryPackage.MACHINE__MEMORY_SIZE:
				return getMemorySize();
			case InventoryPackage.MACHINE__MEMORY_UNIT:
				return getMemoryUnit();
			case InventoryPackage.MACHINE__CP_US:
				return getCPUs();
			case InventoryPackage.MACHINE__OVERHEADS:
				return getOverheads();
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
			case InventoryPackage.MACHINE__IDENTIFIER:
				setIdentifier((Long)newValue);
				return;
			case InventoryPackage.MACHINE__COST:
				setCost((Integer)newValue);
				return;
			case InventoryPackage.MACHINE__MEMORY_SIZE:
				setMemorySize((Integer)newValue);
				return;
			case InventoryPackage.MACHINE__MEMORY_UNIT:
				setMemoryUnit((MemoryUnit)newValue);
				return;
			case InventoryPackage.MACHINE__CP_US:
				setCPUs((Integer)newValue);
				return;
			case InventoryPackage.MACHINE__OVERHEADS:
				getOverheads().clear();
				getOverheads().addAll((Collection<? extends Integer>)newValue);
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
			case InventoryPackage.MACHINE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case InventoryPackage.MACHINE__COST:
				setCost(COST_EDEFAULT);
				return;
			case InventoryPackage.MACHINE__MEMORY_SIZE:
				setMemorySize(MEMORY_SIZE_EDEFAULT);
				return;
			case InventoryPackage.MACHINE__MEMORY_UNIT:
				setMemoryUnit(MEMORY_UNIT_EDEFAULT);
				return;
			case InventoryPackage.MACHINE__CP_US:
				setCPUs(CP_US_EDEFAULT);
				return;
			case InventoryPackage.MACHINE__OVERHEADS:
				getOverheads().clear();
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
			case InventoryPackage.MACHINE__IDENTIFIER:
				return identifier != IDENTIFIER_EDEFAULT;
			case InventoryPackage.MACHINE__COST:
				return cost != COST_EDEFAULT;
			case InventoryPackage.MACHINE__MEMORY_SIZE:
				return memorySize != MEMORY_SIZE_EDEFAULT;
			case InventoryPackage.MACHINE__MEMORY_UNIT:
				return memoryUnit != MEMORY_UNIT_EDEFAULT;
			case InventoryPackage.MACHINE__CP_US:
				return cpUs != CP_US_EDEFAULT;
			case InventoryPackage.MACHINE__OVERHEADS:
				return overheads != null && !overheads.isEmpty();
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
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(", cost: ");
		result.append(cost);
		result.append(", memorySize: ");
		result.append(memorySize);
		result.append(", memoryUnit: ");
		result.append(memoryUnit);
		result.append(", CPUs: ");
		result.append(cpUs);
		result.append(", overheads: ");
		result.append(overheads);
		result.append(')');
		return result.toString();
	}

} //MachineImpl
