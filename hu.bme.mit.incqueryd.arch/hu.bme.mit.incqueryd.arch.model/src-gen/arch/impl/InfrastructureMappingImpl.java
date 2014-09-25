/**
 */
package arch.impl;

import arch.ArchPackage;
import arch.InfrastructureMapping;
import arch.Role;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getTraceInfo <em>Trace Info</em>}</li>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getRoles <em>Roles</em>}</li>
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
	 * The cached value of the '{@link #getProcess() <em>Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcess()
	 * @generated
	 * @ordered
	 */
	protected infrastructure.Process process;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

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
	public infrastructure.Process getProcess() {
		if (process != null && process.eIsProxy()) {
			InternalEObject oldProcess = (InternalEObject)process;
			process = (infrastructure.Process)eResolveProxy(oldProcess);
			if (process != oldProcess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchPackage.INFRASTRUCTURE_MAPPING__PROCESS, oldProcess, process));
			}
		}
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public infrastructure.Process basicGetProcess() {
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcess(infrastructure.Process newProcess) {
		infrastructure.Process oldProcess = process;
		process = newProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.INFRASTRUCTURE_MAPPING__PROCESS, oldProcess, process));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList<Role>(Role.class, this, ArchPackage.INFRASTRUCTURE_MAPPING__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
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
			case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
				return getTraceInfo();
			case ArchPackage.INFRASTRUCTURE_MAPPING__PROCESS:
				if (resolve) return getProcess();
				return basicGetProcess();
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				return getRoles();
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
			case ArchPackage.INFRASTRUCTURE_MAPPING__PROCESS:
				setProcess((infrastructure.Process)newValue);
				return;
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
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
			case ArchPackage.INFRASTRUCTURE_MAPPING__PROCESS:
				setProcess((infrastructure.Process)null);
				return;
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				getRoles().clear();
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
			case ArchPackage.INFRASTRUCTURE_MAPPING__PROCESS:
				return process != null;
			case ArchPackage.INFRASTRUCTURE_MAPPING__ROLES:
				return roles != null && !roles.isEmpty();
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
