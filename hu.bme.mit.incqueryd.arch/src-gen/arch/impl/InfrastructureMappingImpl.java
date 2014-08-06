/**
 */
package arch.impl;

import arch.ArchPackage;
import arch.InfrastructureMapping;
import arch.Role;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getTraceInfo <em>Trace Info</em>}</li>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getMachines <em>Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureMappingImpl extends MinimalEObjectImpl.Container implements InfrastructureMapping {
	/**
	 * The default value of the '{@link #getTraceInfo() <em>Trace Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceInfo()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_INFO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceInfo() <em>Trace Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceInfo()
	 * @generated
	 * @ordered
	 */
	protected String traceInfo = TRACE_INFO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getMachines() <em>Machines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachines()
	 * @generated
	 * @ordered
	 */
	protected infrastructure.Process machines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchPackage.Literals.INFRASTRUCTURE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceInfo() {
		return traceInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceInfo(String newTraceInfo) {
		String oldTraceInfo = traceInfo;
		traceInfo = newTraceInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO, oldTraceInfo, traceInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectResolvingEList<Role>(Role.class, this, ArchPackage.INFRASTRUCTURE_MAPPING__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public infrastructure.Process getMachines() {
		if (machines != null && machines.eIsProxy()) {
			InternalEObject oldMachines = (InternalEObject)machines;
			machines = (infrastructure.Process)eResolveProxy(oldMachines);
			if (machines != oldMachines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchPackage.INFRASTRUCTURE_MAPPING__MACHINES, oldMachines, machines));
			}
		}
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public infrastructure.Process basicGetMachines() {
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachines(infrastructure.Process newMachines) {
		infrastructure.Process oldMachines = machines;
		machines = newMachines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.INFRASTRUCTURE_MAPPING__MACHINES, oldMachines, machines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
				return getTraceInfo();
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				return getRoles();
			case ArchPackage.INFRASTRUCTURE_MAPPING__MACHINES:
				if (resolve) return getMachines();
				return basicGetMachines();
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
			case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
				setTraceInfo((String)newValue);
				return;
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case ArchPackage.INFRASTRUCTURE_MAPPING__MACHINES:
				setMachines((infrastructure.Process)newValue);
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
			case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
				setTraceInfo(TRACE_INFO_EDEFAULT);
				return;
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				getRoles().clear();
				return;
			case ArchPackage.INFRASTRUCTURE_MAPPING__MACHINES:
				setMachines((infrastructure.Process)null);
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
			case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
				return TRACE_INFO_EDEFAULT == null ? traceInfo != null : !TRACE_INFO_EDEFAULT.equals(traceInfo);
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				return roles != null && !roles.isEmpty();
			case ArchPackage.INFRASTRUCTURE_MAPPING__MACHINES:
				return machines != null;
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
		result.append(" (traceInfo: ");
		result.append(traceInfo);
		result.append(')');
		return result.toString();
	}

} //InfrastructureMappingImpl
