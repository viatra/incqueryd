/**
 */
package arch.impl;

import arch.ArchPackage;
import arch.InfrastructureMapping;

import infrastructure.InfrastructureNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getTraceInfo <em>Trace Info</em>}</li>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getMappedElements <em>Mapped Elements</em>}</li>
 *   <li>{@link arch.impl.InfrastructureMappingImpl#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureMappingImpl extends MinimalEObjectImpl.Container implements InfrastructureMapping
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
   * The cached value of the '{@link #getMappedElements() <em>Mapped Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMappedElements()
   * @generated
   * @ordered
   */
  protected EList<ReteNodeRecipe> mappedElements;

  /**
   * The cached value of the '{@link #getTargetElement() <em>Target Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetElement()
   * @generated
   * @ordered
   */
  protected InfrastructureNode targetElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InfrastructureMappingImpl()
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
    return ArchPackage.Literals.INFRASTRUCTURE_MAPPING;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO, oldTraceInfo, traceInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReteNodeRecipe> getMappedElements()
  {
    if (mappedElements == null)
    {
      mappedElements = new EObjectResolvingEList<ReteNodeRecipe>(ReteNodeRecipe.class, this, ArchPackage.INFRASTRUCTURE_MAPPING__MAPPED_ELEMENTS);
    }
    return mappedElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfrastructureNode getTargetElement()
  {
    if (targetElement != null && targetElement.eIsProxy())
    {
      InternalEObject oldTargetElement = (InternalEObject)targetElement;
      targetElement = (InfrastructureNode)eResolveProxy(oldTargetElement);
      if (targetElement != oldTargetElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchPackage.INFRASTRUCTURE_MAPPING__TARGET_ELEMENT, oldTargetElement, targetElement));
      }
    }
    return targetElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfrastructureNode basicGetTargetElement()
  {
    return targetElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetElement(InfrastructureNode newTargetElement)
  {
    InfrastructureNode oldTargetElement = targetElement;
    targetElement = newTargetElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.INFRASTRUCTURE_MAPPING__TARGET_ELEMENT, oldTargetElement, targetElement));
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
      case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
        return getTraceInfo();
      case ArchPackage.INFRASTRUCTURE_MAPPING__MAPPED_ELEMENTS:
        return getMappedElements();
      case ArchPackage.INFRASTRUCTURE_MAPPING__TARGET_ELEMENT:
        if (resolve) return getTargetElement();
        return basicGetTargetElement();
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
      case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
        setTraceInfo((String)newValue);
        return;
      case ArchPackage.INFRASTRUCTURE_MAPPING__MAPPED_ELEMENTS:
        getMappedElements().clear();
        getMappedElements().addAll((Collection<? extends ReteNodeRecipe>)newValue);
        return;
      case ArchPackage.INFRASTRUCTURE_MAPPING__TARGET_ELEMENT:
        setTargetElement((InfrastructureNode)newValue);
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
      case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
        setTraceInfo(TRACE_INFO_EDEFAULT);
        return;
      case ArchPackage.INFRASTRUCTURE_MAPPING__MAPPED_ELEMENTS:
        getMappedElements().clear();
        return;
      case ArchPackage.INFRASTRUCTURE_MAPPING__TARGET_ELEMENT:
        setTargetElement((InfrastructureNode)null);
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
      case ArchPackage.INFRASTRUCTURE_MAPPING__TRACE_INFO:
        return TRACE_INFO_EDEFAULT == null ? traceInfo != null : !TRACE_INFO_EDEFAULT.equals(traceInfo);
      case ArchPackage.INFRASTRUCTURE_MAPPING__MAPPED_ELEMENTS:
        return mappedElements != null && !mappedElements.isEmpty();
      case ArchPackage.INFRASTRUCTURE_MAPPING__TARGET_ELEMENT:
        return targetElement != null;
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

} //InfrastructureMappingImpl
