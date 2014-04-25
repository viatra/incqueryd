/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.runtime.rete.recipes.IndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.JoinRecipeImpl#getRightParentComplementaryMask <em>Right Parent Complementary Mask</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JoinRecipeImpl extends BetaRecipeImpl implements JoinRecipe
{
  /**
   * The cached value of the '{@link #getRightParentComplementaryMask() <em>Right Parent Complementary Mask</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightParentComplementaryMask()
   * @generated
   * @ordered
   */
  protected Mask rightParentComplementaryMask;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JoinRecipeImpl()
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
    return RecipesPackage.Literals.JOIN_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mask getRightParentComplementaryMask()
  {
    return rightParentComplementaryMask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightParentComplementaryMask(Mask newRightParentComplementaryMask, NotificationChain msgs)
  {
    Mask oldRightParentComplementaryMask = rightParentComplementaryMask;
    rightParentComplementaryMask = newRightParentComplementaryMask;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK, oldRightParentComplementaryMask, newRightParentComplementaryMask);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightParentComplementaryMask(Mask newRightParentComplementaryMask)
  {
    if (newRightParentComplementaryMask != rightParentComplementaryMask)
    {
      NotificationChain msgs = null;
      if (rightParentComplementaryMask != null)
        msgs = ((InternalEObject)rightParentComplementaryMask).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK, null, msgs);
      if (newRightParentComplementaryMask != null)
        msgs = ((InternalEObject)newRightParentComplementaryMask).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK, null, msgs);
      msgs = basicSetRightParentComplementaryMask(newRightParentComplementaryMask, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK, newRightParentComplementaryMask, newRightParentComplementaryMask));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getArity()
  {
    JoinRecipe _this = this;
    ProjectionIndexerRecipe _leftParent = _this.getLeftParent();
    int _arity = _leftParent.getArity();
    JoinRecipe _this_1 = this;
    IndexerRecipe _rightParent = _this_1.getRightParent();
    int _arity_1 = _rightParent.getArity();
    int _plus = (_arity + _arity_1);
    JoinRecipe _this_2 = this;
    IndexerRecipe _rightParent_1 = _this_2.getRightParent();
    Mask _mask = _rightParent_1.getMask();
    EList<Integer> _sourceIndices = _mask.getSourceIndices();
    int _length = ((Object[])Conversions.unwrapArray(_sourceIndices, Object.class)).length;
    int _minus = (_plus - _length);
    return _minus;
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
      case RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK:
        return basicSetRightParentComplementaryMask(null, msgs);
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
      case RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK:
        return getRightParentComplementaryMask();
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
      case RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK:
        setRightParentComplementaryMask((Mask)newValue);
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
      case RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK:
        setRightParentComplementaryMask((Mask)null);
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
      case RecipesPackage.JOIN_RECIPE__RIGHT_PARENT_COMPLEMENTARY_MASK:
        return rightParentComplementaryMask != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
  {
    if (baseClass == ReteNodeRecipe.class)
    {
      switch (baseOperationID)
      {
        case RecipesPackage.RETE_NODE_RECIPE___GET_ARITY: return RecipesPackage.JOIN_RECIPE___GET_ARITY;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
  {
    switch (operationID)
    {
      case RecipesPackage.JOIN_RECIPE___GET_ARITY:
        return getArity();
    }
    return super.eInvoke(operationID, arguments);
  }

} //JoinRecipeImpl
