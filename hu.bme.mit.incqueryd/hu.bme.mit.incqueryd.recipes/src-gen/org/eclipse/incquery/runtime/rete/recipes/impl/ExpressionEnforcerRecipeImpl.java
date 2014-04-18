/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.incquery.runtime.rete.recipes.ExpressionDefinition;
import org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Enforcer Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.ExpressionEnforcerRecipeImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.ExpressionEnforcerRecipeImpl#getMappedIndices <em>Mapped Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExpressionEnforcerRecipeImpl extends AlphaRecipeImpl implements ExpressionEnforcerRecipe
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected ExpressionDefinition expression;

  /**
   * The cached value of the '{@link #getMappedIndices() <em>Mapped Indices</em>}' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMappedIndices()
   * @generated
   * @ordered
   */
  protected EMap<String, Integer> mappedIndices;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionEnforcerRecipeImpl()
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
    return RecipesPackage.Literals.EXPRESSION_ENFORCER_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionDefinition getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(ExpressionDefinition newExpression, NotificationChain msgs)
  {
    ExpressionDefinition oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(ExpressionDefinition newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMap<String, Integer> getMappedIndices()
  {
    if (mappedIndices == null)
    {
      mappedIndices = new EcoreEMap<String,Integer>(RecipesPackage.Literals.STRING_INDEX_MAP_ENTRY, StringIndexMapEntryImpl.class, this, RecipesPackage.EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES);
    }
    return mappedIndices;
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
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION:
        return basicSetExpression(null, msgs);
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES:
        return ((InternalEList<?>)getMappedIndices()).basicRemove(otherEnd, msgs);
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
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION:
        return getExpression();
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES:
        if (coreType) return getMappedIndices();
        else return getMappedIndices().map();
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
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION:
        setExpression((ExpressionDefinition)newValue);
        return;
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES:
        ((EStructuralFeature.Setting)getMappedIndices()).set(newValue);
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
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION:
        setExpression((ExpressionDefinition)null);
        return;
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES:
        getMappedIndices().clear();
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
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__EXPRESSION:
        return expression != null;
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES:
        return mappedIndices != null && !mappedIndices.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExpressionEnforcerRecipeImpl
