/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Projection Indexer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.ProjectionIndexerImpl#getMask <em>Mask</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectionIndexerImpl extends SingleParentNodeRecipeImpl implements ProjectionIndexer
{
  /**
   * The cached value of the '{@link #getMask() <em>Mask</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMask()
   * @generated
   * @ordered
   */
  protected Mask mask;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProjectionIndexerImpl()
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
    return RecipesPackage.Literals.PROJECTION_INDEXER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mask getMask()
  {
    return mask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMask(Mask newMask, NotificationChain msgs)
  {
    Mask oldMask = mask;
    mask = newMask;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecipesPackage.PROJECTION_INDEXER__MASK, oldMask, newMask);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMask(Mask newMask)
  {
    if (newMask != mask)
    {
      NotificationChain msgs = null;
      if (mask != null)
        msgs = ((InternalEObject)mask).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecipesPackage.PROJECTION_INDEXER__MASK, null, msgs);
      if (newMask != null)
        msgs = ((InternalEObject)newMask).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecipesPackage.PROJECTION_INDEXER__MASK, null, msgs);
      msgs = basicSetMask(newMask, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.PROJECTION_INDEXER__MASK, newMask, newMask));
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
      case RecipesPackage.PROJECTION_INDEXER__MASK:
        return basicSetMask(null, msgs);
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
      case RecipesPackage.PROJECTION_INDEXER__MASK:
        return getMask();
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
      case RecipesPackage.PROJECTION_INDEXER__MASK:
        setMask((Mask)newValue);
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
      case RecipesPackage.PROJECTION_INDEXER__MASK:
        setMask((Mask)null);
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
      case RecipesPackage.PROJECTION_INDEXER__MASK:
        return mask != null;
    }
    return super.eIsSet(featureID);
  }

} //ProjectionIndexerImpl
