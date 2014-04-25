/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.incquery.runtime.rete.recipes.ExpressionDefinition;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.ExpressionDefinitionImpl#getEvaluator <em>Evaluator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExpressionDefinitionImpl extends MinimalEObjectImpl.Container implements ExpressionDefinition
{
  /**
   * The default value of the '{@link #getEvaluator() <em>Evaluator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluator()
   * @generated
   * @ordered
   */
  protected static final Object EVALUATOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEvaluator() <em>Evaluator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluator()
   * @generated
   * @ordered
   */
  protected Object evaluator = EVALUATOR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionDefinitionImpl()
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
    return RecipesPackage.Literals.EXPRESSION_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object getEvaluator()
  {
    return evaluator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvaluator(Object newEvaluator)
  {
    Object oldEvaluator = evaluator;
    evaluator = newEvaluator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.EXPRESSION_DEFINITION__EVALUATOR, oldEvaluator, evaluator));
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
      case RecipesPackage.EXPRESSION_DEFINITION__EVALUATOR:
        return getEvaluator();
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
      case RecipesPackage.EXPRESSION_DEFINITION__EVALUATOR:
        setEvaluator(newValue);
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
      case RecipesPackage.EXPRESSION_DEFINITION__EVALUATOR:
        setEvaluator(EVALUATOR_EDEFAULT);
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
      case RecipesPackage.EXPRESSION_DEFINITION__EVALUATOR:
        return EVALUATOR_EDEFAULT == null ? evaluator != null : !EVALUATOR_EDEFAULT.equals(evaluator);
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
    result.append(" (evaluator: ");
    result.append(evaluator);
    result.append(')');
    return result.toString();
  }

} //ExpressionDefinitionImpl
