/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inequality Filter Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.InequalityFilterRecipeImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.InequalityFilterRecipeImpl#getInequals <em>Inequals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InequalityFilterRecipeImpl extends FilterRecipeImpl implements InequalityFilterRecipe
{
  /**
   * The default value of the '{@link #getSubject() <em>Subject</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubject()
   * @generated
   * @ordered
   */
  protected static final Integer SUBJECT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSubject() <em>Subject</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubject()
   * @generated
   * @ordered
   */
  protected Integer subject = SUBJECT_EDEFAULT;

  /**
   * The cached value of the '{@link #getInequals() <em>Inequals</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInequals()
   * @generated
   * @ordered
   */
  protected EList<Integer> inequals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InequalityFilterRecipeImpl()
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
    return RecipesPackage.Literals.INEQUALITY_FILTER_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integer getSubject()
  {
    return subject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubject(Integer newSubject)
  {
    Integer oldSubject = subject;
    subject = newSubject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.INEQUALITY_FILTER_RECIPE__SUBJECT, oldSubject, subject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getInequals()
  {
    if (inequals == null)
    {
      inequals = new EDataTypeEList<Integer>(Integer.class, this, RecipesPackage.INEQUALITY_FILTER_RECIPE__INEQUALS);
    }
    return inequals;
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
      case RecipesPackage.INEQUALITY_FILTER_RECIPE__SUBJECT:
        return getSubject();
      case RecipesPackage.INEQUALITY_FILTER_RECIPE__INEQUALS:
        return getInequals();
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
      case RecipesPackage.INEQUALITY_FILTER_RECIPE__SUBJECT:
        setSubject((Integer)newValue);
        return;
      case RecipesPackage.INEQUALITY_FILTER_RECIPE__INEQUALS:
        getInequals().clear();
        getInequals().addAll((Collection<? extends Integer>)newValue);
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
      case RecipesPackage.INEQUALITY_FILTER_RECIPE__SUBJECT:
        setSubject(SUBJECT_EDEFAULT);
        return;
      case RecipesPackage.INEQUALITY_FILTER_RECIPE__INEQUALS:
        getInequals().clear();
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
      case RecipesPackage.INEQUALITY_FILTER_RECIPE__SUBJECT:
        return SUBJECT_EDEFAULT == null ? subject != null : !SUBJECT_EDEFAULT.equals(subject);
      case RecipesPackage.INEQUALITY_FILTER_RECIPE__INEQUALS:
        return inequals != null && !inequals.isEmpty();
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
    result.append(" (subject: ");
    result.append(subject);
    result.append(", inequals: ");
    result.append(inequals);
    result.append(')');
    return result.toString();
  }

} //InequalityFilterRecipeImpl
