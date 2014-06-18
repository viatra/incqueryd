/**
 */
package arch.impl;

import arch.ArchPackage;
import arch.ReteRole;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rete Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arch.impl.ReteRoleImpl#getNodeRecipe <em>Node Recipe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReteRoleImpl extends RoleImpl implements ReteRole
{
  /**
   * The cached value of the '{@link #getNodeRecipe() <em>Node Recipe</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeRecipe()
   * @generated
   * @ordered
   */
  protected ReteNodeRecipe nodeRecipe;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReteRoleImpl()
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
    return ArchPackage.Literals.RETE_ROLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReteNodeRecipe getNodeRecipe()
  {
    if (nodeRecipe != null && nodeRecipe.eIsProxy())
    {
      InternalEObject oldNodeRecipe = (InternalEObject)nodeRecipe;
      nodeRecipe = (ReteNodeRecipe)eResolveProxy(oldNodeRecipe);
      if (nodeRecipe != oldNodeRecipe)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchPackage.RETE_ROLE__NODE_RECIPE, oldNodeRecipe, nodeRecipe));
      }
    }
    return nodeRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReteNodeRecipe basicGetNodeRecipe()
  {
    return nodeRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodeRecipe(ReteNodeRecipe newNodeRecipe)
  {
    ReteNodeRecipe oldNodeRecipe = nodeRecipe;
    nodeRecipe = newNodeRecipe;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchPackage.RETE_ROLE__NODE_RECIPE, oldNodeRecipe, nodeRecipe));
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
      case ArchPackage.RETE_ROLE__NODE_RECIPE:
        if (resolve) return getNodeRecipe();
        return basicGetNodeRecipe();
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
      case ArchPackage.RETE_ROLE__NODE_RECIPE:
        setNodeRecipe((ReteNodeRecipe)newValue);
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
      case ArchPackage.RETE_ROLE__NODE_RECIPE:
        setNodeRecipe((ReteNodeRecipe)null);
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
      case ArchPackage.RETE_ROLE__NODE_RECIPE:
        return nodeRecipe != null;
    }
    return super.eIsSet(featureID);
  }

} //ReteRoleImpl
