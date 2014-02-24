/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rete Node Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.ReteNodeRecipeImpl#getTraceInfo <em>Trace Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ReteNodeRecipeImpl extends MinimalEObjectImpl.Container implements ReteNodeRecipe
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReteNodeRecipeImpl()
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
    return RecipesPackage.Literals.RETE_NODE_RECIPE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.RETE_NODE_RECIPE__TRACE_INFO, oldTraceInfo, traceInfo));
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
      case RecipesPackage.RETE_NODE_RECIPE__TRACE_INFO:
        return getTraceInfo();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RecipesPackage.RETE_NODE_RECIPE__TRACE_INFO:
        setTraceInfo((String)newValue);
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
      case RecipesPackage.RETE_NODE_RECIPE__TRACE_INFO:
        setTraceInfo(TRACE_INFO_EDEFAULT);
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
      case RecipesPackage.RETE_NODE_RECIPE__TRACE_INFO:
        return TRACE_INFO_EDEFAULT == null ? traceInfo != null : !TRACE_INFO_EDEFAULT.equals(traceInfo);
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

} //ReteNodeRecipeImpl
