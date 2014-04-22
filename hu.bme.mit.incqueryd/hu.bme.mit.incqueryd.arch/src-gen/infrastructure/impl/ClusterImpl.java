/**
 */
package infrastructure.impl;

import infrastructure.Cluster;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;

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
 * An implementation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link infrastructure.impl.ClusterImpl#getTraceInfo <em>Trace Info</em>}</li>
 *   <li>{@link infrastructure.impl.ClusterImpl#getReteMachines <em>Rete Machines</em>}</li>
 *   <li>{@link infrastructure.impl.ClusterImpl#getCacheMachines <em>Cache Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClusterImpl extends MinimalEObjectImpl.Container implements Cluster
{
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
   * The cached value of the '{@link #getReteMachines() <em>Rete Machines</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReteMachines()
   * @generated
   * @ordered
   */
  protected EList<Machine> reteMachines;

  /**
   * The cached value of the '{@link #getCacheMachines() <em>Cache Machines</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCacheMachines()
   * @generated
   * @ordered
   */
  protected EList<Machine> cacheMachines;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClusterImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return InfrastructurePackage.Literals.CLUSTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTraceInfo()
  {
    return traceInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTraceInfo(String newTraceInfo)
  {
    String oldTraceInfo = traceInfo;
    traceInfo = newTraceInfo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.CLUSTER__TRACE_INFO, oldTraceInfo, traceInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Machine> getReteMachines()
  {
    if (reteMachines == null)
    {
      reteMachines = new EObjectContainmentEList<Machine>(Machine.class, this, InfrastructurePackage.CLUSTER__RETE_MACHINES);
    }
    return reteMachines;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Machine> getCacheMachines()
  {
    if (cacheMachines == null)
    {
      cacheMachines = new EObjectContainmentEList<Machine>(Machine.class, this, InfrastructurePackage.CLUSTER__CACHE_MACHINES);
    }
    return cacheMachines;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case InfrastructurePackage.CLUSTER__RETE_MACHINES:
        return ((InternalEList<?>)getReteMachines()).basicRemove(otherEnd, msgs);
      case InfrastructurePackage.CLUSTER__CACHE_MACHINES:
        return ((InternalEList<?>)getCacheMachines()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case InfrastructurePackage.CLUSTER__TRACE_INFO:
        return getTraceInfo();
      case InfrastructurePackage.CLUSTER__RETE_MACHINES:
        return getReteMachines();
      case InfrastructurePackage.CLUSTER__CACHE_MACHINES:
        return getCacheMachines();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case InfrastructurePackage.CLUSTER__TRACE_INFO:
        setTraceInfo((String)newValue);
        return;
      case InfrastructurePackage.CLUSTER__RETE_MACHINES:
        getReteMachines().clear();
        getReteMachines().addAll((Collection<? extends Machine>)newValue);
        return;
      case InfrastructurePackage.CLUSTER__CACHE_MACHINES:
        getCacheMachines().clear();
        getCacheMachines().addAll((Collection<? extends Machine>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case InfrastructurePackage.CLUSTER__TRACE_INFO:
        setTraceInfo(TRACE_INFO_EDEFAULT);
        return;
      case InfrastructurePackage.CLUSTER__RETE_MACHINES:
        getReteMachines().clear();
        return;
      case InfrastructurePackage.CLUSTER__CACHE_MACHINES:
        getCacheMachines().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case InfrastructurePackage.CLUSTER__TRACE_INFO:
        return TRACE_INFO_EDEFAULT == null ? traceInfo != null : !TRACE_INFO_EDEFAULT.equals(traceInfo);
      case InfrastructurePackage.CLUSTER__RETE_MACHINES:
        return reteMachines != null && !reteMachines.isEmpty();
      case InfrastructurePackage.CLUSTER__CACHE_MACHINES:
        return cacheMachines != null && !cacheMachines.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (traceInfo: ");
    result.append(traceInfo);
    result.append(')');
    return result.toString();
  }

} //ClusterImpl
