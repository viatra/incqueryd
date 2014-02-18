/**
 */
package arch.impl;

import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

import infrastructure.Cluster;

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

import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arch.impl.ConfigurationImpl#getTraceInfo <em>Trace Info</em>}</li>
 *   <li>{@link arch.impl.ConfigurationImpl#getClusters <em>Clusters</em>}</li>
 *   <li>{@link arch.impl.ConfigurationImpl#getReteRecipes <em>Rete Recipes</em>}</li>
 *   <li>{@link arch.impl.ConfigurationImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration
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
   * The cached value of the '{@link #getClusters() <em>Clusters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClusters()
   * @generated
   * @ordered
   */
  protected EList<Cluster> clusters;

  /**
   * The cached value of the '{@link #getReteRecipes() <em>Rete Recipes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReteRecipes()
   * @generated
   * @ordered
   */
  protected EList<ReteRecipe> reteRecipes;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConfigurationImpl()
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
    return ArchPackage.Literals.CONFIGURATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.CONFIGURATION__TRACE_INFO, oldTraceInfo, traceInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Cluster> getClusters()
  {
    if (clusters == null)
    {
      clusters = new EObjectContainmentEList<Cluster>(Cluster.class, this, ArchPackage.CONFIGURATION__CLUSTERS);
    }
    return clusters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReteRecipe> getReteRecipes()
  {
    if (reteRecipes == null)
    {
      reteRecipes = new EObjectContainmentEList<ReteRecipe>(ReteRecipe.class, this, ArchPackage.CONFIGURATION__RETE_RECIPES);
    }
    return reteRecipes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InfrastructureMapping> getMappings()
  {
    if (mappings == null)
    {
      mappings = new EObjectContainmentEList<InfrastructureMapping>(InfrastructureMapping.class, this, ArchPackage.CONFIGURATION__MAPPINGS);
    }
    return mappings;
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
      case ArchPackage.CONFIGURATION__CLUSTERS:
        return ((InternalEList<?>)getClusters()).basicRemove(otherEnd, msgs);
      case ArchPackage.CONFIGURATION__RETE_RECIPES:
        return ((InternalEList<?>)getReteRecipes()).basicRemove(otherEnd, msgs);
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArchPackage.CONFIGURATION__TRACE_INFO:
        return getTraceInfo();
      case ArchPackage.CONFIGURATION__CLUSTERS:
        return getClusters();
      case ArchPackage.CONFIGURATION__RETE_RECIPES:
        return getReteRecipes();
      case ArchPackage.CONFIGURATION__MAPPINGS:
        return getMappings();
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
      case ArchPackage.CONFIGURATION__TRACE_INFO:
        setTraceInfo((String)newValue);
        return;
      case ArchPackage.CONFIGURATION__CLUSTERS:
        getClusters().clear();
        getClusters().addAll((Collection<? extends Cluster>)newValue);
        return;
      case ArchPackage.CONFIGURATION__RETE_RECIPES:
        getReteRecipes().clear();
        getReteRecipes().addAll((Collection<? extends ReteRecipe>)newValue);
        return;
      case ArchPackage.CONFIGURATION__MAPPINGS:
        getMappings().clear();
        getMappings().addAll((Collection<? extends InfrastructureMapping>)newValue);
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
      case ArchPackage.CONFIGURATION__TRACE_INFO:
        setTraceInfo(TRACE_INFO_EDEFAULT);
        return;
      case ArchPackage.CONFIGURATION__CLUSTERS:
        getClusters().clear();
        return;
      case ArchPackage.CONFIGURATION__RETE_RECIPES:
        getReteRecipes().clear();
        return;
      case ArchPackage.CONFIGURATION__MAPPINGS:
        getMappings().clear();
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
      case ArchPackage.CONFIGURATION__TRACE_INFO:
        return TRACE_INFO_EDEFAULT == null ? traceInfo != null : !TRACE_INFO_EDEFAULT.equals(traceInfo);
      case ArchPackage.CONFIGURATION__CLUSTERS:
        return clusters != null && !clusters.isEmpty();
      case ArchPackage.CONFIGURATION__RETE_RECIPES:
        return reteRecipes != null && !reteRecipes.isEmpty();
      case ArchPackage.CONFIGURATION__MAPPINGS:
        return mappings != null && !mappings.isEmpty();
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

} //ConfigurationImpl
