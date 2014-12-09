/**
 */
package hu.bme.mit.incqueryd.infrastructure.impl;

import hu.bme.mit.incqueryd.infrastructure.InfrastructurePackage;
import hu.bme.mit.incqueryd.infrastructure.Machine;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.impl.MachineImpl#getTraceInfo <em>Trace Info</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.impl.MachineImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.impl.MachineImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.infrastructure.impl.MachineImpl#getProcesses <em>Processes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MachineImpl extends MinimalEObjectImpl.Container implements Machine {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<hu.bme.mit.incqueryd.infrastructure.Process> processes;

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
		return InfrastructurePackage.Literals.MACHINE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__TRACE_INFO, oldTraceInfo, traceInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__IP, oldIp, ip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<hu.bme.mit.incqueryd.infrastructure.Process> getProcesses() {
		if (processes == null) {
			processes = new EObjectContainmentWithInverseEList<hu.bme.mit.incqueryd.infrastructure.Process>(hu.bme.mit.incqueryd.infrastructure.Process.class, this, InfrastructurePackage.MACHINE__PROCESSES, InfrastructurePackage.PROCESS__MACHINE);
		}
		return processes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.MACHINE__PROCESSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProcesses()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.MACHINE__PROCESSES:
				return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
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
			case InfrastructurePackage.MACHINE__TRACE_INFO:
				return getTraceInfo();
			case InfrastructurePackage.MACHINE__NAME:
				return getName();
			case InfrastructurePackage.MACHINE__IP:
				return getIp();
			case InfrastructurePackage.MACHINE__PROCESSES:
				return getProcesses();
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
			case InfrastructurePackage.MACHINE__TRACE_INFO:
				setTraceInfo((String)newValue);
				return;
			case InfrastructurePackage.MACHINE__NAME:
				setName((String)newValue);
				return;
			case InfrastructurePackage.MACHINE__IP:
				setIp((String)newValue);
				return;
			case InfrastructurePackage.MACHINE__PROCESSES:
				getProcesses().clear();
				getProcesses().addAll((Collection<? extends hu.bme.mit.incqueryd.infrastructure.Process>)newValue);
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
			case InfrastructurePackage.MACHINE__TRACE_INFO:
				setTraceInfo(TRACE_INFO_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__IP:
				setIp(IP_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__PROCESSES:
				getProcesses().clear();
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
			case InfrastructurePackage.MACHINE__TRACE_INFO:
				return TRACE_INFO_EDEFAULT == null ? traceInfo != null : !TRACE_INFO_EDEFAULT.equals(traceInfo);
			case InfrastructurePackage.MACHINE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case InfrastructurePackage.MACHINE__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case InfrastructurePackage.MACHINE__PROCESSES:
				return processes != null && !processes.isEmpty();
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
		result.append(", name: ");
		result.append(name);
		result.append(", ip: ");
		result.append(ip);
		result.append(')');
		return result.toString();
	}

} //MachineImpl
