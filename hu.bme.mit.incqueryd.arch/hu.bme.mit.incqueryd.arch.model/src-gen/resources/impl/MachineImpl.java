/**
 */
package resources.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import resources.Machine;
import resources.MemoryUnit;
import resources.ResourcesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link resources.impl.MachineImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link resources.impl.MachineImpl#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link resources.impl.MachineImpl#getMemoryUnit <em>Memory Unit</em>}</li>
 *   <li>{@link resources.impl.MachineImpl#getCPUs <em>CP Us</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MachineImpl extends MinimalEObjectImpl.Container implements Machine {
	/**
	 * The default value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected String ip = IP_EDEFAULT;

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
		return ResourcesPackage.Literals.MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIp(String newIp) {
		String oldIp = ip;
		ip = newIp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.MACHINE__IP, oldIp, ip));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.MACHINE__MEMORY_SIZE, oldMemorySize, memorySize));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.MACHINE__MEMORY_UNIT, oldMemoryUnit, memoryUnit));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.MACHINE__CP_US, oldCPUs, cpUs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourcesPackage.MACHINE__IP:
				return getIp();
			case ResourcesPackage.MACHINE__MEMORY_SIZE:
				return getMemorySize();
			case ResourcesPackage.MACHINE__MEMORY_UNIT:
				return getMemoryUnit();
			case ResourcesPackage.MACHINE__CP_US:
				return getCPUs();
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
			case ResourcesPackage.MACHINE__IP:
				setIp((String)newValue);
				return;
			case ResourcesPackage.MACHINE__MEMORY_SIZE:
				setMemorySize((Integer)newValue);
				return;
			case ResourcesPackage.MACHINE__MEMORY_UNIT:
				setMemoryUnit((MemoryUnit)newValue);
				return;
			case ResourcesPackage.MACHINE__CP_US:
				setCPUs((Integer)newValue);
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
			case ResourcesPackage.MACHINE__IP:
				setIp(IP_EDEFAULT);
				return;
			case ResourcesPackage.MACHINE__MEMORY_SIZE:
				setMemorySize(MEMORY_SIZE_EDEFAULT);
				return;
			case ResourcesPackage.MACHINE__MEMORY_UNIT:
				setMemoryUnit(MEMORY_UNIT_EDEFAULT);
				return;
			case ResourcesPackage.MACHINE__CP_US:
				setCPUs(CP_US_EDEFAULT);
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
			case ResourcesPackage.MACHINE__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ResourcesPackage.MACHINE__MEMORY_SIZE:
				return memorySize != MEMORY_SIZE_EDEFAULT;
			case ResourcesPackage.MACHINE__MEMORY_UNIT:
				return memoryUnit != MEMORY_UNIT_EDEFAULT;
			case ResourcesPackage.MACHINE__CP_US:
				return cpUs != CP_US_EDEFAULT;
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
		result.append(" (ip: ");
		result.append(ip);
		result.append(", memorySize: ");
		result.append(memorySize);
		result.append(", memoryUnit: ");
		result.append(memoryUnit);
		result.append(", CPUs: ");
		result.append(cpUs);
		result.append(')');
		return result.toString();
	}

} //MachineImpl
