/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.ConstantRecipeImpl#getConstantValues <em>Constant Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantRecipeImpl extends ReteNodeRecipeImpl implements ConstantRecipe
{
  /**
   * The cached value of the '{@link #getConstantValues() <em>Constant Values</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstantValues()
   * @generated
   * @ordered
   */
  protected EList<Object> constantValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantRecipeImpl()
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
    return RecipesPackage.Literals.CONSTANT_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Object> getConstantValues()
  {
    if (constantValues == null)
    {
      constantValues = new EDataTypeEList<Object>(Object.class, this, RecipesPackage.CONSTANT_RECIPE__CONSTANT_VALUES);
    }
    return constantValues;
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
      case RecipesPackage.CONSTANT_RECIPE__CONSTANT_VALUES:
        return getConstantValues();
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
      case RecipesPackage.CONSTANT_RECIPE__CONSTANT_VALUES:
        getConstantValues().clear();
        getConstantValues().addAll((Collection<? extends Object>)newValue);
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
      case RecipesPackage.CONSTANT_RECIPE__CONSTANT_VALUES:
        getConstantValues().clear();
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
      case RecipesPackage.CONSTANT_RECIPE__CONSTANT_VALUES:
        return constantValues != null && !constantValues.isEmpty();
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
    result.append(" (constantValues: ");
    result.append(constantValues);
    result.append(')');
    return result.toString();
  }

} //ConstantRecipeImpl
