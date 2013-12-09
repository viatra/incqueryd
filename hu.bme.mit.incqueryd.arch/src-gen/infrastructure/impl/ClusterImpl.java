/**
 */
package infrastructure.impl;

import infrastructure.Cluster;
import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.ServiceNode;

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
 *   <li>{@link infrastructure.impl.ClusterImpl#getInfrastructureNodes <em>Infrastructure Nodes</em>}</li>
 *   <li>{@link infrastructure.impl.ClusterImpl#getServiceNodes <em>Service Nodes</em>}</li>
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
   * The cached value of the '{@link #getInfrastructureNodes() <em>Infrastructure Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInfrastructureNodes()
   * @generated
   * @ordered
   */
  protected EList<InfrastructureNode> infrastructureNodes;

  /**
   * The cached value of the '{@link #getServiceNodes() <em>Service Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceNodes()
   * @generated
   * @ordered
   */
  protected EList<ServiceNode> serviceNodes;

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
  public EList<InfrastructureNode> getInfrastructureNodes()
  {
    if (infrastructureNodes == null)
    {
      infrastructureNodes = new EObjectContainmentEList<InfrastructureNode>(InfrastructureNode.class, this, InfrastructurePackage.CLUSTER__INFRASTRUCTURE_NODES);
    }
    return infrastructureNodes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ServiceNode> getServiceNodes()
  {
    if (serviceNodes == null)
    {
      serviceNodes = new EObjectContainmentEList<ServiceNode>(ServiceNode.class, this, InfrastructurePackage.CLUSTER__SERVICE_NODES);
    }
    return serviceNodes;
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
      case InfrastructurePackage.CLUSTER__INFRASTRUCTURE_NODES:
        return ((InternalEList<?>)getInfrastructureNodes()).basicRemove(otherEnd, msgs);
      case InfrastructurePackage.CLUSTER__SERVICE_NODES:
        return ((InternalEList<?>)getServiceNodes()).basicRemove(otherEnd, msgs);
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
      case InfrastructurePackage.CLUSTER__INFRASTRUCTURE_NODES:
        return getInfrastructureNodes();
      case InfrastructurePackage.CLUSTER__SERVICE_NODES:
        return getServiceNodes();
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
      case InfrastructurePackage.CLUSTER__INFRASTRUCTURE_NODES:
        getInfrastructureNodes().clear();
        getInfrastructureNodes().addAll((Collection<? extends InfrastructureNode>)newValue);
        return;
      case InfrastructurePackage.CLUSTER__SERVICE_NODES:
        getServiceNodes().clear();
        getServiceNodes().addAll((Collection<? extends ServiceNode>)newValue);
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
      case InfrastructurePackage.CLUSTER__INFRASTRUCTURE_NODES:
        getInfrastructureNodes().clear();
        return;
      case InfrastructurePackage.CLUSTER__SERVICE_NODES:
        getServiceNodes().clear();
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
      case InfrastructurePackage.CLUSTER__INFRASTRUCTURE_NODES:
        return infrastructureNodes != null && !infrastructureNodes.isEmpty();
      case InfrastructurePackage.CLUSTER__SERVICE_NODES:
        return serviceNodes != null && !serviceNodes.isEmpty();
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
