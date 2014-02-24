/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregator Join Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorJoinRecipeImpl#getAggregator <em>Aggregator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregatorJoinRecipeImpl extends BetaRecipeImpl implements AggregatorJoinRecipe
{
  /**
   * The cached value of the '{@link #getAggregator() <em>Aggregator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAggregator()
   * @generated
   * @ordered
   */
  protected AggregatorRecipe aggregator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AggregatorJoinRecipeImpl()
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
    return RecipesPackage.Literals.AGGREGATOR_JOIN_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregatorRecipe getAggregator()
  {
    return aggregator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAggregator(AggregatorRecipe newAggregator, NotificationChain msgs)
  {
    AggregatorRecipe oldAggregator = aggregator;
    aggregator = newAggregator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR, oldAggregator, newAggregator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAggregator(AggregatorRecipe newAggregator)
  {
    if (newAggregator != aggregator)
    {
      NotificationChain msgs = null;
      if (aggregator != null)
        msgs = ((InternalEObject)aggregator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR, null, msgs);
      if (newAggregator != null)
        msgs = ((InternalEObject)newAggregator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR, null, msgs);
      msgs = basicSetAggregator(newAggregator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR, newAggregator, newAggregator));
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
      case RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR:
        return basicSetAggregator(null, msgs);
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
      case RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR:
        return getAggregator();
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
      case RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR:
        setAggregator((AggregatorRecipe)newValue);
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
      case RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR:
        setAggregator((AggregatorRecipe)null);
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
      case RecipesPackage.AGGREGATOR_JOIN_RECIPE__AGGREGATOR:
        return aggregator != null;
    }
    return super.eIsSet(featureID);
  }

} //AggregatorJoinRecipeImpl
