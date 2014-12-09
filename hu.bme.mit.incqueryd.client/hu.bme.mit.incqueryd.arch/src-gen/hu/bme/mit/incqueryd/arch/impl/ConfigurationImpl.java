/**
 */
package hu.bme.mit.incqueryd.arch.impl;

import hu.bme.mit.incqueryd.arch.ArchPackage;
import hu.bme.mit.incqueryd.arch.Configuration;
import hu.bme.mit.incqueryd.arch.InfrastructureMapping;

import hu.bme.mit.incqueryd.infrastructure.Machine;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl#getTraceInfo <em>Trace Info</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl#getConnectionString <em>Connection String</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl#getMachines <em>Machines</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl#getRecipes <em>Recipes</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl#getCoordinatorMachine <em>Coordinator Machine</em>}</li>
 *   <li>{@link hu.bme.mit.incqueryd.arch.impl.ConfigurationImpl#getMonitoringMachine <em>Monitoring Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration {
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
	 * The cached value of the '{@link #getMachines() <em>Machines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachines()
	 * @generated
	 * @ordered
	 */
	protected EList<Machine> machines;

	/**
	 * The cached value of the '{@link #getRecipes() <em>Recipes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecipes()
	 * @generated
	 * @ordered
	 */
	protected EList<ReteRecipe> recipes;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<InfrastructureMapping> mappings;

	/**
	 * The cached value of the '{@link #getCoordinatorMachine() <em>Coordinator Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinatorMachine()
	 * @generated
	 * @ordered
	 */
	protected Machine coordinatorMachine;

	/**
	 * The cached value of the '{@link #getMonitoringMachine() <em>Monitoring Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitoringMachine()
	 * @generated
	 * @ordered
	 */
	protected Machine monitoringMachine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchPackage.Literals.CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.CONFIGURATION__TRACE_INFO, oldTraceInfo, traceInfo));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.CONFIGURATION__CONNECTION_STRING, oldConnectionString, connectionString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Machine> getMachines() {
		if (machines == null) {
			machines = new EObjectContainmentEList<Machine>(Machine.class, this, ArchPackage.CONFIGURATION__MACHINES);
		}
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReteRecipe> getRecipes() {
		if (recipes == null) {
			recipes = new EObjectResolvingEList<ReteRecipe>(ReteRecipe.class, this, ArchPackage.CONFIGURATION__RECIPES);
		}
		return recipes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InfrastructureMapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectContainmentEList<InfrastructureMapping>(InfrastructureMapping.class, this, ArchPackage.CONFIGURATION__MAPPINGS);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine getCoordinatorMachine() {
		if (coordinatorMachine != null && coordinatorMachine.eIsProxy()) {
			InternalEObject oldCoordinatorMachine = (InternalEObject)coordinatorMachine;
			coordinatorMachine = (Machine)eResolveProxy(oldCoordinatorMachine);
			if (coordinatorMachine != oldCoordinatorMachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchPackage.CONFIGURATION__COORDINATOR_MACHINE, oldCoordinatorMachine, coordinatorMachine));
			}
		}
		return coordinatorMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine basicGetCoordinatorMachine() {
		return coordinatorMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoordinatorMachine(Machine newCoordinatorMachine) {
		Machine oldCoordinatorMachine = coordinatorMachine;
		coordinatorMachine = newCoordinatorMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.CONFIGURATION__COORDINATOR_MACHINE, oldCoordinatorMachine, coordinatorMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine getMonitoringMachine() {
		if (monitoringMachine != null && monitoringMachine.eIsProxy()) {
			InternalEObject oldMonitoringMachine = (InternalEObject)monitoringMachine;
			monitoringMachine = (Machine)eResolveProxy(oldMonitoringMachine);
			if (monitoringMachine != oldMonitoringMachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchPackage.CONFIGURATION__MONITORING_MACHINE, oldMonitoringMachine, monitoringMachine));
			}
		}
		return monitoringMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine basicGetMonitoringMachine() {
		return monitoringMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitoringMachine(Machine newMonitoringMachine) {
		Machine oldMonitoringMachine = monitoringMachine;
		monitoringMachine = newMonitoringMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.CONFIGURATION__MONITORING_MACHINE, oldMonitoringMachine, monitoringMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchPackage.CONFIGURATION__MACHINES:
				return ((InternalEList<?>)getMachines()).basicRemove(otherEnd, msgs);
			case ArchPackage.CONFIGURATION__MAPPINGS:
				return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
			case ArchPackage.CONFIGURATION__TRACE_INFO:
				return getTraceInfo();
			case ArchPackage.CONFIGURATION__CONNECTION_STRING:
				return getConnectionString();
			case ArchPackage.CONFIGURATION__MACHINES:
				return getMachines();
			case ArchPackage.CONFIGURATION__RECIPES:
				return getRecipes();
			case ArchPackage.CONFIGURATION__MAPPINGS:
				return getMappings();
			case ArchPackage.CONFIGURATION__COORDINATOR_MACHINE:
				if (resolve) return getCoordinatorMachine();
				return basicGetCoordinatorMachine();
			case ArchPackage.CONFIGURATION__MONITORING_MACHINE:
				if (resolve) return getMonitoringMachine();
				return basicGetMonitoringMachine();
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
			case ArchPackage.CONFIGURATION__TRACE_INFO:
				setTraceInfo((String)newValue);
				return;
			case ArchPackage.CONFIGURATION__CONNECTION_STRING:
				setConnectionString((String)newValue);
				return;
			case ArchPackage.CONFIGURATION__MACHINES:
				getMachines().clear();
				getMachines().addAll((Collection<? extends Machine>)newValue);
				return;
			case ArchPackage.CONFIGURATION__RECIPES:
				getRecipes().clear();
				getRecipes().addAll((Collection<? extends ReteRecipe>)newValue);
				return;
			case ArchPackage.CONFIGURATION__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends InfrastructureMapping>)newValue);
				return;
			case ArchPackage.CONFIGURATION__COORDINATOR_MACHINE:
				setCoordinatorMachine((Machine)newValue);
				return;
			case ArchPackage.CONFIGURATION__MONITORING_MACHINE:
				setMonitoringMachine((Machine)newValue);
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
			case ArchPackage.CONFIGURATION__TRACE_INFO:
				setTraceInfo(TRACE_INFO_EDEFAULT);
				return;
			case ArchPackage.CONFIGURATION__CONNECTION_STRING:
				setConnectionString(CONNECTION_STRING_EDEFAULT);
				return;
			case ArchPackage.CONFIGURATION__MACHINES:
				getMachines().clear();
				return;
			case ArchPackage.CONFIGURATION__RECIPES:
				getRecipes().clear();
				return;
			case ArchPackage.CONFIGURATION__MAPPINGS:
				getMappings().clear();
				return;
			case ArchPackage.CONFIGURATION__COORDINATOR_MACHINE:
				setCoordinatorMachine((Machine)null);
				return;
			case ArchPackage.CONFIGURATION__MONITORING_MACHINE:
				setMonitoringMachine((Machine)null);
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
			case ArchPackage.CONFIGURATION__TRACE_INFO:
				return TRACE_INFO_EDEFAULT == null ? traceInfo != null : !TRACE_INFO_EDEFAULT.equals(traceInfo);
			case ArchPackage.CONFIGURATION__CONNECTION_STRING:
				return CONNECTION_STRING_EDEFAULT == null ? connectionString != null : !CONNECTION_STRING_EDEFAULT.equals(connectionString);
			case ArchPackage.CONFIGURATION__MACHINES:
				return machines != null && !machines.isEmpty();
			case ArchPackage.CONFIGURATION__RECIPES:
				return recipes != null && !recipes.isEmpty();
			case ArchPackage.CONFIGURATION__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
			case ArchPackage.CONFIGURATION__COORDINATOR_MACHINE:
				return coordinatorMachine != null;
			case ArchPackage.CONFIGURATION__MONITORING_MACHINE:
				return monitoringMachine != null;
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
		result.append(", connectionString: ");
		result.append(connectionString);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
