/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Input Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BinaryInputRecipeImpl extends TypeInputRecipeImpl implements BinaryInputRecipe
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BinaryInputRecipeImpl()
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
    return RecipesPackage.Literals.BINARY_INPUT_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getArity()
  {
    return 2;
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
        case RecipesPackage.RETE_NODE_RECIPE___GET_ARITY: return RecipesPackage.BINARY_INPUT_RECIPE___GET_ARITY;
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
      case RecipesPackage.BINARY_INPUT_RECIPE___GET_ARITY:
        return getArity();
    }
    return super.eInvoke(operationID, arguments);
  }

} //BinaryInputRecipeImpl
